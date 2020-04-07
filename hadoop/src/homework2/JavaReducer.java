package homework2;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;



public class JavaReducer extends Reducer<Text,  JavaBean,Text, Text>{
	
	protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        int sum=0;
        //获取当前遍历的value
        for (IntWritable v : values) {
            sum+=v.get();
        }
        context.write(key,new IntWritable(sum));
    }
}