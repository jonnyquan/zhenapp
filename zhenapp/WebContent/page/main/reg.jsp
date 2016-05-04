<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/style.css">
</head>
<body>
<body style="background-color: #F8F8F8">
<nav class="navbar navbar-default navbar-fixed-top" style="background-color: #FFF;">
	<div class="container" style="height:85px;">
		<div class="navbar-header">
			<a href="index.html" class="navbar-brand logo"><img src="${pageContext.request.contextPath}/bootstrap/img/index/logo.png"  alt="真流量"></a>
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
				<li><a href="${pageContext.request.contextPath}/guide/findGuide_10" style="height:85px;line-height:80px;font-size:20px;"><span class="glyphicon glyphicon-fire"></span> 新手指引</a></li>
				<li><a href="${pageContext.request.contextPath}/about/findGuideandelectrity" style="height:85px;line-height:80px;font-size:20px;"><span class="glyphicon glyphicon-question-sign"></span> 联系我们</a></li>
				<li><a href="${pageContext.request.contextPath}/page/main/reg.jsp" style="height:85px;line-height:80px;font-size:20px;color: #FFA8A8;"><span class="glyphicon glyphicon-question-sign"></span> 用户中心</a></li>
			</ul>	
		</div>
	</div>
</nav>
<div style="height:20px;">
</div>


<div style="height:100px;background-color: #EEE">

</div>
		<div class="container" style="width: 500px;height: 300px;">
			<form id="form" class="form-group" action="${pageContext.request.contextPath}/user/register.action" method="post">
				<div class="form-group" >
					<label class=" control-label ">用户名：</label>
					<input type="text" id="usernick" name="usernick" class="form-control" placeholder="请输入用户名,一经注册不允许修改" onkeyup="value=value.replace(/\s/g,'')"/>
					<div id="nickdiv"></div>
				</div>
				<div class="form-group" >
					<label class=" control-label ">真实姓名：</label>
					<input type="text" id="username" name="username" class="form-control" placeholder="请输入真实姓名,一经注册不允许修改" onkeyup="value=value.replace(/\s/g,'')"/>
					<div id="nickdiv"></div>
				</div>
				<div class="form-group" >
					<label class=" control-label ">密码：</label>
					<input type="password" id="userpwd1" name="userpwd" class="form-control" placeholder="请输入密码"/>
					<div id="userpwd1div"></div>
				</div>
				<div class="form-group" >
					<label class=" control-label ">确认密码：</label>
					<input type="password" id="userpwd2" class="form-control" placeholder="请再次输入密码"/>
					<div id="userpwd2div"></div>
				</div>
				<div class="form-group" >
					<label class=" control-label ">电子邮箱：</label>
					<input type="email" id="regemail" name="regemail" class="form-control" placeholder="请输入您的电子邮箱"/>
					<div id="regemaildiv"></div>
				</div>
				<div class="form-group" >
					<label class=" control-label ">注册须知：</label>
					<textarea id="zcxz" class="form-control" rows="15" cols="10" readonly="readonly" disabled="disabled">
					</textarea>
					<input type="radio" value="agree" name="register"/>同意&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="radio" value="disagree" name="register" checked="checked" />不同意
				</div>
				<input type="hidden" name="regip" value="<%=request.getServerName()%>">
				<div class="form-group" >
					<input type="button" id="reg_btn" class="btn btn-default center-block" value="注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;册" />
				</div>
			</form>
		</div>
	</body>	
	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/page/js/reg.js"></script>
	<script type="text/javascript">
		var uri="${pageContext.request.contextPath}";
	</script>
</html>