package homework1;

import java.util.HashMap;
import java.util.Map;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MonthPartitioner extends Partitioner<Text, flowBean>{
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
	public int getPartition(Text arg0, flowBean arg1, int arg2) {
		// TODO Auto-generated method stub
		String month=arg0.toString().substring(5, 7);
		Integer num= map.get(month);
		if(num==null) {
			return 12;
		}
		return num;
		
	}

}

