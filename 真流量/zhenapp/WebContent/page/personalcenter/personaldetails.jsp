<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>个人中心-基本信息</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css" />
	<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/page/css/index.css" />
  </head>
  <body>
		<div id="tabs">
			<div id="basics" title=" 基  本  资  料   " class="container"  style="padding:100px 200px 0 200px;">
				<form action="" method="post">
					<div class="form-group" style="width:500px;">
						<label>用户名:</label>
						<input type="text" class="form-control" name="usernick" placeholder="用户名不允许修改" readonly="readonly"/>
						<span>用户名不允许修改</span>
					</div>
					<div class="form-group" style="width:500px;">
						<label>真实姓名:</label>
						<input type="text" class="form-control" name="usernick" placeholder="请输入真实姓名"/>
					</div>
					<div class="form-group" style="width:500px;">
						<label>电子邮箱:</label>
						<input type="email" class="form-control" name="usernick" placeholder="请输入电子邮箱"/>
					</div>
					<div class="form-group" style="width:500px;">
						<label>QQ号:</label>
						<input type="text" class="form-control" name="usernick" placeholder="请输入QQ号"/>
					</div>
					<div class="form-group" style="width:500px;padding:0 0 0 200px;" >
						<button class="btn btn-info">保存修改</button>
					</div>
				</form>
			</div>
			
			<div id="updatepassword" title="  修   改  密   码  " class="container"  style="padding:100px 200px 0 200px;">
				<form action="" method="post">
					<div class="form-group" style="width:500px;">
						<label>原始登录密码：</label>
						<input type="password" class="form-control" name="usernick" placeholder="用户名不允许修改" readonly="readonly"/>
					</div>
					<div class="form-group" style="width:500px;">
						<label>新登录密码:</label>
						<input type="password" class="form-control" name="usernick" placeholder="请输入真实姓名"/>
					</div>
					<div class="form-group" style="width:500px;">
						<label>确认密码:</label>
						<input type="password" class="form-control" name="usernick" placeholder="请输入电子邮箱"/>
					</div>
					<div class="form-group" style="width:500px;padding:0 0 0 200px;" >
						<button class="btn btn-info">保存修改</button>
					</div>
				</form>
			</div>
		</div>
  </body>
  <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/js/user.js"></script>
<script type="text/javascript"> 
	var uri="${pageContext.request.contextPath}";
	$('#tabs').tabs({
		
	});
</script>
</html>
