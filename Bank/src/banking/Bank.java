package banking;

public class Bank {
public Customer[]	customer;
int numberOfCustomers;

public Bank() {
	
customer=new Customer[20];

}

public boolean addCustomer(Customer c) {
	//将客户添加进数组
	
	for(int i=0;i<customer.length;i++) {
	if(customer[i]==null) {
		customer[i]=c;
		numberOfCustomers++;
		return true;
	}	
	}
	
	return false;
	}

public int getNumOfCustomers() {
	return numberOfCustomers;
}
public Customer getCustomers(int index) {
	return customer[index];
}
}
