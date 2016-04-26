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
    
    <title>在线充值</title>
    
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
  </head>
  <body>
   	<div>
	   	购买套餐
   	</div>
   	<div style="color:red;">
   		注：支付宝付款之后一分钟左右将自动为账号充值积分，如有问题请及时反馈给客服
   	</div>
   	<div>
   		<table class="table table-hover">
   			<c:forEach items="${tComboInfoCustomlist}" var="tComboInfoCustom" varStatus="status">
	   			<tr>
	   				<td>
	   					<input type="radio" name="taocan" value="${tComboInfoCustom.comboid}"/>
	   				</td>
	   				<td>
	   					${tComboInfoCustom.comboname}:
	   				</td>
	   				<td>
	   					 价格:${tComboInfoCustom.combomoney}元,积分数量：${tComboInfoCustom.combointegral},赠送价格${tComboInfoCustom.combogivemoney}元,赠送积分${tComboInfoCustom.combogiveintegral} 
	   				</td>
	   			</tr>
   			</c:forEach>
   			<tr>
   				<td colspan="3">
   					<button class="btn btn-info" id="btn_cz">>去充值<</button>
   				</td>
   			</tr>
   		</table>
   	</div>
  </body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	;$(function(){
		$("#btn_cz").click(function(){
			window.location.href="${pageContext.request.contextPath}/recharge/insertRechargeinfo/"+$("input[name='taocan']:checked").val();
		});
	});
</script>
	
</html>
