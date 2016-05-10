<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="真流量,无线流量,无限流量代运营,无线刷流量 " />
<meta name="description" content="真流量,无线流量,无限流量代运营,无线刷流量 " />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/global.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/sweetalert.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/backstage/pagematter/common/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/backstage/pagematter/common/js/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/backstage/pagematter/common/js/sweetalert-dev.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/layer_user.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/user.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/validform.style.css"
	type="text/css">

<style type="text/css">
.login_box {
	width: 930px;
	padding-bottom: 20px;
}

.form_control {
	margin-top: 5px;
	height: 25px;
	line-height: 25px;
	font-size: 12px;
	border-bottom: 1px dashed #dedede;
	padding-bottom: 5px;
}

.form_control_t {
	margin-top: 5px;
}

.form_control .form_label {
	height: 25px;
	line-height: 25px;
	font-size: 12px;
	width: 180px;
}

.form_control .form_input {
	height: 23px;
	line-height: 23px;
	font-size: 12px;
}

.form_control .form_select {
	height: 23px;
	line-height: 23px;
	font-size: 12px;
	list-style: 20px;
}

.form_control .form_radio {
	height: 25px;
	line-height: 25px;
	font-size: 12px;
}

.form_control .form_radio span {
	margin: 0 20px 0 5px;
}

.form_control .input_tip {
	height: 25px;
	line-height: 25px;
	font-size: 12px;
}

.form_control .Validform_checktip {
	height: 25px;
	line-height: 25px;
}

.form_control .form_btn {
	width: 150px;
	height: 30px;
	line-height: 30px;
	font-size: 14px;
	font-weight: normal;
}

.form_control a.form_abtn {
	height: 30px;
	line-height: 30px;
	font-size: 14px;
	font-weight: normal
}

.form_control_t .form_label {
	float: left;
	display: block;
	width: 140px;
	text-align: right;
	padding-right: 10px;
	height: 25px;
	line-height: 25px;
	font-size: 12px;
}

.form_control .Validform_wrong {
	background-position: 15px -95px;
}

.form_control .Validform_right {
	background-position: 15px -145px;
}

.form_control .Validform_loading {
	background-position: 15px 4px;
}

.taxkTips {
	padding-bottom: 10px;
}

.taxkTips h2 {
	height: 30px;
	line-height: 30px;
	text-indent: 20px;
	border-bottom: 1px solid #dedede;
	font-size: 12px;
	color: #666;
	font-weight: bold;
	background-color: #f0f0f0;
	margin-top: 10px;
}
</style>
<title>购买积分中。。。</title>
</head>
<body>
	<div id="topbar">
		<div class="warp1200">
			<div class="clearfix">
				<div class="welcome row_l">
					<div class="welcome row_l"></div>
				</div>
				<div class="userlogininfo row_r">
					<div class="islogin" id="islogin">
						<a href="${pageContext.request.contextPath}/user/responseuser"><i class="fa fa-user"></i><span id="username">${tUserInfoCustom.usernick}</span></a>
						<a href="${pageContext.request.contextPath}/user/responseuser"><i class="fa fa-cog"></i>会员中心</a> 
						<a href="${pageContext.request.contextPath}/user/authlogout"><i class="fa fa-sign-out"></i>退出</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="pageFull">
		<div class="webHeader clearfix">
			<div class="logo row_l">
				<a href="${pageContext.request.contextPath}/frontend/index"
					title="电商流量">真流量</a>
			</div>
			<div class="channel row_r">
				<ul class="clearfix">
					<li><a href="${pageContext.request.contextPath}/frontend/index" title="电商流量" class="scl1">网站首页</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/intro" class="scl2">服务介绍</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/anli" class="scl3">成功案例</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/articlenews" class="scl4" title="电商干货">电商干货</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/articleguide" class="scl5">新手指引</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/authlogin" class="scl6" title="真流量用户中心">用户中心</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/about" class="scl7">联系我们</a></li>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript">
    $('.scl6').addClass('hover');
</script>

	<div class="uc_warp">
		<div class="userbody clearfix">
			<div class="leftmenu row_l">
				<dl>
					<dt>
						<a href="${pageContext.request.contextPath}/user/responseuser">个人中心</a>
					</dt>
					<dd>
						<p>
							<a href="${pageContext.request.contextPath}/user/responsepersonal" id="info"><i class="fa fa-angle-right"></i>基本信息</a>
						</p>
						<p>
							<!-- <a href="/user/broker" id="account"><i class="fa fa-angle-right"></i>我的推广</a> -->
							<a href="javascript:void(0);" id="account"><i class="fa fa-angle-right"></i>我的推广</a>
						</p>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="javascript:void(0);">流量任务管理</a>
					</dt>
					<dd>
						<p>
							<a href="${pageContext.request.contextPath}/task/responsetaskadd" id="addtask"><i class="fa fa-angle-right"></i>发布任务</a>
						</p>
						<p>
							<a href="${pageContext.request.contextPath}/task/responsetaskmanage" id="managetask"><i class="fa fa-angle-right"></i>任务管理</a>
						</p>
					</dd>
				</dl>
				<dl>
					<dt>
						<a href="javascript:void(0);">财务中心</a>
					</dt>
					<dd class="acc">
						<p>
							<a href="${pageContext.request.contextPath}/points/responsebuypoints" id="purchase"><i class="fa fa-angle-right"></i>购买积分</a>
						</p>
						<p>
							<a href="${pageContext.request.contextPath}/points/responserecordspoints" id="point"><i class="fa fa-angle-right"></i>积分明细</a>
						</p>
					</dd>
				</dl>
			</div>
			<script type="text/javascript">
        $('#purchase').addClass('hover');
    </script>

			<div class="rightbox row_r">
				<div class="u_outbox">
					<div class="tabtitle clearfix">
						<a href="${pageContext.request.contextPath}/points/responsebuypoints" class="row_l hover">购买积分套餐</a> 
						<a href="${pageContext.request.contextPath}/points/responseconsume" class="row_l">购买记录</a> 
						<a href="${pageContext.request.contextPath}/points/responserecordspoints" class="row_l">积分明细</a>
					</div>
					<div class="umainbox">
						<div style="font-size:15px;" >
							[第1步]：点击打开【<a style="color:red;font-size:17px;" href="https://shenghuo.alipay.com/send/payment/fill.htm" target="_bank">https://shenghuo.alipay.com/send/payment/fill.htm</a>】进入支付宝转账页面，按照下面步骤填写
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
										<button class="btn btn-info" id="btn_cz">>打开充值网页<</button>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="copyRight">
		<div class="warp1200 footer">
			<p>
				Copyright (c) 2015 <a href="${pageContext.request.contextPath}/frontend/index" title="淘宝流量">淘宝流量</a> | <a href="${pageContext.request.contextPath}/frontend/index" title="真流量">真流量</a>(www.zhenapp.cn) Inc. All Rights. 浙ICP备140452118号-5.
			</p>
		</div>
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/backstage/pagematter/common/js/layer_user.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/backstage/pagematter/common/js/Validform_v5.3.2.js"></script>
<script type="text/javascript">
	;$(function(){
		$("#btn_cz").click(function(){
			window.open("https://shenghuo.alipay.com/send/payment/fill.htm");
		});
	});
</script>
</html>