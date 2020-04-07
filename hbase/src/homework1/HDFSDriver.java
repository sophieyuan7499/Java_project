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

		// ��װ JOB
		Job job = Job.getInstance(conf, this.getClass().getSimpleName());
		job.setJarByClass(HDFSDriver.class);

		// ����·��
		Path inPath = new Path("hdfs://test1:9000/test/hbase01");
		// �������·��
		FileInputFormat.addInputPath(job, inPath);

		// ����mapper
		job.setMapperClass(myMapper.class);
		job.setMapOutputKeyClass(ImmutableBytesWritable.class);
		job.setMapOutputValueClass(Put.class);

		// ���� Reduce
		TableMapReduceUtil.initTableReducerJob("employees", myReducer.class, job);
		// ����Reduce��������С��1��
		job.setNumReduceTasks(1);
		boolean completion = job.waitForCompletion(true);
		if (!completion) {
			throw new IOException(" JOB ���д���");
		}
		return completion ? 0 : 1;
	}

	public static void main(String[] args) throws Exception {
		Configuration conf = HBaseConfiguration.create();
		conf.set("hbase.zookeeper.quorum", "test1");// ����
		
		conf.set("hbase.zookeeper.property.clientPort", "2181");// zookeeper�˿�
		int run = ToolRunner.run(conf, new HDFSDriver(), args);
		System.exit(run);

	}
}


class myMapper extends Mapper<LongWritable, Text, ImmutableBytesWritable, Put> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, ImmutableBytesWritable, Put>.Context context) throws IOException, InterruptedException {

		String line = value.toString();
		// �������ݵ�ͬʱ��ϴ����
		String[] values = line.split("\t");
		String row = values[0];
		String name = values[1];
		String job = values[2];

		//��ʼ��rowKey
		ImmutableBytesWritable immutableBytesWritable = new ImmutableBytesWritable(row.getBytes());
		//��ʼ��put
		Put put = new Put(Bytes.toBytes(row));
		//�����ֱ��� ���塢�С�ֵ
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("name"), Bytes.toBytes(name));
		put.addColumn(Bytes.toBytes("info"), Bytes.toBytes("color"), Bytes.toBytes(job));

		context.write(immutableBytesWritable, put);
	}
}


 class myReducer extends TableReducer<ImmutableBytesWritable, Put, NullWritable> {
		@Override
		protected void reduce(ImmutableBytesWritable imm, Iterable<Put> puts, Reducer<ImmutableBytesWritable, Put, NullWritable, Mutation>.Context context) throws IOException, InterruptedException {
			// ��������ÿһ��д�뵽 hbase��
			for (Put put : puts) {
				context.write(NullWritable.get(), put);
			}

		}
	}
	
