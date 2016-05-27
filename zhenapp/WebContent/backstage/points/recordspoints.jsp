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
<script src="${pageContext.request.contextPath}/bootstrap/js/jqPaginator.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/myPage.js" type="text/javascript"></script>
<style type="text/css">
.money {
	font-size: 14px;
}

.balance {
	font-size: 14px;
	color: #999;
}

.money.add1 {
	color: #008000;
}

.money.add2 {
	color: #f00;
}
</style>
<title>积分明细</title>
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
		        $('#point').addClass('hover');
		    </script>
			<div class="rightbox row_r">
				<div class="u_outbox">
					<div class="tabtitle clearfix">
						<a href="${pageContext.request.contextPath}/points/responsebuypoints" class="row_l">购买积分套餐</a> 
						<a href="${pageContext.request.contextPath}/points/responseconsume" class="row_l">购买记录</a> 
						<a href="${pageContext.request.contextPath}/points/responserecordspoints" class="row_l hover">积分明细</a>
					</div>
					<div class="umainbox">
						<!--main-->
						<form id="searchform" class="koo_fromBox" action="${pageContext.request.contextPath}/points/responserecordspoints" method="post">
							<table class="table table-bordered">
								<tr>
									<td>
										<label class="form_label">订单ID:</label>
										<input class="form_input" style="width:200px;" type="text" name="taskpk" id="taskpk" value="${taskpk}" /> 
									</td>
								</tr>
								<tr>
									<td>
										<button type="button" id="search" class="btn btn-info">搜索</button>
									</td>
								</tr>
							</table>
							
						</form>
						<div class="tablebox">
							<table class="tablelist">
								<thead>
									<th width="20%">订单号</th>
									<th width="8%">积分变更</th>
									<th width="8%">实时积分</th>
									<th width="8%">类型</th>
									<th>备注说明</th>
									<th width="15%">发生时间</th>
								</thead>
							<c:if test="${tPointsInfoCustomlist==null}">
		                        <tr>
		                            <td colspan="4">
		                                <div class="no_data">暂无积分记录</div>
		                            </td>
		                        </tr>
	                        </c:if>
	                        <c:if test="${tPointsInfoCustomlist!=null}">
		                       <c:forEach items="${tPointsInfoCustomlist}" var="list">
		                       		<tr>
		                       			<td>
		                       				${list.taskpk}
		                       			</td>
		                       			<td>
		                       				${list.pointsupdate}
		                       			</td>
				                        <td>
											${list.points}
										</td>
										<td>
											${list.pointstypename}
										</td>
				                        <td>
											${list.pointreason}
										</td>
				                        <td>
				                        	${list.createtime}
				                        </td>
		                       		</tr>
		                       </c:forEach>
	                        </c:if>
							</table>
						</div>
						<!--main-->
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
			<script type="text/javascript"
				src="${pageContext.request.contextPath}/backstage/pagematter/common/js/layer_user.js"></script>
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
;$(function(){
	$(".leftmenu").load("${pageContext.request.contextPath}/backstage/user/menu.jsp");
	
	$("#search").click(function(){
		$("#searchform").submit();
	});
});

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
			{totalPages : parseInt($("#countindex").val()),
				visiblePages : parseInt($("#visiblePages").val()),
				currentPage : index,
				first : '<li class="first"><a href="${pageContext.request.contextPath}/points/responserecordspoints?page=1">首页</a></li>',
				prev : '<li class="prev"><a href="javascript:;">上一页</a></li>',
				next : '<li class="next"><a href="javascript:;">下一页</a></li>',
				last : '<li class="last"><a href="javascript:;">末页</a></li>',
				page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
				onPageChange : function(num, type) {
					if (type == "change") {
						//exeData(num, type);
						window.location.href = "${pageContext.request.contextPath}/points/responserecordspoints?page=" + num;
					}
				}
			});
		}
</script>
</body>
</html>