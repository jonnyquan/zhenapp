<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>套餐管理</title>
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
  <body style="padding:10px 10px;">
	
	<table class="table table-hover">
			<tr>
				<td colspan="3">
					<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add();">新增</a>
				</td>
			</tr>
   			<c:forEach items="${tComboInfoCustomlist}" var="tComboInfoCustom" varStatus="status">
	   			<tr>
	   				<td>
	   					 ${tComboInfoCustom.comboname}
	   				</td>
	   				<td>
	   					 价格${tComboInfoCustom.combomoney}元,积分数量：${tComboInfoCustom.combointegral},赠送价格${tComboInfoCustom.combogivemoney}元,赠送积分${tComboInfoCustom.combogiveintegral} 
	   				</td>
	   				<td>
	   					<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">编辑</a>|<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
	   				</td>
	   			</tr>
   			</c:forEach>
   		</table>
	<div style="padding:500px 0 0 0;">
		<div id="dialog"  style="margin:auto;text-align:center;padding:30px 0;font-size:20;">
			<form method="post" id="formadd" action="${pageContext.request.contextPath}/combo/insertComboto">
				<p><lable>套餐名称：</lable><input type="text" name="comboname" class="textbox" value="wuxiaofan"></p>
				<p><lable>价格：</lable><input type="text" name="combomoney" class="textbox" onkeyup="this.value=this.value.replace(/\D/g,'')"
								onafterpaste="this.value=this.value.replace(/\D/g,'')" value="wuxiaofan"></p>
				<p><lable>积分：</lable><input type="text" name="combointegral" class="textbox" onkeyup="this.value=this.value.replace(/\D/g,'')"
								onafterpaste="this.value=this.value.replace(/\D/g,'')" value="wuxiaofan"></p>
				<p><lable>赠送价格：</lable><input type="text" name="combogivemoney" class="textbox" onkeyup="this.value=this.value.replace(/\D/g,'')"
								onafterpaste="this.value=this.value.replace(/\D/g,'')" value="wuxiaofan"></p>
				<p><lable>赠送积分：</lable><input type="text" name="combogiveintegral" class="textbox" onkeyup="this.value=this.value.replace(/\D/g,'')"
								onafterpaste="this.value=this.value.replace(/\D/g,'')" value="wuxiaofan"></p>
				<a href="#" id="a_sub" class="easyui-linkbutton" >&nbsp;&nbsp; 保&nbsp;&nbsp;&nbsp;&nbsp;存&nbsp;&nbsp; </a>
			</form>
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
	function add(){
		$("#dialog").dialog({
			title : '新增套餐信息',
			width : 450,
			height : 350,
			modal : true,
			maximizable:true,
			iconCls : 'icon-add'
		});
	}
	;$(function(){
		$("#a_sub").click(function(){
			$("#formadd").submit();
		});
	});
</script>
</html>
