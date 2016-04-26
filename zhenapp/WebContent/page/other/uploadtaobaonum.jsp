<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>上传淘宝账号</title>
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
	<form id="form"
		action="${pageContext.request.contextPath}/util/uploadTbaccount" method="post"
		enctype="multipart/form-data">
		<table style="width:100%;padding:5px;border: 1px solid #ddd;">
			<tr>
				<td align="center" width="30%">选择上传文件:<input type="file"
					name="file">
				</td>
			</tr>
			<tr>
				<td align="center" width="30%"><a class="easyui-linkbutton"
					onclick="check()">上传淘宝账号信息</a></td>
			</tr>
			<tr>
				<td>【1】放入大号库</td>
			</tr>
			<tr>
				<td>【2】按照手机分配</td>
			</tr>
		</table>
	</form>
	<table>
		<tr>
			<td><input type="text" name="ALLphonenum"></td>
			<td><input type="text" name="phonenum"></td>
			<td>
				<button>平均分配</button>
			</td>
		</tr>
		<tr>
			<td><input type="text" name="phonenum"></td>
			<td>
				<button>[2]按手机号分配</button>
			</td>
			<td></td>
		</tr>
		<tr>
			<td><input type="text" name="phonenum"></td>
			<td>
				<button>设置一键换号</button>
			</td>
		</tr>
	</table>
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
</script>
</html>
