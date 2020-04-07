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

        // 3、创建线程
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
				System.out.println("当前仓库容量不足，请等待。。。");
				   //进入仓库，发现仓库容量不足，进入等待状态
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
					System.out.println("已经生产"+proNum+",存入仓库,目前仓库容量为："+ProducerConsumerDemo3.list.size());
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
		//	库存不足
			System.out.println("当前仓库库存不足，请等待。。。");
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
			
			System.out.println("已经消费"+conNum+"商品，还有"+ProducerConsumerDemo3.list.size()+"件商品");
			ProducerConsumerDemo3.list.notifyAll();
		}
		}
		
	}

