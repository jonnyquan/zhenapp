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
.money {
	color: #f00;
}

.status_map {
	
}

.status_map a {
	display: block;
	width: 63px;
	height: 22px;
	line-height: 22px;
	padding: 0 10px;
	border: 1px solid #dedede;
	background-color: #fffbeb;
	text-align: center;
	margin-right: 10px;
	margin-top: 10px;
	position: relative;
}

.status_map a.hover {
	background-color: #11b3b9;
	color: #fff;
	border: 1px solid #11b3b9;
}

.status_map a em {
	position: absolute;
	top: -5px;
	right: -5px;
	display: block;
	width: 16px;
	height: 16px;
	line-height: 16px;
	font-size: 6px;
	color: #fff;
	text-align: center;
	background-color: #999;
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
}

.status_map a em.num {
	background-color: #f00;
}

.tabtitle a.back {
	float: right;
	border: none;
	font-weight: normal;
	color: #c00;
}

.Tasktable {
	padding: 6px 0;
}

.Tasktable table {
	width: 100%;
	border: 1px solid #dedede;
}

.Tasktable td {
	background-color: #fffbdb;
	height: 25px;
	line-height: 25px;
	padding: 0 10px;
}

.Tasktable td .con {
	width: 260px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
	height: 25px;
	line-height: 25px;
}

.Tasktable td .con.caozuo a {
	display: inline-block;
	height: 22px;
	line-height: 22px;
	margin-top: 3px;
	margin-right: 10px;
	background-color: #03C;
	color: #fff;
	text-align: center;
	cursor: pointer;
	width: 100px;
}

.Tasktable td .con.caozuo span {
	display: inline-block;
	height: 22px;
	line-height: 22px;
	margin-top: 3px;
	margin-right: 10px;
	background-color: #999;
	color: #fff;
	cursor: pointer;
	text-align: center;
	width: 100px;
}

.Tasktable td .con.tips {
	color: #039;
}

.notask {
	text-align: center;
	height: 50px;
	line-height: 50px;
	color: #c00;
}

.myOrders {
	background-color: #fff;
	padding: 10px 20px;
	width: 510px;
}

.myOrders p {
	line-height: 18px;
	padding: 6px 0;
	border-bottom: 1px dashed #dedede;
	font-size: 14px;
	color: #039;
}

.myOrders p span {
	color: #666;
	padding-right: 20px;
	display: inline-block;
	width: 90px;
	text-align: right;
}

.myOrders p.ordernum {
	color: #C00;
}

.text_overflow_1 {
	white-space: nowrap;
	text-overflow: ellipsis;
	-o-text-overflow: ellipsis;
	overflow: hidden;
}

.searchbox {
	margin-bottom: 10px;
	padding: 5px 0px;
	color: #333;
	border-bottom-color: rgb(222, 222, 222);
	border-bottom-style: dashed;
	border-bottom-width: 1px;
}

.form_control {
	margin-top: 5px;
	height: 25px;
	line-height: 25px;
	font-size: 12px;
	border-bottom: 1px dashed #dedede;
	padding-bottom: 5px;
}

button.search_btn {
	display: inline-block;
	background-color: rgb(11, 148, 146);
	padding: 0px 3px;
	color: white;
}

input.search_time {
	width: 90px;
}

input {
	padding-right: 20px;
}
</style>
<title>会员中心 - 真流量</title>
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
			<div class="logo row_l">
				<a href="${pageContext.request.contextPath}/frontend/index"
					title="电商流量">真流量</a>
			</div>
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
						<a href="javascript:void(0);">财务中心</a>
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
        $('#managetask').addClass('hover');
    </script>

			<div class="rightbox row_r">
				<div class="u_outbox">
					<div class="tabtitle clearfix">
						<a href="/user/task/manage" class="row_l hover">流量任务管理</a><a
							href="/user" class="row_l back">返回个人中心</a>
					</div>
					<div class="umainbox">
						<!--main-->
						<form class="koo_fromBox" action="/user/task/manage" method="post">
							<div class="searchbox ">
								<div>
									<label class="form_label">搜索关键字:</label> <input
										class="form_input input120" type="text" name="keyword"
										id="keyword" value="" /> <label class="form_label">商品标题:</label>
									<input class="form_input input120" type="text" name="title"
										id="title" value="" /> <label class="form_label">任务状态:</label>

									<select name="status" id="status">
										<option selected value="全部状态">全部状态</option>
										<option value="同步中">同步中</option>
										<option value="已经完成">已经完成</option>
										<option value="正在执行">正在执行</option>
										<option value="自动暂停">自动暂停</option>
										<option value="手动暂停">手动暂停</option>
									</select> <label class="form_label">任务开始时间:</label> <input type="text"
										name="fromDate" class="Wdate search_time"
										onClick="WdatePicker()" value="2016-05-10" /> <label
										class="form_label">至</label> <input type="text" name="toDate"
										class="Wdate search_time" onClick="WdatePicker()"
										value="2016-05-26" />

									<button type="submit" name="submit" class="search_btn">搜索</button>

								</div>

							</div>

						</form>

						<div class="tablebox">
							<table class="tablelist">
								<thead>
									<th width="5%">序号</th>
									<th width="15%">关键字</th>
									<th width="20%">宝贝标题</th>
									<th width="10%">任务数</th>
									<th width="12%">开始时间</th>
									<th width="8%">状态</th>
									<th width="15%">备注</th>
									<th width="15%">操作</th>
								</thead>
								<tr>
									<td colspan="8">
										<div class="no_data">暂无任务记录</div>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			<script type="text/javascript"
				src="${pageContext.request.contextPath}/backstage/pagematter/common/js/layer_user.js"></script>
			<script type="text/javascript"
				src="${pageContext.request.contextPath}/backstage/pagematter/common/js/Validform_v5.3.2.js"></script>
			<script type="text/javascript"
				src="${pageContext.request.contextPath}/backstage/pagematter/common/js/WdatePicker.js "></script>
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