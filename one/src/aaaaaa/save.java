package aaaaaa;

public class save {
	public static void main(String args[]) {
		savemoney s=new savemoney();
		Thread s1=new Thread(s);
		Thread s2=new Thread(s);
		s1.start();
		s2.start();
	}
}

class savemoney implements Runnable{
	int money=1000;
	int sum=0;
	public void run() {
		for(int i=1;i<=6;i++) {
			synchronized(this){
				notify();
					try {
						Thread.sleep(2);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	if(sum<6000) {
			if(Thread.currentThread().getName().equals("0")) {
				
				System.out.println(Thread.currentThread().getName()+"存入"+money);
				sum+=money;		
			}else  {

				System.out.println(Thread.currentThread().getName()+"存入"+money);
				sum+=money;
			}
			System.out.println("账户当前余额"+sum);
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
			}
			
	}
}
	}