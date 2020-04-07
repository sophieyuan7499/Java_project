package bbs.model;

import java.util.Date;

public class content {
	private int id;
	private String content;
	private Date date;
	private int newsid;
	private int userid;
	private String dateStr;
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
@Override
	public String toString() {
		return "content [id=" + id + ", content=" + content + ", date=" + date + ", newsid=" + newsid + ", userid=" + userid
			+ "]";
	}
public String getDateStr() {
	return dateStr;
}
public void setDateStr(String dateStr) {
	this.dateStr = dateStr;
}
}
