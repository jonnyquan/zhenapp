<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>数据统计</title>
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
	
	<table id="datagridtask">
	</table>
	
	<div id="datagridtools" style="padding:5px;">
		<div style="padding:5px;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" >导出Excle</a>
		</div>
		<div style="padding:5px;">
			<lable style="padding:0 10px 0 10px;">代理名称:</lable>
			<select name="tasktype" class="easyui-select" width="110px">
				<option value="0">流量老大</option>
				<option value="1">真流量</option>
			</select>
			<lable style="padding:0 10px 0 10px;">流量类型:</lable>
			<select name="tasktype" class="easyui-select" width="110px">
				<option value="0">普通流量</option>
				<option value="1">直通车</option>
			</select>
			<lable style="padding:0 10px 0 10px;">统计时间从:</lable><input type="text" name="datefrom" class="easyui-datebox"  width="110px"  />
			到：<input type="text" name="dateto" class="easyui-datebox"  width="110px"  />
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="obj.search();">查询</a>
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
				$("#datagridtask").datagrid('load',{
					datefrom:$("input[name='datefrom']").val(),
					dateto:$("input[name='dateto']").val(),
				});
			},
			remove:function(){
				var rows=$("#datagridtask").datagrid('getSelections');
				if(rows.length>0){
					$.messager.confirm('确认','您确认想要删除记录吗？',function(b){    
					    if (b){
							var pks=[];
							for(var i=0;i<rows.length;i++){
								pks.push(rows[i].taskpk);
							}
							$.ajax({
								type:"POST",
								url:"${pageContext.request.contextPath}/task/deleteTaskBypk",
								data:{
									pks:pks.join(",")
								},
								beforeSend:function(){
									$("#datagridtask").datagrid('loading');
								},
								success:function(){
									$("#datagridtask").datagrid('loaded');	
									$.messager.show({
										title:"提示消息",
										msg:"删除成功",
										width:300,
										height:200,
									});
									$("#datagridtask").datagrid('load');
								},
							});
					    }
					});
				}else{
					$.messager.alert('提示信息',"请选择要删除的信息",'info');
				}
			},
		};	
		
		
			$("#datagridtask").datagrid({
				fit:true,
				title : '任务订单管理',
				url:"${pageContext.request.contextPath}/datacount/findDataBydate",
				columns : [ [ 
				     
					{
						field : 'date',
						title : '日期',
						width : 100,
					}, 
					{
						field : 'flowcount',
						title : '访问量',
						width : 100,
					},
					{
						field : 'collectioncount',
						title : '收藏量',
						width : 100,
					},
					{
						field : 'shoppingcount',
						title : '购物车量',
						width : 100,
					},
					{
						field : 'buypoints',
						title : '购买积分',
						width : 100,
					},
					{
						field : 'expendpoints',
						title : '消耗积分',
						width : 100,
					},
					{
						field : 'backstage',
						title : '后台操作',
						width : 100,
					}
					] ],
				pagination:true,
				pageList:[1,5,10,15,20,25],
				striped:true,
				nowrap:true,
				fitColumns:true,
				rownumbers:true,
				toolbar:'#datagridtools'
			});
			
	});
	
</script>
</html>
