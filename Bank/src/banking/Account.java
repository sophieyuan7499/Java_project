package banking;

public class Account {
	
public  double balance;

public Account(double balance) {//����
	super();
	this.balance=balance;
	System.out.println("Creating an account with a "+ balance+ " balance");
}
	public double getBalance() {//��ȡ���
		return balance;
	}
	public boolean deposit(double money) {//���
		System.out.println("Deposit "+ money +":true" );
		 this.balance+=money;
		return true;
	}
	
	public boolean withdraw(double money) {//ȡ��
		
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

