package homework1;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.mapreduce.TableMapReduceUtil;
import org.apache.hadoop.hbase.mapreduce.TableMapper;
import org.apache.hadoop.hbase.mapreduce.TableOutputFormat;
import org.apache.hadoop.hbase.mapreduce.TableReducer;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

public class test2 {

   private static  Configuration conf=null;
	
	private Connection conn;//对表进行一系列操作，需要进行连接
	private Table table;
	static {
		
		conf=HBaseConfiguration.create();
		//默认会从classpath中查找hbase-site.xml中配置信息，初始化Configuration
		conf.set("hbase.zookeeper.quorum","test1,test2,test3");
		conf.set("hbase.zookeeper.property.clientPort", "2181");
		
		conf.set(TableOutputFormat.OUTPUT_TABLE, "employee01");
	
	}
	public  void createTable() throws MasterNotRunningException, ZooKeeperConnectionException, IOException {
		
		HBaseAdmin admin=new HBaseAdmin(conf);
		
		TableName name=TableName.valueOf("employee01");
		HTableDescriptor desc=new HTableDescriptor(name);
		
	    //列族描述类
		HColumnDescriptor family=new HColumnDescriptor("info01");//一个列族 多个列
	
		desc.addFamily(family);
		
		admin.createTable(desc);
		
		//table.close();
	  // conn.close();
	}
	
	
	public static void main(String[] args) throws MasterNotRunningException, ZooKeeperConnectionException, IOException, ClassNotFoundException, InterruptedException {
	
		test2 t=new test2();
		t.createTable();
		
		//获取job实例并设置名称
		 Job job=Job.getInstance(conf );
		 job.setJarByClass(test2.class);
		 TableMapReduceUtil.addDependencyJars(job);

		 //设置job的类
		 job.setJarByClass(test2.class);

		 //设置mapper类和K、V的类型
		 job.setMapperClass(myMapper1.class);
		 job.setMapOutputKeyClass(Text.class);
		 job.setMapOutputValueClass(NullWritable.class);

		 //设置reducer的类和输出类型
		 job.setReducerClass(myReducer1.class);
		 job.setOutputValueClass(NullWritable.class);

		 //设置输入路径地址和输出格式
		 FileInputFormat.addInputPath(job,new Path("F:\\周四作业20191121\\employee.txt"));
		 job.setOutputFormatClass(TableOutputFormat.class);

		 //将作业提交到群集并等待它完成
		 job.waitForCompletion(true);
	
	}

}
class myMapper1 extends Mapper<LongWritable, Text, Text,NullWritable> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
		context.write(value, NullWritable.get());//截取每一行数据发到reduce端
	}
	
}

class myReducer1 extends TableReducer<Text, NullWritable, NullWritable>{
	
	@Override
	protected void reduce(Text arg0, Iterable<NullWritable> arg1,
			Reducer<Text, NullWritable, NullWritable, Mutation>.Context arg2) throws IOException, InterruptedException {
		
		String[] arr=arg0.toString().split(" ");//文件数据
		String[] emp= {"id","Name","job","gender","birthday","salary","deptNo"};
		//empNo作为rowkey
		Put p=new Put(arr[0].getBytes());
		//循环将匹配到的键值对装入定义的列簇里
		for(int i=0;i<arr.length;i++) {
			if(i!=0) {
				
			p.addColumn("info01".getBytes(), emp[i].getBytes(), arr[i].getBytes());
			}
			
		}
		arg2.write(NullWritable.get(), p);
	}
	
}