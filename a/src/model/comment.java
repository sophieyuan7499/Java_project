package model;

import java.sql.Timestamp;

public class comment {
	private int id;
	private int userid;
	private String content;
	private Timestamp time;
	private int newsid;
	private String userName;

	private String dateStr;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
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
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "comment [id=" + id + ", uersid=" + userid + ", content=" + content + ", time=" + time + "]";
	}
	
	
	
}
