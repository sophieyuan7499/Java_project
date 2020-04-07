package model;

import java.sql.Date;

public class User {
	private int id;
	private String account;
	private String psw;
	private Date date;
	private String email;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String account, String psw, Date date, String email, String name) {
		super();
		this.id = id;
		this.account = account;
		this.psw = psw;
		this.date = date;
		this.email = email;
		this.name = name;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", account=" + account + ", psw=" + psw + ", date=" + date + ", email=" + email
				+ ", name=" + name + "]";
	}
	
	
}
