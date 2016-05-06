<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试页面</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
</head>
<body>

	<form id="form" action="http://liuliangapp.com/api/tasks/cost" method="post">
		任务名称:<input type="text" name="name" value="" />
		关键词:<input type="text" name="name" value="" />
		商品url:<input type="text" name="name" value="" />
		开始日期:<input type="text" name="name" value="" />
		结束日期:<input type="text" name="name" value="" />
		每小时发送量:<input type="text" name="name" value="" />
		停留时长选项的id:<input type="text" name="name" value="" />
		<input type="text" name="name" value="" />
		<input type="text" name="name" value="" />
		<input type="text" name="name" value="" />
		<input type="submit" value="提交"/>
	</form>
	
	
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
		var uri="${pageContext.request.contextPath}";
		$(function(){
			
			
		});
</script>
	
</html>