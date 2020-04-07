package homework01;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class airMapper extends Mapper<LongWritable, Text, nanjingair,IntWritable>{
@Override
protected void map(LongWritable key, Text value,
		Mapper<LongWritable, Text, nanjingair, IntWritable>.Context context)
		throws IOException, InterruptedException {
	// TODO Auto-generated method stub
	String line=value.toString();
	String[] strs=line.split("	");
nanjingair a=new nanjingair(strs[0],strs[1],strs[2],Integer.parseInt(strs[3]),Integer.parseInt(strs[4]),Integer.parseInt(strs[5]),Integer.parseInt(strs[6]),
		Integer.parseInt(strs[7]),Integer.parseInt(strs[8]),Double.parseDouble(strs[9]) );
		context.write(a,new IntWritable(1));
}
}
