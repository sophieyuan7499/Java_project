package bbs.filter;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class timeFilter implements HandlerInterceptor{
private int startTime;
private int endTime;

	public int getStartTime() {
	return startTime;
}

public void setStartTime(int startTime) {
	this.startTime = startTime;
}

public int getEndTime() {
	return endTime;
}

public void setEndTime(int endTime) {
	this.endTime = endTime;
}

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub

		//验证时间，只有在规定时间内可以登录
		Calendar c=Calendar.getInstance();
		//获取当前时间
		int hour=c.get(Calendar.HOUR_OF_DAY);
		if(hour>=startTime&&hour<endTime) {
			return true;
		}
		String reqUrl=arg0.getRequestURI();
		if(reqUrl.endsWith("time")) {
			return true;
		}
  arg1.sendRedirect("time");
		return false;
	}

}
