<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/page/css/index.css" />
	<table id="tab">
	</table>

	<div id="usertools" style="padding:5px;height:auto;">
		<div>
			<a href="#" class="easyui-linkbutton" plain="true">添加</a> <a href="#"
				class="easyui-linkbutton" plain="true">编辑</a>
		</div>
		<div>
			账号:<input type="text" name="user" style="width:110px;">
			创建时间从:<input type="text" name="user" style="width:110px;"> 到：<input
				type="text" name="user" style="width:110px;"> <a href="#"
				class="easyui-linkbutton" >查询</a>
		</div>
	</div>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/js/user.js"></script>
<script type="text/javascript">
		var uri="${pageContext.request.contextPath}";
</script>
</body>
</html>
