
package homework3;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;




public class JavaMapper extends  Mapper<LongWritable, Text, Text, JavaBean>{

	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, JavaBean>.Context context)
			throws IOException, InterruptedException {
		
		String line=value.toString();
		String[] str=line.split(" ");
		JavaBean jb=new JavaBean(str[0], str[1], str[2], str[3], str[4], str[5], str[6], str[7]);
		context.write(new Text(str[1]), jb);
		
	}
}
