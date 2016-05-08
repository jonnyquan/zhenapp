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
                <a href="${pageContext.request.contextPath}/user/responsepersonal" class="row_l">基本资料</a>
                <a href="${pageContext.request.contextPath}/user/responseupdatepassword" class="row_l hover">修改密码</a>
            </div>

            <div class="umainbox">
                <!--main-->
                <div class="login_box">
                    <form class="koo_fromBox" action="/user/passwd" method="post">
                        <input type="hidden" name="_token" value="t1yIDXF06aLrBmCEySsRpefqJxLY1EARgWOjXaYV">
                        <div class="form_control clearfix">
                            <label class="form_label">原始登录密码：</label>
                            <input class="form_input input240" type="password" name="oldpassword"
                                   datatype="*6-20"
                                   ajaxurl="/ajax/checkOldPassword"
                                   sucmsg="输入正确" nullmsg="请输入6-20原始登录密码" errormsg="密码必须是6-20位"/>
                        </div>
                        <div class="form_control clearfix">
                            <label class="form_label">新登录密码：</label>
                            <input class="form_input input240" type="password" name="password" id="password"
                                   datatype="*6-20" sucmsg="密码格式正确" nullmsg="请输入6-20登录密码" errormsg="密码必须是6-20位">
                            <span class="Validform_checktip">请输入6-20登录密码</span>
                        </div>
                        <div class="form_control clearfix">
                            <label class="form_label">确认密码：</label>
                            <input class="form_input input240" type="password" name="password_confirmation" id="password_confirmation"
                                   recheck="password" datatype="*6-20" sucmsg="密码输入正确" nullmsg="请再次输入登录密码"
                                   errormsg="两次输入的密码不一致">
                            <span class="Validform_checktip">请再次输入一次登录密码</span>
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
					src="${pageContext.request.contextPath}/backstage/pagematter/common/js/layer.min.js"></script>
				<script type="text/javascript"
					src="${pageContext.request.contextPath}/backstage/pagematter/common/js/Validform_v5.3.2.js"></script>
			</div>
		</div>

		<div class="copyRight">
			<div class="warp1200 footer">
				<p>
					Copyright (c) 2015 <a href="${pageContext.request.contextPath}/frontend/index" title="淘宝流量">淘宝流量</a> | <a href="${pageContext.request.contextPath}/frontend/index" title="真流量">真流量</a>(www.zhenapp.cn) Inc. All Rights. 浙ICP备140452118号-5.
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