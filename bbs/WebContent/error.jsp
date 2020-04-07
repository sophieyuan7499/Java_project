<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 
JSP的内置对象
①out:页面输出流
②request:封装了一次用户请求
③response:封装了一次用户响应
④session:代表一次用户会话
类似于缓存 --》存储数据 --》有效范围 （打开浏览器，关闭浏览器结束）
⑤application:代表Web应用本身，由所有用户所共享
⑥config:代表JSP的配置信息
⑦page:代表本页面，相当于this
⑧pageContext:代表页面上下文，主要访问 JSP之间共享的数据，可以访问page,request,session,application访问的变量
⑨：exception：JSP脚本中产生的异常


1、看到页面(a标签，url地址栏)
①直接访问页面
login.jsp 注册
③需要从数据库获取数据 --》将数据转发给相应的页面
index.jsp   view.jsp
2、表单提交
获取表单提交的数据--》做相应的处理--》看到页面

两层：
①不登录就可以完成的操作  浏览主页、注册、view
③必须要登录才能完成的操作   浏览个人主页、编辑、删除、修改密码

路径：
a标签，表单提交:
以/打头的路径，都是绝对路径      http://127.0.0.1/
不以/打头的路径，相对路径     

servlet中的url-partten 路径
/index.action      是绝对路径  http://127.0.0.1/web应用的名称/










 -->
<title>Insert title here</title>
</head>
<body>
账号或密码输入不正确 
</body>
</html>