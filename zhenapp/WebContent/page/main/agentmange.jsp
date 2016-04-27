<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>代理管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>  
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
<style>
	.textbox{
		height:20xp;
		margin:0;
		padding:0 2px;
		box-sizing:content-box;
	}
</style>
  <body>
	<table id="datagrid">
	</table>
	<div id="datagridtools" style="padding:5px;">
		<div style="padding:5px;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="obj.editweb();">修改登录页信息</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="obj.editprice();">修改单价信息</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="obj.remove();">删除</a>
		</div>
		<div style="padding:5px;">
			<!--
			留待以后拓展查询用 
			<lable style="padding:0 10px 0 10px;">创建时间从:</lable><input type="text" name="datefrom" class="easyui-datebox"  width="110px"  />
			到：<input type="text" name="dateto" class="easyui-datebox"  width="110px"  />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="obj.search();">查询</a>
			 -->
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
			editprice:function(){
				var rows=$("#datagrid").datagrid('getSelections');
				if(rows.length==1){
					$.ajax({
						type:"POST",
						url:"${pageContext.request.contextPath}/price/findPriceByAgentid/"+rows[0].agentid,
						beforeSend:function(){
							$("#datagrid").datagrid('loading');
						},
						success:function(){
							$("#datagrid").datagrid('loaded');	
							window.location.href="${pageContext.request.contextPath}/price/findPriceByAgentid/"+rows[0].agentid;
						},
					});
				}else{
					$.messager.alert('提示信息',"请选择要修改的信息",'info');
				}
			},
			editweb:function(){
				var rows=$("#datagrid").datagrid('getSelections');
				if(rows.length==1){
					$.ajax({
						type:"POST",
						url:"${pageContext.request.contextPath}/web/findWebByAgentid/"+rows[0].agentid,
						beforeSend:function(){
							$("#datagrid").datagrid('loading');
						},
						success:function(){
							$("#datagrid").datagrid('loaded');	
							window.location.href="${pageContext.request.contextPath}/web/findWebByAgentid/"+rows[0].agentid;
						},
					});
				}else{
					$.messager.alert('提示信息',"请选择要修改的信息",'info');
				}
			},
			remove:function(){
				var rows=$("#datagrid").datagrid('getSelections');
				if(rows.length>0){
					$.messager.confirm('确认','您确认想要删除记录吗？',function(b){    
					    if (b){
							var ids=[];
							for(var i=0;i<rows.length;i++){
								ids.push(rows[i].agentid);
							}
							$.ajax({
								type:"POST",
								url:"${pageContext.request.contextPath}/agent/deleteAgentByid",
								data:{
									ids:ids.join(",")
								},
								beforeSend:function(){
									$("#datagrid").datagrid('loading');
								},
								success:function(){
									$("#datagrid").datagrid('loaded');	
									$.messager.show({
										title:"提示消息",
										msg:"删除成功",
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
				title : '代理信息管理',
				url:"${pageContext.request.contextPath}/agent/findAgentBypage",
				columns : [ [ 
				    {
						field : 'agentid',
						title : '选择',
						checkbox:true,
					}, 
					{
						field : 'agentperson',
						title : '代理人',
						width : 100,
					}, 
					{
						field : 'agentphone',
						title : '手机号',
						width : 100,
					}, 
					{
						field : 'agentname',
						title : '网站名称',
						width : 100,
					}, 
					{
						field : 'agentwww',
						title : '域名',
						width : 100,
					}, 
					{
						field : 'agenthttp',
						title : '网址',
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
						field : 'agentstate',
						title : '状态',
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
</html>
