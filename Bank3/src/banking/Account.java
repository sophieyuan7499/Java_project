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

class SavingAccount  extends Account {
	double  interestRate ;
	
	public SavingAccount(double balance ,double interest_rate) {
		super(balance);
		// TODO Auto-generated constructor stub
		System.out.println("Creating an Saveing Account with a "+ balance+ " balance and "+ interest_rate*100 +"% interest.");
	}
}

class CheckingAccount  extends Account{
	double overdraftProtection;
	 
	public CheckingAccount(double balance) {
	super(balance);	
	System.out.println("Creating an Checking Account with a "+ balance+ " balance and no overdraft protection.  ");
	}
	
	public CheckingAccount(double balance,double protect) {
		 super(balance);
		 overdraftProtection+=protect;
		 System.out.println("Creating an Checking Account with a "+ balance+ " balance and "+ protect +" no overdraft protection.  ");
	} 
	
	public boolean withdraw(double amount) {//ȡ��
		
		if(amount>this.balance) {
			System.out.println("withdraw "+amount+":false" );
			return false;
		}
	else if(amount>(this.balance+overdraftProtection)){
			return false;
		}
		else {
			System.out.println("withdraw "+ amount+":true" );
			
			this.balance=overdraftProtection-(this.balance-amount);
			return true;
		}
			}
}

