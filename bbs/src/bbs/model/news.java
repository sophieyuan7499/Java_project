package bbs.model;

import java.util.Date;

public class news {
	private int id;
	private String title;
	private String content;
	private Date date;
	private int userid;
	public news() {}
	
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
	@Override
	public String toString() {
		return "news [id=" + id + ", title=" + title + ", content=" + content + ", date=" + date + ", userid=" + userid
				+ "]";
	}
	
}
