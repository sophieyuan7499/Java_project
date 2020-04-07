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
	
	private Connection conn;//�Ա����һϵ�в�������Ҫ��������
	private Table table;
	static {
		
		conf=HBaseConfiguration.create();
		//Ĭ�ϻ��classpath�в���hbase-site.xml��������Ϣ����ʼ��Configuration
		conf.set("hbase.zookeeper.quorum","test1,test2,test3");
		conf.set("hbase.zookeeper.property.clientPort", "2181");
		
		conf.set(TableOutputFormat.OUTPUT_TABLE, "employee01");
	
	}
	public  void createTable() throws MasterNotRunningException, ZooKeeperConnectionException, IOException {
		
		HBaseAdmin admin=new HBaseAdmin(conf);
		
		TableName name=TableName.valueOf("employee01");
		HTableDescriptor desc=new HTableDescriptor(name);
		
	    //����������
		HColumnDescriptor family=new HColumnDescriptor("info01");//һ������ �����
	
		desc.addFamily(family);
		
		admin.createTable(desc);
		
		//table.close();
	  // conn.close();
	}
	
	
	public static void main(String[] args) throws MasterNotRunningException, ZooKeeperConnectionException, IOException, ClassNotFoundException, InterruptedException {
	
		test2 t=new test2();
		t.createTable();
		
		//��ȡjobʵ������������
		 Job job=Job.getInstance(conf );
		 job.setJarByClass(test2.class);
		 TableMapReduceUtil.addDependencyJars(job);

		 //����job����
		 job.setJarByClass(test2.class);

		 //����mapper���K��V������
		 job.setMapperClass(myMapper1.class);
		 job.setMapOutputKeyClass(Text.class);
		 job.setMapOutputValueClass(NullWritable.class);

		 //����reducer������������
		 job.setReducerClass(myReducer1.class);
		 job.setOutputValueClass(NullWritable.class);

		 //��������·����ַ�������ʽ
		 FileInputFormat.addInputPath(job,new Path("F:\\������ҵ20191121\\employee.txt"));
		 job.setOutputFormatClass(TableOutputFormat.class);

		 //����ҵ�ύ��Ⱥ�����ȴ������
		 job.waitForCompletion(true);
	
	}

}
class myMapper1 extends Mapper<LongWritable, Text, Text,NullWritable> {
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, NullWritable>.Context context)
			throws IOException, InterruptedException {
		context.write(value, NullWritable.get());//��ȡÿһ�����ݷ���reduce��
	}
	
}

class myReducer1 extends TableReducer<Text, NullWritable, NullWritable>{
	
	@Override
	protected void reduce(Text arg0, Iterable<NullWritable> arg1,
			Reducer<Text, NullWritable, NullWritable, Mutation>.Context arg2) throws IOException, InterruptedException {
		
		String[] arr=arg0.toString().split(" ");//�ļ�����
		String[] emp= {"id","Name","job","gender","birthday","salary","deptNo"};
		//empNo��Ϊrowkey
		Put p=new Put(arr[0].getBytes());
		//ѭ����ƥ�䵽�ļ�ֵ��װ�붨����д���
		for(int i=0;i<arr.length;i++) {
			if(i!=0) {
				
			p.addColumn("info01".getBytes(), emp[i].getBytes(), arr[i].getBytes());
			}
			
		}
		arg2.write(NullWritable.get(), p);
	}
	
}