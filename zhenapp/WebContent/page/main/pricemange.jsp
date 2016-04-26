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
    <title>单价配置</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
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
  </head>
  <body>
		<div id="tabs">
			<div id="basics" title=" 单价配置  " class="container"  style="padding:100px 200px 0 200px;">
				<form action="${pageContext.request.contextPath}/price/updatePriceBycode" method="post">
					<c:forEach items="${tPriceInfoCustomlist }" var="list">
						<div class="form-group" style="width:500px;">
							<label>${list.pricetype }:</label>
							<input type="text" class="form-control" name="pricecounts" placeholder="请输入${list.pricetype }" value="${list.pricecounts}" />
						</div>
					</c:forEach>
					<div class="form-group" style="width:500px;padding:0 0 0 200px;" >
						<button class="btn btn-info" id="btn_sub">保存系统信息</button>
					</div>
				</form>
			</div>
		</div>
  </body>
  <script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/js/user.js"></script>
<script type="text/javascript"> 
	var uri="${pageContext.request.contextPath}";
	$('#tabs').tabs({
		
	});
</script>
</html>
