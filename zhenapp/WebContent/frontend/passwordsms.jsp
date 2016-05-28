<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frontend/pagematter/common/css/layer_user.css" >
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/frontend/pagematter/common/css/user.css" >
<script type="text/javascript" src="${pageContext.request.contextPath}/frontend/pagematter/common/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/frontend/pagematter/common/js/jquery.laravel-sms.js"></script>

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


.webHeader .logo a {
	display: block;
	width: 280px;
	height: 80px;
	background: url("${pageContext.request.contextPath}/webimg/${tWebInfoCustom.logo}") no-repeat;
	text-indent: -99999px;
}
</style>

<title>找回密码 - 真流量</title>
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
					title="电商流量">真流量</a>
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

		<div class="userbox mtop20">

			<div class="login_tip clearfix">

				<h2 class="row_l">找回密码</h2>

				<div class="gologin row_r">
					已有账号，<a href="${pageContext.request.contextPath}/frontend/authlogin">现在登录</a>
				</div>

			</div>

			<div class="userForm clearfix">

				<div class="row_l login_box">

					<form class="koo_fromBox" action="${pageContext.request.contextPath}/frontend/password/reset"  method="post">
						<span id="spanmsg" style="color:red;"></span>
						<div class="form_control clearfix">
							<label class="form_label">用户名：</label> 
							<input class="form_input input240" type="text" name="usernick"
								id="usernick" value="" datatype="/^[0-9a-zA-Z\u4e00-\u9fa5]{4,20}$/"
								ajaxurl="${pageContext.request.contextPath}/frontend/ajax/checkUserNameexist" sucmsg="该用户名可用"
								nullmsg="请输入4-20位的用户名" errormsg="用户名格式不正确" /> 
							<span id="spanmsgusernick" style="color:red;"></span>
						</div>
						<div class="form_control clearfix">
							<label class="form_label">注册邮箱：</label> 
							<input class="form_input input240" type="text" name="regemail" id="email" datatype="e" value="">
							<input type="button" id="sendvalidcode" style="width:100px;" value="发送验证码" />
							
						</div>
						<div class="form_control clearfix">
							<label class="form_label">验证码：</label> 
							<input class="form_input input240" type="text" name="regvalidcode" id="regvalidcode" datatype="*6-6" nullmsg="请输入6位验证码" value="">
							
						</div>
						<div class="form_control clearfix">
							<label class="form_label">输入新密码：</label> 
								<input class="form_input input240" type="password" name="userpwd"
								id="password" datatype="*6-20" sucmsg="密码格式正确"
								nullmsg="请输入6-20登录密码" errormsg="密码必须是6-20位"> 
								<span class="Validform_checktip">请输入6-20登录密码</span>
						</div>
						<div class="form_control">
							<div class="botton">
								<button type="submit" id="btn_submit" class="form_btn">确 定</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
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
            /*
            $("#btn_submit").click(function(){
            	var email = $("#email").val();
            	var usernick = $("#usernick").val();
            	$.ajax({
    				url : "${pageContext.request.contextPath}/frontend/password/reset",
    				data :$("form").serialize(),
    				type : "POST",
    				success:function(data,state){
    					if(data!=null && data.msg == "success"){
    						$("#spanmsg").html("重置密码成功");
    				     	$("#spanmsg").show();
    				     	$("#spanmsg").fadeOut(4000);
    					}else{
    						$("#spanmsg").html("重置密码失败,请稍后再试!");
    					}
    				}
    			});
            });*/
            var msg = "${msg}";
            if(msg=="success"){
            	$("#spanmsg").html("重置密码成功");
            	$("#spanmsg").show();
		     	$("#spanmsg").fadeOut(4000);
            }else if(msg=="error"){
            	$("#spanmsg").html("重置密码失败");
            	$("#spanmsg").show();
		     	$("#spanmsg").fadeOut(4000);
            }else{
            }
            
            $("#sendvalidcode").click(function(){
            	
            	var email = $("#email").val();
            	var usernick = $("#usernick").val();
            	if(email.length<1 || usernick.length <1){
            		alert("请输入用户名及邮箱地址！");
            		return false;
            	}
            	$("#sendvalidcode").attr("disabled","true");
            	$.ajax({
    				url : "${pageContext.request.contextPath}/frontend/sendvalidcode/"+email+"/"+usernick,
    				type : "POST",
    				success:function(data,state){
    					if(data!=null && data.msg == "success"){
    						$("#spanmsg").html("验证码发送成功");
    				     	$("#spanmsg").show();
    				     	$("#spanmsg").fadeOut(4000);
    					}else{
    						$("#spanmsg").html("验证码发送失败");
    					}
    				}
    			});
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
				Copyright (c) 2015 <a href="${pageContext.request.contextPath}/frontend/index" title="淘宝流量">淘宝流量</a> | <a href="${pageContext.request.contextPath}/frontend/index" title="真流量">真流量</a>(www.zhenapp.cn) Inc. All Rights. 浙ICP备140452118号-5.
			</p>
		</div>
	</div>
</body>
</html>