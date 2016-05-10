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
.uMainbox {
	border: 1px solid #dedede;
	background-color: #fff;
	padding: 30px 0;
}

.uInfos {
	padding: 0 30px;
}

.uFace {
	width: 150px;
	height: 120px;
}

.uFace .faceimg {
	text-align: center;
}

.uFace .uSafe {
	margin-top: 15px;
	height: 20px;
	line-height: 20px;
	background: url(${pageContext.request.contextPath}/backstage/pagematter/common/img/safe.png) 60px 5px no-repeat;
}

.welCome {
	width: 550px;
}

.welCome h2 {
	height: 30px;
	line-height: 30px;
	font-size: 18px;
}

.welCome h2 span {
	color: #F03;
	margin: 0 5px;
}

.logininfo {
	height: 25px;
	line-height: 25px;
	color: #666;
}

.logininfo span {
	padding: 0 10px;
	color: #369;
}

.uinfo {
	height: 25px;
	line-height: 25px;
	color: #369;
}

.uinfo label {
	padding-right: 10px;
	color: #666
}

.uinfo label.kong {
	margin-left: 30px;
}

.uMoeny {
	font-size: 14px;
	height: 40px;
	line-height: 40px;
}

.uMoeny span {
	font-size: 18px;
	color: #c00;
	margin: 0 8px;
}

.uMoeny a {
	display: inline-block;
	height: 22px;
	line-height: 22px;
	padding: 0 15px;
	background-color: #f7f7f7;
	border: 1px solid #dedede;
	color: #333;
	margin-left: 25px;
	font-size: 12px;
	color: #039;
}

.sysMsg {
	height: 50px;
	line-height: 50px;
	border-bottom: 1px solid #dedede;
	border-top: 1px solid #dedede;
	margin-top: 20px;
}

.sysMsg a {
	display: block;
	float: left;
	border-right: 1px solid #dedede;
	text-align: center;
	width: 158px;
	height: 50px;
	line-height: 50px;
	font-size: 14px;
}

.sysMsg a span {
	font-size: 12px;
	margin: 0 5px;
}

.sysMsg a.end {
	border-right: none;
}

.news {
	padding: 0 30px;
	margin-top: 20px;
}

.articlebox {
	width: 350px;
}

.articlebox h2 {
	font-size: 16px;
	font-weight: bold;
	height: 30px;
	line-height: 30px;
	text-indent: 10px;
	border-bottom: 1px solid #dedede;
}

.articlebox h2 a {
	float: right;
	font-size: 12px;
	font-weight: normal;
	color: #c00;
}

.articlebox h2 a i {
	padding: 0 5px;
}

.articlebox ul {
	margin-top: 10px;
}

.articlebox li {
	height: 40px;
	line-height: 40px;
	border-bottom: 1px dashed #dedede;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.articlebox li a {
	font-size: 14px;
}

.articlebox li i {
	padding: 0 10px;
	color: #999;
}
</style>
<title>会员中心 - 流量网</title>
</head>
<body>
	<div id="topbar">
		<div class="warp1200">
			<div class="clearfix">
				<div class="welcome row_l">
					<div class="welcome row_l"></div>
				</div>
				<div class="userlogininfo row_r">
					<div class="islogin" id="islogin">
						<a href="${pageContext.request.contextPath}/user/responseuser"><i class="fa fa-user"></i><span id="username">${tUserInfoCustom.usernick}</span></a>
						<a href="${pageContext.request.contextPath}/user/responseuser"><i class="fa fa-cog"></i>会员中心</a> 
						<a href="${pageContext.request.contextPath}/user/authlogout"><i class="fa fa-sign-out"></i>退出</a>
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
				<div class="rightbox row_r">
					<div class="uMainbox">
						<div class="uInfos clearfix">
							<div class="uFace row_l">
								<div class="faceimg">
									<img src="${pageContext.request.contextPath}/backstage/pagematter/common/img/uface.png" />
								</div>
								<div class="uSafe">安全等级：</div>
							</div>

							<div class="welCome row_r">
								<h2>
									尊敬的<span>${tUserInfoCustom.usernick}</span> 欢迎您！
								</h2>
								<div class="logininfo">
									您当前会员级别：<span>普通会员</span>
								</div>
								<div class="uinfo">
									<label>真实姓名：</label>${tUserInfoCustom.username}<label class="kong">手机号码：</label>${tUserInfoCustom.userphone}
								</div>
								<div class="uMoeny">
									<label>当前积分余额：</label><span>${tUserInfoCustom.points}</span>个 <a href="${pageContext.request.contextPath}/points/responsebuypoints">购买积分</a>
									<a href="${pageContext.request.contextPath}/task/responsetaskadd" class="mx">发布任务</a>
								</div>
							</div>
						</div>

						<div class="sysMsg clearfix">
							<a href="${pageContext.request.contextPath}/task/responsetaskmanage">已完成任务<span>(0)</span></a> <a
								href="${pageContext.request.contextPath}/task/responsetaskmanage">待完成任务<span>(0)</span></a> <a
								href="${pageContext.request.contextPath}/task/responsetaskmanage">购买记录<span>(0)</span></a>
						</div>
						<div class="news clearfix">
							<div class="articlebox row_l">
								<h2>
									电商干货
									<a href="${pageContext.request.contextPath}/frontend/articlenews" target="_blank">更多 <i class="fa fa-angle-right"></i></a>
								</h2>
								<ul>
									<c:forEach items="${TelectricityCustomlist}" var="list">
										<li><a href="${pageContext.request.contextPath}/frontend/articlenewsdetail/${list.electricitypk}" target="_blank"><i class="fa fa-angle-right"></i>${list.electricityname}</a></li>
									</c:forEach>
								</ul>
							</div>
							<div class="articlebox row_r">
								<h2>
									新手指引
									<a href="${pageContext.request.contextPath}/frontend/articleguide" target="_blank">更多<i class="fa fa-angle-right"></i></a>
								</h2>
								<ul>
									<c:forEach items="${TGuideInfoCustomlist}" var="list">
										<li><a href="${pageContext.request.contextPath}/frontend/articleguidedetail/${list.guidepk}" target="_blank"><i class="fa fa-angle-right"></i>${list.guidename}</a></li>
									</c:forEach>
								</ul>
							</div>
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
</body>
</html>