package one;

import java.util.Arrays;

public class emp190903 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String str="abcdefg";
System.out.println(str.charAt(1));//����ָ�����������ַ�b
System.out.println(str.concat("123"));//abcdefg123  ��ָ�����ַ����������ӵ��ַ�����
System.out.println(str.contains("abc"));//�ж��ַ����Լ��Ӵ��Ƿ����Ŀ�괮,���ҽ������ַ�������ָ����charֵ����ʱ������true
System.out.println(str.startsWith("123"));//����ַ����Ƿ���ָ����ǰ׺��ʼ�������ز���ֵ
System.out.println(str.endsWith("123"));//�����ַ����Ƿ���ָ���ĺ�׺����
System.out.println(str.indexOf("a",5));//�ӵ�6���ַ�λ�ÿ�ʼ����������ң���û���ҵ�����-1
System.out.println(str.length());//�ַ�������
System.out.println(str.substring(3,7));//ȡ�ӵ�3λ��ʼ����7λ�������ַ�
System.out.println(str.trim());//ɾ���ַ�����ͷβ�հ׷�
String str1="hadoop|hbase|hive";
String[] strs=str1.split("\\|");//��ָ���ַ�������������ȥ�ָ�ĳ���ַ���
System.out.println(Arrays.toString(strs));
	}

}
