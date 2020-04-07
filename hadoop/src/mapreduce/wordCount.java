package mapreduce;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class wordCount {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		Job wcjob = Job.getInstance(conf);
		//ָ�������job���ڵ�jar��
		wcjob.setJarByClass(wordCount.class);
		
		//ָ��map �� reduce�����ڵ�class
		wcjob.setMapperClass(wordcountMap.class);
		wcjob.setReducerClass(wordcountReduce.class);
		
		//����ҵ���߼�Mapper������key��value����������
		wcjob.setMapOutputKeyClass(Text.class);
		wcjob.setMapOutputValueClass(IntWritable.class);
		
		//����ҵ���߼�Reducer������key��value����������
		wcjob.setOutputKeyClass(Text.class);
		wcjob.setOutputValueClass(IntWritable.class);

		//ָ��Ҫ�������������ڵ�λ��
		FileInputFormat.setInputPaths(wcjob, new Path("D://datas/gv/gun.txt"));
		//ָ���������֮��Ľ���������λ��
		FileOutputFormat.setOutputPath(wcjob, new Path("hdfs://192.168.247.135:9000/gv/re2"));
		//FileOutputFormat.setOutputPath(wcjob, new Path("D://datas/gv/re2"));
		//��yarn��Ⱥ�ύ���job
		boolean res = wcjob.waitForCompletion(true);
		System.exit(res?0:1);
	}

}

//��ȷMap���������������  ����
//KEYIN��LongWritable �к�
//VALUEIN���ı�  һ������ Text
//KEYOUT���ı� Text
//VALUEOUT��Text

class wordcountMap extends Mapper<LongWritable, Text, Text, IntWritable>{ 
	@Override
	//key�к�
	//value �ı�
	//context �����Ķ���
	//ÿһ�����������ִ��һ��map����
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//super.map(key, value, context);
		String line=value.toString();
		String[] arr=line.split(",");
		for(String ele:arr) {
			context.write(new Text(ele), new IntWritable(1));
		}
	}
}


//KEYIN:Text   <a,1><a,1>
// VALUEIN:IntWritable  
// KEYOUT:Text  <a,2>
// VALUEOUT:IntWritable  
class wordcountReduce extends Reducer<Text, IntWritable, Text, IntWritable>{
	@Override
	//arg0: a
	//arg1:<1,1>
	//<a,<1,1>>
	//ÿ����һ���µ�keyֵ��ִ��һ��reduce����
	protected void reduce(Text arg0, Iterable<IntWritable> arg1,
			Reducer<Text, IntWritable, Text, IntWritable>.Context arg2) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		//super.reduce(arg0, arg1, arg2);
	Iterator<IntWritable> i =arg1.iterator(); 
	int count=0;
	while(i.hasNext()) {
	IntWritable num=	i.next();
	count+=num.get();
	}
	arg2.write(arg0,new IntWritable(count));
	}
}