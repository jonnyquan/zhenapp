<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
	<title>企业简介</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/style.css">
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top" style="background-color: #FFF;">
	<div style="height:20px;">
		<c:if test="${username=='' || username == null}">
			<marquee scrollamount="5" onMouseOut=start(); onMouseOver=stop();>
				<a href="${pageContext.request.contextPath}/page/main/login.jsp"><font style="font-size:20px;">欢迎登陆 |</font></a> 
				<a href="${pageContext.request.contextPath}/page/main/reg.jsp"><font style="font-size:20px;">| 赶紧加入我们</font></a>
			</marquee>	
		</c:if>
		<c:if test="${username!='' || username != null}">
			<marquee scrollamount="5" onMouseOut=start(); onMouseOver=stop();>
				<a href="javascript:void(0);"><font style="font-size:20px;">欢迎<font color="#F00">${username}</font>使用本系统！</font></a>
			</marquee>	
		</c:if>
	</div>
	<div class="container" style="height:85px;">
		<div class="navbar-header">
			<a href="index.html" class="navbar-brand logo"><img src="${pageContext.request.contextPath}/bootstrap/img/index/logo.png"  alt="瓢城企训网"></a>
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="navbar-collapse" >
			<ul class="nav navbar-nav navbar-right" >
				<li><a href="${pageContext.request.contextPath}/index/findwebinfo" style="height:85px;line-height:80px;font-size:20px;"><span class="glyphicon glyphicon-home" ></span> 首页</a></li>
				<li><a href="${pageContext.request.contextPath}/electrity/findElectrity_10" style="height:85px;line-height:80px;font-size:20px;"><span class="glyphicon glyphicon-list"></span> 电商干货</a></li>
				<li><a href="${pageContext.request.contextPath}/guide/findGuide_10" style="height:85px;line-height:80px;font-size:20px;"><span class="glyphicon glyphicon-fire"></span> 新手指引</a></li>
				<li><a href="${pageContext.request.contextPath}/about/findGuideandelectrity" style="height:85px;line-height:80px;font-size:20px;color: #FFA8A8;"><span class="glyphicon glyphicon-question-sign"></span> 联系我们</a></li>
			</ul>	
		</div>
	</div>
</nav>
<div style="height:20px;">
</div>


<div style="height:100px;background-color: #EEE">

</div>

<div id="about">
	<div class="container">
		<div class="row">
			<div class="col-md-4 info-right hidden-xs hidden-sm">
				<blockquote>
					<h2>热门信息</h2>
				</blockquote>
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12" style="background-color: #fff;">
						<blockquote>
							<h4>电商信息</h4>
						</blockquote>
						<div style="height:360px;">
							<table id="table">
								<c:forEach items="${TelectricityCustomlist}" var="item">
									<tr>
										<td style="margin:5px; padding:5px;border: 1px dashed #fff;">
											<span class="glyphicon glyphicon-menu-right"></span>
										</td>
										<td style="margin:5px; padding:5px;border: 1px dashed #fff;">
											<a href="${pageContext.request.contextPath}/electrity/details/${item.electricitypk}"><font color="#666" size="3">${item.electricityname}</font></a>		
										</td>
									</tr>	
								</c:forEach>
							</table>
						</div>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12" align="center">
						<div style="background-color: #DDD;height:10px;width:300px;">
						&nbsp;
						</div>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12" style="background-color: #fff;height:20px;width:300px;" >
					
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12" style="background-color: #fff;">
						<blockquote>
							<h4>新手注意事项</h4>
						</blockquote>
						<div style="height:300px;">
							<table id="table2" >
								<c:forEach items="${TGuideInfoCustomlist}" var="item">
									<tr>
										<td style="margin:5px; padding:5px;border: 1px dashed #fff;">
											<span class="glyphicon glyphicon-menu-right"></span>
										</td>
										<td style="margin:5px; padding:5px;border: 1px dashed #fff;">
											<a href="${pageContext.request.contextPath}/guide/details/${item.guidepk}"><font color="#666" size="3">${item.guidename}</font></a>		
										</td>
									</tr>	
								</c:forEach>
							</table>
						</div>
					</div>
					
				</div>
			</div>
			<div class="col-md-1 " style="width:5px;">
			</div>
			<div class="col-md-7 " style="background-color: #fff;">
					<div>
		                <h3>联系我们</h3>
		
		                <div class="mainBox">
		                    <div class="newsContent">
		                        <div class="content">
		                            <p>客服斌哥：QQ:319809430 <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=319809430&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:731004:4" alt="点击这里给我发消息" title="点击这里给我发消息"/></a></p>
		                            <p>客服婷婷：QQ:319809430 <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=319809430&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:731004:4" alt="点击这里给我发消息" title="点击这里给我发消息"/></a></p>
		                            <p>网站合作：QQ:319809430 <a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=319809430&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:731004:4" alt="点击这里给我发消息" title="点击这里给我发消息"/></a></p>
		                            <br />
		                            <p>承接托管业务：淘宝端APP无线流量、聚划算开团提醒、双11双12赛马服务(加购、收藏、领券)；<br>请咨询坐席客服，我们将竭诚为您服务!</p>
		                        </div>
		                    </div>
		                </div>
		            </div>
			</div>
		</div>
	</div>
</div>

<footer id="footer">
	<div class="container">
		<p>企业培训 | 合作事宜 | 版权投诉</p>
		<p>苏ICP 备12345678. © 2009-2026真流量. Powered by Bootstrap.</p>
	</div>
</footer>


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">

</script>
</body>
</html>
<script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	//轮播自动播放
	$('#myCarousel').carousel({
		//自动4秒播放
		interval : 4000,
	});

	// //设置垂直居中
	// $('.carousel-control').css('line-height', $('.carousel-inner img').height() + 'px');
	// $(window).resize(function () {
	// 	var $height = $('.carousel-inner img').eq(0).height() || 
	// 				  $('.carousel-inner img').eq(1).height() || 
	// 				  $('.carousel-inner img').eq(2).height();
	// 	$('.carousel-control').css('line-height', $height + 'px');
	// });

	//设置文字垂直居中，谷歌浏览器加载图片的顺序问题，导致高度无法获取
	$(window).load(function () {
		$('.text').eq(0).css('margin-top', ($('.auto').eq(0).height() - $('.text').eq(0).height()) / 2 + 'px');
	});
	

	$(window).resize(function () {
		$('.text').eq(0).css('margin-top', ($('.auto').eq(0).height() - $('.text').eq(0).height()) / 2 + 'px');
	});

	$(window).load(function () {
		$('.text').eq(1).css('margin-top', ($('.auto').eq(1).height() - $('.text').eq(1).height()) / 2 + 'px');
	});

	$(window).resize(function () {
		$('.text').eq(1).css('margin-top', ($('.auto').eq(1).height() - $('.text').eq(1).height()) / 2 + 'px');
	});

</script>
</body>
</html>