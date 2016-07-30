<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String msg=request.getParameter("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
<!-- 
* {margin:0;padding:0}
div {
  width:500px;
  height:300px;
  border:0px solid #666;
  overflow:hidden;
  position:relative;
  text-align:center;
}
div p {
  position:static;
  +position:absolute;
  top:50%;
  vertical-align:middle
}
img {
  position:static;
  +position:relative;
  top:-50%;left:-50%;
  vertical-align:middle
}
-->
</style>
<body>
	<div style="margin:0px auto;">
		<p><img src="${pageContext.request.contextPath}/webimg/404.jpg"/></p>
	</div>
	<div style="margin:0px auto;color:red;">
		${msg}<a target="_blank" href="tencent://message/?uin=1105889150&&Site=sc.chinaz.com&&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:12345678:42"></a>
	</div>
</body>
</html>