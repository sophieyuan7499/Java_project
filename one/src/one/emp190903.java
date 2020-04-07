package one;

import java.util.Arrays;

public class emp190903 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String str="abcdefg";
System.out.println(str.charAt(1));//返回指定索引处的字符b
System.out.println(str.concat("123"));//abcdefg123  将指定的字符串参数连接到字符串上
System.out.println(str.contains("abc"));//判断字符串以及子串是否包含目标串,当且仅当此字符串包含指定的char值序列时，返回true
System.out.println(str.startsWith("123"));//检测字符串是否以指定的前缀开始，并返回布尔值
System.out.println(str.endsWith("123"));//测试字符串是否以指定的后缀结束
System.out.println(str.indexOf("a",5));//从第6个字符位置开始往后继续查找，若没有找到返回-1
System.out.println(str.length());//字符串长度
System.out.println(str.substring(3,7));//取从第3位开始到第7位结束的字符
System.out.println(str.trim());//删除字符串的头尾空白符
String str1="hadoop|hbase|hive";
String[] strs=str1.split("\\|");//按指定字符（串）或正则去分割某个字符串
System.out.println(Arrays.toString(strs));
	}

}
