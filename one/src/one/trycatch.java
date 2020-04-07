/*
 * 控制台程序实现学生分数录入，录入数据的格式为：语文-90,数学-80，中间逗号，和横杠分隔；
验证是否符合样式，是提示格式正确，如果格式不符合，抛出自定义异常BadFormatException，测试的时候捕获该异常并提示格式错误
说明：

1.自己定义了数据格式错误异常NoUserFoundException 
2.实现数据的控制台读取                           
3.封装了验证的方法对字符串进行分隔验证            
4.数据格式不正确的时候抛出自定义异常              
5.在主函数调用时捕获了该异常并处理提示格式不正确
 */

package one;
import java. util .Scanner ;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

@SuppressWarnings("serial")
class BadFormatException extends Exception {
    
    public BadFormatException(String value) {
        super(value);
    }
    
    }
class Input {
	 void method() throws BadFormatException{
        throw new BadFormatException("数据格式错误"); // 抛出自定义的类
    }
 
	public  boolean checkValidity () {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner ( System. in );
		String data=scan.nextLine();
		
		String pattern = ".*-.*,.*-.*";//正则表达式，格式化
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(data);
		if (m.matches()) {
			return true;
		} else {
			try {
				method();
			} catch (BadFormatException e) {
				
				e.printStackTrace();
			}
			return false;
		}
	}

}
public class trycatch {
	public static void main(String[] args) {
		Input demo1=new Input();
		demo1.checkValidity();
		
	}
}
