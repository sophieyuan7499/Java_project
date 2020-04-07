package exam.model;

import java.util.Date;

public class News {
int id ;
String title;
String content;
Date day;
int userid;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getDay() {
	return day;
}
public void setDay(Date day) {
	this.day = day;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}

}
