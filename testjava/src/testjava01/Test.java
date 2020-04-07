package testjava01;

public class Test {
public static void compareNum(int num1, int num2) {
    // 请在此处完成大小判断，并输出较大的值
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