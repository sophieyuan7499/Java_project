package banking;

public class TestBanking {

	public static void main(String[] args) {	
		/*Customer cus=new Customer("Jane","Smith");
		Account acc=new Account(500);
		//将账户与客户之间建立关系
		cus.setAccount(acc);
		cus.getAccount().withdraw(150);
		cus.getAccount().deposit(22.5);
		cus.getAccount().withdraw(47.62);
		cus.getAccount().withdraw(400);
	
		System.out.println("customer["+ cus.getLastName()+","+cus.getFirstName()+"] has a balance of"+cus.getAccount().getBalance());*/
		
		Bank bank=new Bank();
		
		Customer cus1=new Customer("Jane","Simms");
		Customer cus2=new Customer("Owen","Bryant");
		Customer cus3=new Customer("Tim","Soley");
		Customer cus4=new Customer("Maria","Soley");
		
		bank.addCustomer(cus1);
		bank.addCustomer(cus2);
		bank.addCustomer(cus3);
		bank.addCustomer(cus4);
		
			for(int i=0;i<bank.getNumOfCustomers();i++) {
				
				System.out.println("Customer["  + (i+1) + "]"+ "is"+bank.getCustomers(i).getFirstName()+","+bank.getCustomers(i).getLastName() );
			}
}
}