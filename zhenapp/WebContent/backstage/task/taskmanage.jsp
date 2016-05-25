<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="真流量,无线流量,无限流量代运营,无线刷流量 " />
<meta name="description" content="真流量,无线流量,无限流量代运营,无线刷流量 " />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/myPage.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/pagematter/common/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/pagematter/common/css/global.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/pagematter/common/css/common.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/pagematter/common/css/sweetalert.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/backstage/pagematter/common/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/backstage/pagematter/common/js/common.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/backstage/pagematter/common/js/sweetalert-dev.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/pagematter/common/css/layer_user.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/pagematter/common/css/user.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/pagematter/common/css/validform.style.css" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<script src="${pageContext.request.contextPath}/bootstrap/js/jqPaginator.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/myPage.js" type="text/javascript"></script>
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
				<a href="${pageContext.request.contextPath}/frontend/index" title="电商流量">真流量</a>
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
		
		</div>
<script type="text/javascript">
    $('#managetask').addClass('hover');
</script>
	<div class="rightbox row_r">
		<div class="u_outbox">
			<div class="tabtitle clearfix">
				<a href="${pageContext.request.contextPath}/task/responsetaskmanage" class="row_l hover">流量任务管理</a>
				<a href="${pageContext.request.contextPath}/user/responseuser" class="row_l back">返回个人中心</a>
			</div>
			<div class="umainbox">
				<!--main-->
				<form id="searchform" class="koo_fromBox" action="${pageContext.request.contextPath}/task/responsetaskmanage" method="post">
				<table class="table table-bordered">
						<tr>
							<td>
								<label class="form_label">订单ID:</label>
								<input class="form_input input120" type="text" name="taskpk" id="taskpk" value="" /> 
							</td>
							<td>
								<label class="form_label">宝贝ID:</label>
								<input class="form_input input120" type="text" name="taskkeynum" id="taskkeynum" value="" /> 
							</td>
							<td>
								<label class="form_label">搜索关键字(模糊):</label> 
								<input class="form_input input120" type="text" name="keyword" id="keyword" value="" />
							</td>
						</tr>
						<tr>
							<td>
								<label class="form_label">任务类型:</label>
									<select name="tasktype" id="tasktype">
										<option selected value="">全部类型</option>
										<option value="33">流量</option>
										<option value="34">直通车</option>
									</select> 
							</td>
							<td >
								<label class="form_label">任务开始时间:</label> 
								<input type="text" name="datefrom" id="datefrom" class="Wdate search_time" onClick="WdatePicker()" value="" /> 
								<label class="form_label">至</label> 
								<input type="text" name="dateto" id="dateto" class="Wdate search_time" onClick="WdatePicker()" value="" />
							</td>
							<td >
								<label class="form_label">任务当前状态:</label> 
								<select name="taskstate" id="taskstate">
									<option <c:if test="${taskstate==''}">selected</c:if> value="">全部类型</option>
									<option <c:if test="${taskstate==15}">selected</c:if> value="15">待分配</option>
									<option <c:if test="${taskstate==16}">selected</c:if> value="16">运行中</option>
									<option <c:if test="${taskstate==17}">selected</c:if> value="17">已完成</option>
									<option <c:if test="${taskstate==18}">selected</c:if> value="18">终止中</option>
									<option <c:if test="${taskstate==19}">selected</c:if> value="19">已终止</option>
								</select> 
							</td>
						</tr>
						<tr>
							<td colspan="3">
								<button type="button" id="search" class="btn btn-info">搜索</button>
								<button type="button" id="delete" class="btn btn-default">删除</button>
							</td>
						</tr>
					</table>
					
				</form>

				<div class="tablebox">
					<table class="table" style="table-layout:fixed;">
						<thead>
							<tr class="active">
							  <th style="width:30px;">选择</th>
				              <th style="width:90px;">订单ID</th>
				              <th style="width:100px;">宝贝ID</th>
				              <th style="width:40px;">类型</th>
				              <th style="width:110px;">关键词</th>
				              <th style="width:45px;">访</th>
				              <th style="width:45px;">藏</th>
				              <th style="width:45px;">购</th>
				              <th style="width:45px;">完成访问</th>
				              <th style="width:45px;">完成收藏</th>
				              <th style="width:45px;">完成加购</th>
				              <th style="width:45px;">失败</th>
				              <th style="width:60px;">任务日期</th>
				              <th style="width:80px;">发布时间</th>
				              <th style="width:50px;">任务状态</th>
				              <th>操作</th>
				            </tr>
						</thead>
						<c:if test="${tTaskInfoCustomlist == null}">
							<tr>
								<td colspan="18">
									<div class="no_data">暂无任务记录</div>
								</td>
							</tr>
						</c:if>
						<c:if test="${tTaskInfoCustomlist != null}">
							<c:forEach items="${tTaskInfoCustomlist}" var="list">
								<tr style="word-wrap:break-word;">
									<td><input type="checkbox" name="taskpk" value="${list.taskpk}"><input type="hidden" name="taskstate" value="${list.taskstate}"></td>
					                <td>${list.taskpk}</td>
					                <td>${list.taskkeynum}</td>
					                <td>${list.tasktypename }</td>
					                <td>${list.taskkeyword}</td>
					                <td>${list.flowcount }</td>
					                <td>${list.collectioncount }</td>
					                <td>${list.shoppingcount }</td>
					                <td>${list.finishflowcount }</td>
					                <td>${list.finishcollectioncount }</td>
					                <td>${list.finishshoppingcount }</td>
					                <td class="font-red">${list.errorcount}</td>
					                <td >${list.taskdaterange}</td>
					                <td >${list.createtime}</td>
					                <td>${list.dicinfoname} </td>
									<td > 
									  <!--  <a onclick="againtask('${list.taskid}')" class="btn btn-success btn-xs">再次发布</a>	<br/>-->
									  <a onclick="againtask('${list.taskid}')" class="btn btn-success btn-xs">再次发布</a>	<br/>
									  <a onclick="endtask('${list.taskid}')" class="btn btn-default btn-xs">终止任务</a>				
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
					
				</div>
				
			</div>
			<div>
				<ul class="pagination" id="pagination">
				</ul>
				<input type="hidden" id="PageCount" runat="server" value="${total}"/>
				<input type="hidden" id="PageSize" runat="server" value="10" />
				<input type="hidden" id="countindex" runat="server" value="10"/>
				<!--设置最多显示的页码数 可以手动设置 默认为7-->
				<input type="hidden" id="visiblePages" runat="server" value="12" />
			</div>
		</div>
	</div>
			
<script type="text/javascript"
	src="${pageContext.request.contextPath}/backstage/pagematter/common/js/layer_user.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/backstage/pagematter/common/js/Validform_v5.3.2.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/backstage/pagematter/common/js/WdatePicker.js "></script>
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
<script type="text/javascript">
;$(function(){
	$(".leftmenu").load("${pageContext.request.contextPath}/backstage/user/menu.jsp");
	
	$('#datefrom').datebox();
	$('#dateto').datebox();
	
	$("#search").click(function(){
		$("#searchform").submit();
	});

	$("#delete").click(function(){
		var taskpkarr = $("input[name='taskpk']:checked");
		var taskpks="";
		for (var i = 0; i < taskpkarr.length; i++) {
			taskpks = taskpks + taskpkarr[i].value+"==";
		}
		$.messager.confirm('确认','您确认想要删除该条记录吗？',function(b){   
			 if (b){
				 $.ajax({
						url : "${pageContext.request.contextPath}/task/deletetaskByPks/"+taskpks,
						type : 'post',
						success : function (data, response, status) {
							if (data!=null && data.data=="success") {
								alert("删除任务成功！");
								window.location.href="${pageContext.request.contextPath}/task/responsetaskmanage";
							}else if(data!=null && data.data=="stateexc"){
								alert("删除任务失败,待分配任务不允许删除！");
							} else{
								alert("删除任务失败,请联系客服！");
							}
						}
					});
			 }
		});
	});
});
/*
function againtask(taskid){
	$.ajax({
		url : "${pageContext.request.contextPath}/task/againtaskBytaskid/"+taskid,
		type : 'post',
		success : function (data, response, status) {
			if (data!=null && data.data=="success") {
				alert("发布成功！");
				window.location.href="${pageContext.request.contextPath}/task/responsetaskmanage";
			} else if(data!=null && data.data=="low") {
				alert("余额不足,发布失败！");
			} else if(data!=null && data.data=="refuse") {
				alert("系统维护暂停任务发布！");
			} else{
				alert("任务发布失败,请联系客服！");
			}
		}
	});
}*/
function againtask(taskid){
	window.location.href="${pageContext.request.contextPath}/task/againtaskBytaskid/"+taskid;
}

function endtask(taskid){
	$.ajax({
		url : "${pageContext.request.contextPath}/task/endtaskBytaskid/"+taskid,
		type : 'post',
		success : function (data, response, status) {
			if (data!=null && data.data=="success") {
				alert("终止任务成功！");
				window.location.href="${pageContext.request.contextPath}/task/responsetaskmanage";
			} else{
				alert("终止任务失败,请联系客服！");
			}
		}
	});
}
	
var index = Number("${pagenum}");
if (index.length < 1) {
	index = 1;
}
function loadpage() {
	var myPageCount = parseInt($("#PageCount").val());
	var myPageSize = parseInt($("#PageSize").val());
	var countindex = myPageCount % myPageSize > 0 ? (myPageCount / myPageSize) + 1
			: (myPageCount / myPageSize);
	if(countindex==0){
		countindex=1;
	}
	$("#countindex").val(countindex);
	$.jqPaginator('#pagination',
	{
		totalPages : parseInt($("#countindex").val()),
		visiblePages : parseInt($("#visiblePages").val()),
		currentPage : index,
		first : '<li class="first"><a href="${pageContext.request.contextPath}/task/responsetaskmanage?page=1">首页</a></li>',
		prev : '<li class="prev"><a href="javascript:;">上一页</a></li>',
		next : '<li class="next"><a href="javascript:;">下一页</a></li>',
		last : '<li class="last"><a href="javascript:;">末页</a></li>',
		page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
		onPageChange : function(num, type) {
			if (type == "change") {
				window.location.href = "${pageContext.request.contextPath}/task/responsetaskmanage?page=" + num;
			}
		}
	});
}

function fn_deleteTaskBypk (obj){
	$.messager.confirm('确认','您确认想要删除该条记录吗？',function(b){    
	    if (b){
	    	window.location.href="${pageContext.request.contextPath}/task/deleteTaskBypk/"+obj;
	    }
	});
}
		
		
	</script>
</body>
</html>