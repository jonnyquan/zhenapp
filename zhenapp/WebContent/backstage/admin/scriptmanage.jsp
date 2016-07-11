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
<title>${tAgentInfoCustom.agentname }</title>
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
<meta name="viewport" content="width=device-width, initial-scale=1">
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
      <strong class="am-text-primary am-text-lg">上传脚本</strong>
    </div>
  </div>
    <div class="am-g" style="margin-bottom: 10px;">
    <form action="${pageContext.request.contextPath}/script/uploadscript" method="post" enctype="Multipart/Form-data" id="taskForm">
    <div class="am-u-sm-12 am-u-md-6">
         <div class="am-form-group am-form-file">
        <button type="button" class="am-btn am-btn-default am-btn-sm">
            <i class="am-icon-cloud-upload"></i> 选择要上传的文件
        </button>
        <input type="file" name="file_name" id="file_id" multiple>
    </div>
    </div>
    <div class="am-u-sm-12 am-u-md-6">
      <button type="submit" class="am-btn am-btn-default" id="file_sub">提交</button>
    </div>
  </form>
  </div>
     <div class="am-u-sm-12">
    <table class="am-table am-table-striped am-table-hover" style="font-size: 1.4rem;">
        <thead>
        <tr class="am-success">
            <th>名称</th>
            <th>时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${tScriptInfoCustomlist == null }">
        	<tr>
        		<td colspan="3">
        			暂无详细数据
        		</td>
        	</tr>
        </c:if>
        <c:if test="${tScriptInfoCustomlist != null }">
        	<c:forEach items="${tScriptInfoCustomlist }" var="list">
        		<tr data-id="${list.scriptid}">
                <td>${list.scriptname}</td>
                <td>${list.createtime}</td>
                <td>
                    <div class="am-btn-toolbar">
                        <div class="am-btn-group am-btn-group-xs">
                            <a class="am-btn am-btn-default am-btn-xs am-text-secondary" href="${pageContext.request.contextPath}/script/downloadFile/${list.scriptid}"> 
                            	<span class="am-icon-pencil-square-o"></span> 下载
                            </a> 
                            <a class="am-btn am-btn-default am-btn-xs am-text-danger" href="${pageContext.request.contextPath}/script/deleteScriptByid/${list.scriptid}"> 
                            	<span class="am-icon-trash-o"></span> 删除
                        	</a>
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
    </div>
</div>

<script>

    $(function(){
    	$(".admin-offcanvas-bar").load("${pageContext.request.contextPath}/backstage/admin/adminmenu.jsp");
    	
        $('#taskForm').validate({
            rules : {
                file_name : {
                    required : true
                },
            },
            messages : {
                file_name : {
                    required : '不能为空。'
                },
            },
            submitHandler : function(form) {
                if (!$(form).valid()) {
                    $('.error').eq(0).focus();
                    return false;
                }
                $(form).ajaxSubmit({
                    success : function(resp) {
                        if (resp && resp.ec == 0) {
                            Message.info('上传成功：', false);
                            setTimeout(function() {
                                window.location.href = '${pageContext.request.contextPath}/script/responsescriptmanage';
                            }, 2000);
                        } else {
                            Message.error('上传失败：' + resp.em, false);
                        }
                    },
                    error : function() {
                        Message.error('上传失败！', false);
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
			first : '<li class="first"><a href="${pageContext.request.contextPath}/script/responsescriptmanage?page=1">首页</a></li>',
			prev : '<li class="prev"><a href="javascript:;">上一页</a></li>',
			next : '<li class="next"><a href="javascript:;">下一页</a></li>',
			last : '<li class="last"><a href="javascript:;">末页</a></li>',
			page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
			onPageChange : function(num, type) {
				if (type == "change") {
					//exeData(num, type);
					window.location.href = "${pageContext.request.contextPath}/script/responsescriptmanage?page=" + num;
				}
			}
		});
	}
    </script>
    </div>
  
  <a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu"
    data-am-offcanvas="{target: '#admin-offcanvas'}"></a>
  <footer>
    <hr>
    <p class="am-padding-left">Copyright (c) 2015 Inc. All Rights. 浙ICP备140452118号-5</p>
  </footer>

</body>
</html>