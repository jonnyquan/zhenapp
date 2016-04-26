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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/page/css/index.css" />
</head>
<body>
<form id="form" action="${pageContext.request.contextPath}/util/upload" method="post" enctype="multipart/form-data">
	<table class="easyui-table">
		<tr>
			<td>
				weblogo
			</td>
			<td>
				上传图片:<input type="file" name="filelogo">
			</td>
		</tr>
		<tr>
			<td>
				轮播图1
			</td>
			<td>
				上传图片:<input type="file" name="file1">
			</td>
		</tr>
		<tr>
			<td>
				轮播图2
			</td>
			<td>
				上传图片:<input type="file" name="file2">
			</td>
		</tr>
		<tr>
			<td>
				轮播图3
			</td>
			<td>
				上传图片:<input type="file" name="file3">
			</td>
		</tr>
		<tr>
			<td>
				侧边QQ栏背景图
			</td>
			<td>
				上传图片:<input type="file" name="QQ">
			</td>
		</tr>
		<tr>
			<td>
				QQ号
			</td>
			<td>
				<input type="text" name="QQ">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" class="easyui-linkbutton" value="保存">
			</td>
		</tr>
	</table>
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
		function check(){
			$("#form").submit();
		};
		$(function(){
			
			
			
		});
</script>
</html>
