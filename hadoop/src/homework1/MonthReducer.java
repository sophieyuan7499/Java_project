package homework1;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import homework1.flowBean;



public class MonthReducer extends Reducer<Text , flowBean, Text , flowBean> {
@Override
protected void reduce(Text arg0, Iterable<flowBean> arg1, Reducer<Text, flowBean, Text, flowBean>.Context arg2)
		throws IOException, InterruptedException {
	// TODO Auto-generated method stub
String name = null;
String type = null;
 String price = null;
 String id = null;
 String selAddr = null;
 String recAddr = null;
 String phone = null;

for(flowBean flow:arg1) {
	id=flow.getId();
	name=flow.getName();
	type=flow.getType();
	price=flow.getPrice();
	selAddr=flow.getSelAddr();
	recAddr=flow.getRecAddr();
	phone=flow.getPhone();
}
flowBean fb=new flowBean(id,name,arg0.toString(),type,price,selAddr,recAddr,phone);
	arg2.write(arg0,fb);
	
	
	}
}

