<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
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
				<a href="${pageContext.request.contextPath}/task/responsetaskadd" id="addtask"><i class="fa fa-angle-right"></i>发布流量任务</a>
			</p><!-- 
			<p>
				<a href="${pageContext.request.contextPath}/task/responsetaskztcadd" id="addztctask"><i class="fa fa-angle-right"></i>发布直通车任务</a>
			</p> -->
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
				<a href="${pageContext.request.contextPath}/points/responseconsume" id="consume"><i class="fa fa-angle-right"></i>购买记录</a>
			</p>
			<p>
				<a href="${pageContext.request.contextPath}/points/responserecordspoints" id="point"><i class="fa fa-angle-right"></i>积分明细</a>
			</p>
		</dd>
	</dl>
				