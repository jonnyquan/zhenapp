<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试页面</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
</head>
<body>

	<form id="form" action="${pageContext.request.contextPath}/api/platform/flow/save" method="post">
		用户名:<input type="text" name="partnerId" value="liuliangapp" />
		提交数据json字符串:<input type="text" name="data" value='{"minPrice":0,"totalTask":10,"totalCollectProduct":10,"totalShoppingCart":10,"kwd":"粗柄木柄园艺","nid":38404501492,"ktype":"FLOW","searchType":"COMPOSITE","timecontrol":"0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,3,3,2,2"}' />
		验证加密字符串:<input type="text" name="validation" value="b6304131f66cff059f6c0d406b3a5acb" />
		<input type="submit" value="提交"/>
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
		$(function(){
			
			
		});
</script>
	
</html>