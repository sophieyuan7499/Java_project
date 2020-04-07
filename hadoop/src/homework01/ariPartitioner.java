package homework01;

import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class ariPartitioner extends Partitioner<nanjingair, IntWritable>{
static Map<String,Integer> map=new HashMap<>();
	
	static {
	map.put("0:00", 0);
	map.put("1:00", 1);
	map.put("2:00", 2);
	map.put("3:00", 3);
	map.put("4:00", 4);
	map.put("5:00", 5);
	map.put("6:00", 6);
		
		
	}
	@Override
	public int getPartition(nanjingair arg0, IntWritable arg1, int arg2) {
String day=arg0.getDayDate().toString();
		String []arr=day.split(" ");
		Integer i =map.get(arr[1]);
		
		if(i ==null) {
			return 7;
		}		
		return i;
	}

}
