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
	//请求完毕后的回调方法（视图渲染结束时回调）
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	//后处理回调方法，在处理器之后，在视图渲染之前，执行此函数
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	//预处理回调方法，实现处理器的预处理，登陆检查（在请求到达处理器之前，进行拦截验证）
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		//请求要获取的url
		String reqUrl=arg0.getRequestURI();
		for(String ele:whiteUrls) {
			if(reqUrl.endsWith(ele)) {
				return true;
			}
		}
		//如果不是验证session
	HttpSession hSession=	arg0.getSession();
			Users u=(Users)hSession.getAttribute("Users");
	if(u !=null) {
		return true;
	}
					//对url进行判断，如果是login/register/view 就直接放过
					//如果是index 就验证session 有值 则放过
					//没有 跳转到 登陆页面
arg1.sendRedirect("login");
		return false;
	}

}
