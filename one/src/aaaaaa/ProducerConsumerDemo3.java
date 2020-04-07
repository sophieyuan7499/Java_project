package aaaaaa;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerDemo3
{
	public static List<Object>list=new ArrayList<Object>();
	public static final int maxnum=100;
    public static void main(String[] args) 
    {
       
        //Consumer con = new Consumer(r);

        // 3�������߳�
        Thread t0 = new Thread(new Producer(10));
        Thread t1 = new Thread(new Producer(20));
        Thread t2 = new Thread(new Producer(30));
        Thread t3 = new Thread(new Producer(40));
        
        Thread t5 = new Thread(new Customer(10));
		Thread t6 = new Thread(new Customer(20));
		Thread t7 = new Thread(new Customer(30));
		Thread t8 = new Thread(new Customer(40));

        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t5.start();
		t6.start();
		t7.start();
		t8.start();
    }
}

class  Producer implements Runnable{
	int proNum;
	
	public Producer(int proNum){
		super();
		this.proNum=proNum;
	}
	
	@Override
	public void run() {
		synchronized (ProducerConsumerDemo3.list) {
			
			while(proNum>ProducerConsumerDemo3.maxnum) {
				System.out.println("��ǰ�ֿ��������㣬��ȴ�������");
				   //����ֿ⣬���ֲֿ��������㣬����ȴ�״̬
				   try {
				ProducerConsumerDemo3.list.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
		
					for (int i = 0; i < proNum; i++) {
		
						ProducerConsumerDemo3.list.add(new Object());
					}
					System.out.println("�Ѿ�����"+proNum+",����ֿ�,Ŀǰ�ֿ�����Ϊ��"+ProducerConsumerDemo3.list.size());
					ProducerConsumerDemo3.list.notifyAll();
		}
       }
	}
class  Customer implements Runnable{
	int conNum;
	public Customer(int conNum){
		super();
		this.conNum=conNum;
	}
	@Override
	public void run() {
		synchronized (ProducerConsumerDemo3.list) {
		while(conNum>ProducerConsumerDemo3.list.size()) {
		//	��治��
			System.out.println("��ǰ�ֿ��治�㣬��ȴ�������");
			try {
				ProducerConsumerDemo3.list.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			for(int i=0;i<conNum;i++) {
				ProducerConsumerDemo3.list.remove(0);
			}
			
			System.out.println("�Ѿ�����"+conNum+"��Ʒ������"+ProducerConsumerDemo3.list.size()+"����Ʒ");
			ProducerConsumerDemo3.list.notifyAll();
		}
		}
		
	}

