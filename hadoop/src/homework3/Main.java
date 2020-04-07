package homework3;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;




public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		Job wcjob = Job.getInstance(conf);
		//指定我这个job所在的jar包
		wcjob.setJarByClass(Main.class);
		
		//指定map 和 reduce类所在的class
		wcjob.setMapperClass(JavaMapper .class);
		wcjob.setReducerClass(JavaReducer.class);
		
		//指定分区类所在的class
				wcjob.setPartitionerClass(JavaPartitioner.class);
				//指定reduce的个数，reduceTask个数与分区数匹配
				wcjob.setNumReduceTasks(13);
		
		//设置业务逻辑Mapper类的输出key和value的数据类型
		wcjob.setMapOutputKeyClass(Text.class);
		wcjob.setMapOutputValueClass(JavaBean.class);
		
		//设置业务逻辑Reducer类的输出key和value的数据类型
		wcjob.setOutputKeyClass(Text.class);
		wcjob.setOutputValueClass(Text.class);

		//指定要处理的数据所在的位置
		FileInputFormat.setInputPaths(wcjob, new Path("e://consumption.log"));
		//指定处理完成之后的结果所保存的位置
		FileOutputFormat.setOutputPath(wcjob, new Path("hdfs://192.168.247.135:9000/test/homework/res02" ));

		//向yarn集群提交这个job
		boolean res = wcjob.waitForCompletion(true);
		System.exit(res?0:1);
	}

}
