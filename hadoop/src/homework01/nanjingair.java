package homework01;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Date;

import org.apache.hadoop.io.WritableComparable;
import org.codehaus.janino.Java.ThisReference;



public class nanjingair implements WritableComparable<nanjingair>{
private String dayDate;
private String city;
private String station;
private int AQ;
private int PM2point5;
private int O3;
private int  PM10;
private int  SO2;
private int  NO2;
private double  CO;

public nanjingair() {
	super();
}
public nanjingair(String dayDate,String city,String station,int AQ,int PM2point5,
 int O3, int  PM10,int  SO2,int  NO2,double  CO) {
	super();
	this.dayDate=dayDate;
	this.city=city;
	this.station=station;
	this.AQ=AQ;
	this.PM2point5=PM2point5;
	this.O3=O3;
	this.PM10=PM10;
	this.SO2=SO2;
	this.NO2=NO2;
	this.CO=CO;
}



@Override
public String toString() {
	return   dayDate+" "  + city +" "+  station +" " + AQ+" " + 
			PM2point5 +" "+ O3 +" "+  PM10+" " + SO2+" " +NO2+" " + CO +" "+ "]";
}
@Override
public void readFields(DataInput arg0) throws IOException {
	// TODO Auto-generated method stub
	this.dayDate=arg0.readUTF();
	this.city=arg0.readUTF();
	this.station=arg0.readUTF();
	this.AQ=arg0.readInt();
	this.PM2point5=arg0.readInt();
	this.O3=arg0.readInt();
	this.PM10=arg0.readInt();
	this.SO2=arg0.readInt();
	this.NO2=arg0.readInt();
	this.CO=arg0.readDouble();
}
@Override
public void write(DataOutput arg0) throws IOException {
	// TODO Auto-generated method stub
	arg0.writeUTF(dayDate);
	arg0.writeUTF(city);
	arg0.writeUTF(station);
	arg0.writeInt(AQ);
	arg0.writeInt(PM2point5);
	arg0.writeInt(O3);
	arg0.writeInt(PM10);
	arg0.writeInt(SO2);
	arg0.writeInt(NO2);
	arg0.writeDouble(CO);
}
@Override
public int compareTo(nanjingair o) {
	// TODO Auto-generated method stub
	String date=o.getDayDate();
	String []arr=date.split(" ");
	if("0:00".equals(arr[1])) {
		return this.AQ-o.AQ;
	}else if("1:00".equals(arr[1])){
		return this.PM2point5-o.PM2point5;
	}else if("2:00".equals(arr[1])){
		return this.O3-o.O3;
	}else if("3:00".equals(arr[1])) {
		return this.PM10-o.PM10;
	}else if("4:00".equals(arr[1])) {
		return this.SO2-o.SO2;
	}else if("5:00".equals(arr[1])) {
	   return this.NO2-o.NO2;
	}/*else {
		return this.co-o.co;
	}*/
	return o.AQ-this.AQ;
}



public String getDayDate() {
	return dayDate;
}
public void setDayDate(String dayDate) {
	this.dayDate = dayDate;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getStation() {
	return station;
}
public void setStation(String station) {
	this.station = station;
}
public int getAQ() {
	return AQ;
}
public void setAQ(int aQ) {
	AQ = aQ;
}
public int getPM2point5() {
	return PM2point5;
}
public void setPM2point5(int pM2point5) {
	PM2point5 = pM2point5;
}
public int getO3() {
	return O3;
}
public void setO3(int o3) {
	O3 = o3;
}
public int getPM10() {
	return PM10;
}
public void setPM10(int pM10) {
	PM10 = pM10;
}
public int getSO2() {
	return SO2;
}
public void setSO2(int sO2) {
	SO2 = sO2;
}
public int getNO2() {
	return NO2;
}
public void setNO2(int nO2) {
	NO2 = nO2;
}
public double getCO() {
	return CO;
}
public void setCO(double cO) {
	CO = cO;
}




}
