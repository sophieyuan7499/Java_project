/*
 * ����̨����ʵ��ѧ������¼�룬¼�����ݵĸ�ʽΪ������-90,��ѧ-80���м䶺�ţ��ͺ�ָܷ���
��֤�Ƿ������ʽ������ʾ��ʽ��ȷ�������ʽ�����ϣ��׳��Զ����쳣BadFormatException�����Ե�ʱ�򲶻���쳣����ʾ��ʽ����
˵����

1.�Լ����������ݸ�ʽ�����쳣NoUserFoundException 
2.ʵ�����ݵĿ���̨��ȡ                           
3.��װ����֤�ķ������ַ������зָ���֤            
4.���ݸ�ʽ����ȷ��ʱ���׳��Զ����쳣              
5.������������ʱ�����˸��쳣��������ʾ��ʽ����ȷ
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
        throw new BadFormatException("���ݸ�ʽ����"); // �׳��Զ������
    }
 
	public  boolean checkValidity () {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner ( System. in );
		String data=scan.nextLine();
		
		String pattern = ".*-.*,.*-.*";//������ʽ����ʽ��
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
