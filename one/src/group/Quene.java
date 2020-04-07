package group;

import java.util.ArrayList;
import java.util.List;

public class Quene {
	 private List list = new ArrayList();

	//入队

	public void push(int data){
		list.add(data);
	}

	public int pop(){
		Object data=null;
		if(!list.isEmpty()){
			for (Object obj : list) {
				System.out.println(obj);
				list.remove(obj);
		            }
		        }else{
		 return 0;
		        }
		return 0;
	}

	}

 class Stack{

	private List list = new ArrayList();

	//入栈

	public void push(int data){
		list.add(data);
	}

	//出栈

	public int pop(){
		Object data=null;
		 if(!list.isEmpty()){
			 data=list.get(list.size()-1);
			 System.out.println(data);
			 list.remove(data);
		        }else{
		        	return 0;
		        }
		 return 0;
	}
 
	//取栈顶元素

	public Object top(){
	 return list.get(0);
	}

	} 
