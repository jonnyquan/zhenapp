<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<ul class="am-list admin-sidebar-list">
  <!--  <li><a href="/admin"><span class="am-icon-home"></span> 首页</a></li>-->
	<li class="admin-parent"><a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span
	    class="am-icon-user"></span>用户管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
	  <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
	    <li><a href="${pageContext.request.contextPath}/user/findUserByPageAndAdmin" class="am-cf"><span class="am-icon-list"></span>用户列表</a></li>
		<li><a href="${pageContext.request.contextPath}/points/responseconsumeadmin"><span class="am-icon-usd"></span>充值记录</a></li>
		<li><a href="${pageContext.request.contextPath}/points/responserecordspointsadmin"><span class="am-icon-money"></span>积分明细</a></li>
	  </ul>
	</li>
	<li><a href="${pageContext.request.contextPath}/task/responsetaskmanageadmin"><span class="am-icon-pencil-square-o"></span>订单查询</a></li>
	<!--  <li><a href="${pageContext.request.contextPath}/combo/findComboByadmin"><span class="am-icon-cubes"></span> 套餐信息</a></li>-->
	<!--  <li><a href="${pageContext.request.contextPath}/task/findproblemtaskadmin"><span class="am-icon-mobile"></span> 有问题任务查询</a></li>-->
	<li><a href="${pageContext.request.contextPath}/task/findtaskdetaillist"><span class="am-icon-mobile"></span> 任务详情</a></li> 
	<li><a href="${pageContext.request.contextPath}/task/findtasklocklist"><span class="am-icon-mobile"></span> 卡机任务查询</a></li> 
	<li><a href="${pageContext.request.contextPath}/phone/responsetaskdatasum"><span class="am-icon-bar-chart"></span>当前流量统计</a></li>
	<li><a href="${pageContext.request.contextPath}/note/findnoticeList"><span class="am-icon-bullhorn"></span> 软文管理</a></li>
	<li><a href="${pageContext.request.contextPath}/sysconf/responsesyssetting"><span class="am-icon-cog"></span>系统设置</a></li>
	<li><a href="${pageContext.request.contextPath}/agent/responseagentmanage"><span class="am-icon-sitemap"></span>代理管理</a></li>
	<li><a href="${pageContext.request.contextPath}/datacount/responsedatasumadmin"><span class="am-icon-bar-chart"></span>数据统计</a></li>
	
	<li class="admin-parent">
		<a class="am-cf" data-am-collapse="{target: '#collapse-navo'}">
			<spanclass="am-icon-sign-out"></span>其他 
			<span class="am-icon-angle-right am-fr am-margin-right"></span>
		</a>
		<ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-navo">
		    <li><a href="${pageContext.request.contextPath}/script/responsescriptmanage" class="am-cf"><span class="am-icon-arrow-circle-up"></span>上传脚本</a></li>
			<li><a href="${pageContext.request.contextPath}/tbaoccount/responsetbaoccount"><span class="am-icon-upload"></span>上传淘宝账户</a></li>
			<li><a href="${pageContext.request.contextPath}/tbaoccount/responsetaobaoid"><span class="am-icon-eye"></span>查看淘宝账户信息</a></li>
		</ul>
	</li>
	
</ul>
       