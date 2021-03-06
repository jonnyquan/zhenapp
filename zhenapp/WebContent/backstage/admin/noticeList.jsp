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
<title>公告管理</title>
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

<div class="admin-content">

	<div class="am-cf am-padding">
		<div class="am-fl am-cf">
			<strong class="am-text-primary am-text-lg">公告管理 </strong>
		</div>
	</div>

	<div class="am-g" id="module-head" style="margin-bottom: 10px;">
		<div class="am-u-sm-12 am-u-md-6">
		<a class="am-btn am-btn-secondary" href="${pageContext.request.contextPath}/note/responseNoteadd">添加</a>
		</div>
	</div>
	<div class="am-g">
		<div class="am-u-sm-12">
			<form class="am-form">
				<table class="am-table am-table-striped am-table-hover"
					style="font-size: 1.4rem;">
					<thead>
						<tr class="am-success">
							<th>ID</th>
							<th>类型</th>
							<th>标题</th>
							<th>状态</th>
							<th>创建时间</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					<c:if test="${tNoteInfoCustomlist == null }">
						<tr>
							<td colspan="5">
								暂无详细信息
							</td>
						</tr>
					</c:if>
					<c:if test="${tNoteInfoCustomlist != null }">
						<c:forEach items="${tNoteInfoCustomlist}" var="list">
							<tr data-id="${list.notepk }">
								<td>${list.notepk}</td>
								<td>${list.notetype}</td>
								<td>${list.notename}</td>
								<td>${list.notestatename}</td>
								<td>${list.createtime}</td>
								<td>
									<div class="am-btn-toolbar">
										<div class="am-btn-group am-btn-group-xs">
											<a class="am-btn am-btn-default am-btn-xs am-text-secondary" href="${pageContext.request.contextPath}/note/responsenoticeEdit/${list.noteid}/${list.notetype}"> 
												<span class="am-icon-pencil-square-o"></span> 编辑
											</a>
											<c:if test="${list.notetype == 0 or list.notetype == 1}">
												<a class="am-btn am-btn-default am-btn-xs am-text-danger" href="${pageContext.request.contextPath}/note/DeleteNoteAndinfo/${list.noteid}/${list.notetype}"> 
													<span class="am-icon-trash-o"></span> 删除
												</a>
											</c:if>
											<c:if test="${list.notestate == 66}">
												<a class="am-btn am-btn-default am-btn-xs am-text-secondary" href="${pageContext.request.contextPath}/note/updatenotestate/${list.noteid}/${list.notetype}"> 
													<span class="am-icon-pencil-square-o"></span> 审核通过
												</a>
											</c:if>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</c:if>					
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
;$(function(){
	$(".admin-offcanvas-bar").load("${pageContext.request.contextPath}/backstage/admin/adminmenu.jsp");
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
	{
		totalPages : parseInt($("#countindex").val()),
		visiblePages : parseInt($("#visiblePages").val()),
		currentPage : index,
		first : '<li class="first"><a href="${pageContext.request.contextPath}/note/findnoticeList?page=1">首页</a></li>',
		prev : '<li class="prev"><a href="javascript:;">上一页</a></li>',
		next : '<li class="next"><a href="javascript:;">下一页</a></li>',
		last : '<li class="last"><a href="javascript:;">末页</a></li>',
		page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
		onPageChange : function(num, type) {
			if (type == "change") {
				//exeData(num, type);
				window.location.href = "${pageContext.request.contextPath}/note/findnoticeList?page=" + num;
			}
		}
	});
}
</script>
  <a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu"
    data-am-offcanvas="{target: '#admin-offcanvas'}"></a>
  <footer>
    <hr>
    <p class="am-padding-left">Copyright (c) 2015 Inc. All Rights. 浙ICP备140452118号-5</p>
  </footer>
</body>
</html>