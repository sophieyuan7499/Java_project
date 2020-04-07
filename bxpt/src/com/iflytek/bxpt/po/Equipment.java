package com.iflytek.bxpt.po;

import java.sql.Date;
import java.sql.Timestamp;

public class Equipment {
private int  eid;
private String model;
private String number;
private int typeid;
private int brandsid;
private String address;
private Date buydate;
private int statusid;
private String status;
private String type;
private String brands;
private Timestamp rtime;



public Equipment(int eid, String model, String number, int typeid, int brandsid, String address, Date buydate,
		int statusid, String status, String type, String brands) {
	super();
	this.eid = eid;
	this.model = model;
	this.number = number;
	this.typeid = typeid;
	this.brandsid = brandsid;
	this.address = address;
	this.buydate = buydate;
	this.statusid = statusid;
	this.status = status;
	this.type = type;
	this.brands = brands;
}

public Equipment( int eid,String model, String number, int typeid, int brandsid, String address, Date buydate,
		int statusid) {
	super();
	this.eid=eid;
	this.model = model;
	this.number = number;
	this.typeid = typeid;
	this.brandsid = brandsid;
	this.address = address;
	this.buydate = buydate;
	this.statusid = statusid;
}

public Equipment( int eid,String model, String number, String address, Date buydate, String status, String type,
		String brands) {
	super();
    this.eid=eid;
	this.model = model;
	this.number = number;
	this.address = address;
	this.buydate = buydate;
	this.status = status;
	this.type = type;
	this.brands = brands;
}


public Equipment(String model, String number, int typeid, int brandsid, String address, Date buydate, int statusid) {
	super();
	this.model = model;
	this.number = number;
	this.typeid = typeid;
	this.brandsid = brandsid;
	this.address = address;
	this.buydate = buydate;
	this.statusid = statusid;
}


public Equipment(int eid, String model, String number, int typeid, int brandsid, String address, Date buydate,
		int statusid, String status, String type, String brands, Timestamp rtime) {
	super();
	this.eid = eid;
	this.model = model;
	this.number = number;
	this.typeid = typeid;
	this.brandsid = brandsid;
	this.address = address;
	this.buydate = buydate;
	this.statusid = statusid;
	this.status = status;
	this.type = type;
	this.brands = brands;
	this.rtime = rtime;
}

public Equipment(int eid, String model, String number, String address, Date buydate, String status, String type,
		String brands, Timestamp rtime) {
	super();
	this.eid = eid;
	this.model = model;
	this.number = number;	
	this.address = address;
	this.buydate = buydate;
	this.status = status;
	this.type = type;
	this.brands = brands;
	this.rtime = rtime;// TODO Auto-generated constructor stub
}

public Timestamp getRtime() {
	return rtime;
}

public void setRtime(Timestamp rtime) {
	this.rtime = rtime;
}

public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public int getTypeid() {
	return typeid;
}
public void setTypeid(int typeid) {
	this.typeid = typeid;
}
public int getBrandsid() {
	return brandsid;
}
public void setBrandsid(int brandsid) {
	this.brandsid = brandsid;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Date getBuydate() {
	return buydate;
}
public void setBuydate(Date buydate) {
	this.buydate = buydate;
}
public int getStatusid() {
	return statusid;
}
public void setStatusid(int statusid) {
	this.statusid = statusid;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getBrands() {
	return brands;
}

public void setBrands(String brands) {
	this.brands = brands;
}



}
