package homework01;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class airReducer extends Reducer<nanjingair,IntWritable, Text, NullWritable> {
@Override
protected void reduce(nanjingair arg0, Iterable<IntWritable> arg1,
		Reducer<nanjingair, IntWritable, Text, NullWritable>.Context arg2)
		throws IOException, InterruptedException {
	// TODO Auto-generated method stub
	
	arg2.write(new Text(""+arg0.getDayDate()+arg0), NullWritable.get());
}
}
