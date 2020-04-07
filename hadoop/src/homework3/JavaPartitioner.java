package homework3;

import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public abstract class JavaPartitioner extends Partitioner<Text, JavaBean>{
static Map<String,Integer> map=new HashMap<String,Integer>();

static {
	map.put("01", 0);
	map.put("02", 1);
	map.put("03", 2);
	map.put("04", 3);
	map.put("05", 4);
	map.put("06", 5);
	map.put("07", 6);
	map.put("08", 7);
	map.put("09", 8);
	map.put("10", 9);
	map.put("11", 10);
	map.put("12", 11);
}
@Override
public int getPartition(Text arg0, JavaBean arg1, int arg2) {
	
	String data=arg0.toString();
	String[] str=data.split("-");
	
    Integer n=map.get(str[1]);//获取月份
    if(n==null) {
    	
    	return 12;
    }else {
    	
    	return n;
    }
	
}

}
