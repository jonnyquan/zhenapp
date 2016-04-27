<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>任务管理</title>
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
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true">再次发布</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="obj.remove();">删除</a>
		</div>
		<div style="padding:5px;">
			<lable style="padding:0 10px 0 10px;">查询任务id:</lable><input type="text" id="taskid" class="textbox" width="110px" />
			<lable style="padding:0 10px 0 10px;">查询宝贝id:</lable><input type="text" id="taskkeynum"  class="textbox" width="110px" />
			<lable style="padding:0 10px 0 10px;">查询关键词:</lable><input type="text" id="taskkeyword" class="textbox" width="110px" />
			<lable style="padding:0 10px 0 10px;">任务类型:</lable>
			<select name="tasktype" class="easyui-select" width="110px">
				<option value="0">普通流量</option>
				<option value="1">直通车</option>
			</select>
			<lable style="padding:0 10px 0 10px;">创建时间从:</lable><input type="text" name="datefrom" class="easyui-datebox"  width="110px"  />
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
				$("#datagrid").datagrid('load',{
					taskid:$.trim($("#taskid").val()),
					datefrom:$("input[name='datefrom']").val(),
					dateto:$("input[name='dateto']").val(),
				});
			},
			/*add:function(){
				$("#datagrid").datagrid('insertRow',{
					index:0,
					row:{
						
					}
				});
				
			},
			edit:function(){
				
				
			},*/
			remove:function(){
				var rows=$("#datagrid").datagrid('getSelections');
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
				title : '任务订单管理',
				url:"${pageContext.request.contextPath}/task/findTaskBypage",
				columns : [ [ 
				    {
						field : 'task',
						title : '选择',
						checkbox:true
					}, 
					{
						field : 'taskpk',
						title : '任务订单号'
						
					}, 
					{
						field : 'taskid',
						title : '任务名称',
						width : 300,
					},
					{
						field : 'taskkeynum',
						title : '宝贝id'
					},
					{
						field : 'taskkeyword',
						title : '关键词'
					},
					{
						field : 'tasktype',
						title : '任务类型'
					},
					{
						field : 'flowcount',
						title : '访问数'
					},
					{
						field : 'collectioncount',
						title : '收藏数'
					},
					{
						field : 'shoppingcount',
						title : '加购物车数'
					},
					{
						field : 'flowcountok',
						title : '完成访问数'
					},
					{
						field : 'Collectioncountok',
						title : '完成收藏数'
					},
					{
						field : 'Shoppingcountok',
						title : '完成加购物车数'
					}, 
					{
						field : 'errorcount',
						title : '失败数'
					}, 
					{
						field : 'createtime',
						title : '发布时间'
					}, 
					{
						field : 'taskstate',
						title : '任务状态'
					}
					] ],
				pagination:true,
				pageList:[1,5,10,15,20,25],
				striped:true,
				nowrap:true,
				fitColumns:true,
				rownumbers:true,
				//singleSelect:true,
				toolbar:'#datagridtools'
			});
			
	});
	
</script>
</html>
