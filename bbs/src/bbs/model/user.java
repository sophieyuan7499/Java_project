package bbs.model;

public class user {
private int id;
private String account;
private String psw;
private String name;
private String email;

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
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
@Override
public String toString() {
	return "user [id=" + id + ", account=" + account + ", psw=" + psw +  ", name=" + name + ", email="
			+ email + "]";
}



}
