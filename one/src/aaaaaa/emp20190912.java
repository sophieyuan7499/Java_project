package aaaaaa;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
public class emp20190912 {

	public static void main(String[] args) {
		Collection<String> c=new ArrayList<String>();
	    c.add("111");
	    
	    Collection<String> c1=new ArrayList<String>();
	    c1.add("AA");
	    c1.add("BB");
	    c.addAll(c1);//��c1��Ԫ����ӵ�c��

	    System.out.println(c);
	    System.out.println(c1);

	    //c.clear();
	    //System.out.println(c);
	    System.out.println(c.contains("yzh"));//�ж��Ƿ����ĳ��Ԫ��
	    System.out.println(c.containsAll(c1));//�ж��Ƿ����c1
	    System.out.println(c.equals(c1));//�Ƚ�c��c1��ֵ�Ƿ���ͬ
	    /*c.remove("111");
	    System.out.println(c);*/
	    /*c.removeAll(c1);
	    System.out.println(c);*/
	    c.retainAll(c1);
	    System.out.println(c);//ȡ����
	   
	    Iterator i=c.iterator();
	    while(i.hasNext()) {
	    	 System.out.println(i.next());
	    }
	 }
}
