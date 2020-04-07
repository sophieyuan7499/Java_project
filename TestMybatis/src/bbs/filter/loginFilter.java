package bbs.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import bbs.model.Users;

public class loginFilter implements HandlerInterceptor {
private List<String> whiteUrls;
public List<String> getWhiteUrls() {
	return whiteUrls;
}

public void setWhiteUrls(List<String> whiteUrls) {
	this.whiteUrls = whiteUrls;
}

	@Override
	//������Ϻ�Ļص���������ͼ��Ⱦ����ʱ�ص���
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	//����ص��������ڴ�����֮������ͼ��Ⱦ֮ǰ��ִ�д˺���
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	//Ԥ����ص�������ʵ�ִ�������Ԥ������½��飨�����󵽴ﴦ����֮ǰ������������֤��
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		//����Ҫ��ȡ��url
		String reqUrl=arg0.getRequestURI();
		for(String ele:whiteUrls) {
			if(reqUrl.endsWith(ele)) {
				return true;
			}
		}
		//���������֤session
	HttpSession hSession=	arg0.getSession();
			Users u=(Users)hSession.getAttribute("Users");
	if(u !=null) {
		return true;
	}
					//��url�����жϣ������login/register/view ��ֱ�ӷŹ�
					//�����index ����֤session ��ֵ ��Ź�
					//û�� ��ת�� ��½ҳ��
arg1.sendRedirect("login");
		return false;
	}

}
