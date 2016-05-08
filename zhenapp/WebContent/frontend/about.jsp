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
<title>真流量</title>
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
					<li><a href="/detail/2118" target="_blank"><i
							class="fa fa-angle-right"></i>ROI的小心机,实操指导如何提高ROI</a></li>
					<li><a href="/detail/2117" target="_blank"><i
							class="fa fa-angle-right"></i>小细节,淘抢购报名通过率提高翻倍</a></li>
					<li><a href="/detail/2115" target="_blank"><i
							class="fa fa-angle-right"></i>标题优化技巧，淘宝无线端宝贝标题优化技巧</a></li>
					<li><a href="/detail/2116" target="_blank"><i
							class="fa fa-angle-right"></i>淘宝卖家常遇到的问题及解决办法</a></li>
					<li><a href="/detail/2114" target="_blank"><i
							class="fa fa-angle-right"></i>新品宝贝如何玩转直通车</a></li>
				</ul>

			</div>
			<div class="chennalBox mtop15">

				<h3>新手指引</h3>

				<ul class="titlelist">
					<li><a href="/detail/2010" target="_blank"><i
							class="fa fa-angle-right"></i>淘口令在哪里？淘口令怎么打开？</a></li>
					<li><a href="/detail/1879" target="_blank"><i
							class="fa fa-angle-right"></i>APP流量在淘宝后台怎么看？在生意参谋中怎么看？</a></li>
					<li><a href="/detail/1825" target="_blank"><i
							class="fa fa-angle-right"></i>什么是真假流量？真假流量对比？教你辨别真假流量</a></li>
					<li><a href="/detail/1814" target="_blank"><i
							class="fa fa-angle-right"></i>发布淘宝无线端APP流量任务常见问题？</a></li>
					<li><a href="/detail/1715" target="_blank"><i
							class="fa fa-angle-right"></i>如何发布淘宝无线端APP流量任务？</a></li>
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
								流量客服：QQ5761126 <a target="_blank"
									href="http://wpa.qq.com/msgrd?v=3&uin=5731126&site=qq&menu=yes"><img
									border="0" src="http://wpa.qq.com/pa?p=2:731004:4"
									alt="点击这里给我发消息" title="点击这里给我发消息" /></a>
							</p>
							<p>
								技术咨询：QQ731004 <a target="_blank"
									href="http://wpa.qq.com/msgrd?v=3&uin=731004&site=qq&menu=yes"><img
									border="0" src="http://wpa.qq.com/pa?p=2:731004:4"
									alt="点击这里给我发消息" title="点击这里给我发消息" /></a>
							</p>
							<p>
								流量托管：QQ46497161 <a target="_blank"
									href="http://wpa.qq.com/msgrd?v=3&uin=46497161&site=qq&menu=yes"><img
									border="0" src="http://wpa.qq.com/pa?p=2:731004:4"
									alt="点击这里给我发消息" title="点击这里给我发消息" /></a>
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
	<script>
        uParse('.content', {
            rootPath: '../'
        })
    </script>
	<div class="copyRight">
		<div class="warp1200 footer">
			<p>
				Copyright (c) 2015 <a href="${pageContext.request.contextPath}/frontend/index" title="淘宝流量">淘宝流量</a> | <a href="${pageContext.request.contextPath}/frontend/index" title="真流量">真流量</a>(www.zhenapp.cn) Inc. All Rights. 浙ICP备140452118号-5.
			</p>
		</div>
	</div>
</body>
</html>