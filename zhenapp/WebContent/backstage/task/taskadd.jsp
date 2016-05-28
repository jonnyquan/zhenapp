<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
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
<meta name="keywords" content="真流量,无线流量,无限流量代运营,无线刷流量 " />
<meta name="description" content="真流量,无线流量,无限流量代运营,无线刷流量 " />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
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
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/user.css" type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/backstage/pagematter/common/css/validform.style.css"
	type="text/css">

<style type="text/css">
.login_box {
	width: 930px;
	padding-bottom: 20px;
}

.form_control {
	margin-top: 5px;
	height: 25px;
	line-height: 25px;
	font-size: 12px;
	border-bottom: 1px dashed #dedede;
	padding-bottom: 5px;
}

.form_control_t {
	margin-top: 5px;
}

.form_control .form_label {
	height: 25px;
	line-height: 25px;
	font-size: 12px;
	width: 180px;
}

.form_control .form_label_rate {
	height: 25px;
	line-height: 25px;
	font-size: 12px;
	width: 100px;
	float: left;
	padding-left: 15px;
}

.form_control .form_input {
	height: 23px;
	line-height: 23px;
	font-size: 12px;
}

.form_control .form_select {
	height: 23px;
	line-height: 23px;
	font-size: 12px;
	list-style: 20px;
}

.form_control .select_big {
	width: 85px;
}

.form_control .select_small {
	width: 55px;
}

.form_control .form_radio {
	height: 25px;
	line-height: 25px;
	font-size: 12px;
}

.form_control .form_radio span {
	margin: 0 20px 0 5px;
}

.form_control .input_tip {
	height: 25px;
	line-height: 25px;
	font-size: 12px;
}

.form_control .Validform_checktip {
	height: 25px;
	line-height: 25px;
}

.form_control .form_btn {
	width: 150px;
	height: 30px;
	line-height: 30px;
	font-size: 14px;
	font-weight: normal;
}

.form_control .form_btn_order_good {
	width: 80px;
	height: 30px;
	line-height: 30px;
	font-size: 14px;
	font-weight: normal;
	background-color: #006633;
	color: #ffffff;
	border: 1px solid #01706e;
	margin-right: 2px;
}

.form_control .form_btn_order_bad {
	width: 80px;
	height: 30px;
	line-height: 30px;
	font-size: 14px;
	font-weight: normal;
	background-color: #cccc00;
	color: #ffffff;
	border: 1px solid #01706e;
	margin-right: 2px;
}

.form_control .form_btn_order_notfound {
	width: 80px;
	height: 30px;
	line-height: 30px;
	font-size: 14px;
	font-weight: normal;
	background-color: #990033;
	color: #ffffff;
	border: 1px solid #01706e;
	margin-right: 2px;
}

.form_control a.form_abtn {
	height: 30px;
	line-height: 30px;
	font-size: 14px;
	font-weight: normal
}

.form_control_t .form_label {
	float: left;
	display: block;
	width: 140px;
	text-align: right;
	padding-right: 10px;
	height: 25px;
	line-height: 25px;
	font-size: 12px;
}

.form_control .Validform_wrong {
	background-position: 15px -95px;
}

.form_control .Validform_right {
	background-position: 15px -145px;
}

.form_control .Validform_loading {
	background-position: 15px 4px;
}

.taxkTips {
	padding-bottom: 10px;
}

.taxkTips h2 {
	height: 30px;
	line-height: 30px;
	text-indent: 5px;
	border-bottom: 1px solid #dedede;
	font-size: 12px;
	color: #666;
	font-weight: bold;
	background-color: #f0f0f0;
	margin-top: 10px;
}

.task_dist {
	background-color: rgb(239, 239, 239);
	display: inline-table;
	width: 40px;
}

.task_time_title {
	width: 46px;
	text-align: center;
	font-weight: bold;
}

.task_time_count {
	margin: 1px;
}

.input_time {
	width: 40px;
	text-align: center;
}

.scan_icon {
	padding-right: 10px;
}

.toggle_wrapper {
	display: none;
}

.scan_break {
	padding-right: 10px;
}

.input50 {
	text-align: center;
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
			</div>
<script type="text/javascript">
   $('#addtask').addClass('hover');
</script>
			<div class="rightbox row_r">
				<div class="u_outbox">
					<div class="tabtitle clearfix">
						<a href="../task/responsetaskadd" class="row_l hover">淘宝APP流量</a>
						<!--  <a href="/user/task/taokouling/add" class="row_l">淘口令流量</a>-->
						<a href="${pageContext.request.contextPath}/frontend/articleguidedetail/5" target="_blank" class="row_r" style="color:#FF0000">如何发布淘宝APP流量？</a>
					</div>
					<div class="umainbox">
						<!--main-->
						<div id="addTaskDiv">
							<form class="koo_fromBox" >
								<div class="taxkTips">
									<h2>
										<scan class="scan_icon">
										<a><i class="fa fa-info-circle fa-lg"></i></a></scan>
										任务基本信息区
									</h2>
								</div>
								<table class="table">
									<tr>
										<td >
											宝贝url
										</td>
										<td >
											<input type="text" name="taskurl" placeholder="请输入宝贝url" class='form-control' id="taskurl" value="${tTaskInfoCustom.taskurl}" maxlength="1000" 
												
												onchange="checkurl(this);" /><!-- 例如:https://item.taobao.com/item.htm?id=531027639098 --><br/>
											<span id="span" style="color:#aaa;"></span>
										</td>
									</tr>
									<tr>
										<td>
											关键词
										</td>
										<td>
											<table id="tab_keyword" >
												<tr>
													<c:if test="${tTaskInfoCustom!=null}">
														<td>
															<input type="text" name="taskkeywords" class='form-control'  style="width:600px;" value="${tTaskInfoCustom.taskkeyword}" placeholder="请输入关键词" onchange="checkword(this);" />		
														</td>
														<td>
															<input type="button" class="easyui-linkbutton" iconCls="icon-add" onclick="addinput();" value="&nbsp;&nbsp;添 &nbsp;加 &nbsp;&nbsp;" />
														</td>
													</c:if>
													<c:if test="${tTaskInfoCustom==null}">
														<td>
															<input type="text" name="taskkeywords" class='form-control' style="width:600px;"  onchange="checkword(this);" />		
														</td>
														<td>
															<input type="button" class="easyui-linkbutton" iconCls="icon-add" onclick="addinput();" value="&nbsp;&nbsp;添 &nbsp;加 &nbsp;&nbsp;" />
														</td>
													</c:if>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td>
											发布时间
										</td>
										<td>
											<lable style="padding:0 10px 0 10px;">从:</lable>
											<input type="text" name="datefrom" id="datefrom" width="200px"/>
											到：<input type="text" name="dateto" id="dateto" width="200px"/>
										</td>
									</tr>
								</table>
								<div class="box" style="padding:0px 0px;">
									<div class="taxkTips box_toggle">
										<h2>
											<scan class="scan_icon">
											<a><i class="fa fa-chevron-circle-right fa-lg"></i></a></scan>
											卡位可选信息区（点击显示更多可选项，以更好的提升宝贝流量）建议保持默认不做更改!!
										</h2>
									</div>

									<div class="toggle_wrapper">

										<div class="form_control clearfix">
											<label class="form_label">排序类型：</label> 
											<select name="tasksearchType" id="tasksearchType" class="form_select select_big" v-model="sortType">
												<option selected="selected" value="35">综合排序</option>
												<option value="39">销量优先</option>
												<option value="37">价格从低到高</option>
												<option value="38">价格从高到低</option>
												<option value="36">信用排序</option>
											</select>
										</div>
										<div class="form_control clearfix">
											<label class="form_label">限价区间：</label> 
											<input class="form_input input50" type="text" name="priceRangeMinValue" id="priceRangeMinValue" v-model="start_price" value=0 /> 
											<span class="Validform_checktip scan_break">--</span> 
											<input class="form_input input50" type="text" name="priceRangeMaxValue" id="priceRangeMaxValue" v-model="end_price" value=0 /> 
											<label class="form_label">发货地：</label>
											<select name="searchArea" id="searchArea" class="form_select select_big" v-model="loc">
												<option value="所有地区">所有地区</option>
												<option value="江浙沪">江浙沪</option>
												<option value="珠三角">珠三角</option>
												<option value="港澳台">港澳台</option>
												<option value="海外">海外</option>
												<option value="北京">北京</option>
												<option value="上海">上海</option>
												<option value="广州">广州</option>
												<option value="深圳">深圳</option>
												<option value="杭州">杭州</option>
												<option value="温州">温州</option>
												<option value="宁波">宁波</option>
												<option value="南京">南京</option>
												<option value="苏州">苏州</option>
												<option value="济南">济南</option>
												<option value="青岛">青岛</option>
												<option value="大连">大连</option>
												<option value="无锡">无锡</option>
												<option value="合肥">合肥</option>
												<option value="天津">天津</option>
												<option value="长沙">长沙</option>
												<option value="武汉">武汉</option>
												<option value="郑州">郑州</option>
												<option value="石家庄">石家庄</option>
												<option value="成都">成都</option>
												<option value="重庆">重庆</option>
												<option value="西安">西安</option>
												<option value="昆明">昆明</option>
												<option value="南宁">南宁</option>
												<option value="福州">福州</option>
												<option value="厦门">厦门</option>
												<option value="南昌">南昌</option>
												<option value="东莞">东莞</option>
												<option value="沈阳">沈阳</option>
												<option value="长春">长春</option>
												<option value="哈尔滨">哈尔滨</option>
												<option value="河北">河北</option>
												<option value="河南">河南</option>
												<option value="湖北">湖北</option>
												<option value="湖南">湖南</option>
												<option value="福建">福建</option>
												<option value="江苏">江苏</option>
												<option value="江西">江西</option>
												<option value="广东">广东</option>
												<option value="广西">广西</option>
												<option value="海南">海南</option>
												<option value="浙江">浙江</option>
												<option value="安徽">安徽</option>
												<option value="吉林">吉林</option>
												<option value="辽宁">辽宁</option>
												<option value="黑龙江">黑龙江</option>
												<option value="山东">山东</option>
												<option value="山西">山西</option>
												<option value="陕西">陕西</option>
												<option value="新疆">新疆</option>
												<option value="内蒙古">内蒙古</option>
												<option value="云南">云南</option>
												<option value="贵州">贵州</option>
												<option value="四川">四川</option>
												<option value="甘肃">甘肃</option>
												<option value="宁夏">宁夏</option>
												<option value="青海">青海</option>
												<option value="西藏">西藏</option>
												<option value="香港">香港</option>
												<option value="澳门">澳门</option>
												<option value="台湾">台湾</option>
											</select>
										</div>

										<div class="form_control clearfix">
											<label class="form_label">折扣和服务：</label> 
											<label class="form_radio">
												<input type="checkbox" name="myfChecked" v-model="myfChecked" />
												<span>免运费</span></label> 
											<label class="form_radio">
												<input type="checkbox" name="tmChecked" v-model="tmChecked" />
												<span>天猫</span>
											</label> 
											<label class="form_radio">
												<input type="checkbox" name="sjzxChecked" v-model="sjzxChecked" />
												<span>手机专享</span>
											</label>
											<label class="form_radio">
												<input type="checkbox" name="tjbChecked" v-model="tjbChecked" />
												<span>淘金币抵钱</span>
											</label>
											<label class="form_radio">
												<input type="checkbox" name="hdfkChecked" v-model="hdfkChecked" />
												<span>货到付款</span>
											</label>
											<label class="form_radio">
												<input type="checkbox" name="cxChecked" v-model="cxChecked" />
												<span>促销</span>
											</label>
										</div>
									</div>
								</div>
								<div class="taxkTips">
									<h2>
										<scan class="scan_icon">
										<a><i class="fa fa-rmb fa-lg"></i></a></scan>
										本次刷流量共需费用
									</h2>
								</div>
								<table class="table" style="margin-bottom:0px;">
									<tr class="active">
										<td>【流量数：<span id="lls_1">0</span>个，流量单个花费:<span id="lls_2" style="color:red;">${tPriceInfoCustom.pricecounts1}</span>(积分)/个，总计：<span id="lls_3">0</span>(积分)】</td>
									</tr>
									<tr class="default">
										<td>【收藏数：<span id="scs_1">0</span>个，收藏单个花费:<span id="scs_2" style="color:red;">${tPriceInfoCustom.pricecounts2}</span>(积分)/个，总计：<span id="scs_3">0</span>(积分)】</td>
									</tr>
									<tr class="active">
										<td>【购物车数：<span id="gwcs_1">0</span>个，加购物车单个花费:<span id="gwcs_2" style="color:red;">${tPriceInfoCustom.pricecounts3}</span>/个，总计：<span id="gwcs_3">0</span>(积分)】</td>
									</tr>
									<tr class="success">
										<td>【总费用:<span id="sum" style="color:red;">0</span>(积分)】</td>
									</tr>
								</table>
								<div class="form_control clearfix">
									<label class="form_label">任务数量：</label> 
									<input type="text" name="flowcount" id="flowcount" <c:if test="${tTaskInfoCustom.flowcount!=null }">value="${tTaskInfoCustom.flowcount}"</c:if>
									<c:if test="${tTaskInfoCustom.flowcount==null }">value="1"</c:if>
										placeholder="请输入需要的流量数" onblur="fpll(this)"
										onkeyup="this.value=this.value.replace(/\D/g,'')"
										onafterpaste="this.value=this.value.replace(/\D/g,'')" />
								</div>
								
								<div class="form_control form_control_dist clearfix">
									<label class="form_label">任务分布：</label>
									<div class="hourCounts clearfix">
										<div class="task_dist">
											<div class="task_time_title">0时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_0"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">1时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_1"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">2时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_2"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">3时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_3"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">4时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_4"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">5时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_5"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">6时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_6"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">7时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_7"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">8时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_8"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">9时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_9"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">10时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_10"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">11时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_11"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
									</div>
								</div>
								<div class="form_control form_control_dist clearfix">
									<label class="form_label"></label>
									<div class="hourCounts clearfix">
										<div class="task_dist">
											<div class="task_time_title">12时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_12"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">13时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_13"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">14时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_14"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">15时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_15"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">16时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_16"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">17时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_17"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">18时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_18"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">19时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_19"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">20时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_20"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">21时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_21"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">22时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_22"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
										<div class="task_dist">
											<div class="task_time_title">23时</div>
											<div class="task_time_count">
												<input class="input_time" type="text"
													name="taskhourcounts" id="hour_23"	onblur="checkNum(this)" value="0" maxlength="3" />
											</div>
										</div>
									</div>
								</div>
								<div class="form_control clearfix">
									<label class="form_label">深入点击比例：</label> 
									<input type="text" name="deepclick" id="deepclick" maxlength="3" onblur="checkdeep();"
													onkeyup="this.value=this.value.replace(/\D/g,'')"
													onafterpaste="this.value=this.value.replace(/\D/g,'')"
													<c:if test="${tTaskInfoCustom.shoppingcount!=null }">value="${tTaskInfoCustom.shoppingcount}"</c:if>
													<c:if test="${tTaskInfoCustom.shoppingcount==null }">value="0"</c:if>
													 />
													 <apan style="font-size:20px;">%</apan>
												（百分比，0到100整数，浏览店铺其它宝贝比例）
								</div>
								<div class="form_control clearfix">
									<label class="form_label">收藏数量：</label> 
									<input name="collectioncount" id="collectioncount"
										placeholder="请输入收藏数" onchange="fpsc(this)" 
										<c:if test="${tTaskInfoCustom.collectioncount!=null }">value="${tTaskInfoCustom.flowcount}"</c:if>
										<c:if test="${tTaskInfoCustom.collectioncount==null }">value="0"</c:if>
										onkeyup="this.value=this.value.replace(/\D/g,'')"
										onafterpaste="this.value=this.value.replace(/\D/g,'')"/> <span id="collection_span"></span>
								</div>
								<div class="form_control clearfix">
									<label class="form_label">加购物车数量：</label> 
									<input type="text" name="shoppingcount" id="shoppingcount"
										placeholder="请输入购物车数"  onchange="fpgwc(this)" 
										<c:if test="${tTaskInfoCustom.shoppingcount!=null }">value="${tTaskInfoCustom.shoppingcount}"</c:if>
										<c:if test="${tTaskInfoCustom.shoppingcount==null }">value="0"</c:if>
										onkeyup="this.value=this.value.replace(/\D/g,'')"
										onafterpaste="this.value=this.value.replace(/\D/g,'')" /><span id="shopping_span"></span>
								</div>
								<div id="buttonSubmit" class="form_control clearfix"
									style="margin-top:20px; border-bottom:none;">
									<div class="botton" style="margin-left:40px;">
										<input type="button" class="btn btn-info" id="subbtn" value="发布任务" />
										<!--  <button id="orderCheck" type="button" name="orderCheck"
											 v-on="click: searchOrder">排名检查</button>
										&nbsp;&nbsp;<font color="#FF0000">*发布任务前务必先进行“排名检查”</font>-->
									</div>
								</div>
								<div id="searchOrderWrapper" class="form_control clearfix"
									style="margin-top:20px; border-bottom:none;">
									<div id="searchOrderInnerWrapper" class="botton"></div>
								</div>
							</form>
						</div>
						<!--main-->
					</div>
				</div>
			</div>
			<script type="text/javascript">
        $(function () {
        	$(".leftmenu").load("${pageContext.request.contextPath}/backstage/user/menu.jsp");
        	
            $(".koo_fromBox").Validform({
                tiptype: 3,
            });
        });
        $(document).ready(function(){
            $(".box_toggle").on('click', (function(){
                $(this).next(".toggle_wrapper").animate({height: 'toggle', opacity: 'toggle'}, "slow");
            },function(){
                $(this).next(".toggle_wrapper").animate({height: 'toggle', opacity: 'toggle'}, "slow");
            }));
        });
        var uri = "${pageContext.request.contextPath}";
    </script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/backstage/pagematter/common/js/vue.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/backstage/pagematter/common/js/addtask-v3.26.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/backstage/pagematter/common/js/layer_user.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/backstage/pagematter/common/js/taskadd.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/backstage/pagematter/common/js/Validform_v5.3.2.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
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