package homework3;

import java.io.IOException;
import java.util.Iterator;


import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


public class JavaReducer extends Reducer<Text, JavaBean, Text, Text>{

	@Override
	protected void reduce(Text arg0, Iterable<JavaBean> arg1, Reducer<Text, JavaBean, Text, Text>.Context arg2)
			throws IOException, InterruptedException {
		
		Iterator<JavaBean> i=arg1.iterator();
		String id=null;
		String name=null;
	
		String type=null;
	    String price=null;
		String selAddr=null;
	     String recAddr=null;
		 String phone=null;
		while(i.hasNext()) {
			JavaBean c=i.next();
		    id=c.getId();
			name=c.getName();
			type=c.getType();
			selAddr=c.getSelAddr();
			recAddr=c.getRecAddr();
			price=c.getPrice();
			phone=c.getPhone();
			
		}
		
	
	arg2.write(arg0, new Text(id+" "+name+" "+type+" "+price+" "+selAddr+" "+recAddr+" "+phone));
	}

}
