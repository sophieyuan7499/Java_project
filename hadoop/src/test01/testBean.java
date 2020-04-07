package test01;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

import homework1.flowBean;

public class testBean implements WritableComparable<flowBean>{
String className;
String studentName;
String score;

public testBean() {
	super();
}

public testBean(String className,String studentName,String score) {
	super();
	this.className=className;
	this.studentName=studentName;
	this.score=score;		
}


@Override
public void readFields(DataInput arg0) throws IOException {
	// TODO Auto-generated method stub
	this.className=arg0.readUTF();
	this.studentName=arg0.readUTF();
	this.score=arg0.readUTF();
}

@Override
public void write(DataOutput arg0) throws IOException {
	// TODO Auto-generated method stub
	
}

@Override
public int compareTo(flowBean o) {
	// TODO Auto-generated method stub
	return 0;
}


public String getScore() {
	return score;
}

public void setScore(String score) {
	this.score = score;
}

public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
}
public String getStudentName() {
	return studentName;
}
public void setStudentName(String studentName) {
	this.studentName = studentName;
}



}
