package testjava01;

public class Test {
public static void compareNum(int num1, int num2) {
    // ���ڴ˴���ɴ�С�жϣ�������ϴ��ֵ
if(num1>=num2) {
	System.out.println(num1);
}else {
	System.out.println(num2);
}


}
public static void main(String args[]) {
    int num1 = 1, num2 = 2;
    compareNum(num1, num2);
}
}