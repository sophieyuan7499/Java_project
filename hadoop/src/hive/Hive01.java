package hive;
import org.apache.hadoop.hive.ql.exec.UDF;
public class Hive01 extends UDF{

public  String evaluate (String text,int index) {
	  String replaceAll = text.replaceAll("\\|", ":");
	  String[] split = replaceAll.split(":");
	  return split[index-1];
	 
}
public static void main(String[] args) {
	Hive01 u = new Hive01();
    String str = u.evaluate("zhangsan:18:beijing|male|it",5);
    System.out.println(str);
 
}
}

