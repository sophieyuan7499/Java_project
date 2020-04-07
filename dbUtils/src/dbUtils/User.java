package dbUtils;

public class User {
private int id;
private String account;
private String psw;
private int money;
private String name;
//dbUtils使用反射创建对象，要求有无参构造函数
public User(){
	super();
}

public User (String account,String psw,int money,String name ) {
	super();
	this.account=account;
	this.psw=psw;
	this.money=money;
	this.name=name;
	
}
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
public int getMoney() {
	return money;
}
public void setMoney(int money) {
	this.money = money;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "User [id=" + id + ", account=" + account + ", psw=" + psw + ", money=" + money + ", name=" + name + "]";
}


}
