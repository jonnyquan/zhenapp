<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<meta name="viewport" content="width=device-width, initial-scale=1">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
  <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<title>${tAgentInfoCustom.agentname} -- 充值记录</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/myPage.css">
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
    <strong>${tAgentInfoCustom.agentname}</strong> <small>后台管理系统</small>
  </div>
  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
    data-am-collapse="{target: '#topbar-collapse'}">
    <span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
  </button>
  <div class="am-collapse am-topbar-collapse" id="topbar-collapse"> 
    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li class="am-dropdown" data-am-dropdown>
    	<a href="${pageContext.request.contextPath}/user/findUserByPageandRole">
    		积分：${points}
    	</a>
      </li>  
      <li class="am-dropdown" data-am-dropdown>
      </li>
      <li class="am-dropdown" data-am-dropdown>
      	<a href="${pageContext.request.contextPath}/user/authlogout">
      		<span class="am-icon-power-off"></span>退出
      	</a>
      </li>
    </ul>
  </div>
</header>
<div class="am-cf admin-main">
      <div id="menu" class="admin-sidebar am-offcanvas"></div>
      
      <div id="module-head"></div>
<meta name="viewport" content="width=device-width, initial-scale=1">
<div class="admin-content">
  <div class="am-alert am-alert-danger" id="my-alert" style="display: none;">
    <p>开始日期应小于结束日期！</p>
  </div>
  <div class="am-cf am-padding">
    <div class="am-fl am-cf">
      <strong class="am-text-primary am-text-lg">用户管理</strong>/<small>充值管理</small>
    </div>
  </div>
  <div class="am-g" style="margin-bottom: 10px;">
    <div class="am-u-sm-12 am-u-md-3">
      <button type="button" class="am-btn am-btn-default" id="my-start">
        <span class="am-icon-calendar"></span>开始日期
      </button>
      <span id="my-startDate">${datefrom }</span>
    </div>
    <div class="am-u-sm-12 am-u-md-3">
      <button type="button" class="am-btn am-btn-default" id="my-end">
        <span class="am-icon-calendar"></span>结束日期
      </button>
      <span id="my-endDate">${dateto }</span>
    </div>

    <div class="am-u-sm-12 am-u-md-2">
      <input type="text" id="nick" class="am-form-field" placeholder="用户名" value="${usernick }">
    </div>
    <div class="am-u-sm-12 am-u-md-2">
      <input type="text" id="rechargeId" class="am-form-field" value="${rechargeid}" placeholder="充值ID">
    </div>

    <div class="am-u-sm-12 am-u-md-2">
      <button class="am-btn am-btn-default" id="search" type="button">搜索</button>
    </div>

  </div>

  <div class="am-g">
    <div class="am-u-sm-12">
      <form class="am-form">
        <table class="am-table am-table-striped am-table-hover" style="font-size: 1.4rem;">
          <thead>
            <tr class="am-success">
              <th>备注(充值id)</th>
              <th>校验码</th>
              <th>用户名</th>
              <th>充值金额</th>
              <th>充值时间</th>
              <th>状态</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${tRechargeInfoCustomlist }" var="list">
            	<tr data-id="${list.rechargepk}">
                <td>${list.rechargeid}</td>
                <td>${list.rechargeverification}</td>
                <td>${list.usernick}</td>
                <td><a href="#">${list.rechargemoney}</a></td>
                <td>${list.createtime}</td>
                <td>${list.rechargestatename}</td>
                <td>
                	<c:if test="${list.rechargestate != 25 }">
                		<a class="btn btn-info btn-xs" onclick="updateRechargestate('${list.rechargeverification}');">确认充值</a>
                	</c:if>
                </td>
              </tr>
            </c:forEach>
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
function updateRechargestate(rechargeverification){
	$.ajax({
		url : "${pageContext.request.contextPath}/recharge/updateRechargestate/"+rechargeverification,
		type : 'post',
		success : function (data, response, status) {
			if (data!=null && data.data=="success") {
				window.location.href="${pageContext.request.contextPath}/points/responseconsumeagent";
			} else{
				alert("确认失败!");
			}
		}
	});
}

  $(function() {
	  $("#menu").load("${pageContext.request.contextPath}/backstage/agent/menu.jsp");
    var startDate = new Date(2015, 12, 20);
    var endDate = new Date(2016, 11, 25);
    var $alert = $('#my-alert');
    $('#my-start').datepicker().on('changeDate.datepicker.amui', function(event) {
      if (event.date.valueOf() > endDate.valueOf()) {
        $alert.find('p').text('开始日期应小于结束日期！').end().show();
      } else {
        $alert.hide();
        startDate = new Date(event.date);
        $('#my-startDate').text($('#my-start').data('date'));
      }
      $(this).datepicker('close');
    });

    $('#my-end').datepicker().on('changeDate.datepicker.amui', function(event) {
      if (event.date.valueOf() < startDate.valueOf()) {
        $alert.find('p').text('结束日期应大于开始日期！').end().show();
      } else {
        $alert.hide();
        endDate = new Date(event.date);
        $('#my-endDate').text($('#my-end').data('date'));
      }
      $(this).datepicker('close');
    });

    $("#search").click(
        function() {
          var startTime = $("#my-startDate").text();
          var entTime = $("#my-endDate").text();
          var nick = $("#nick").val();
          var rechargeid = $("#rechargeId").val();
          location.href = "${pageContext.request.contextPath}/points/responseconsumeagent?page=1&datefrom=" + startTime + "&dateto=" + entTime
          + "&usernick=" + nick + "&rechargeid=" + rechargeid;
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
			first : '<li class="first"><a href="${pageContext.request.contextPath}/points/responseconsumeagent?page=1">首页</a></li>',
			prev : '<li class="prev"><a href="javascript:;">上一页</a></li>',
			next : '<li class="next"><a href="javascript:;">下一页</a></li>',
			last : '<li class="last"><a href="javascript:;">末页</a></li>',
			page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
			onPageChange : function(num, type) {
				if (type == "change") {
					var startTime = $("#my-startDate").text();
			          var entTime = $("#my-endDate").text();
			          var nick = $("#nick").val();
			          var rechargeid = $("#rechargeId").val();
			          location.href = "${pageContext.request.contextPath}/points/responseconsumeagent?page=" + num + "&datefrom=" + startTime + "&dateto=" + entTime + "&usernick=" + nick + "&rechargeid=" + rechargeid;
				}
			}
		});
	}
</script>
</div>
<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>
<footer>
  <hr>
  <p class="am-padding-left">Copyright (c) 2015 zhenapp.cn Inc. All Rights. 浙ICP备140452118号-5</p>
</footer>
</body>
</html>