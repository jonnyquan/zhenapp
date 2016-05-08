<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="真流量,无线流量,无限流量代运营,无线刷流量 " />
<meta name="description" content="真流量,无线流量,无限流量代运营,无线刷流量 " />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/global.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/common.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/sweetalert.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/backstage/pagematter/common/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/backstage/pagematter/common/js/common.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/backstage/pagematter/common/js/sweetalert-dev.js"></script>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/layer_user.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/user.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/validform.style.css"
	type="text/css">

 <style type="text/css">
        .process {
            background: url(/image/process.png) 40px -35px no-repeat;
            height: 35px;
            line-height: 35px;
            margin-top: 30px;
        }

        .messagebox {
            padding: 20px;
        }

        .messagebox h1 {
            line-height: 40px;
            text-align: center;
            line-height: 30px;
            padding: 15px 0;
            font-size: 16px;
            font-weight: bold;
        }

        .messagebox .time {
            border-bottom: 1px dashed #dedede;
            height: 30px;
            line-height: 30px;
            text-align: center;
        }

        .messagebox .time span {
            margin: 0 10px;
        }

        .messagebox .msgContent {
            margin-top: 20px;
            font-size: 14px;
        }
    </style>
    <title>基本资料 - 真流量</title>
</head>

<body>

<div id="topbar">
    <div class="warp1200">
        <div class="clearfix">
            <div class="welcome row_l"><div class="welcome row_l"></div></div>
            <div class="userlogininfo row_r">
                <div class="islogin" id="islogin">
                    <a href="/user"><i class="fa fa-user"></i><span id="username">fekong</span></a>
                    <a href="/user"><i class="fa fa-cog"></i>会员中心</a>
                    <a href="/auth/logout"><i class="fa fa-sign-out"></i>退出</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="pageFull">
    <div class="webHeader clearfix">
         <div class="logo row_l"><a href="${pageContext.request.contextPath}/frontend/index" title="电商流量">真流量</a></div>
        <div class="channel row_r">
           <ul class="clearfix">
						<li><a href="${pageContext.request.contextPath}/frontend/index" title="电商流量" class="scl1">网站首页</a></li>
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
    <div class="userbody clearfix">
        <div class="leftmenu row_l">
					<dl>
						<dt>
							<a href="${pageContext.request.contextPath}/user/responseuser">个人中心</a>
						</dt>
						<dd>
							<p>
								<a href="${pageContext.request.contextPath}/user/responsepersonal" id="info"><i class="fa fa-angle-right"></i>基本信息</a>
							</p>
							<p>
								<!-- <a href="/user/broker" id="account"><i class="fa fa-angle-right"></i>我的推广</a> -->
								<a href="javascript:void(0);" id="account"><i class="fa fa-angle-right"></i>我的推广</a>
							</p>
						</dd>
					</dl>
					<dl>
						<dt>
							<a href="javascript:void(0);">流量任务管理</a>
						</dt>
						<dd>
							<p>
								<a href="${pageContext.request.contextPath}/task/responsetaskadd" id="addtask"><i class="fa fa-angle-right"></i>发布任务</a>
							</p>

							<p>
								<a href="${pageContext.request.contextPath}/task/responsetaskmanage" id="managetask"><i class="fa fa-angle-right"></i>任务管理</a>
							</p>
						</dd>
					</dl>
					<dl>
						<dt>
							<a href="/user/cash/records">财务中心</a>
						</dt>
						<dd class="acc">
							<p>
								<a href="${pageContext.request.contextPath}/points/responsebuypoints" id="purchase"><i class="fa fa-angle-right"></i>购买积分</a>
							</p>
							<p>
								<a href="${pageContext.request.contextPath}/points/responserecordspoints" id="point"><i class="fa fa-angle-right"></i>积分明细</a>
							</p>
						</dd>
					</dl>
				</div>     
    <script type="text/javascript">
        $('#info').addClass('hover');
    </script>

    <div class="rightbox row_r">
        <div class="u_outbox">

            <div class="tabtitle clearfix">
                <a href="${pageContext.request.contextPath}/user/responsepersonal" class="row_l hover">基本资料</a>
                <a href="${pageContext.request.contextPath}/user/responseupdatepassword" class="row_l">修改密码</a>
            </div>

            <div class="umainbox">
                <!--main-->
                <div class="login_box">
                    
                    <form class="koo_fromBox" action="${pageContext.request.contextPath}/user/updateUser" method="post">
                        <input type="hidden" name="userid" value="${tUserInfoCustom.userid}">

                        <div class="form_control clearfix">
                            <label class="form_label">登录账号：</label>
                            <input class="form_input input240 readonly"  readonly type="text" name="usernick" value="${tUserInfoCustom.usernick}" disabled>
                            <span class="Validform_checktip">登录账号不可修改</span>

                        </div>

                        <div class="form_control clearfix">
                            <label class="form_label">真实姓名：</label>
                            <input class="form_input input240" type="text" name="username" datatype="s2-5"
                                   sucmsg="真实姓名格式正确" nullmsg="请输入2-5位真实姓名" errormsg="真实姓名格式不正确" value="${tUserInfoCustom.username}" >
                            <span class="Validform_checktip"></span>
                        </div>

                        <div class="form_control clearfix">
                            <label class="form_label">手机号码：</label>
                            <input class="form_input input240 readonly" readonly type="text" name="userphone" datatype="m" value="${tUserInfoCustom.userphone}" disabled >
                            <span class="Validform_checktip">手机号码不可修改</span>
                        </div>

                        <div class="form_control clearfix">
                            <label class="form_label">电子邮箱：</label>
                            <input class="form_input input240 readonly" type="text" name="regemail" datatype="e" value="${tUserInfoCustom.regemail}"
                                    sucmsg="电子邮箱格式正确" nullmsg="请输入正确电子邮箱" errormsg="电子邮箱格式不正确" disabled /><span
                                    class="Validform_checktip">找回密码关键凭证</span>
                        </div>

                        <div class="form_control clearfix">
                            <label class="form_label">QQ号：</label>
                            <input class="form_input input240" type="text" name="userqq" datatype="n5-15" value="${tUserInfoCustom.userqq}"
                                    sucmsg="QQ号码输入正确" nullmsg="请输入5-15位QQ号" errormsg="QQ号格式不正确"/><span
                                    class="Validform_checktip">客服在线联系关键凭证</span>
                        </div>

                        <div class="form_control clearfix" id="verifybox">
							<!-- 
                            <label class="form_label">验证码：</label>

                            <input class="form_input input240" type="text" name="verify" id="verify" maxlength="5"
                                   placeholder="点击下面按钮获取验证码" datatype="s5-5"
                                   sucmsg="验证码输入正确" errormsg="请填写5位验证码" nullmsg="请填写验证码">
                            -->
                        </div>
                        <div class="form_control">
<!--
                            <div class="botton">
                                <button id='sendVerifySmsButton' class="form_btn">点击获取短信验证码</button>
                            </div>
-->
                        </div>

                        <div class="form_control">
                            <div class="botton">
                                <button type="submit" name="submit" class="form_btn">保存修改</button>
                            </div>
                        </div>
                    </form>
                </div>
                <!--main-->
            </div>
        </div>
    </div>
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/backstage/pagematter/common/js/scroll.js"></script>
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/backstage/pagematter/common/js/Validform_v5.3.2.js"></script>
	</div>
	</div>

		<div class="copyRight">
			<div class="warp1200 footer">
				<p>
					Copyright<span>&copy;</span>2010-2015<span><a
						href="${pageContext.request.contextPath}/frontend/index"
						title="淘宝流量">淘宝流量</a> | <a
						href="${pageContext.request.contextPath}/frontend/index"
						title="真流量">真流量</a>(LiuLiangCun.COM).</span>All Rights Reserved.
				</p>
			</div>
		</div>
		<script type="text/javascript">
		$(function(){
			//var msg = "${msg}";
			//alert(msg);
		});
	</script>
</body>
</html>