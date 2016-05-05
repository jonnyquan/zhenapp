<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/page/css/index.css" />
</head>
<body class="easyui-layout">
	<div
		data-options="region:'north',title:'header',split:true,noheader:true"
		style="height:60px;background:#666;">
		<div class="logo">后台管理</div>
		<div class="logout">
			<a href="${pageContext.request.contextPath}/index/findwebinfo"><font
				color="#fff" size="3px">网站首页</font></a>
		</div>
		<div class="logout">
			您好，<font color="red" size="3px"> ${tUserInfoCustom.usernick}</font> | <a
				href="${pageContext.request.contextPath}/user/Logout">退出</a>
		</div>
	</div>
	<div
		data-options="region:'south',title:'footer',split:true,noheader:true"
		style="height:35px;line-height:30px;text-align:center;">
		&copy;Copyright (c) 2015 zhenapp.cn Inc. All Rights.
		浙ICP备140452118号-5.</div>
	<div
		data-options="region:'west',title:'导航',split:true,iconCls:'icon-world'"
		style="width:220px;padding:10px;">
		<ul id="nav"></ul>
	</div>
	<div data-options="region:'center'" style="width:900px;height:900px;"><!-- style="overflow-y:auto;overflow-x:hidden;" -->
		<div id="tabs">
			<div title="起始页" iconCls="icon-house"
				style="padding:0 10px;display:block;">欢迎来到本系统,祝您的店铺越来越红火...
				
				<table class="table">
					<tr>
						<td>
							您当前账户余额为:
						</td>
						<td>
							<span id="balabce" style="color:red;"></span>&nbsp;&nbsp;&nbsp;<a href="#" class="easyui-linkbutton" id="refresh" iconCls="icon-reload">刷新余额</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/js/index.js"></script>
<script type="text/javascript">
	var uri = "${pageContext.request.contextPath}";
	var usernick = "${tUserInfoCustom.usernick}";
	var roleid = "${tUserInfoCustom.userroleid}";
	;$(function() {
		if (usernick.length < 1) {
			window.parent.location="${pageContext.request.contextPath}/page/main/login.jsp"; 
		}
		
		$("#refresh").click(function(){
			$.ajax({
				url : uri+"/user/findpoints",
				type : "POST",
				success:function(data,state){
					$("#balabce").text(data.points);
				}
			});
		});
	});
</script>
</html>