<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<title>手工充值扣款</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<body>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/style.css">
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/page/css/index.css" />
	<form action="${pageContext.request.contextPath}/user/updatepoints" method="post">
	<input type="hidden" name="points" value="${tUserInfoCustom.points}"/>
	<input type="hidden" name="userpk" value="${tUserInfoCustom.userpk}"/>
	<table class="table">
		<tr>
			<td >
				用户积分
			</td>
			<td >
				${tUserInfoCustom.points}
			</td>
		</tr>
		<tr>
			<td >
				执行操作
			</td>
			<td >
				<lable class="radio-inline"><input type="radio" name="caozo" value="0">充值</lable>
				<lable class="radio-inline"><input type="radio" name="caozo" value="1">扣款</lable>
			</td>
		</tr>
		<tr>
			<td >
				积分
			</td>
			<td >
				<input type="text" class='form-control' name="updatepoints" placeholder="请输入需要修改的积分数量">
			</td>
		</tr>
		<tr>
			<td >
				备注
			</td>
			<td >
				<input type="text" class='form-control' name="desc" placeholder="请输入修改积分的原因">
			</td>
		</tr>
		<tr>
			<td colspan="2" style="padding-left: 200px;">
				<button class="btn btn-info" type="submit">保存修改</button>
			</td>
		</tr>
	</table>
	</form>
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
				updaterole:function(){
					var rows=$("#datagrid").datagrid('getSelections');
					if(rows.length>0){
						$.messager.confirm('确认','您确认想要将此用户设置为代理用户吗？',function(b){    
						    if (b){
								$.ajax({
									type:"POST",
									url:"${pageContext.request.contextPath}/user/updaterole/"+rows[0].userpk,
									beforeSend:function(){
										$("#datagrid").datagrid('loading');
									},
									success:function(data){
										$("#datagrid").datagrid('loaded');	
										$.messager.show({
											title:"提示消息",
											msg:"操作"+data.data+"条记录成功",
											width:300,
											height:200,
										});
										$("#datagrid").datagrid('load');
									},
								});
						    }
						});
					}else{
						$.messager.alert('提示信息',"请选择要设为代理的用户",'info');
					}
				},
				login:function(){
					var rows=$("#datagrid").datagrid('getSelections');
					if(rows.length>0){
						$.ajax({
							type:"POST",
							url:"${pageContext.request.contextPath}/user/login/"+rows[0].userpk,
							beforeSend:function(){
								$("#datagrid").datagrid('loading');
							},
							success:function(data){
								window.parent.location="${pageContext.request.contextPath}/page/main/index.jsp";
							},
						});
					}
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
							title : '身份证号',
							width : 100,
						},
						{
							field : 'regemail',
							title : '邮箱',
							width : 100,
						},
						{
							field : 'points',
							title : '积分',
							width : 100,
						},
						{
							field : 'createtime',
							title : '创建时间',
							width : 100,
						},
						{
							field : 'updatetime',
							title : '更新时间',
							width : 100,
						},
						{
							field : 'dicinfoname',
							title : '状态',
							width : 100,
						},
						{
							field : 'rolename',
							title : '用户角色类型',
							width : 100,
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
