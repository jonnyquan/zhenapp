<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="keywords" content="真流量,淘口令,刷淘宝流量,淘宝刷流量软件,淘宝流量,淘宝刷流量" />
<meta name="description"
	content="真流量是一个快速提升淘宝手机流量、淘口令流量、淘宝无线流量、淘宝APP流量的平台,真流量优势:  百分百模拟刷淘宝手机流量、淘口令、淘宝刷流量软件、刷淘宝流量软件。" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/global.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/index.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/frontend/pagematter/common/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/frontend/pagematter/common/js/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/frontend/pagematter/common/js/jquery.SuperSlide.2.1.1.js"></script>
<title>联系我们</title>

<style type="text/css">
.webHeader .logo a {
	display: block;
	width: 280px;
	height: 80px;
	background: url("${pageContext.request.contextPath}/frontend/pagematter/common/img/logo.png") no-repeat;
	text-indent: -99999px;
}
</style>
</head>
</head>
<body>
	<div class="topbar">
		<div class="warp1200 toplogin clearfix">
			<div class="userlogin row_r" id="userLogin">
				<c:if test="${tUserInfoCustom == null}">
					您好，欢迎来到真流量网！<a href="${pageContext.request.contextPath}/frontend/authlogin">马上登录</a>|<a href="${pageContext.request.contextPath}/frontend/authregister">快速注册</a>
				</c:if>
				<c:if test="${tUserInfoCustom != null}">
					<div class="userlogin row_r" id="userLogin">您好 <span>${tUserInfoCustom.usernick }</span> 欢迎您回来！<a href="${pageContext.request.contextPath}/user/responsepersonal">进入会员中心</a>|<a href="${pageContext.request.contextPath}/user/authlogout">退出登录</a></div>
				</c:if>
			</div>
		</div>
	</div>

	<div class="pageFull">
		<div class="webHeader clearfix">
			<div class="logo row_l">
				<a href="${pageContext.request.contextPath}/frontend/index" title="电商流量">真流量</a>
			</div>
			<div class="channel row_r">
				<ul class="clearfix">
					<li><a href="${pageContext.request.contextPath}/frontend/index" title="电商流量"
						class="scl1">网站首页</a></li>
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
        $('.scl7').addClass('hover');
    </script>

	<div class="warp1200 clearfix">
		<div class="leftMenu row_l">

			<div class="chennalBox mtop15">

				<h3>电商干货</h3>

				<ul class="titlelist">
					<c:forEach items="${TelectricityCustomlist}" var="list">
						<li><a href="${pageContext.request.contextPath}/frontend/articlenewsdetail/${list.electricitypk}" target="_blank"><i class="fa fa-angle-right"></i>${list.electricityname}</a></li>
					</c:forEach>
				</ul>

			</div>
			<div class="chennalBox mtop15">
				<h3>新手指引</h3>
				<ul class="titlelist">
					<c:forEach items="${TGuideInfoCustomlist}" var="list">
						<li><a href="${pageContext.request.contextPath}/frontend/articleguidedetail/${list.guidepk}" target="_blank"><i class="fa fa-angle-right"></i>${list.guidename}</a></li>
					</c:forEach>
				</ul>
			</div>

		</div>

		<div class="rightBox row_r">
			<div class="chennalBox mtop15">
				<h3>联系我们</h3>

				<div class="mainBox">
					<div class="newsContent">
						<div class="content">
							<p>
								流量客服：QQ5761126 
								<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=5731126&site=qq&menu=yes">
								<img border="0" src="http://wpa.qq.com/pa?p=2:731004:4" alt="点击这里给我发消息" title="点击这里给我发消息" /></a>
							</p>
							<p>
								技术咨询：QQ731004 <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=731004&site=qq&menu=yes">
								<img border="0" src="http://wpa.qq.com/pa?p=2:731004:4" alt="点击这里给我发消息" title="点击这里给我发消息" /></a>
							</p>
							<p>
								流量托管：QQ46497161 
								<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=46497161&site=qq&menu=yes">
								<img border="0" src="http://wpa.qq.com/pa?p=2:731004:4" alt="点击这里给我发消息" title="点击这里给我发消息" /></a>
							</p>
							<br />
							<p>承接托管业务：淘宝端APP无线流量、聚划算开团提醒、加购、收藏、领券；</p>
							<p>请咨询坐席客服，我们将竭诚为您服务!</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/frontend/pagematter/common/js/floatTools.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/frontend/pagematter/common/js/layer.min.js"></script>

	<div class="copyRight">
		<div class="warp1200 footer">
			<p>
				Copyright (c) 2015 <a href="${pageContext.request.contextPath}/frontend/index" title="淘宝流量">淘宝流量</a> | <a href="${pageContext.request.contextPath}/frontend/index" title="真流量">真流量</a>(www.zhenapp.cn) Inc. All Rights. 浙ICP备140452118号-5.
			</p>
		</div>
	</div>
</body>
</html>