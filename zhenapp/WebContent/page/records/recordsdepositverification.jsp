<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div>支付宝充值信息确认</div>
	<div style="color:red;">
		[第1步]：点击打开【<a href="https://shenghuo.alipay.com/send/payment/fill.htm" target="_bank">https://shenghuo.alipay.com/send/payment/fill.htm</a>】进入支付宝转账页面，按照下面步骤填写
	</div>
	<div>
		<table class="table table-hover">
			<tr>
				<td width="20%">收款人：</td>
				<td width="80%"><input type="hidden" name="payee" readonly="readonly" width=100% height=100%>wuxiaofan@qq.com
				</td>
			</tr>
			<tr>
				<td>付款金额：</td>
				<td>
					<font color="red" size="4">${tComboInfoCustom.combomoney}元</font><font color="#aaa" size="3">  积分数量：${tComboInfoCustom.combointegral},赠送价格${tComboInfoCustom.combogivemoney}元,赠送积分${tComboInfoCustom.combogiveintegral}</font>
				</td>
			</tr>
			<tr>
				<td>付款说明（充值id）：</td>
				<td><input type="hidden" name="Verificationcode"
					readonly="readonly" value="${Verificationcode}">${Verificationcode}</td>
			</tr>
			<tr>
				<td colspan="2">
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
			window.location.href="${pageContext.request.contextPath}/combo/submit/"+$("input[name='taocan']:checked").val();
		});
	});
</script>

</html>
