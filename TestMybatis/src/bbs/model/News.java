package bbs.model;

import java.util.Date;

public class News {
private int id;
private String title;
private String content;
private Date date;
private int userid;

private String username;

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

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

@Override
public String toString() {
	return "News [id=" + id + ", title=" + title + ", content=" + content + ", date=" + date + ", userid=" + userid
			+ ", username=" + username + "]";
}


}
