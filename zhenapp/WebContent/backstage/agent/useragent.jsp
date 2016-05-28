<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
  <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<title>${tAgentInfoCustom.agentname}  -- 用户列表</title>
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
<body>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
  <div class="am-cf am-padding">
    <div class="am-fl am-cf">
      <strong class="am-text-primary am-text-lg">用户管理</strong>/<small>用户列表</small>
    </div>
  </div>
  <div class="am-g" style="margin-bottom: 10px;">
    <div class="am-u-sm-12">
      <form class="am-form-inline" role="form">
        <div class="am-form-group">
          <input type="text" id="userId" value="${userpk}" class="am-form-field" placeholder="用户ID">
        </div>
        <div class="am-form-group">
          <input type="text" id="userName" value="${usernick}" class="am-form-field" placeholder="用户名">
        </div>
        <div class="am-form-group">
          <input type="text" id="mobile" value="${userphone}" class="am-form-field" placeholder="手机号">
        </div>
        <button type="button" class="am-btn am-btn-default" id="search">搜索</button>
      </form>
    </div>
  </div>
  <div class="am-u-sm-12">
    <form class="am-form">
      <table class="am-table am-table-striped am-table-hover" style="font-size: 1.4rem;">
        <thead>
          <tr class="am-success">
            <th>用户ID</th>
            <th>用户名</th>
            <th>手机号</th>
            <th>邮箱</th>
            <th>积分</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th>状态</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
        <c:if test="${tUserInfoCustomlist==null}">
        	<tr data-id="1">
        		<td colspan="9">暂无数据</td>
        	</tr>
        </c:if>
          <c:forEach items="${tUserInfoCustomlist}" var="list">
          	<tr data-id="${list.userpk}">
              <th>${list.userpk}</th>
              <td>${list.usernick}</td>
              <td>${list.userphone}</td>
              <td>${list.regemail}</td>
              <td>${list.points}</td>
              <td>${list.createtime}</td>
              <td>${list.updatetime}</td>
              <td>${list.statename}</td>
			  <td><a href="${pageContext.request.contextPath}/user/recharge?userpk=${list.userpk}" class="am-badge am-badge-primary">充值/扣款</a> 
                  <a data-id="${list.userpk}" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="${pageContext.request.contextPath}/user/handworkLogin?userpk=${list.userpk}" data-id="3685" class="am-badge am-badge-primary">登录</a>
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

<script>
  $(function() {
	$("#menu").load("${pageContext.request.contextPath}/backstage/agent/menu.jsp");
	  
	  
	  
    $("#search").click(function() {
      var name = $("#userName").val();
      var id = $("#userId").val();
      var mobile = $("#mobile").val();
      location.href = "${pageContext.request.contextPath}/user/findUserByPageandRole?page=1&usernick=" + name + "&userpk=" + id + "&userphone=" + mobile;
    });

    $(document).on("click", ".deleteUser", function() {
      if (confirm("你确定要删除吗？")) {
        $.getJSON('${pageContext.request.contextPath}/user/deleteUserByUserpkAndRole', {
          userpk : $(this).attr("data-id")
        }, function(resp) {
          if (resp && resp.ec == 0) {
            location.href = '${pageContext.request.contextPath}/user/findUserByPageandRole';
          } else {
            Message.error('删除失败!', true);
          }
        });
      }
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
			first : '<li class="first"><a href="${pageContext.request.contextPath}/task/responsetaskmanage?page=1">首页</a></li>',
			prev : '<li class="prev"><a href="javascript:;">上一页</a></li>',
			next : '<li class="next"><a href="javascript:;">下一页</a></li>',
			last : '<li class="last"><a href="javascript:;">末页</a></li>',
			page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
			onPageChange : function(num, type) {
				if (type == "change") {
					//exeData(num, type);
					window.location.href = "${pageContext.request.contextPath}/task/responsetaskmanage?page=" + num;
				}
			}
		});
	}
</script>
  <a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>
  <footer>
    <hr>
    <p class="am-padding-left">Copyright (c) 2015 zhenapp.cn Inc. All Rights. 浙ICP备140452118号-5</p>
  </footer>
</body>
</html>
