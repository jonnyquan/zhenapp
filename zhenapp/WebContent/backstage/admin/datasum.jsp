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
<title>数据统计</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
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


<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/tableExport.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/base64.js"></script>


<div class="admin-content">
  <div class="am-alert am-alert-danger" id="my-alert" style="display: none;">
    <p>开始日期应小于结束日期！</p>
  </div>
  <div class="am-cf am-padding">
    <div class="am-fl am-cf">
      <strong class="am-text-primary am-text-lg">数据统计</strong>
    </div>
  </div>

  <div class="am-g" style="margin-bottom: 10px;">
    <form class="am-form">
      <div class="am-u-md-2">
        
      </div>
      <div class="am-u-md-2">
        <select id="flowType">
          <option value="">任务流量类型</option>
          <option value="ZTCFLOW" >直通车</option>
          <option value="FLOW" >流量</option>
        </select>
      </div>
      <div class="am-u-md-3">
        <button type="button" class="am-btn am-btn-default" id="my-start">
          <span class="am-icon-calendar"></span>开始日期
        </button>
        <span id="my-startDate">2016-05-11</span>
      </div>
      <div class="am-u-md-3">
        <button type="button" class="am-btn am-btn-default" id="my-end">
          <span class="am-icon-calendar"></span>结束日期
        </button>
        <span id="my-endDate">2016-05-12</span>
      </div>
      <div class="am-u-md-2">
        <button class="am-btn am-btn-default" id="search" type="button">搜索</button>
      </div>
    </form>
  </div>
  <div class="am-g">
    <div class="am-u-md-12">
      <button class="am-btn am-btn-primary am-btn-xs" onclick="$('#taskList').tableExport({type:'excel',escape:'false'});">导出Excel</button>
      <div class="am-panel am-panel-default">
        <div class="am-panel-hd am-cf" data-am-collapse="{target: '#collapse-panel-2'}">
          任务统计 <span class="am-icon-chevron-down am-fr"></span>
        </div>
        <div id="collapse-panel-2" class="am-collapse am-in">

          <table class="am-table am-table-bd am-table-bdrs am-table-striped am-table-hover" id="taskList">
            <thead>
              <tr>
                <th>日期</th>
                <th>访问量</th>
                <th>收藏量</th>
                <th>购物车量</th>
                <th>购买积分</th>
                <th>发布任务</th>
                <th>后台操作</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach items="${datacountInfoCustomlist }" var="list">
	              <tr>
	                 <td>${list.date}</td>
	                 <td>${list.flowcount}</td>
	                 <td>${list.collectioncount}</td>
	                 <td>${list.shoppingcount}</td>
	                 <td>${list.buypoints}</td>
	                 <td>${list.expendpoints}</td>
	                 <td>${list.backstage}</td>
	              </tr>
              
              </c:forEach>
              <tr><td>总计</td><td>101</td><td>4</td><td>4</td></tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>
<script>

  $(function() {

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

    $("#search").click(function() {
      var startTime = $("#my-startDate").text();
      var entTime = $("#my-endDate").text();
      var type = $("#flowType").val(); 
      var url = "/admin/stat?&startTime=" + startTime + "&endTime=" + entTime + "&type=" + type;
      if($("#proxyList").length>0){
        var userId = $("#proxyList").val();
        url += "&userId=" + userId;
      }
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