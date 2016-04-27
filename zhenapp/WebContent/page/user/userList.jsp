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
	<table id="datagrid">
	</table>

	<div id="datagridtools" style="padding:5px;height:auto;">
		<div>
			<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-edit">充值扣款</a>
			<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-remove" onclick="obj.remove();">删除</a>
			<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-login">登录</a> 
			<a href="#" class="easyui-linkbutton" plain="true">设为代理</a> 
		</div>
		<div>
			账号:<input type="text" name="user" style="width:110px;">
			创建时间从:<input type="text" name="user" style="width:110px;"> 到：<input
				type="text" name="user" style="width:110px;"> <a href="#"
				class="easyui-linkbutton" onclick="obj.search();">查询</a>
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
		;$(function(){
			obj={
				search:function(){
					$("#datagrid").datagrid('load',{
						datefrom:$("input[name='datefrom']").val(),
						dateto:$("input[name='dateto']").val(),
					});
				},
				remove:function(){
					var rows=$("#datagrid").datagrid('getSelections');
					if(rows.length>0){
						$.messager.confirm('确认','您确认想要删除记录吗？',function(b){    
						    if (b){
								$.ajax({
									type:"POST",
									url:"${pageContext.request.contextPath}/user/deleteUserinfoBypk/"+rows[0].userpk,
									beforeSend:function(){
										$("#datagrid").datagrid('loading');
									},
									success:function(data){
										$("#datagrid").datagrid('loaded');	
										$.messager.show({
											title:"提示消息",
											msg:"删除"+data.data+"条记录成功",
											width:300,
											height:200,
										});
										$("#datagrid").datagrid('load');
									},
								});
						    }
						});
					}else{
						$.messager.alert('提示信息',"请选择要删除的信息",'info');
					}
				},
			};	
			
			
				$("#datagrid").datagrid({
					fit:true,
					title : '用户信息管理',
					url:"${pageContext.request.contextPath}/user/findUserByPage",
					columns : [ [ 
					    {
							field : 'userpk',
							title : '选择',
							checkbox:true
						}, 
						{
							field : 'username',
							title : '用户名',
							width : 100,
						}, 
						{
							field : 'userphone',
							title : '手机号',
							width : 100,
						},
						{
							field : 'usercardnum',
							title : '身份证号'
						},
						{
							field : 'regemail',
							title : '邮箱'
						},
						{
							field : 'points',
							title : '积分'
						},
						{
							field : 'createtime',
							title : '创建时间'
						},
						{
							field : 'updatetime',
							title : '更新时间'
						},
						{
							field : 'userstate',
							title : '状态'
						}
						] ],
					pagination:true,
					pageList:[1,5,10,15,20,25],
					striped:true,
					nowrap:true,
					fitColumns:true,
					rownumbers:true,
					singleSelect:true,
					toolbar:'#datagridtools'
				});
		});
	</script>
</body>
</html>
