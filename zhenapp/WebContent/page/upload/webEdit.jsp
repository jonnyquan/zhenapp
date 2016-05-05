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
<title>首页信息编辑</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/page/css/index.css" />
</head>
<body>
<form id="form" action="${pageContext.request.contextPath}/web/updatewebinfo" method="post" enctype="multipart/form-data">
	<input type="hidden" name="agentid" value="${tAgentInfoCustom.agentid }">
	<table style="width:100%;padding:5px;border: 1px solid #ddd;">
		<tr>
			<td>
				网站名称
			</td>
			<td>
				<input type="text" name="agentname" value="${tAgentInfoCustom.agentname}"/>
			</td>
		</tr>
		<tr>
			<td>
				域名
			</td>
			<td>
				<input type="text" name="agentwww" value="${tAgentInfoCustom.agentwww}"/>
			</td>
		</tr>
		<tr>
			<td>
				网站地址
			</td>
			<td>
				<input type="text" name="agenthttp" value="${tAgentInfoCustom.agenthttp}"/>
			</td>
		</tr>
		<tr>
			<td>
				QQ号
			</td>
			<td>
				<input type="text" name="qq" value="${tWebInfoCustom.qq}">
			</td>
		</tr>
		<tr>
			<td>
				QQ群号
			</td>
			<td>
				<input type="text" name="qqgroup" value="${tWebInfoCustom.qqgroup}">
			</td>
		</tr>
		<tr>
			<td>
				微信号
			</td>
			<td>
				<input type="text" name="wechat" value="${tWebInfoCustom.wechat}">
			</td>
		</tr>
		<tr>
			<td>
				备案信息
			</td>
			<td>
				<input type="text" name="archival" value="${tWebInfoCustom.archival}">
			</td>
		</tr>
		<tr>
			<td>
				支付宝账号
			</td>
			<td>
				<input type="text" name="alipay" value="${tWebInfoCustom.alipay}">
			</td>
		</tr>
		<tr>
			<td>
				网站logo
			</td>
			<td>
				<c:if test="${tWebInfoCustom.logo != null && tWebInfoCustom.logo != ''}">
					<img src="${pageContext.request.contextPath}/bootstrap/img/index/${tWebInfoCustom.logo}" width="280px" height="80"px alt="真流量">
				</c:if>
				上传图片:<input type="file" name="files">
			</td>
		</tr>
		<tr>
			<td>
				轮播图1
			</td>
			<td>
				<c:if test="${tWebInfoCustom.carousel01 != null && tWebInfoCustom.carousel01 != ''}">
					<img src="${pageContext.request.contextPath}/bootstrap/img/index/${tWebInfoCustom.carousel01}" width="1080px" height="380px" alt="真流量">
				</c:if>
				上传图片:<input type="file" name="files">
			</td>
		</tr>
		<tr>
			<td>
				轮播图2
			</td>
			<td>
				<c:if test="${tWebInfoCustom.carousel02 != null && tWebInfoCustom.carousel02 != ''}">
					<img src="${pageContext.request.contextPath}/bootstrap/img/index/${tWebInfoCustom.carousel02}" width="1080px" height="380px" alt="真流量">
				</c:if>
				上传图片:<input type="file" name="files">
			</td>
		</tr>
		<tr>
			<td>
				轮播图3
			</td>
			<td>
				<c:if test="${tWebInfoCustom.carousel03 != null && tWebInfoCustom.carousel03 != ''}">
					<img src="${pageContext.request.contextPath}/bootstrap/img/index/${tWebInfoCustom.carousel03}" width="1080px" height="380px" alt="真流量">
				</c:if>
				上传图片:<input type="file" name="files">
			</td>
		</tr>
		<tr>
			<td>
				侧边QQ栏背景图
			</td>
			<td>
				<c:if test="${tWebInfoCustom.bg01 != null && tWebInfoCustom.bg01 != ''}">
					<img src="${pageContext.request.contextPath}/bootstrap/img/index/${tWebInfoCustom.bg01}" width="280px" height="250px" alt="真流量">
				</c:if>
				上传图片:<input type="file" name="files">
			</td>
		</tr>
		<tr>
			<td>
				侧边QQ栏咨询中心图片
			</td>
			<td>
				<c:if test="${tWebInfoCustom.bg02 != null && tWebInfoCustom.bg02 != ''}">
					<img src="${pageContext.request.contextPath}/bootstrap/img/index/${tWebInfoCustom.bg02}" width="280px" height="40px" alt="真流量">
				</c:if>
				上传图片:<input type="file" name="files">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<a class="easyui-linkbutton" onclick="check()">上传web信息</a>
			</td>
		</tr>
	</table>
</form>

</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
		var uri="${pageContext.request.contextPath}";
		function check(){
			$("#form").submit();
		};
</script>
</html>
