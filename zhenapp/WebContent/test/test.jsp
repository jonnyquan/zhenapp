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
		用户名:<input type="text" name="partnerId" value="wuxiaofan11" />
		提交数据json字符串:<input type="text" name="data" value='{"minPrice":"30","maxPrice":"30","totalTask":20,"totalCollectProduct":20,"totalShoppingCart":20,"taskstartdate":"2016-05-06","taskenddate":"2016-05-09","kwd":"男装1====男装2====男装3====","nid":"12345678945","ktype":"33","searchType":"35","timecontrol":"0,0,0,0,0,0,0,0,0,0,0,0,0,0,20,10,0,0,0,0,0,0,0,0","image":"https://img.alicdn.com/bao/uploaded/i4/411832242/TB20MMqlVXXXXbQXXXXXXXXXXXX_!!411832242.jpg_430x430q90.jpg"}' />
		验证加密字符串:<input type="text" name="validation" value="fc3904b3dedc8eaec47b3492f31fc775" />
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