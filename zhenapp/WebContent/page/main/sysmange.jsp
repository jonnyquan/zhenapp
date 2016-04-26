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
    <title>系统管理</title>
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
			<div id="basics" title=" 系 统 管 理  " class="container"  style="padding:100px 200px 0 200px;">
				<form action="${pageContext.request.contextPath}/sysconf/updateSysinfo" method="post">
					<div class="form-group" style="width:500px;">
						<label>手机数目(需要重启服务器):</label>
						<div class="form-inline">
							<input type="text" class="form-control" style="width:480px;" name="sysconfvalue1" value="${tSysconfInfoCustom.sysconfvalue1}" placeholder="请输入手机数目"/>台
						</div>
					</div>
					<div class="form-group" style="width:500px;">
						<label>手机标记:</label>
						<div class="form-inline">
							<input type="text" class="form-control" style="width:480px;" name="sysconfvalue2" value="${tSysconfInfoCustom.sysconfvalue2}" placeholder="请输入手机标记"/>
						</div>
					</div>
					<div class="form-group" style="width:500px;">
						<label>每个小号库最小账号数量:</label>
						<div class="form-inline">
							<input type="text" class="form-control" style="width:480px;" name="sysconfvalue3" value="${tSysconfInfoCustom.sysconfvalue3}" placeholder="请输入最小账号数量"/>个
						</div>
					</div>
					<div class="form-group" style="width:500px;">
						<label>宝贝错误次数(超过就终止):</label>
						<div class="form-inline">
							<input type="text" class="form-control" style="width:480px;" name="sysconfvalue4" value="${tSysconfInfoCustom.sysconfvalue4}" placeholder="请输入宝贝错误次数"/>个
						</div>
					</div>
					<div class="form-group" style="width:500px;">
						<label>当天平均模式最后结束时间:</label>
						<div class="form-inline">
							<input type="text" class="form-control" style="width:480px;" name="sysconfvalue5" value="${tSysconfInfoCustom.sysconfvalue5}" placeholder="请输入结束时间"/>点
						</div>
					</div>
					<div class="form-group" style="width:500px;">
						<label>禁止发布流量:</label>
						<div class="form-inline">
							<c:if test="${tSysconfInfoCustom.sysconfvalue6 == 0 }">
								<input type="radio" name="sysconfvalue6" value="0" checked="checked"/>否
								<input type="radio" name="sysconfvalue6" value="1" />是
							</c:if>
							<c:if test="${tSysconfInfoCustom.sysconfvalue6 == 1 }">
								<input type="radio" name="sysconfvalue6" value="0" />否
								<input type="radio" name="sysconfvalue6" value="1"  checked="checked"/>是
							</c:if>
						</div>
					</div>
					<div class="form-group" style="width:500px;padding:0 0 0 200px;" >
						<button class="btn btn-info" id="btn_sub">保存修改</button>
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
