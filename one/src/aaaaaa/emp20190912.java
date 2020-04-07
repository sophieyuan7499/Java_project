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
	    c.addAll(c1);//把c1的元素添加到c中

	    System.out.println(c);
	    System.out.println(c1);

	    //c.clear();
	    //System.out.println(c);
	    System.out.println(c.contains("yzh"));//判断是否包含某个元素
	    System.out.println(c.containsAll(c1));//判断是否包含c1
	    System.out.println(c.equals(c1));//比较c与c1的值是否相同
	    /*c.remove("111");
	    System.out.println(c);*/
	    /*c.removeAll(c1);
	    System.out.println(c);*/
	    c.retainAll(c1);
	    System.out.println(c);//取交集
	   
	    Iterator i=c.iterator();
	    while(i.hasNext()) {
	    	 System.out.println(i.next());
	    }
	 }
}
