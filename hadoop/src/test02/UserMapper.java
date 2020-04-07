package test02;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class UserMapper extends Mapper<LongWritable, Text, Text, SalesUser>{
@Override
protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, SalesUser>.Context context)
		throws IOException, InterruptedException {
	// TODO Auto-generated method stub
	 String line = value.toString();
	 String[] strs=line.split(",");
	 
}
}
