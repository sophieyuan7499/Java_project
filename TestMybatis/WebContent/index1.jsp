<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>示例</title>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
</head>
<body>
<h2>欢迎${sessionScope.Users.name }来到主页面</h2>
<br>
如何获取数据
<br>
<a href="index2?userid=6">提交参数与方法形参名一致</a><br>
<a href="index3?acc=stevenzhang">提交参数与方法形参名不一致</a><br>
<br><br>
<p>文件的上传</p>
<form action="index4.do" method="post" enctype="multipart/form-data">
上传文件： <input type="file" name="file"> <br>
 <input type="submit" value="上传">
    </form>
<br><br>
<p>多文件的上传</p>
<form action="index5.do" method="post" enctype="multipart/form-data">
上传文件： <input type="file" name="file"><input type="file" name="file"> <br>
 <input type="submit" value="上传">
    </form>
 <hr>
 <a href="index6/2/get">restful风格编码</a>
 <hr>
 <button id="btn">查询所有用户</button>
 <div id="div"></div>
 <script type="text/javascript">
 $(function(){
	 $("#btn").click(function(){
		 $.get("index7",function(data){
			 var html="<table>";
			 $.each(data,function(index,item){
				 html+="<tr>"+"<td>"+item.name+"</td>"+ "<td>"+item.account+"</td>"+
				 "<td>"+item.password+"</td>"+"</tr>";
			 });
			 html+="</table>"
			 $("#div").append(html);
		 });
	 });
 });
 </script>
</body>
</html>