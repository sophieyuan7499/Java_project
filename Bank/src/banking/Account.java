package banking;

public class Account {
	
public  double balance;

public Account(double balance) {//开户
	super();
	this.balance=balance;
	System.out.println("Creating an account with a "+ balance+ " balance");
}
	public double getBalance() {//获取余额
		return balance;
	}
	public boolean deposit(double money) {//存款
		System.out.println("Deposit "+ money +":true" );
		 this.balance+=money;
		return true;
	}
	
	public boolean withdraw(double money) {//取款
		
if(money>this.balance) {
	System.out.println("withdraw "+money+":false" );
	return false;
}else {
	System.out.println("withdraw "+ money+":true" );
	this.balance-=money;
	return true;
}
	}
}

