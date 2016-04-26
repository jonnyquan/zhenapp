<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
			<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-edit">充值扣款</a>
			<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-remove">删除</a>
			<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-login">登录</a> 
			<a href="#" class="easyui-linkbutton" plain="true">设为代理</a> 
		</div>
		<div>
			账号:<input type="text" name="user" style="width:110px;">
			创建时间从:<input type="text" name="user" style="width:110px;"> 到：<input
				type="text" name="user" style="width:110px;"> <a href="#"
				class="easyui-linkbutton">查询</a>
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
		var uri = "${pageContext.request.contextPath}";
		$(function() {
			$("#tab").datagrid(
					{
						url : uri + "/user/findAllUser",
						title : "用户列表",
						iconCls : "icon-search",
						columns : [ [ {
							field : 'userpk',
							title : '用户id',
							checkbox:true
						},{
							field : 'userid',
							title : '用户id',
							sortable : true,
						}, {
							field : 'usernick',
							title : '用户名',
							sortable : true,
						}, {
							field : 'userphone',
							title : '手机号',
							sortable : true,
						}, {
							field : 'regemail',
							title : '邮箱',
							sortable : true,
						}, {
							field : 'counts',
							title : '积分',
							sortable : true,
						}, {
							field : 'createtime',
							title : '创建时间',
							sortable : true,
						}, {
							field : 'updatetime',
							title : '更新时间',
							sortable : true,
						}, {
							field : 'userstate',
							title : '状态',
							sortable : true,
						}
						] ],
						pagination : true,
						pageSize : 2,
						pageList : [ 2, 4, 6 ],
						toolbar : "#usertools",
						layout : [ 'list', 'sep', 'first', 'prev', 'next',
								'last', 'links' ],
					});
		});
	</script>
</body>
</html>
