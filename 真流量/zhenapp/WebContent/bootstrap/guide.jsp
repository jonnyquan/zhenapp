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
	<title>新手指导</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/style.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
</head>
<body style="background-color: #EEE">

<nav class="navbar navbar-default navbar-fixed-top" style="background-color: #FFF;">
	<div style="height:20px;">
		<c:if test="${username=='' || username == null}">
			<marquee scrollamount="5" onMouseOut=start(); onMouseOver=stop();>
				<a href="${pageContext.request.contextPath}/page/main/login.jsp"><font style="font-size:20px;">欢迎登陆 |</font></a> 
				<a href="${pageContext.request.contextPath}/page/main/reg.jsp"><font style="font-size:20px;">| 赶紧加入我们</font></a>
			</marquee>	
		</c:if>
		<c:if test="${username!='' || username != null}">
			<marquee scrollamount="5" onMouseOut=start(); onMouseOver=stop();>
				<a href="javascript:void(0);"><font style="font-size:20px;">欢迎<font color="#F00">${username}</font>使用本系统！</font></a>
			</marquee>	
		</c:if>
	</div>
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

<div style="height:130px;background-color: #EEE">

</div>

<div id="guide">
	<div class="container">
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
					<div class="col-md-12 col-sm-12 col-xs-12" style="background-color: #fff;height:20px;width:300px;" >
					
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
			<div class="col-md-1 " style="width:5px;">
			</div>
			<div class="col-md-7 ">
				<div>
					<blockquote style="margin:5px; padding:5px;border: 1px dashed #eee;">
						<h3>新手指引信息</h3>
					</blockquote>
					<div style="height:700px;">
						<table id="table3" width="100%">
							<c:forEach items="${tGuideInfoCustomAlllist}" var="item" varStatus="status">
								<tr>
									<td style="margin:7px; padding:7px;border: 0px dashed #fff;  border-bottom:1px dashed #bbb;">
										<span class="glyphicon glyphicon-menu-right"></span>
									</td>
									<td style="margin:7px; padding:7px;border: 0px dashed #fff;  border-bottom:1px dashed #bbb;">
										<a id="linka" onmouseout="this.style.color='#777'" onmousemove="this.style.color='red'"
										href="${pageContext.request.contextPath}/guide/details/${item.guidepk}">
										<font size="2">${item.guidename}</font></a>
									</td>
									<td style="margin:7px; padding:7px;border: 0px dashed #fff;  border-bottom:1px dashed #bbb;">
										
									</td>
									<td style="margin:7px; padding:7px;border: 0px dashed #fff;  border-bottom:1px dashed #bbb;" align="right">
										<font size="2">${item.createtime}</font>
									</td>
								</tr>
								<c:if test="${(status.index + 1 ) % 5 ==0}">
								<tr>
									<td>
									&nbsp;
									</td>
									<td>
									</td>
									<td>
									</td>
									<td>
									</td>
								</tr>
								</c:if>
							</c:forEach>
						</table>
					</div>
					<div id="paginateion">
					</div>
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
		$("#paginateion").pagination({
			width:500,
			total:${total},
			pageSize:15,
			pageNumber:${pagenum},
			pageList:[1,2],
			layout:['first','prev','links','next','last','refresh'],
			onSelectPage:function(pageNumber,pageSize){
				self.location="${pageContext.request.contextPath}/guide/findGuide_10/"+pageNumber+"/"+pageSize;
			}
		});
	});
</script>
</body>
</html>