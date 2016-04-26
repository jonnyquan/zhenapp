<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>账户明细</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
	
	<div id="datagridtools">
		<div style="padding:5px;">
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
					datefrom:$("input[name='datefrom']").val(),
					dateto:$("input[name='dateto']").val(),
				});
			},
		};	
			$("#datagrid").datagrid({
				fit:true,
				title : '账户明细信息管理',
				url:"${pageContext.request.contextPath}/points/findPointsInfoByPage",
				columns : [ [
					{
						field : 'pointspk',
						title : '账户明细主键',
						checkbox:true,
					}, 
					{
						field : 'taskid',
						title : '任务id',
					},
					{
						field : 'pointstype',
						title : '操作类型',
					},
					{
						field : 'pointsupdate',
						title : '变动积分数'
					},
					{
						field : 'points',
						title : '当前积分'
					},
					{
						field : 'pointreason',
						title : '积分变动说明'
					},
					{
						field : 'createtime',
						title : '创建时间'
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
