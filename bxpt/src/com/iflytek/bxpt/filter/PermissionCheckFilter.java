package com.iflytek.bxpt.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionCheckFilter implements Filter{


	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//System.out.println("执行初始化操作");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//System.out.println("过滤器执行过滤工作");

		HttpServletRequest httpServletRequest=(HttpServletRequest)request;
		HttpServletResponse httpServletResponse=(HttpServletResponse)response;
		Object object = httpServletRequest.getSession().getAttribute("admin");

		if(object!=null) {
			chain.doFilter(request, response);
		}else {
			httpServletResponse.sendRedirect("../login.jsp");
		}

	}

	@Override
	public void destroy() {
		//System.out.println("执行销毁前操作");


	}

}
