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

<meta name="keywords" content="电商干货,淘宝干货,跨境电商干货,微商干货,淘宝实操干货,电商运营" />
<meta name="description"
	content="电商实操运营经验哪里找，尽在真流量电商干货频道。无论你是深耕天猫淘宝开店的，还是刚刚涉足跨境电商领域的，或是刚刚投奔微商领域的，总有一款电商干货是你需要的，看这里就够了。" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/global.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/common.css">

<script type="text/javascript"
	src="${pageContext.request.contextPath}/frontend/pagematter/common/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/frontend/pagematter/common/js/common.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/index.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/frontend/pagematter/common/js/jquery.SuperSlide.2.1.1.js"></script>
<title>电商干货 - 真流量</title>
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
        $('.scl4').addClass('hover');
    </script>

	<div class="warp1200 clearfix">
		<div class="leftMenu row_l">

			<div class="chennalBox mtop15">

				<h3>电商干货</h3>

				<ul class="titlelist">
					<c:forEach items="${TelectricityCustomlist}" var="list">
						<li><a href="${pageContext.request.contextPath}/detail/2118" target="_blank"><i class="fa fa-angle-right"></i>${list.electricityname}</a></li>
					</c:forEach>
				</ul>

			</div>
			<div class="chennalBox mtop15">
				<h3>新手指引</h3>
				<ul class="titlelist">
					<c:forEach items="${TGuideInfoCustomlist}" var="list">
						<li><a href="${pageContext.request.contextPath}/detail/2118" target="_blank"><i class="fa fa-angle-right"></i>${list.guidename}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div class="rightBox row_r">
			<div class="chennalBox mtop15">
				<h3>电商干货</h3>
				<div class="mainBox">
					<ul class="newslist">
						<c:forEach items="${TelectricityCustomAlllist}" var="list">
							<li><span>${list.createtime}</span><a href="/detail/2118" target="_blank"><i class="fa fa-angle-right"></i>${list.electricityname}</a></li>
						</c:forEach>
					</ul>

					<div class="paging">
						<a>上一页</a> 
						<a class="cur">1</a>
						<a href="${pageContext.request.contextPath}/frontend/articlenews/?page=2">2</a>
						<a href="${pageContext.request.contextPath}/frontend/articlenews/?page=3">3</a>
						<a href="${pageContext.request.contextPath}/frontend/articlenews/?page=4">4</a>
						<a href="${pageContext.request.contextPath}/frontend/articlenews/?page=5">5</a>
						<a href="${pageContext.request.contextPath}/frontend/articlenews/?page=6">6</a>
						<a href="${pageContext.request.contextPath}/frontend/articlenews/?page=7">7</a>
						<a href="${pageContext.request.contextPath}/frontend/articlenews/?page=8">8</a>
						<a>...</a>
						<a href="${pageContext.request.contextPath}/frontend/articlenews/?page=48">48</a>
						<a href="${pageContext.request.contextPath}/frontend/articlenews/?page=49">49</a> 
						<a href="${pageContext.request.contextPath}/frontend/articlenews/?page=2" rel="next">下一页</a>
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