<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
  <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

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

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/layer_user.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/user.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/validform.style.css"
	type="text/css">

<style type="text/css">

/*header*/
.pageFull {
	width: 100%;
	height: 80px;
	background-color: #fff;
	background-image: none;
	padding-bottom: 0px;
}

.webHeader {
	height: 80px;
	width: 1200px;
	margin: 0 auto;
}

.webHeader .logo {
	width: 280px;
	height: 80px;
	overflow: hidden;
}

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


.webHeader .channel {
	width: 770px;
}

.webHeader .channel ul {
	margin-top: 17px;
}

.webHeader .channel ul li {
	float: left;
	width: 80px;
	height: 45px;
	line-height: 45px;
	display: inline-block;
	margin-left: 20px;
}

.webHeader .channel ul li a {
	display: block;
	width: 80px;
	height: 45px;
	line-height: 45px;
	text-align: center;
	font-size: 16px;
}

.webHeader .channel ul li a:hover,.webHeader .channel ul li a.hover {
	height: 44px;
	line-height: 44px;
	border-bottom: 1px solid #ed7200;
	color: #d54308;
}

.huiyuandenglu {
	padding-bottom: 20px;
	padding: 25px 10px;
	background-color: #fff;
	border: 1px solid #dedede;
	margin-top: 40px;
}

.leftlogin {
	width: 280px;
}

.loginBox {
	padding-left: 15px;
	padding-bottom: 20px;
}

.loginBox h2 {
	height: 20px;
	line-height: 20px;
	font-size: 16px;
	font-weight: bold;
	padding-top: 10px;
}

.form_control .botton {
	padding-left: 0;
}

#verifyimg {
	left: 0px;
}

.aregtips {
	margin-top: 5px;
	border-top: 1px dashed #dedede;
	padding-top: 25px;
	padding-bottom: 10px;
}

.aregtips .tipwz {
	height: 25px;
	line-height: 25px;
	font-size: 12px;
	color: #666;
	text-align: left;
}

.aregtips .tipwz {
	text-align: center;
}

.aregtips .reg {
	height: 30px;
	line-height: 30px;
	text-align: center;
	margin-top: 10px;
}

.aregtips .reg a {
	display: inline-block;
	width: 200px;
	height: 30px;
	line-height: 30px;
	text-align: center;
	color: #fff;
	background-color: #933;
	cursor: pointer;
}

.getpwd {
	height: 35px;
	line-height: 35px;
	text-align: center;
}

.getpwd a {
	color: #00f;
}

.loginshuoming {
	width: 684px;
	border-left: 1px solid #dedede;
	padding: 25px;
	min-height: 400px;
	_height: 400px;
}

.loginshuoming h2 {
	height: 20px;
	line-height: 20px;
	font-size: 16px;
	font-weight: bold;
	border-bottom: 1px dashed #dedede;
	padding-bottom: 10px;
}

.loginshuoming .neirong {
	margin-top: 10px;
	padding: 10px 0;
}

.newsContent .neirong {
	margin-top: 20px;
	padding: 20px;
	line-height: 26px;
	font-size: 14px;
}

.newsContent .neirong p {
	line-height: 26px;
	font-size: 14px;
}

.newsContent .neirong img {
	max-width: 500px;
}

.tipwz {
	padding-top: 5px;
}

.tipwz li {
	color: red;
}
</style>
<title>会员登录 - 真流量</title>
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
				<a href="${pageContext.request.contextPath}/frontend/index"
					title="淘宝流量">真流量</a>
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
        $('.scl6').addClass('hover');
    </script>

	<div class="uc_warp">

		<div class="huiyuandenglu clearfix">

			<div class="leftlogin row_l">

				<div class="loginBox">

					<form class="koo_fromBox" action="${pageContext.request.contextPath}/frontend/login" method="post">
						<input type="hidden" name="_token"
							value="Y2ZM2EhoU6uFf43IlOBRLsaogFZXlqyfLz7dviDn">
							<h2>会员登录</h2>

							<div class="form_control clearfix">

								<input class="form_input input240" type="text" name="username"
									id="username" placeholder="用户名：" value="${username}" />

							</div>

							<div class="form_control clearfix">

								<input class="form_input input240" type="password"
									name="password" id="password" placeholder="密 码：">
							</div>

							<div class="form_control clearfix">

								<div class="botton">
									<button type="submit" name="submit" class="form_btn">登 录</button>
								</div>
								
							</div>
							<span id="spanmsg" style="color:red;"></span>
							
					</form>

					<div class="tipwz"></div>

				</div>

				<div class="aregtips">

					<div class="tipwz">您还没有注册真流量帐号？您只需10秒钟！</div>

					<div class="tipwz">成功注册立刻发布任务！</div>
					<div class="reg">
						<a href="${pageContext.request.contextPath}/frontend/authregister">快速免费注册新用户</a>
					</div>
					<div class="getpwd">
						<a href="${pageContext.request.contextPath}/frontend/passwordsms">找回登录密码</a>
					</div>

				</div>

			</div>

			<div class="loginshuoming row_r">

				<h2>会员注册说明</h2>

				<div class="neirong">
					<p></p>
					<p></p>
					<table width="100%" height="300" cellpadding="5" cellspacing="0"
						class="tbl_2 login_bg">
						<tbody>
							<tr class="firstRow">
								<td width="60" align="right"><img width="57" height="60"
									style="border: 0px currentColor; border-image: none;" alt="流量网"
									src="${pageContext.request.contextPath}/frontend/pagematter/common/img/ico_5.gif" /></td>
								<td width="10">&nbsp;</td>
								<td><strong>超低的费用 方便快捷的排单方式</strong><br />全面支持系统下单，支持计划任务，可以24小时下单；</td>
							</tr>
							<tr>
								<td width="60" align="right"><img width="57" height="60"
									style="border: 0px currentColor; border-image: none;" alt="流量网"
									src="${pageContext.request.contextPath}/frontend/pagematter/common/img/ico_5.gif" /></td>
								<td>&nbsp;</td>
								<td><strong>高端个性化流量 最真实的模拟人工点击</strong><br />独创百分百模拟、符合淘宝个性化搜索规则、百倍手机订单由此开始；</td>
							</tr>
							<tr>
								<td align="right"><img width="60" height="51"
									style="border: 0px currentColor; border-image: none;" alt="流量网"
									src="${pageContext.request.contextPath}/frontend/pagematter/common/img/ico_5.gif" /></td>
								<td>&nbsp;</td>
								<td><strong>全能规避淘宝规则个性化搜索规则</strong><br />独创分布式随机算法、任务随机分配到不同地区、自定义时间安排流量,更真实；</td>
							</tr>
							<tr>
								<td align="right"><img width="61" height="54"
									style="border: 0px currentColor; border-image: none;" alt="流量网"
									src="${pageContext.request.contextPath}/frontend/pagematter/common/img/ico_5.gif" /></td>
								<td>&nbsp;</td>
								<td><strong>成熟的放单系统</strong><br />操作轻松简单、任务进度一目了然、成熟的流量REP系统。</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/frontend/pagematter/common/js/layer_user.js"></script>

	<div class="copyRight">
		<div class="warp1200 footer">
			<p>
				Copyright (c) 2015 <a href="${pageContext.request.contextPath}/frontend/index" title="淘宝流量">淘宝流量</a> | <a href="${pageContext.request.contextPath}/frontend/index" title="真流量">真流量</a>(www.zhenapp.cn) Inc. All Rights. 浙ICP备140452118号-5.
			</p>
		</div>
	</div>
<div id="divQQbox" class="QQbox">
<div id="divOnline" class="Qlist">
	<div class="OnlineLeft">
		<div class="con">
			<ul>
				<li>技术咨询<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq}&&Site=sc.chinaz.com&&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:12345678:42"></a></li>
				<li>流量托管<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq}&&Site=sc.chinaz.com&&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:12345678:42"></a></li>
			<!--  	<li>网站优化<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq}&&Site=sc.chinaz.com&&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:12345678:42"></a></li>
				<li>整合营销<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq}&&Site=sc.chinaz.com&&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:12345678:42"></a></li>
				<li>售后服务<a target="_blank" href="tencent://message/?uin=${tWebInfoCustom.qq}&&Site=sc.chinaz.com&&Menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=1:12345678:42"></a></li>
			-->
				</ul>
			</div>
		</div>
		<div class="OnlineBtn">
		
		</div>
	</div>
</div>
	<script type="text/javascript">
		$(function(){
			
			$("#divQQbox").hover(
       			function(){
       				$(this).stop(true,false);
       				$(this).animate({left:0},300);	
       			},
       			function(){
       				$(this).animate({left:-276},149);	
       			}
       		);
        		
			 var msg = "${msg}";
		     if(msg.length > 0){
		     	$("#spanmsg").html(msg);
		     	$("#spanmsg").show();
		     	$("#spanmsg").fadeOut(4000);
		     }
		});
	</script>
	
</body>
</html>