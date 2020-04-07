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
		//指定我这个job所在的jar包
		wcjob.setJarByClass(wordCount.class);
		
		//指定map 和 reduce类所在的class
		wcjob.setMapperClass(wordcountMap.class);
		wcjob.setReducerClass(wordcountReduce.class);
		
		//设置业务逻辑Mapper类的输出key和value的数据类型
		wcjob.setMapOutputKeyClass(Text.class);
		wcjob.setMapOutputValueClass(IntWritable.class);
		
		//设置业务逻辑Reducer类的输出key和value的数据类型
		wcjob.setOutputKeyClass(Text.class);
		wcjob.setOutputValueClass(IntWritable.class);

		//指定要处理的数据所在的位置
		FileInputFormat.setInputPaths(wcjob, new Path("D://datas/gv/gun.txt"));
		//指定处理完成之后的结果所保存的位置
		FileOutputFormat.setOutputPath(wcjob, new Path("hdfs://192.168.247.135:9000/gv/re2"));
		//FileOutputFormat.setOutputPath(wcjob, new Path("D://datas/gv/re2"));
		//向yarn集群提交这个job
		boolean res = wcjob.waitForCompletion(true);
		System.exit(res?0:1);
	}

}

//明确Map函数输入输出类型  泛型
//KEYIN：LongWritable 行号
//VALUEIN：文本  一行数据 Text
//KEYOUT：文本 Text
//VALUEOUT：Text

class wordcountMap extends Mapper<LongWritable, Text, Text, IntWritable>{ 
	@Override
	//key行号
	//value 文本
	//context 上下文对象
	//每一行数据输入就执行一次map函数
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
	//每输入一个新的key值就执行一次reduce函数
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