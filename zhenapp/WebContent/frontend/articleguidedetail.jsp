<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="keywords" content="电商干货,淘宝干货,跨境电商干货,微商干货,淘宝实操干货,电商运营" />
<meta name="description"
	content="电商实操运营经验哪里找，尽在真流量电商干货频道。无论你是深耕天猫淘宝开店的，还是刚刚涉足跨境电商领域的，或是刚刚投奔微商领域的，总有一款电商干货是你需要的，看这里就够了。" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/myPage.css">
	
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/global.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/common.css">

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/pagination.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/frontend/pagematter/common/js/jquery-1.11.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/frontend/pagematter/common/js/common.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/frontend/pagematter/common/css/index.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/frontend/pagematter/common/js/jquery.SuperSlide.2.1.1.js"></script>
	
	
<script src="${pageContext.request.contextPath}/bootstrap/js/jqPaginator.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/myPage.js" type="text/javascript"></script>
<title>新手指引 - 真流量</title>
</head>

<body>

	<div class="topbar">
		<div class="warp1200 toplogin clearfix">
			<div class="userlogin row_r" id="userLogin">
				<c:if test="${tUserInfoCustom == null}">
					您好，欢迎来到真流量网！<a href="${pageContext.request.contextPath}/frontend/authlogin">马上登录</a>|<a href="${pageContext.request.contextPath}/frontend/authregister">快速注册</a>
				</c:if>
				<c:if test="${tUserInfoCustom != null}">
					<div class="userlogin row_r" id="userLogin">您好 <span>${tUserInfoCustom.usernick }</span> 欢迎您回来！<a href="${pageContext.request.contextPath}/user/responsepersonal">进入会员中心</a>|<a href="${pageContext.request.contextPath}/user/authlogout">退出登录</a></div>
				</c:if>
			</div>
		</div>
	</div>

	<div class="pageFull">
		<div class="webHeader clearfix">
			<div class="logo row_l">
				<a href="${pageContext.request.contextPath}/frontend/index" title="电商流量">真流量</a>
			</div>
			<div class="channel row_r">
				<ul class="clearfix">
					<li><a href="${pageContext.request.contextPath}/frontend/index" title="电商流量"
						class="scl1">网站首页</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/intro" class="scl2">服务介绍</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/anli" class="scl3">成功案例</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/articlenews" class="scl4" title="电商干货">电商干货</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/articleguide" class="scl5">新手指引</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/authlogin" class="scl6" title="真流量用户中心">用户中心</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/about" class="scl7">联系我们</a></li>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript">
        $('.scl5').addClass('hover');
    </script>

	<div class="warp1200 clearfix">
		<div class="leftMenu row_l">

			<div class="chennalBox mtop15">

				<h3>电商干货</h3>

				<ul class="titlelist">
					<c:forEach items="${TelectricityCustomlist}" var="list">
						<li><a href="${pageContext.request.contextPath}/frontend/articlenewsdetail/${list.electricitypk}" target="_blank"><i class="fa fa-angle-right"></i>${list.electricityname}</a></li>
					</c:forEach>
				</ul>

			</div>
			<div class="chennalBox mtop15">
				<h3>新手指引</h3>
				<ul class="titlelist">
					<c:forEach items="${TGuideInfoCustomlist}" var="list">
						<li><a href="${pageContext.request.contextPath}/frontend/articleguidedetail/${list.guidepk}" target="_blank"><i class="fa fa-angle-right"></i>${list.guidename}</a></li>
					</c:forEach>
				</ul>
			</div>
		</div>

		<div class="rightBox row_r">
			<div class="chennalBox mtop15">
                <h3>新手指引</h3>

                <div class="mainBox">
                    <div class="newsContent">
                        <h1>${tGuideInfoCustom.guidename }</h1>

                        <div class="date">
                             <a href="${pageContext.request.contextPath}/frontend/index">真流量</a><span>发布：${tGuideInfoCustom.createtime}</span>
                        </div>
                        <div class="content">
                            <!--  <p>淘口令模式对无排名的新宝贝非常有用，不再需要为找不到宝贝而烦恼。</p><p>淘口令在哪里？淘口令怎么打开？</p><p>淘口令打开的两种方法：</p><p><span style="color: rgb(0, 112, 192);"><strong>第一种：淘宝APP的宝贝页面——分享——复制（第一种方法比较简便）</strong></span></p><p><img src="/ueditor/php/upload/image/20160414/1460616520557597.jpg" title="1460616520557597.jpg" alt="3.jpg"/>&nbsp;&nbsp;<img src="/ueditor/php/upload/image/20160414/1460616527742510.jpg" title="1460616527742510.jpg" alt="4.jpg"/></p><p><strong><span style="color: rgb(0, 112, 192);">第二种：千牛APP的流量中心——淘口令（第二种方法可以自定义推广文字）</span></strong></p><p><img src="/ueditor/php/upload/image/20160414/1460616541330227.jpg" title="1460616541330227.jpg" alt="1.jpg"/>&nbsp;&nbsp;<img src="/ueditor/php/upload/image/20160414/1460616546942717.jpg" title="1460616546942717.jpg" alt="2.jpg"/></p>
                        	-->
                        	${tGuideInfoCustom.guidetext}
                        </div>
                    </div>
                </div>
            </div>
		</div>
	</div>
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/frontend/pagematter/common/js/floatTools.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/frontend/pagematter/common/js/layer.min.js"></script>

	<div class="copyRight">
		<div class="warp1200 footer">
			<p>
				Copyright (c) 2015 <a href="${pageContext.request.contextPath}/frontend/index" title="淘宝流量">淘宝流量</a> | <a href="${pageContext.request.contextPath}/frontend/index" title="真流量">真流量</a>(www.zhenapp.cn) Inc. All Rights. 浙ICP备140452118号-5.
			</p>
		</div>
	</div>

	<script type="text/javascript">
		var index = Number("${pagenum}");
		if (index.length < 1) {
			index = 1;
		}
		function loadpage() {
			var myPageCount = parseInt($("#PageCount").val());
			var myPageSize = parseInt($("#PageSize").val());
			var countindex = myPageCount % myPageSize > 0 ? (myPageCount / myPageSize) + 1
					: (myPageCount / myPageSize);
			$("#countindex").val(countindex);
			$.jqPaginator('#pagination',
							{
								totalPages : parseInt($("#countindex").val()),
								visiblePages : parseInt($("#visiblePages").val()),
								currentPage : index,
								first : '<li class="first"><a href="${pageContext.request.contextPath}/frontend/articlenews?page=1">首页</a></li>',
								prev : '<li class="prev"><a href="javascript:;">上一页</a></li>',
								next : '<li class="next"><a href="javascript:;">下一页</a></li>',
								last : '<li class="last"><a href="javascript:;">末页</a></li>',
								page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
								onPageChange : function(num, type) {
									if (type == "change") {
										//exeData(num, type);
										window.location.href = "${pageContext.request.contextPath}/frontend/articlenews?page=" + num;
									}
								}
							});
		}
	</script>
</body>
</html>