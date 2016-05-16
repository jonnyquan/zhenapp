<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML>
<meta name="viewport" content="width=device-width, initial-scale=1">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>任务详情</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/myPage.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/agent/pagematter/amazeui.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/agent/pagematter/admin.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/agent/pagematter/lanyunying.css" />
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/jquery.form.min.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/lanyunying.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/agent/pagematter/default.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/backstage/agent/pagematter/kindeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/backstage/agent/pagematter/zh_CN.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/jqPaginator.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/myPage.js" type="text/javascript"></script>
</head>
<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
    <strong>真流量</strong> <small>后台管理系统</small>
  </div>
  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
    data-am-collapse="{target: '#topbar-collapse'}">
    <span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
  </button>
  <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li class="am-dropdown" data-am-dropdown><a href="${pageContext.request.contextPath}/user/authlogout"><span class="am-icon-power-off"></span>
          退出</a></li>
      <li class="am-dropdown" data-am-dropdown><a href="javascript:alert('不要点我');"><span class="am-icon-power-off"></span>
          清理数据（不要点）</a></li>
      <li class="am-dropdown" data-am-dropdown><a href="javascript:alert('不要点我');"><span class="am-icon-power-off"></span>
          查询数据（不要点）</a></li>
      <li class="am-hide-sm-only"><a href="javascript:alert('不准开');;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span>
          <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
  </div>
</header>
<div class="am-cf admin-main">
      <!-- sidebar start -->
      <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
        <div class=" admin-offcanvas-bar">
           <ul class="am-list admin-sidebar-list">
            <!--  <li><a href="/admin"><span class="am-icon-home"></span> 首页</a></li>-->
            <li class="admin-parent"><a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span
                class="am-icon-user"></span>用户管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
              <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
                <li><a href="${pageContext.request.contextPath}/user/findUserByPageAndAdmin" class="am-cf"><span class="am-icon-list"></span>用户列表</a></li>
                <li><a href="${pageContext.request.contextPath}/points/responseconsumeadmin"><span class="am-icon-usd"></span>充值记录</a></li>
                <li><a href="${pageContext.request.contextPath}/points/responserecordspointsadmin"><span class="am-icon-money"></span>资金记录</a></li>
              </ul></li>
            <li><a href="${pageContext.request.contextPath}/task/responsetaskmanageadmin"><span class="am-icon-pencil-square-o"></span>订单查询</a></li>
            <li><a href="${pageContext.request.contextPath}/combo/findComboByadmin"><span class="am-icon-cubes"></span> 套餐信息</a></li>

            
             <li><a href="${pageContext.request.contextPath}/task/findproblemtaskadmin"><span class="am-icon-mobile"></span> 有问题任务查询</a></li>
             <li><a href="${pageContext.request.contextPath}/task/findtaskdetaillist"><span class="am-icon-mobile"></span> 任务详情</a></li> 
             <li><a href="${pageContext.request.contextPath}/task/findtasklocklist"><span class="am-icon-mobile"></span> 卡机任务查询</a></li> 
 			<!--   <li><a href="/admin/phoneTask/getMessage"><span class="am-icon-mobile"></span> 淘宝ID查询</a></li>
              <li><a href="/admin/phoneTask/problem"><span class="am-icon-mobile"></span> 手机状态信息</a></li>
              <li><a href="/admin/findProblemAssignKeyWords"><span class="am-icon-search"></span>问题宝贝查询</a></li>
              <li><a href="/admin/findProblemKeyWords"><span class="am-icon-search"></span>问题宝贝查询(简单)</a></li> -->
              <li><a href="${pageContext.request.contextPath}/note/findnoticeList"><span class="am-icon-bullhorn"></span> 公告管理</a></li>
              <li><a href="${pageContext.request.contextPath}/sysconf/responsesyssetting"><span class="am-icon-cog"></span>系统设置</a></li>
              <li><a href="${pageContext.request.contextPath}/agent/responseagentmanage"><span class="am-icon-sitemap"></span>代理管理</a></li>
              <li><a href="${pageContext.request.contextPath}/datacount/responsedatasumadmin"><span class="am-icon-bar-chart"></span>数据统计</a></li>
               <li class="admin-parent"><a class="am-cf" data-am-collapse="{target: '#collapse-navo'}"><span
                class="am-icon-sign-out"></span>其他 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
              <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-navo">
                <li><a href="${pageContext.request.contextPath}/script/responsescriptmanage" class="am-cf"><span class="am-icon-arrow-circle-up"></span>上传脚本</a></li>
                <li><a href="${pageContext.request.contextPath}/tbaoccount/responsetbaoccount"><span class="am-icon-upload"></span>上传淘宝账户</a></li>
                <li><a href="${pageContext.request.contextPath}/tbaoccount/responsetaobaoid"><span class="am-icon-eye"></span>查看淘宝账户信息</a></li>
              </ul></li>
          </ul>
        </div>
      </div>
 <!-- sidebar end -->
      <div id="module-head"></div>
      
  <meta name="viewport" content="width=device-width, initial-scale=1">

<div class="admin-content">

	<div class="am-cf am-padding">
		<div class="am-fl am-cf">
			<strong class="am-text-primary am-text-lg">手机任务 </strong>
		</div>
	</div>

	<div class="am-g" id="module-head" style="margin-bottom: 10px;">
		<div class="am-u-sm-12 am-u-md-12">
			<form class="am-form-inline" role="form">
				<div class="am-form-group">
					<input type="text" id="pid" class="am-form-field am-input-sm"
						value="" placeholder="手机号">
				</div>
				<div class="am-form-group">
					<input type="text" id="nid" class="am-form-field am-input-sm"
						value="" placeholder="宝贝id">
				</div>
				<div class="am-form-group">
					<input type="text" id="fid" class="am-form-field am-input-sm"
						 placeholder="订单id">
				</div>
				<div class="am-form-group">
					<input type="text" id="hours" class="am-form-field am-input-sm"
						value="" placeholder="时间">
				</div>
				<div class="am-form-group">
						<select name="tasktype" id="tasktype" class="am-form-field am-input-sm">
							<option selected value="">全部类型</option>
							<option value="33">流量</option>
							<option value="34">直通车</option>
						</select> 
				</div>
				<button class="am-btn am-btn-default" id="search" type="button">搜索</button>
			</form>
		</div>

	</div>
	<div id="onmousediv">
		<table class="table">
			<tr class="info">
				<td id="omnousetd">
					
				</td>
			</tr>
		</table>
	</div>
	<div class="am-g">
		<div class="am-u-sm-12">
			<form class="am-form">
				<table class="am-table am-table-striped am-table-hover"
					style="font-size: 1.4rem;">
					<thead>
						<tr class="am-success">
							<th>手机号</th>
							<th>订单ID</th>
							<th>宝贝ID</th>
							<th>是否加购物车</th>
							<th>是否收藏</th>
							<th>返回状态</th>
							<th>执行时间(点)</th>
							<th>完成收藏</th>
							<th>完成加购</th>
							<th>创建时间</th>
							<th>更新时间</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${tTaskDetailInfoCustomlist != null }">
							<c:forEach items="${tTaskDetailInfoCustomlist}" var="list">
								<tr onclick="onmouse('${list.resultstr}');">
									<td>${list.phoneid}</td>
									<td>${list.taskdetailid}</td>
									<td>${list.taskkeynum}</td>
									<td>${list.isshoppingname}</td>
									<td>${list.iscollectionname}</td>
									<td>${list.visitname}</td>
									<td>${list.taskhour}</td>
									<td>${list.collectname}</td>
									<td>${list.trolleyname}</td>
									<td>${list.createtime}</td>
									<td>${list.updatetime}</td>
								</tr>
							</c:forEach>
						</c:if>
						<c:if test="${tTaskDetailInfoCustomlist == null }">
							<tr>
								<td colspan="11">
									暂无详细记录
								</td>
							</tr>
						</c:if>
					</tbody>
				</table>
				 <div>
					<ul class="pagination" id="pagination">
					</ul>
					<input type="hidden" id="PageCount" runat="server" value="${total}"/>
					<input type="hidden" id="PageSize" runat="server" value="10" />
					<input type="hidden" id="countindex" runat="server" value="10"/>
					<!--设置最多显示的页码数 可以手动设置 默认为7-->
					<input type="hidden" id="visiblePages" runat="server" value="12" />
				  </div>
			</form>
		</div>
	</div>
</div>
<script>
	$(function() {
		$("#search").click(
				function() {
					var pid = $("#pid").val();
					var nid = $("#nid").val();
					var fid = $("#fid").val();
					var hours = $("#hours").val();
					var tasktype= $("#tasktype").val();
					
					location.href = "${pageContext.request.contextPath}/task/findtaskdetaillist?phoneid=" + pid
							+ "&&taskkeynum=" + nid+"&&taskid="+fid+"&&taskhour="+hours+"&&tasktype="+tasktype;
				});
	});
	
	function onmouse(obj){
		if(obj.length<1){
			$("#omnousetd").html("暂无返回值!");	
		}else{
			$("#omnousetd").html(obj);
		}
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
			{totalPages : parseInt($("#countindex").val()),
				visiblePages : parseInt($("#visiblePages").val()),
				currentPage : index,
				first : '<li class="first"><a href="${pageContext.request.contextPath}/task/findtaskdetaillist?page=1">首页</a></li>',
				prev : '<li class="prev"><a href="javascript:;">上一页</a></li>',
				next : '<li class="next"><a href="javascript:;">下一页</a></li>',
				last : '<li class="last"><a href="javascript:;">末页</a></li>',
				page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
				onPageChange : function(num, type) {
					if (type == "change") {
						//exeData(num, type);
						window.location.href = "${pageContext.request.contextPath}/task/findtaskdetaillist?page=" + num;
					}
				}
			});
		}
		
</script>

    </div>
  
  <a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu"
    data-am-offcanvas="{target: '#admin-offcanvas'}"></a>
  <footer>
    <hr>
    <p class="am-padding-left">Copyright (c) 2015 zhenapp.cn Inc. All Rights. 浙ICP备140452118号-5</p>
  </footer>

</body>
</html>

