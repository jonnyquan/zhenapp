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

<script type="text/javascript"
	src="${pageContext.request.contextPath}/frontend/pagematter/common/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/frontend/pagematter/common/js/common.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/user/layer_user.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/user/user.css" type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/validform.style.css"
	type="text/css">

<style type="text/css">

/*header*/


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
<title>会员登录 - 流量村</title>
</head>

<body>

	<div class="topbar">
		<div class="warp1200 toplogin clearfix">
			<div class="userlogin row_r" id="userLogin">
				您好，欢迎来到流量村！<a href="/auth/login">马上登录</a>|<a href="/auth/register">快速注册</a>
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
					<li><a href="${pageContext.request.contextPath}/frontend/authlogin" class="scl6" title="流量村用户中心">用户中心</a></li>
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

					<form class="koo_fromBox" action="/auth/login" method="post">
						<input type="hidden" name="_token"
							value="XuPy54zNSHdOJ3diTiK9G2jGsoQ20TeGkrXVibVS">
						<h2>会员登录</h2>

						<div class="form_control clearfix">

							<input class="form_input input240" type="text" name="username"
								id="username" placeholder="用户名：" value="" />

						</div>

						<div class="form_control clearfix">

							<input class="form_input input240" type="password"
								name="password" id="password" placeholder="密 码：">

						</div>

						<div class="form_control clearfix">

							<div class="botton">
								<button type="submit" name="submit" class="form_btn">登
									录</button>
							</div>

						</div>

					</form>

					<div class="tipwz"></div>

				</div>

				<div class="aregtips">

					<div class="tipwz">您还没有注册流量村帐号？您只需10秒钟！</div>

					<div class="tipwz">成功注册立刻发布任务！</div>
					<div class="reg">
						<a href="/auth/register">快速免费注册新用户</a>
					</div>
					<div class="getpwd">
						<a href="/password/sms">找回登录密码</a>
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
									style="border: 0px currentColor; border-image: none;" alt="流量村"
									src="${pageContext.request.contextPath}/frontend/pagematter/common/img/ico_5.gif" /></td>
								<td width="10">&nbsp;</td>
								<td><strong>超低的费用 方便快捷的排单方式</strong><br />全面支持系统下单，支持计划任务，可以24小时下单；</td>
							</tr>
							<tr>
								<td width="60" align="right"><img width="57" height="60"
									style="border: 0px currentColor; border-image: none;" alt="流量村"
									src="${pageContext.request.contextPath}/frontend/pagematter/common/img/ico_5.gif" /></td>
								<td>&nbsp;</td>
								<td><strong>高端个性化流量 最真实的模拟人工点击</strong><br />独创百分百模拟、符合淘宝个性化搜索规则、百倍手机订单由此开始；</td>
							</tr>
							<tr>
								<td align="right"><img width="60" height="51"
									style="border: 0px currentColor; border-image: none;" alt="流量村"
									src="${pageContext.request.contextPath}/frontend/pagematter/common/img/ico_5.gif" /></td>
								<td>&nbsp;</td>
								<td><strong>全能规避淘宝规则个性化搜索规则</strong><br />独创分布式随机算法、任务随机分配到不同地区、自定义时间安排流量,更真实；</td>
							</tr>
							<tr>
								<td align="right"><img width="61" height="54"
									style="border: 0px currentColor; border-image: none;" alt="流量村"
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
		src="${pageContext.request.contextPath}/frontend/pagematter/common/js/scroll.js"></script>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/frontend/pagematter/common/js/layer.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/frontend/pagematter/common/js/layer_user.js"></script>

	<div class="copyRight">
		<div class="warp1200 footer">
			<p>
				Copyright<span>&copy;</span>2010-2015<span><a
					href="http://www.liuliangcun.com" title="淘宝流量">淘宝流量</a> | <a
					href="http://www.liuliangcun.com" title="流量村">流量村</a>(LiuLiangCun.COM).</span>All
				Rights Reserved.
			</p>
		</div>
	</div>

	<div id="cnzz" style="display: none">
		<script
			src="http://s95.cnzz.com/stat.php?id=1256426482&web_id=1256426482"
			language="JavaScript"></script>
	</div>
	<div id="baidu" style="display: none">
		<script>
        var _hmt = _hmt || [];
        (function() {
            var hm = document.createElement("script");
            hm.src = "//hm.baidu.com/hm.js?5bea207fb51957576263526af963d0ff";
            var s = document.getElementsByTagName("script")[0];
            s.parentNode.insertBefore(hm, s);
        })();
    </script>
	</div>
</body>
</html>