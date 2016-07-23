<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
  <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->


<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="淘口令,刷淘宝流量,淘宝刷流量软件,淘宝流量,淘宝刷流量" />
<meta name="description" content="旺点击是一个快速提升淘宝手机流量、淘口令流量、淘宝无线流量、淘宝APP流量的平台,真流量优势:  百分百模拟刷淘宝手机流量、淘口令、淘宝刷流量软件、刷淘宝流量软件。" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/frontend/pagematter/common/img/favicon.ico" type="image/x-icon" />

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frontend/pagematter/common/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frontend/pagematter/common/css/global.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frontend/pagematter/common/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frontend/pagematter/common/css/index.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/frontend/pagematter/common/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/frontend/pagematter/common/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/frontend/pagematter/common/js/jquery.SuperSlide.2.1.1.js"></script>

<title>${tAgentInfoCustom.agentname }</title>

<style type="text/css">
/*html5*/
article,aside,dialog,footer,header,section,footer,nav,figure,menu{display:block}

.webHeader .logo a {
	display: block;
	width: 280px;
	height: 80px;
	background: url("${pageContext.request.contextPath}/webimg/${tWebInfoCustom.logo}") no-repeat;
	text-indent: -99999px;
}
*{margin:0px;padding:0px;outline:none;list-style-type:none;border:none;}
.QQbox{z-index:1000;width:410px;left:-276px;top:0;margin:149px 0 0 0;position:fixed;}
*html,*html body{background-image:url(about:blank);background-attachment:fixed;}
*html .QQbox{position:absolute;top:expression(eval(document.documentElement.scrollTop));}
.QQbox .press{left:0;border:none;cursor:pointer;width:32px;height:96px;position:absolute;padding-top:140px;}
.QQbox .Qlist{float:left;width:410px;background:url(${pageContext.request.contextPath}/webimg/${tWebInfoCustom.bg01}) no-repeat;background-position:1px 0px;height:436px;display:block;overflow:hidden;zoom:1;}
.QQbox .Qlist .infobox{text-align:center;background-repeat:no-repeat;padding:5px;line-height:14px;color:#CCCCCC;font-weight:700;}
.QQbox .Qlist .con{margin-top:266px;margin-left:50px;color:#32567e;font-size:14px;}
.QQbox .Qlist .con ul li{height:31px;list-style:none;margin-left:35px;}
.QQbox .Qlist .con ul li a{font-size:13px;margin-left:18px;text-decoration:none;}
.OnlineLeft{float:left;display:inline;width:262px;height:439px;overflow:hidden;zoom:1;}
.OnlineBtn{float:right;display:inline;width:127px;height:36px;background:url(${pageContext.request.contextPath}/webimg/${tWebInfoCustom.bg02}) no-repeat;margin-top:-45px;margin-left:220px;}
</style>
</head>
<body>
	<div class="topbar">
		<div class="warp1200 toplogin clearfix">
			<div class="userlogin row_r" id="userLogin">
				<c:if test="${tUserInfoCustom == null}">
					您好，欢迎来到${tAgentInfoCustom.agentname }！<a href="${pageContext.request.contextPath}/frontend/authlogin">马上登录</a>|<a href="${pageContext.request.contextPath}/frontend/authregister">快速注册</a>
				</c:if>
				<c:if test="${tUserInfoCustom != null}">
					<div class="userlogin row_r" id="userLogin">您好 <span>${tUserInfoCustom.usernick }</span> 欢迎您回来！<a href="${pageContext.request.contextPath}/frontend/authlogin">进入会员中心</a>|<a href="${pageContext.request.contextPath}/user/authlogout">退出登录</a></div>
				</c:if>
			</div>
		</div>
	</div>

	<div class="pageFull">
		<div class="webHeader clearfix">
			<div class="logo row_l">
				<a href="${pageContext.request.contextPath}/frontend/index" title="电商流量">${tAgentInfoCustom.agentname }</a>
			</div>
			<div class="channel row_r">
				<ul class="clearfix">
					<li><a href="${pageContext.request.contextPath}/frontend/index" title="电商流量"
						class="scl1">网站首页</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/intro" class="scl2">服务介绍</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/anli" class="scl3">成功案例</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/articlenews" class="scl4" title="电商干货">电商干货</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/articleguide" class="scl5">新手指引</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/authlogin" class="scl6" title="用户中心">用户中心</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/about" class="scl7">联系我们</a></li>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript">
        $('.scl1').addClass('hover');
    </script>
	<div class="slideBox">
		<div class="hd">
			<span>0</span><span>1</span><span>2</span>
		</div>
		<div class="bd">
			<ul>
				<a href="javascript:void(0);" title="淘口令流量" target="_blank">
					<li style="background:url(${pageContext.request.contextPath}/webimg/${tWebInfoCustom.carousel01}) #fff center top no-repeat;"></li>
				</a>
				<li style="background:url(${pageContext.request.contextPath}/webimg/${tWebInfoCustom.carousel02}) #fff center top no-repeat;"></li>
				<li style="background:url(${pageContext.request.contextPath}/webimg/${tWebInfoCustom.carousel03}) #fff center top no-repeat;"></li>
			</ul>
		</div>
	</div>
	<script type="text/javascript">jQuery(".slideBox").slide({titCell:".hd span",mainCell:".bd ul",effect:"fold",trigger:"click",delayTime:2000,autoPlay:true});</script>
	<div class="pageFull" id="part_1">
		<div class="youshi">我们的无线流量优势</div>
	</div>
	<div class="warp1200">
		<div class="youshi_show clearfix">
			<dl class="dl_1">
				<dt>淘宝无线流量</dt>
				<dd>淘宝APP真实搜索流量</dd>
				<dd>最真实的模拟人工点击</dd>
				<dd>百倍手机订单由此开始</dd>
			</dl>
			<dl class="dl_2">
				<dt>高端个性化流量</dt>
				<dd>独创百分百模拟</dd>
				<dd>符合淘宝个性化搜索规则</dd>
				<dd>精准匹配卖家宝贝属性</dd>
			</dl>
			<!-- <dl class="dl_3">
				<dt>淘口令流量</dt>
				<dd>无线流量新玩法</dd>
				<dd>抢占无线市场份额</dd>
				<dd>抢夺店铺新商机</dd>
			</dl> -->
			<dl class="dl_4">
				<dt>全能规避</dt>
				<dd>独创分布式随机算法</dd>
				<dd>任务随机分配到不同地区</dd>
				<dd>自定义时间安排流量,更真实</dd>
			</dl>
			<dl class="dl_5">
				<dt>成熟的放单系统</dt>
				<dd>操作轻松简单</dd>
				<dd>任务进度一目了然</dd>
				<dd>成熟的流量REP系统</dd>
			</dl>
		</div>
	</div>
	<div class="joinUs">
		<a href="${pageContext.request.contextPath}/frontend/authregister" title="加入我们共享双赢网店"><span class="radius5">马上注册</span>想要快速提高宝贝的无线访问流量吗？</a>
	</div>

	<!-- 成功案例开始 -->
	<div class="pageFull mtop20" id="part_3">
		<div class="youshi">
			<a name="anli">我们的成功案例</a>
		</div>
	</div>

	<div class="warp1200">
		<div class="indexAnli">
			<div class="anliBox frist clearfix">
				<div class="con row_l">
					<h3>合作前（流量概况）</h3>
					<div class="img">
						<img src="${pageContext.request.contextPath}/frontend/pagematter/common/img/anli_01.jpg" width="540" height="313"
							alt="淘宝app流量" />
					</div>
				</div>
				<div class="con row_r">
					<h3>合作后（流量概况）</h3>
					<div class="img">
						<img src="${pageContext.request.contextPath}/frontend/pagematter/common/img/anli_02.jpg" width="540" height="313"
							alt="刷手机淘宝流量" />
					</div>
				</div>
			</div>
			<div class="anliBox clearfix">
				<div class="con row_l">
					<h3>合作前（商品概况）</h3>
					<div class="img">
						<img src="${pageContext.request.contextPath}/frontend/pagematter/common/img/anli_03.jpg" width="540" height="294"
							alt="淘宝手机流量软件" />
					</div>
				</div>
				<div class="con row_r">
					<h3>合作后（商品概况）</h3>
					<div class="img">
						<img src="${pageContext.request.contextPath}/frontend/pagematter/common/img/anli_04.jpg" width="540" height="294"
							alt="淘宝无线流量软件" />
					</div>
				</div>
			</div>
			<div class="anliBox clearfix">
				<div class="con row_l">
					<h3>合作前（经营概况）</h3>
					<div class="img">
						<img src="${pageContext.request.contextPath}/frontend/pagematter/common/img/anli_05.jpg" width="468" height="633" alt="刷淘宝流量" />
					</div>
				</div>
				<div class="con row_r">
					<h3>合作后（经营概况）</h3>
					<div class="img">
						<img src="${pageContext.request.contextPath}/frontend/pagematter/common/img/anli_06.jpg" width="468" height="633"
							alt="淘宝刷流量软件" />
					</div>
				</div>
			</div>

		</div>
	</div>
	<div style="height:20px;"></div>
	<!-- 成功案例结束 -->
	<div class="inAbout" id="part_4">
		<div class="content">
			<h3>
				关于我们<span>ABOUT</span>
			</h3>
			<div class="cont">
				<!--<p>旺点击是一个针对淘宝店铺增加无线端APP手机流量、收藏、加购物车和提高直通车质量得分的平台！您可以通过旺点击平台注册会员进行提升淘宝app流量、收藏、加购等操作，真实有效提升商品关键词指数和商品排名。</p>
				<p>旺点击团队，有国内最有技术实力的淘宝专业技术公司团队，针对淘宝规则的整个系统进行的研发。网站技术团队有多位实力成员，负责整个平台的研发、测试、上线、维护、更新、服务。一直不断的根据淘宝的监察规则和淘宝不断变化的情况来研发最真实的流量，符合淘宝的规则。为客户提供流量的必备工具(刷手机淘宝流量、淘宝手机流量软件、淘宝无线流量软件)。</p>
				<p>我们拥有5万以上真实手机，全国分布多个流量机房，轮流提高流量及点击率，提供最真实人工流量，及完全模拟手工操作。造爆款必备，提升网店浏览量和宝贝人气，提高直通车质量得分，完全通过生意参谋检测，可以查到真实的手机淘宝流量，非wap网页模拟流量！</p>
				<p>专业打造优质无线流量 欢迎广大卖家咨询合作 加入我们共享双赢网店</p>-->
				${tIndexInfoCustom.indextext }
			</div>
		</div>
	</div>
<!-- 
	<div class="pageFull">
		<div class="Links">
			<span>友情链接：</span> <a href="http://www.hainingzaixian.com"
				target="_blank">海宁在线</a>|<a href="http://bbs.ihaiyan.com"
				target="_blank">海盐网</a>|<a href="http://www.pgc.cn" target="_blank">海宁皮革城</a>|<a
				href="http://www.mingpi.com" target="_blank">名皮网</a>|<a
				href="http://www.bxggdljq.com" target="_blank">管道堵漏器</a>|<a
				href="http://bbs.jiaxingren.com" target="_blank">嘉兴人网</a>|<a
				href="http://www.6m88.com" target="_blank">淘宝代运营</a>|<a
				href="http://www.kb8000.com" target="_blank">空包网</a>|<a
				href="http://www.haoping99.com" target="_blank">修改中差评</a>|<a
				href="http://www.szsgo.com/" target="_blank">团体服装定制</a>|<a
				href="http://www.shwojv.com" target="_blank">货源批发网</a>|<a
				href="http://www.wenwanshijia.com" target="_blank">文玩世家</a>| <a
				href="http://10yuanjie.com" target=_blank>九块邮</a>| <a
				href="http://www.cnfengkuang.com" target=_blank>疯狂网商学院</a>| <a
				href="http://www.1314mm.net" target=_blank>情侣装</a>| <a
				href="http://www.ywlyd.com" target=_blank>2元店</a>| <a
				href="http://yxy888.cn" target=_blank>北京卫星电视安装</a>| <a
				href="http://www.wnksgj.com" target=_blank>锁匠用品</a>| <a
				href="http://www.szxiaotiane.com" target=_blank>深圳小天鹅洗衣机维修</a>| <a
				href="http://chenxin100.com" target=_blank>北京网</a>| <a
				href="http://www.panasonicweixiu.cn" target=_blank>南宁松下电器维修</a>| <a
				href="http://www.mideawxn.com" target=_blank>南宁美的维修</a>| <a
				href="http://www.gzmtyl.com" target=_blank>图片大全</a>| <a
				href="http://www.131458.co" target=_blank>淘宝信誉查询</a>| <a
				href="http://www.hz-lailai.com" target=_blank>来涞科技</a>| <a
				href="http://yangsheng.120ask.com" target=_blank>养生保健</a>|
		</div>
	</div> -->

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/frontend/pagematter/common/js/layer.min.js"></script>
	<div class="copyRight">
		<div class="warp1200 footer">
			<p>
				Copyright (c) 2015  Inc. All Rights. 浙ICP备140452118号-5.
			</p>
		</div>
	</div>
<div id="divQQbox" class="QQbox">
	<div id="divOnline" class="Qlist">
		<div class="OnlineLeft">
			<div class="con">
				<ul>
					<li>技术咨询<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq}&&Site=sc.chinaz.com&&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:12345678:42"></a></li>
					<li>流量托管<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq2}&&Site=sc.chinaz.com&&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:12345678:42"></a></li>
				<!--  	<li>网站优化<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq}&&Site=sc.chinaz.com&&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:12345678:42"></a></li>
					<li>整合营销<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq}&&Site=sc.chinaz.com&&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:12345678:42"></a></li>
				-->	<li>代理咨询<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq3}&&Site=sc.chinaz.com&&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:12345678:42"></a></li>
				
				</ul>
			</div>
		</div>
		<div class="OnlineBtn">
		</div>
	</div>
</div>
	<script type="text/javascript">
        $(function() {
        	
        	$("#divQQbox").hover(
        			function(){
        				$(this).stop(true,false);
        				$(this).animate({left:0},300);	
        			},
        			function(){
        				$(this).animate({left:-276},149);	
        			}
        		);
        	load();
        });
        window.onresize=function(){  
        	 window.location.reload();
       }  
    	function load(){
            var anli = "${anli}";
            if(anli.length > 0){
            	location.hash="anli";
            }
    	}

    </script>
</body>
</html>