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


<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frontend/pagematter/common/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frontend/pagematter/common/css/global.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frontend/pagematter/common/css/common.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/frontend/pagematter/common/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/frontend/pagematter/common/js/common.js"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frontend/pagematter/common/css/validform.style.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/frontend/pagematter/common/css/layer_user.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/frontend/pagematter/common/css/user.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/frontend/pagematter/common/js/common.js"></script>

<style type="text/css">
.login_box {
	padding-left: 100px;
}

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

.webHeader .logo a {
	display: block;
	width: 280px;
	height: 80px;
	background: url("${pageContext.request.contextPath}/webimg/${tWebInfoCustom.logo}") no-repeat;
	text-indent: -99999px;
}

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
</style>
<title>会员注册 - ${tAgentInfoCustom.agentname }</title>
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
				<a href="${pageContext.request.contextPath}/frontend/index" title="淘宝流量">${tAgentInfoCustom.agentname }</a>
			</div>
			<div class="channel row_r">
				<ul class="clearfix">
					<li><a
						href="${pageContext.request.contextPath}/frontend/index"
						title="电商流量" class="scl1">网站首页</a></li>
					<li><a
						href="${pageContext.request.contextPath}/frontend/intro"
						class="scl2">服务介绍</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/anli"
						class="scl3">成功案例</a></li>
					<li><a
						href="${pageContext.request.contextPath}/frontend/articlenews"
						class="scl4" title="电商干货">电商干货</a></li>
					<li><a
						href="${pageContext.request.contextPath}/frontend/articleguide"
						class="scl5">新手指引</a></li>
					<li><a
						href="${pageContext.request.contextPath}/frontend/authlogin"
						class="scl6" title="用户中心">用户中心</a></li>
					<li><a
						href="${pageContext.request.contextPath}/frontend/about"
						class="scl7">联系我们</a></li>
				</ul>
			</div>
		</div>
	</div>

	<script type="text/javascript">
        $('.scl6').addClass('hover');
    </script>

	<div class="uc_warp">

		<div class="userbox mtop20">

			<div class="login_tip clearfix">

				<h2 class="row_l">会员注册</h2>

				<div class="gologin row_r">
					已有账号，<a href="${pageContext.request.contextPath}/frontend/authlogin">现在登录</a>
				</div>
			</div>
			<div class="userForm clearfix">
				<div class="row_l login_box">

					<form class="koo_fromBox" action="${pageContext.request.contextPath}/frontend/saveuser" method="post">
						<input type="hidden" name="_uid" value="">
							<div class="form_control clearfix">
								<label class="form_label">用户名：</label> <input
									class="form_input input240" type="text" name="usernick"
									id="username" value=""
									datatype="/^[0-9a-zA-Z\u4e00-\u9fa5]{4,20}$/"
									ajaxurl="${pageContext.request.contextPath}/frontend/ajax/checkUserNameUnique" sucmsg="该用户名可用"
									nullmsg="请输入4-20位的用户名" errormsg="用户名格式不正确" /> <span
									class="Validform_checktip">请输入4-20个字符长度用户名</span>
							</div>
							<div class="form_control clearfix">
								<label class="form_label">登录密码：</label> <input
									class="form_input input240" type="password" name="userpwd"
									id="password" datatype="*6-20" sucmsg="密码格式正确"
									nullmsg="请输入6-20登录密码" errormsg="密码必须是6-20位"> <span
									class="Validform_checktip">请输入6-20登录密码</span>
							</div>
							<div class="form_control clearfix">
								<label class="form_label">确认密码：</label> <input
									class="form_input input240" type="password"
									name="password_confirmation" id="password_confirmation"
									recheck="userpwd" datatype="*6-20" sucmsg="密码输入正确"
									nullmsg="请再次输入登录密码" errormsg="两次输入的密码不一致"> <span
									class="Validform_checktip">请再次输入一次登录密码</span>
							</div>
							<div class="form_control clearfix">
								<label class="form_label">安全邮箱：</label> <input
									class="form_input input240" type="text" name="regemail" id="email"
									datatype="e" value="" ajaxurl="${pageContext.request.contextPath}/frontend/ajax/checkEmailUnique"
									sucmsg="邮箱格式正确" nullmsg="请填写安全邮箱" errormsg="请填写正确格式的邮箱">
									<span class="Validform_checktip">请填写您常用邮箱作为安全凭证</span>
							</div>
							<div class="form_control clearfix">
								<label class="form_label">QQ号：</label> <input
									class="form_input input240" type="text" name="userqq"
									datatype="n5-15" value="" sucmsg="QQ号码输入正确"
									nullmsg="请输入5-15位QQ号" errormsg="QQ号格式不正确" /><span
									class="Validform_checktip">客服在线联系关键凭证</span>
							</div>
							<div class="form_control clearfix">
								<label class="form_label">手机号：</label> <input
									class="form_input input240" type="text" name="userphone"
									id="mobile" datatype="m" value=""
									ajaxurl="${pageContext.request.contextPath}/frontend/ajax/checkMobileUnique" sucmsg="手机号码格式正确"
									nullmsg="请填写手机号码" errormsg="请填写正确手机号码"> <span
									class="Validform_checktip">请填写您的手机号码</span>
							</div>
							<div class="form_control">
								<div class="botton">
									<button type="submit" name="submit" class="form_btn">注 册</button>
								</div>
							</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/frontend/pagematter/common/js/scroll.js"></script>
	<script type="text/javascript">
	 $(function () {
         $(".koo_fromBox").Validform({
             tiptype: 3,
             ajaxurl:{
                 headers: {
                     'X-CSRF-TOKEN': $('meta[name="_token"]').attr('content')
                 }
             }
         });
        });
    </script>


	<script type="text/javascript"
		src="${pageContext.request.contextPath}/frontend/pagematter/common/js/layer.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/frontend/pagematter/common/js/layer_user.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/frontend/pagematter/common/js/Validform_v5.3.2.js"></script>


<div class="copyRight">
	<div class="warp1200 footer">
		<p>
			Copyright (c) 2015  Inc. All Rights. 浙ICP备140452118号-5.
		</p>
	</div>
</div>
</body>
</html>