<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎登录...</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/css/login.css" />
</head>
<body>
	<!-- <form id="form_login" action="${pageContext.request.contextPath}/user/Login.action" method="post"> -->
		<div id="div_login" style="margin:auto;text-align:center;" >
			<p><lable>用户名：</lable><input type="text" id="username" class="textbox" value="admin"></p>
			<p><lable>密&nbsp;码：</lable><input type="password" id="password" class="textbox" value="123456"></p>
		</div>
		
		<div id="btn_login">
			<a id="btn_login_a" href="#" class="easyui-linkbutton">&nbsp;登&nbsp;录&nbsp;</a>&nbsp;&nbsp;
			<a href="#" class="easyui-linkbutton">忘记密码</a>
		</div>
		<div id="div_jg">
		</div>
	
	
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js" ></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/js/login.js" ></script>
<script type="text/javascript">
	var uri="${pageContext.request.contextPath}";
	if (window != top) {
		top.location.href = location.href;
	}
</script>
</html>