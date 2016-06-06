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
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>当前流量统计</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
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
</head>
<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
    <strong>${tAgentInfoCustom.agentname }</strong> <small>后台管理系统</small>
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
           
        </div>
      </div>
 <!-- sidebar end -->
<div id="module-head"></div>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/tableExport.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/base64.js"></script>
<div class="admin-content">
  <div class="am-alert am-alert-danger" id="my-alert" style="display: none;">
    <p>开始日期应小于结束日期！</p>
  </div>
  <!--  <div class="am-cf am-padding">
    <div class="am-fl am-cf">
      <strong class="am-text-primary am-text-lg">当前流量统计</strong>
    </div>
  </div>
  -->
  <div class="am-g">
    <div class="am-u-md-12">
      <button class="am-btn am-btn-primary am-btn-xs" onclick="$('#taskList').tableExport({type:'excel',escape:'false'});">导出Excel</button>
      <div class="am-panel am-panel-default">
        <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-2'}">
          	当前流量统计 <span class="am-icon-chevron-down am-fr"></span>
        </div>
        <div id="collapse-panel-2" class="am-collapse am-in">
          <table class="am-table am-table-bd am-table-bdrs am-table-striped am-table-hover" id="taskList">
            <thead>
              <tr>
                <th>手机编号</th>
                <th>完成收藏数</th>
                <th>完成加购数</th>
              </tr>
              </thead>
              <tbody>
              <c:if test="${tTaskDetailInfoCustomlist!=null }">
	              <c:forEach items="${tTaskDetailInfoCustomlist }" var="list">
		              <tr>
		                 <td>${list.phoneid}</td>
		                 <td>${list.collectioncount}</td>
		                 <td>${list.shoppingcount}</td>
		              </tr>
	              </c:forEach>
	              <tr>
	              	<td>总计</td>
	              	<td>${tTaskDetailInfoCustom.collectionsum}</td>
	              	<td>${tTaskDetailInfoCustom.shoppingsum}</td>
	              </tr>
              </c:if>
              <c:if test="${tTaskDetailInfoCustomlist == null }">
              	<tr>
	              	<td colspan="3"><center><span>暂无详细数据...</span></center></td>
	              </tr>
              </c:if>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>
<script>

  $(function() {
	$(".admin-offcanvas-bar").load("${pageContext.request.contextPath}/backstage/admin/adminmenu.jsp");

    $("#search").click(function() {
      var agentpk = $("#agentpk").val();
      var startTime = $("#my-startDate").text();
      var entTime = $("#my-endDate").text();
      var type = $("#flowType").val(); 
      var url = "${pageContext.request.contextPath}/datacount/responsedatasumadmin?&datefrom=" + startTime + "&dateto=" + entTime + "&tasktype=" + type + "&agentpk=" + agentpk;
      location.href = url;
    });
  });
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