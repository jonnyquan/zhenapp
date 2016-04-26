<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>通过电子邮件找回密码</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/style.css">
<link href="${pageContext.request.contextPath}/bootstrap/css/lanrenzhijia.css" rel="stylesheet" type="text/css">
</head>
<body style="padding: 200px;">
	<div>
		<form class="form-horizontal" action="${pageContext.request.contextPath}/user/findPasswordByemail">
			<div class="form-group" style="width:500px;">
				<div class="col-sm-3 control-label">
					<label>用户名</label>
				</div>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="usernick" name="tUserinfoCustom.usernick"
						placeholder="请输入你要找回密码的用户名" value="${tUserinfoCustom.usernick}" />
				</div>
			</div>
			<div class="form-group" style="width:500px;">
				<div class="col-sm-3 control-label">
					<label>邮箱账号</label>
				</div>
				<div class="col-sm-9">
					<input type="text" class="form-control" id="regemail" name="tUserinfoCustom.regemail"
						placeholder="请输入您注册时的邮箱账号" value="${tUserinfoCustom.regemail}"/>
				</div>
			</div>
			<div class="form-group" style="width:500px;padding: 0 0 0 200px;">
				<button type="submit" class="btn btn-info" id="findpassword">找回密码</button>
			</div>
		</form>
	</div>
</body>
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
;$(function(){
	
	
});

</script>
</html>
