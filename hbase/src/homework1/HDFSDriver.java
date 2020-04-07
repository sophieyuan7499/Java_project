package homework1;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.mapreduce.TableOutputFormat;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class HDFSDriver extends Configured implements Tool {

	public int run(String[] args) throws Exception {
		Configuration conf = this.getConf();

		// 组装 JOB
		Job job = Job.getInstance(conf, this.getClass().getSimpleName());
		job.setJarByClass(HDFSDriver.class);

		// 输入路径
		Path inPath = new Path("hdfs://test1:9000/test/hbase01");
		// 添加输入路径
		FileInputFormat.addInputPath(job, inPath);

		// 设置mapper
		job.setMapperClass(myMapper.class);
		job.setMapOutputKeyClass(ImmutableBytesWritable.class);
		job.setMapOutputValueClass(Put.class);

		// 设置 Reduce
		TableMapReduceUtil.initTableReducerJob("employees", myReducer.class, job);
		// 设置Reduce数量，最小是1个
		job.setNumReduceTasks(1);
		boolean completion = job.waitForCompletion(true);
		if (!completion) {
			throw new IOException(" JOB 运行错误");
		}
		return completion ? 0 : 1;
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "test1");// 单机
		
		conf.set("hbase.zookeeper.property.clientPort", "2181");// zookeeper端口
		int run = ToolRunner.run(conf, new HDFSDriver(), args);
		System.exit(run);

	}
}


class myMapper extends Mapper<LongWritable, Text, ImmutableBytesWritable, Put> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, ImmutableBytesWritable, Put>.Context context) throws IOException, InterruptedException {

		String line = value.toString();
		// 倒数数据的同时清洗数据
		String[] values = line.split("\t");
		String row = values[0];
		String name = values[1];
		String job = values[2];

		//初始化rowKey
		ImmutableBytesWritable immutableBytesWritable = new ImmutableBytesWritable(row.getBytes());
		//初始化put
		Put put = new Put(Bytes.toBytes(row));
		//参数分别是 列族、列、值
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes(name));
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("color"), Bytes.toBytes(job));

		context.write(immutableBytesWritable, put);
	}
}


 class myReducer extends TableReducer<ImmutableBytesWritable, Put, NullWritable> {
		@Override
		protected void reduce(ImmutableBytesWritable imm, Iterable<Put> puts, Reducer<ImmutableBytesWritable, Put, NullWritable, Mutation>.Context context) throws IOException, InterruptedException {
			// 读出来的每一行写入到 hbase表
			for (Put put : puts) {
				context.write(NullWritable.get(), put);
			}

		}
	}
	
