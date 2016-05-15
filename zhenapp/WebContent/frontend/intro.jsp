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
<script type="text/javascript" src="${pageContext.request.contextPath}/frontend/pagematter/common/js/ueditor.parse.js"></script>
<title>服务介绍 - 真流量</title>

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
        $('.scl2').addClass('hover');
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
				<h3>服务介绍</h3>

				<div class="mainBox">
					<div class="newsContent">
						<div class="content">
							<p>真流量是一个针对淘宝店铺增加无线端APP手机流量、收藏、加购物车、淘口令和提高直通车质量得分的平台！您可以通过真流量平台注册会员进行提升无线端流量、收藏、加购等操作，真实有效提升商品关键词指数和商品排名。</p>
							<br />

							<p>真流量团队，有国内最有技术实力的淘宝专业技术公司团队，针对淘宝规则的整个系统进行的研发。网站技术团队有多位实力成员，负责整个平台的研发、测试、上线、维护、更新、服务。一直不断的根据淘宝的监察规则和淘宝不断变化的情况来研发最真实的流量，符合淘宝的规则。为客户提供流量的必备工具。</p>
							<br />

							<p>我们拥有5万以上真实手机，全国分布多个流量机房，轮流提高流量及点击率，提供最真实人工流量，及完全模拟手工操作。造爆款必备，提升网店浏览量和宝贝人气，提高直通车质量得分，完全通过生意参谋检测，可以查到真实的手机淘宝流量，非wap网页模拟流量！</p>
							<br />

							<p>专业打造优质无线流量 欢迎广大卖家咨询合作</p>
							<br />

							<p>
								<strong>我们的核心优势</strong>
							</p>
							<br />

							<p>
								<strong>手机流量：</strong>支持淘宝app展现及淘宝APP流量，真实手机挂机，有效提升你的无线端排名，帮你打造无线端新爆款
							</p>
							<br />
							<p>
								<strong>深度性：</strong>软件支持货比、宝贝详情页、宝贝评价、宝贝参数、店铺首页、副宝贝、收藏宝贝、加购物车等
							</p>
							<br />
							<p>
								<strong>真实性：</strong>全国数5万部真实手机挂机搜索浏览，轮流提高流量及销量，提供最真实的淘宝APP流量
							</p>
							<br />
							<p>
								<strong>安全性：</strong>同一任务条件下，系统对浏览的每一页面停留时间随机，做到千万次的访问，千万次的区别
							</p>
							<br />
							<p>
								<strong>地域性：</strong>同时独创的分布式算法，全网任务自动分配到不同地区、不同型号的手机
							</p>
							<br>
							<p align="center">
								<strong>积分价格表</strong>
							</p>
							<br />
							<table width="100%" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td align="center" width="20%"><strong>套餐</strong></td>
									<td align="center" width="20%"><strong>充值金额</strong></td>
									<td align="center" width="20%"><strong>积分</strong></td>
									<td align="center" width="20%"><strong>可发布APP流量数量</strong></td>
									<td align="center" width="20%"><strong>流量单价</strong></td>
								</tr>
								<tr>
									<td align="center">体验套餐</td>
									<td align="center">30元</td>
									<td align="center">2000</td>
									<td align="center">200</td>
									<td align="center">0.15元</td>
								</tr>
								<tr>
									<td align="center">A套餐</td>
									<td align="center">150元</td>
									<td align="center">10700</td>
									<td align="center">1070</td>
									<td align="center">0.14元</td>
								</tr>
								<tr>
									<td align="center">B套餐</td>
									<td align="center">300元</td>
									<td align="center">23000</td>
									<td align="center">2300</td>
									<td align="center">0.13元</td>
								</tr>
								<tr>
									<td align="center">C套餐</td>
									<td align="center">600元</td>
									<td align="center">50000</td>
									<td align="center">5000</td>
									<td align="center">0.12元</td>
								</tr>
								<tr>
									<td align="center">D套餐</td>
									<td align="center">1000元</td>
									<td align="center">90800</td>
									<td align="center">9080</td>
									<td align="center">0.11元</td>
								</tr>
								<tr>
									<td align="center">E套餐</td>
									<td align="center">2000元</td>
									<td align="center">200000</td>
									<td align="center">20000</td>
									<td align="center">0.10元</td>
								</tr>
								<tr>
									<td align="center">F套餐</td>
									<td align="center">5000元</td>
									<td align="center">600000</td>
									<td align="center">60000</td>
									<td align="center">0.08元</td>
								</tr>
							</table>

							*推荐朋友来注册可以获得10%的佣金哦，<a
								href="javascript:void(0);">我要获取推广链接</a>！
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