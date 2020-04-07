package homework3;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;



public class JavaBean implements WritableComparable< JavaBean>{
	private String name;
	private String type;
	private String price;
	private String day;
	private String id;
	private String selAddr;
	private String recAddr;
	private String phone;
	
	
	@Override
	public void readFields(DataInput arg0) throws IOException {
		// TODO Auto-generated method stub
		this.day=arg0.readUTF();
		this.name=arg0.readUTF();
		this.type=arg0.readUTF();
		this.price=arg0.readUTF();
		this.id=arg0.readUTF();
		this.selAddr=arg0.readUTF();
		this.recAddr=arg0.readUTF();
		this.phone=arg0.readUTF();
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		// TODO Auto-generated method stub
		arg0.writeUTF(day);
		arg0.writeUTF(name);
		arg0.writeUTF(type);
		arg0.writeUTF(price);
		arg0.writeUTF(id);
		arg0.writeUTF(selAddr);
		arg0.writeUTF(recAddr);
		arg0.writeUTF(phone);
	}
	public int compareTo(JavaBean o) {
		// TODO Auto-generated method stub
		String date=o.getDay();
		String[] arr1=date.split("-");
		String[]  arr2=day.split("-");
		if(arr1[0].equals(arr2[0])) {
			if(arr1[1].equals(arr2[1])) {
				return Integer.parseInt(arr2[2])-Integer.parseInt(arr1[2]);
			}else {
				return Integer.parseInt(arr2[1])-Integer.parseInt(arr1[1]);
			}
		}
		return  Integer.parseInt(this.day)-Integer.parseInt(o.getDay());
		
	}
	
	
	public JavaBean() {
		super();
	}

	public JavaBean(String id,String name,String day,String type,String price,String selAddr,String recAddr,String phone) {
		super();
		this.day=day;
		this.name=name;
		this.type=type;
		this.price=price;
		this.id=id;
		this.selAddr=selAddr;
		this.recAddr=recAddr;
		this.phone=phone;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSelAddr() {
		return selAddr;
	}

	public void setSelAddr(String selAddr) {
		this.selAddr = selAddr;
	}

	public String getRecAddr() {
		return recAddr;
	}

	public void setRecAddr(String recAddr) {
		this.recAddr = recAddr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	
}
