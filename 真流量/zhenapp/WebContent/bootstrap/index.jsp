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
	<title>真流量</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/style.css">
	<link href="${pageContext.request.contextPath}/bootstrap/css/lanrenzhijia.css" rel="stylesheet" type="text/css">
</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top">
	<div style="height:20px;">
		<marquee scrollamount="5" onMouseOut=start(); onMouseOver=stop();>
			<a id="linka1" href="${pageContext.request.contextPath}/page/main/login.jsp"><font
				style="font-size:20px;">欢迎<font color="#F00">${username}</font>登陆本系统
			</font></a>  
			<a id="linka2" href="${pageContext.request.contextPath}/page/main/reg.jsp"><font
				style="font-size:20px;">| 赶紧加入我们</font></a>
		</marquee>
	</div>
	<div class="container" style="height:85px;">
		<div class="navbar-header">
			<a href="index.html" class="navbar-brand logo"><img src="${pageContext.request.contextPath}/bootstrap/img/index/${tWebInfoCustom.logo}" width="280px" height="80"px alt="真流量"></a>
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="navbar-collapse" >
			<ul class="nav navbar-nav navbar-right" >
				<li><a href="${pageContext.request.contextPath}/index/findwebinfo" style="height:85px;line-height:80px;font-size:20px;color: #FFA8A8;"><span class="glyphicon glyphicon-home" ></span> 首页</a></li>
				<!-- <li><a href="${pageContext.request.contextPath}/bootstrap/information.jsp" style="height:85px;line-height:80px;font-size:20px;"><span class="glyphicon glyphicon-list"></span> 电商干货</a></li> -->
				<li><a href="${pageContext.request.contextPath}/electrity/findElectrity_10" style="height:85px;line-height:80px;font-size:20px;"><span class="glyphicon glyphicon-list"></span> 电商干货</a></li>
				<li><a href="${pageContext.request.contextPath}/guide/findGuide_10" style="height:85px;line-height:80px;font-size:20px;"><span class="glyphicon glyphicon-fire"></span> 新手指引</a></li>
				<li><a href="${pageContext.request.contextPath}/about/findGuideandelectrity" style="height:85px;line-height:80px;font-size:20px;"><span class="glyphicon glyphicon-question-sign"></span> 联系我们</a></li>
			</ul>	
		</div>
	</div>
</nav>
<div style="height:20px;">
</div>

<div id="myCarousel" class="carousel slide" >
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>
	<div class="carousel-inner" style="height:470px;">
		<div class="item active" style="background:#223240">
			<img src="${pageContext.request.contextPath}/bootstrap/img/index/${tWebInfoCustom.carousel01}" style="height:470px;" alt="第一张">
		</div>
		<div class="item" style="background:#F5E4DC;">
			<img src="${pageContext.request.contextPath}/bootstrap/img/index/${tWebInfoCustom.carousel02}" style="height:470px;" alt="第二张">
		</div>
		<div class="item" style="background:#DE2A2D;">
			<img src="${pageContext.request.contextPath}/bootstrap/img/index/${tWebInfoCustom.carousel03}" style="height:470px;" alt="第三张">
		</div>
	</div>
	<a href="#myCarousel" data-slide="prev" class="carousel-control left">
		<span class="glyphicon glyphicon-chevron-left"></span>
	</a>
	<a href="#myCarousel" data-slide="next" class="carousel-control right">
		<span class="glyphicon glyphicon-chevron-right"></span>
	</a>
</div>


<div class="tab1" style="background-color: #F0F0F0">
	<div class="container">
		<h4 class="tab-h2" style="font-size: 50px;">我们的无线流量优势</h4>
		<div style="background-color: #FFFFFF;height:5px;">
		</div>
		<div class="row" >
			<div class="col-md-3 col">
				<div class="media">
					<div class="media-left">
						<a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/bootstrap/img/index/tab1-1.png" class="media-object" alt=""></a>
					</div>
					<div class="media-body">
						<h4 class="media-heading">淘宝无线流量</h4>
						<p>淘宝APP真实搜索流量</p>
						<p>最真实的模拟人工点击</p>
						<p>百倍手机订单由此开始</p>
					</div>
				</div>
			</div>
			<div class="col-md-3 col">
				<div class="media">
					<div class="media-left">
						<a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/bootstrap/img/index/tab1-2.png" class="media-object" alt=""></a>
					</div>
					<div class="media-body">
						<h4 class="media-heading">高端个性化流量</h4>
						<p>独创百分百模拟</p>
						<p>符合淘宝个性化搜索规则</p>
						<p>精准匹配卖家宝贝属性</p>
					</div>
				</div>
			</div>
			<div class="col-md-3 col">
				<div class="media">
					<div class="media-left">
						<a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/bootstrap/img/index/tab1-3.png" class="media-object" alt=""></a>
					</div>
					<div class="media-body">
						<h4 class="media-heading">全能规避</h4>
						<p>独创分布式随机算法</p>
						<p>任务随机分配到不同地区</p>
						<p>自定义时间安排流量,更真实</p>
					</div>
				</div>
			</div>
			<div class="col-md-3 col">
				<div class="media">
					<div class="media-left">
						<a href="javascript:void(0)"><img src="${pageContext.request.contextPath}/bootstrap/img/index/tab1-4.png" class="media-object" alt=""></a>
					</div>
					<div class="media-body">
						<h4 class="media-heading">成熟的放单系统</h4>
						<p>操作轻松简单</p>
						<p>任务进度一目了然</p>
						<p>成熟的流量REP系统</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="tab1" style="background-color: #F0F0F0">
	<div class="container">
		<h4 class="tab-h2" style="font-size: 50px;">我们的成功案例</h4>
		<div style="background-color: #FFFFFF;height:5px;">
		</div>
		<div class="row" >
			<div class="col-md-6 col">
				<div class="media">
					<div class="media-body">
						<center><h4 class="media-heading">合作前（流量概况）</h4></center>
						<div class="img" style><img src="${pageContext.request.contextPath}/bootstrap/img/index/anli_01.jpg" width="540" height="313" alt="淘宝app流量" /></div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col">
				<div class="media">
					<div class="media-body">
						<center><h4 class="media-heading">合作后（流量概况）</h4></center>
						<div class="img"><img src="${pageContext.request.contextPath}/bootstrap/img/index/anli_02.jpg" width="540" height="313" alt="淘宝app流量" /></div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col">
				<div class="media">
					<div class="media-body">
						<center><h4 class="media-heading">合作前（商品概况）</h4></center>
						<div class="img"><img src="${pageContext.request.contextPath}/bootstrap/img/index/anli_03.jpg" width="540" height="313" alt="淘宝app流量" /></div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col">
				<div class="media">
					<div class="media-body">
						<center><h4 class="media-heading">合作后（商品概况）</h4></center>
						<div class="img"><img src="${pageContext.request.contextPath}/bootstrap/img/index/anli_04.jpg" width="540" height="313" alt="淘宝app流量" /></div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col">
				<div class="media">
					<div class="media-body">
						<center><h4 class="media-heading">合作前（经营概况）</h4></center>
						<div class="img" style><img src="${pageContext.request.contextPath}/bootstrap/img/index/anli_05.jpg" width="468" height="633" alt="淘宝app流量" /></div>
					</div>
				</div>
			</div>
			<div class="col-md-6 col">
				<div class="media">
					<div class="media-body">
						<center><h4 class="media-heading">合作后（经营概况）</h4></center>
						<div class="img"><img src="${pageContext.request.contextPath}/bootstrap/img/index/anli_06.jpg" width="468" height="633" alt="淘宝app流量" /></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>



<div class="tab2">
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-sm-6 tab2-img">
				<img src="${pageContext.request.contextPath}/bootstrap/img/tab2.png" class="auto img-responsive center-block" alt="">
			</div>
			<div class="text col-md-6 col-sm-6 tab2-text">
				<h3>关于我们</h3>
				<p>流量村是一个针对淘宝店铺增加无线端APP手机流量、收藏、加购物车、淘口令和提高直通车质量得分的平台！您可以通过流量村平台注册会员进行提升淘宝app流量、收藏、加购等操作，真实有效提升商品关键词指数和商品排名。</p>
				<p>流量村团队，有国内最有技术实力的淘宝专业技术公司团队，针对淘宝规则的整个系统进行的研发。网站技术团队有多位实力成员，负责整个平台的研发、测试、上线、维护、更新、服务。一直不断的根据淘宝的监察规则和淘宝不断变化的情况来研发最真实的流量，符合淘宝的规则。为客户提供流量的必备工具(刷手机淘宝流量、淘宝手机流量软件、淘宝无线流量软件)。</p>
				<p>我们拥有5万以上真实手机，全国分布多个流量机房，轮流提高流量及点击率，提供最真实人工流量，及完全模拟手工操作。造爆款必备，提升网店浏览量和宝贝人气，提高直通车质量得分，完全通过生意参谋检测，可以查到真实的手机淘宝流量，非wap网页模拟流量！</p>
				<p>专业打造优质无线流量 欢迎广大卖家咨询合作 加入我们共享双赢网店。</p>
			</div>
		</div>
	</div>
</div>

<div id="divQQbox" class="QQbox">
	<div id="divOnline" class="Qlist" style="background:url(${pageContext.request.contextPath}/bootstrap/img/${tWebInfoCustom.bg01}) no-repeat;">
		<div class="OnlineLeft">
			<div class="con">
				<ul>
					<li>售前咨询<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq}&amp;&amp;Site=www.lanrenzhijia.com&amp;&amp;Menu=yes"><img
						border="0" src="http://wpa.qq.com/pa?p=1:${tWebInfoCustom.qq}:42"></a></li>
					<li>网站建设<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq}&amp;&amp;Site=www.lanrenzhijia.com&amp;&amp;Menu=yes"><img
						border="0" src="http://wpa.qq.com/pa?p=1:${tWebInfoCustom.qq}:42"></a></li>
					<li>网站优化<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq}&amp;&amp;Site=www.lanrenzhijia.com&amp;&amp;Menu=yes"><img
						border="0" src="http://wpa.qq.com/pa?p=1:${tWebInfoCustom.qq}8:42"></a></li>
					<li>整合营销<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq}&amp;&amp;Site=www.lanrenzhijia.com&amp;&amp;Menu=yes"><img
						border="0" src="http://wpa.qq.com/pa?p=1:${tWebInfoCustom.qq}:42"></a></li>
					<li>售后服务<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq}&amp;&amp;Site=www.lanrenzhijia.com&amp;&amp;Menu=yes"><img
						border="0" src="http://wpa.qq.com/pa?p=1:${tWebInfoCustom.qq}:42"></a></li>
				</ul>
			</div>
		</div>
		<div class="OnlineBtn" style="background:url(${pageContext.request.contextPath}/bootstrap/img/${tWebInfoCustom.bg02}) no-repeat;">
		</div>
	</div>
</div>

<footer id="footer">
	<div class="container">
		<p>帮助中心 | 联系我们 | 关注微信</p>
		<p>Copyright (c) 2015 zhenapp.cn Inc. All Rights. 浙ICP备140452118号-5</p>
	</div>
</footer>


<script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
	//轮播自动播放
	$('#myCarousel').carousel({
		//自动4秒播放
		interval : 4000,
	});
	
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
	$(function(){
		//建站热线展开效果
		$("#divQQbox").hover(
			function(){
				$(this).stop(true,false);
				$(this).animate({left:0},300);	
			},
			function(){
				$(this).animate({left:-276},149);	
			}
		)
	
		if($('#linka1').text().indexOf("欢迎登")==-1){
			//$('#linka2').style.display = "none";
			$('#linka2').innerHTML="";
		}
	
	});
	
</script>
</body>
</html>