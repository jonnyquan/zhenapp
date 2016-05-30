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
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/agent/pagematter/amazeui.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/agent/pagematter/admin.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/agent/pagematter/lanyunying.css" />
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/jquery.form.min.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/lanyunying.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/kindeditor/themes/default/default.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/kindeditor/plugins/code/prettify.css" />
<script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/kindeditor-all-min.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/lang/zh-CN.js"></script>
<script charset="utf-8" src="${pageContext.request.contextPath}/kindeditor/plugins/code/prettify.js"></script>
</head>
<body>
<meta name="viewport" content="width=device-width, initial-scale=1">
<header class="am-topbar admin-header">
  <div class="am-topbar-brand">
    <strong>真流量</strong> <small>后台管理系统</small>
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
        
      </div>
       <!-- sidebar end -->
      <div id="module-head"></div>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript">
	var editor1=null;
	KindEditor.ready(function(K) {
		editor1 = K.create('textarea[name="notetext"]', {
			cssPath : '${pageContext.request.contextPath}/kindeditor/plugins/code/prettify.css',
			uploadJson : '${pageContext.request.contextPath}/kindeditor/jsp/upload_json.jsp',
			fileManagerJson : '${pageContext.request.contextPath}/kindeditor/jsp/file_manager_json.jsp',
			allowFileManager : true,
			afterCreate : function() {
				var self = this;
				self.sync();
			},
			afterBlur:function(){
				this.sync();
			} 
		});
		prettyPrint();
	});
</script>
<div class="admin-content">

  <div class="am-cf am-padding">
    <div class="am-fl am-cf">
      <strong class="am-text-primary am-text-lg">编辑公告</strong>
    </div>
  </div>
  <div class="am-g">
    <!-- 表单 -->
    <div class="am-u-sm-10">
      <form class="am-form am-form-horizontal" id="publisFlow" action="${pageContext.request.contextPath}/note/updatenote" method="post">
        <!-- am-form-group 的基础上添加了 am-form-group-sm -->
         <input type="hidden" value="${tNoteInfoCustom.noteid}" name="noteid" id="id" class="am-form-field" >
         <input type="hidden" value="${tNoteInfoCustom.notetype}" name="notetype" id="notetype" class="am-form-field" >
        <div class="am-form-group am-form-group-sm">
          <label for="kwd" class="am-u-sm-2 am-form-label">标题</label>
          <div class="am-u-sm-10">
            <input type="text" name="notename" value="${tNoteInfoCustom.notename }" id="title" class="am-form-field" placeholder="输入你的标题">
          </div>
        </div>
        <div class="am-form-group am-form-group-sm">
          <label for="contentType"  class="am-u-sm-2 am-form-label">类型</label>
          <div class="am-u-sm-10">
	          <c:if test="${tNoteInfoCustom.notetype=='0' }">
		      	<span>电商信息</span>
		      </c:if>
		      <c:if test="${tNoteInfoCustom.notetype=='1' }">
		      	<span>新手指引</span>
		      </c:if>
		      <c:if test="${tNoteInfoCustom.notetype=='2' }">
		      	<span>服务介绍</span>
		      </c:if>
          </div>
        </div>
        <div class="am-form-group am-form-group-sm">
          <label for="totalTask" class="am-u-sm-2 am-form-label">内容</label>
          <div class="am-u-sm-10">
           <textarea rows="15" cols="60" name="notetext" id="content">
           	${tNoteInfoCustom.notetext }
		   </textarea>
          </div>
        </div>
        <div class="am-form-group">
          <div class="am-u-sm-10 am-u-sm-offset-2">
            <button type="button" id="btn-sub" class="am-btn am-btn-primary">提交</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
<script>
$(function(){
	$("#admin-offcanvas").load("${pageContext.request.contextPath}/backstage/agent/menu.jsp");
	
	$("#btn-sub").click(function(){
		editor1.sync();
		$("#publisFlow").submit();
	});
	
	
    $('#publisFlow').validate({
      rules : {
    	  title : {
          required : true
        },
        typeId : {
          required : true
        }
      },
      messages : {
    	  title : {
          required : '不能为空。'
        },
        typeId : {
          required : '请输入搜索关键词'
        }
      },
      submitHandler : function(form) {
        if (!$(form).valid()) {
          $('.error').eq(0).focus();
          return false;
        }
        $(form).ajaxSubmit({
          success : function(resp) {
            if (resp && resp.ec == 0) {
              Message.info('发布成功：', false);
              setTimeout(function() {
                window.location.href = '${pageContext.request.contextPath}/note/findnoticeListByAgent';
              }, 2000);

            } else {
              Message.error('发布失败：' + resp.em, false);
            }
          },
          error : function() {
            Message.error('发布失败！', false);
          }
        });
      }
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
