package homework01;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class Main {
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		Job wcjob = Job.getInstance(conf);
		//ָ�������job���ڵ�jar��
		wcjob.setJarByClass(Main.class);
		
		//ָ��map �� reduce�����ڵ�class
		wcjob.setMapperClass(airMapper .class);
		wcjob.setReducerClass(airReducer.class);
		
		//ָ�����������ڵ�class
		wcjob.setPartitionerClass(ariPartitioner.class);
		//ָ��reduce�ĸ�����reduceTask�����������ƥ��
		wcjob.setNumReduceTasks(8);
	
		
		//����ҵ���߼�Mapper������key��value����������
		wcjob.setMapOutputKeyClass(nanjingair.class);
		wcjob.setMapOutputValueClass(IntWritable.class);
		
		//����ҵ���߼�Reducer������key��value����������
		wcjob.setOutputKeyClass(Text.class);
		wcjob.setOutputValueClass(NullWritable.class);

		//ָ��Ҫ������������ڵ�λ��
		FileInputFormat.setInputPaths(wcjob, new Path("f://nanjin_air.txt"));
		//ָ���������֮��Ľ���������λ��
		//FileOutputFormat.setOutputPath(wcjob, new Path("hdfs://192.168.247.135:9000/test/homework02/res01" ));
		FileOutputFormat.setOutputPath(wcjob, new Path("hdfs://192.168.247.135:9000/test/homework02/res02" ));

		//��yarn��Ⱥ�ύ���job
		boolean res = wcjob.waitForCompletion(true);
		System.exit(res?0:1);
	}

}