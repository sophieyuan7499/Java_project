package one;

import java.util.ArrayList;
import java.util.Scanner;


public class logintest {
	@SuppressWarnings("serial")
	 public static class NoEmployeeFoundException extends Exception {
	    
	    public NoEmployeeFoundException(String value) {
	        super(value);
	    }
	    }
	 static void method() throws NoEmployeeFoundException{
	        throw new NoEmployeeFoundException("工号不存在！ "); // 抛出自定义的类
	 }
	 
	 
	  public static class employee {
		  String id;
		String name;
			int workage;
		    String password;
		    
		    public employee(String id,String name,int workage,String password) {
		    	this.id=id;
		    	this.name=name;
		    	this.workage=workage;
		    	this.password=password;
		    }

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}
		   
	  }
	  
	  
	  static Scanner scanner = new Scanner(System.in);
	    static ArrayList<employee> emps = new ArrayList<employee>();


	    public static void login(){
	        System.out.println("请输入账号：");
	        String id = scanner.next();
	        System.out.println("请输入密码：");
	        String password = scanner.next();
	 
	     
	        
	        for (employee emp : emps) {
	        	 if((emp.getId().equals(id) )&& (emp.getPassword().equals(password))){
	        		 System.out.println("登录成功！");
		            	break;
	        	  }else if(!emp.getId().equals(id)){
	        	  try {
	      			method();
	      			} catch (NoEmployeeFoundException  e1) {
	      				
	      				e1.printStackTrace();
	      				break;
	      			}
		            }else
		            {
		            	  System.out.println("密码错误，请重新登录 ");
			        	 break;
		            	
		            }
	        }
	        
	    }
	    
	    public static void regist(){
	    	employee e1=new employee("0001"," 张三", 3 ,"12345 ");
	    	e1.setId("0001");
	    	e1.setPassword("12345");
	    	emps.add(e1);
	    	
	    	employee e2=new employee("0002","李四", 4 ,"12345" );
	    	e2.setId("0002");
	    	e2.setPassword("12345");
	    	emps.add(e2);
	    	
	    	employee e3=new employee("0003","王五", 1 ,"12345" );
	    	e3.setId("0003");
	    	e3.setPassword("12345");
	    	emps.add(e3);
	    
	    }
	
public static void main(String[] args) {
	
	System.out.println("欢迎登录员工系统");
	regist();
	login();
   }
}
