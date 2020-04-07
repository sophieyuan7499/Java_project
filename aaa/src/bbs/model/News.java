package bbs.model;

import java.sql.Date;

public class News {
	private int id;
	private String title;
	private String content;
	private Date date;
	private int userid;
	
	
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
	public void setDate(Date date) {
		this.date = date;
	}
	public Date getDate() {
		return date;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content + ", date=" + date + ", userid=" + userid
				+ "]";
	}
	
	
}
