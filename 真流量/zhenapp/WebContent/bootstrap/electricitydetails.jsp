<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
	<title>详情</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
</head>
<body style="background-color: #EEE">

<nav class="navbar navbar-default navbar-fixed-top" style="background-color: #FFF;">
	<div class="container" style="height:85px;">
		<div class="navbar-header">
			<a href="index.html" class="navbar-brand logo"><img src="${pageContext.request.contextPath}/bootstrap/img/index/logo.png"  alt="瓢城企训网"></a>
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="navbar-collapse" >
			<ul class="nav navbar-nav navbar-right" >
				<li><a href="${pageContext.request.contextPath}/index/findwebinfo" style="height:85px;line-height:80px;font-size:20px;"><span class="glyphicon glyphicon-home" ></span> 首页</a></li>
				<li><a href="${pageContext.request.contextPath}/electrity/findElectrity_10" style="height:85px;line-height:80px;font-size:20px;"><span class="glyphicon glyphicon-list"></span> 电商干货</a></li>
				<li><a href="${pageContext.request.contextPath}/guide/findGuide_10" style="height:85px;line-height:80px;font-size:20px;color: #FFA8A8;"><span class="glyphicon glyphicon-fire"></span> 新手指引</a></li>
				<li><a href="${pageContext.request.contextPath}/about/findGuideandelectrity" style="height:85px;line-height:80px;font-size:20px;"><span class="glyphicon glyphicon-question-sign"></span> 联系我们</a></li>
			</ul>	
		</div>
	</div>
</nav>
<div style="height:20px;">
</div>

<div style="height:100px;background-color: #EEE">

</div>

<div id="guide">
	<div class="container">
		<div class="row">
			<div class="col-md-4 info-right hidden-xs hidden-sm">
				<blockquote>
					<h2>热门信息</h2>
				</blockquote>
				<div class="row">
					<div class="col-md-12 col-sm-12 col-xs-12" style="background-color: #fff;">
						<blockquote>
							<h4>电商信息</h4>
						</blockquote>
						<div style="height:360px;">
							<table id="table">
								<c:forEach items="${TelectricityCustomlist}" var="item">
									<tr>
										<td style="margin:5px; padding:5px;border: 1px dashed #fff;">
											<span class="glyphicon glyphicon-menu-right"></span>
										</td>
										<td style="margin:5px; padding:5px;border: 1px dashed #fff;">
											<a href="${pageContext.request.contextPath}/electrity/details/${item.electricitypk}"><font color="#666" size="3">${item.electricityname}</font></a>		
										</td>
									</tr>	
								</c:forEach>
							</table>
						</div>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12" align="center">
						<div style="background-color: #DDD;height:10px;width:300px;">
						&nbsp;
						</div>
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12" style="background-color: #fff;height:20px;width:400px;" >
					
					</div>
					<div class="col-md-12 col-sm-12 col-xs-12" style="background-color: #fff;">
						<blockquote>
							<h4>新手注意事项</h4>
						</blockquote>
						<div style="height:300px;">
							<table id="table2" >
								<c:forEach items="${TGuideInfoCustomlist}" var="item">
									<tr>
										<td style="margin:5px; padding:5px;border: 1px dashed #fff;">
											<span class="glyphicon glyphicon-menu-right"></span>
										</td>
										<td style="margin:5px; padding:5px;border: 1px dashed #fff;">
											<a href="${pageContext.request.contextPath}/guide/details/${item.guidepk}"><font color="#666" size="3">${item.guidename}</font></a>		
										</td>
									</tr>	
								</c:forEach>
							</table>
						</div>
					</div>
					
				</div>
			</div>
			<div class="col-md-1 ">
			</div>
			<div class="col-md-7 ">
				<div>
					<p>&nbsp;</p>
					<p><center><h2><font color="#CC0000">${telectricityCustom.electricityname}</font></h2></center></p>
					<p>&nbsp;</p>
					<p><center>发&nbsp;布 &nbsp;:&nbsp;${telectricityCustom.createtime}</center></p>
					<p><hr size="1" noshade="noshade" /></p>
					<p>&nbsp;</p>
					<p>${telectricityCustom.electricitytext}</p>
				</div>
			</div>
		</div>
	</div>
</div>

<footer id="footer">
	<div class="container">
		<p>企业培训 | 合作事宜 | 版权投诉</p>
		<p>苏ICP 备12345678. © 2009-2026 真流量. Powered by Bootstrap.</p>
	</div>
</footer>


<script src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
  	
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js" ></script>
	
<script type="text/javascript">
	;$(function(){
		//$('#table1').datagrid();
		//$('#table2').datagrid();
		$("#table3").datagrid({
			title:"电商信息列表",
			iconCls:"icon-search",
			columns:[[
						{
							  field:'createtime',
							  title:'新手指引信息发布时间',
							  sortable:true,
						},
						{
							  field:'electricityname',
							  title:'新手指引信息标题',
							  sortable:true,
						},
						{
							  field:'updateuser',
							  title:'新手指引信息发布人',
							  sortable:true,
						}
			          ]],
			pagination:true,
			pageSize:2,
			pageList:[2,4,6],
			
		});
	});
</script>
</body>
</html>