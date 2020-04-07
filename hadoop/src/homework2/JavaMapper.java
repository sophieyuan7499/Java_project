
package homework2;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;




public class JavaMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
	protected void map(LongWritable key,Text value,Mapper<LongWritable, Text, Text, IntWritable >.Context context) throws IOException, InterruptedException {
		String queryname=context.getConfiguration().get("queryname");
		String line=value.toString();
		 String type=null;
		String [] arr=line.split(" ");
		String name=arr[1];
		 if(name.startsWith(queryname)){
		type=arr[3];
		 }
			
		
		context.write(new Text(type), new IntWritable(Integer.valueOf(1)));  
		

	
	}
	}