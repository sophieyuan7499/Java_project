package homework1;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MonthMapper extends Mapper<LongWritable, Text,Text, flowBean>{
@Override
protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, flowBean>.Context context)
		throws IOException, InterruptedException {
	// TODO Auto-generated method stub
	String line=value.toString();
	String[] strs=line.split(" ");
	flowBean f=new flowBean(strs[0],strs[1],strs[2],strs[3],strs[4],strs[5],strs[6],strs[7]);
	context.write(new Text(strs[2]), f);
	}
}
