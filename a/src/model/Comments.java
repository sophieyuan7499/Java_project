package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comments {
	private int id;
	private String content;
	private Date date;
	private int newsid;
	private int userid;
	//联合查询的时�??   对应查询的结�??   username  (对结果取得别�??    �??�??对应)
	private String userName;

	//创建新的属�??
	private String dateStr;
	
	public Comments(){
		
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	@Override
	public String toString() {
		return "Comments [id=" + id + ", content=" + content + ", date=" + date + ", newsid=" + newsid + ", userid="
				+ userid + ", userName=" + userName + ", dateStr=" + dateStr + "]";
	}
	
}
