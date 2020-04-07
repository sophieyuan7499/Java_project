package bbs.model;

import java.sql.Date;

public class Comment {
	private int id;
	private String content;
	private Date date;
	private int userid;
	private int newsid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", date=" + date + ", userid=" + userid + ", nuwsid="
				+ newsid + "]";
	}
	
	
}
