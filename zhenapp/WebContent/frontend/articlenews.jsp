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
				<h3>电商干货</h3>
				<div class="mainBox">
					<ul class="newslist">
						<li><span>2016-05-05 16:58:15</span><a href="/detail/2118"
							target="_blank"><i class="fa fa-angle-right"></i>ROI的小心机,实操指导如何提高ROI</a></li>
						<li><span>2016-05-05 16:58:14</span><a href="/detail/2117"
							target="_blank"><i class="fa fa-angle-right"></i>小细节,淘抢购报名通过率提高翻倍</a></li>
						<li><span>2016-05-05 16:58:13</span><a href="/detail/2115"
							target="_blank"><i class="fa fa-angle-right"></i>标题优化技巧，淘宝无线端宝贝标题优化技巧</a></li>
						<li><span>2016-05-05 16:58:13</span><a href="/detail/2116"
							target="_blank"><i class="fa fa-angle-right"></i>淘宝卖家常遇到的问题及解决办法</a></li>
						<li><span>2016-05-05 16:58:12</span><a href="/detail/2114"
							target="_blank"><i class="fa fa-angle-right"></i>新品宝贝如何玩转直通车</a></li>
						<li><span>2016-05-05 16:58:11</span><a href="/detail/2112"
							target="_blank"><i class="fa fa-angle-right"></i>店铺推广引流怎么做？</a></li>
						<li><span>2016-05-05 16:58:11</span><a href="/detail/2113"
							target="_blank"><i class="fa fa-angle-right"></i>淘抢购审核通不过怎么办？</a></li>
						<li><span>2016-05-05 16:58:10</span><a href="/detail/2110"
							target="_blank"><i class="fa fa-angle-right"></i>利用生意参谋挖掘不知道的类目流量</a></li>
						<li><span>2016-05-05 16:58:10</span><a href="/detail/2111"
							target="_blank"><i class="fa fa-angle-right"></i>如何搭建店铺团队,店铺经营方法</a></li>
						<li><span>2016-05-05 16:58:09</span><a href="/detail/2109"
							target="_blank"><i class="fa fa-angle-right"></i>钻展广告预算，钻展广告预算如何花在刀刃上</a></li>
						<li><span>2016-05-02 21:22:04</span><a href="/detail/2108"
							target="_blank"><i class="fa fa-angle-right"></i>
								内容运营是什么，淘宝卖家如何玩转内容运营？</a></li>
						<li><span>2016-05-02 21:22:03</span><a href="/detail/2107"
							target="_blank"><i class="fa fa-angle-right"></i>直通车点击率飙到10%的优化细节</a></li>
						<li><span>2016-05-02 21:22:02</span><a href="/detail/2105"
							target="_blank"><i class="fa fa-angle-right"></i>如何&ldquo;快速、精准&rdquo;稳定直通车排名</a></li>
						<li><span>2016-05-02 21:22:02</span><a href="/detail/2106"
							target="_blank"><i class="fa fa-angle-right"></i>详情页中不可少的卖点提炼</a></li>
						<li><span>2016-05-02 21:22:01</span><a href="/detail/2103"
							target="_blank"><i class="fa fa-angle-right"></i>直通车推广如何提升质量得分?</a></li>
						<li><span>2016-05-02 21:22:01</span><a href="/detail/2104"
							target="_blank"><i class="fa fa-angle-right"></i>卖家如何提高转化率和质量分</a></li>
						<li><span>2016-05-02 21:22:00</span><a href="/detail/2102"
							target="_blank"><i class="fa fa-angle-right"></i>2016淘宝运营7个实用技巧</a></li>
						<li><span>2016-05-02 21:21:59</span><a href="/detail/2101"
							target="_blank"><i class="fa fa-angle-right"></i>直通车测款方法，直通车定价方法</a></li>
						<li><span>2016-04-30 20:07:53</span><a href="/detail/2099"
							target="_blank"><i class="fa fa-angle-right"></i>直通车这样开才有效！</a></li>
						<li><span>2016-04-30 20:07:53</span><a href="/detail/2100"
							target="_blank"><i class="fa fa-angle-right"></i>内容营销这么做，你的店铺有点火</a></li>
					</ul>

					<div class="paging">
						<a>上一页</a> 
						<a class="cur">1</a>
						<a href="${pageContext.request.contextPath}/article/news/?page=2">2</a>
						<a href="${pageContext.request.contextPath}/article/news/?page=3">3</a>
						<a href="${pageContext.request.contextPath}/article/news/?page=4">4</a>
						<a href="${pageContext.request.contextPath}/article/news/?page=5">5</a>
						<a href="${pageContext.request.contextPath}/article/news/?page=6">6</a>
						<a href="${pageContext.request.contextPath}/article/news/?page=7">7</a>
						<a href="${pageContext.request.contextPath}/article/news/?page=8">8</a>
						<a>...</a>
						<a href="${pageContext.request.contextPath}/article/news/?page=48">48</a>
						<a href="${pageContext.request.contextPath}/article/news/?page=49">49</a> 
						<a href="${pageContext.request.contextPath}/article/news/?page=2" rel="next">下一页</a>
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