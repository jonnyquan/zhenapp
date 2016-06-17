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
<title>系统设置</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
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
      <strong class="am-text-primary am-text-lg">系统设置</strong>
    </div>
  </div>
  <form class="am-form am-form-horizontal am-padding" id="setting-form" action="${pageContext.request.contextPath}/sysconf/updatesyssetting" method="post">
      <div class="am-form-group">
        <label for="phone_num" class="am-u-sm-4 am-form-label">手机数目（需要重启服务器）</label>
        <div class="am-u-sm-4">
          <input type="text" name="sysconfvalue1" value="${tSysconfInfoCustom.sysconfvalue1 }">
        </div>
        <div class="am-u-sm-2" style="padding: 0px;">台</div>
      </div>
      <div class="am-form-group">
        <label for="phone_num" class="am-u-sm-4 am-form-label">直通车手机数目（需要重启服务器）</label>
        <div class="am-u-sm-4">
          <input type="text" name="sysconfvalue2" value="${tSysconfInfoCustom.sysconfvalue2 }">
        </div>
        <div class="am-u-sm-2" style="padding: 0px;">台</div>
      </div>
       <div class="am-form-group">
        <label for="error_num" class="am-u-sm-4 am-form-label">宝贝错误次数（超过就终止）</label>
        <div class="am-u-sm-4">
          <input type="text" name="sysconfvalue4" value="${tSysconfInfoCustom.sysconfvalue4}">
        </div>
        <div class="am-u-sm-2" style="padding: 0px;">个</div>
      </div>
      <div class="am-form-group">
        <label for="flow_price" class="am-u-sm-4 am-form-label">任务分配模式</label>
        <div class="am-u-sm-4">
        	<c:if test="${tSysconfInfoCustom.sysconfvalue5 == 0}">
        		 <label class="am-radio-inline"><input type="radio" value="1" name="sysconfvalue5" >均匀</label>
         		 <label class="am-radio-inline"><input type="radio" value="0" name="sysconfvalue5" checked="checked">快速</label>
        	</c:if>
         	<c:if test="${tSysconfInfoCustom.sysconfvalue5 == 1}">
        		 <label class="am-radio-inline"><input type="radio" value="1" name="sysconfvalue5" checked="checked">均匀</label>
         		 <label class="am-radio-inline"><input type="radio" value="0" name="sysconfvalue5" >快速</label>
        	</c:if>
        </div>
      </div>
      <div class="am-form-group">
        <label for="flow_price" class="am-u-sm-4 am-form-label">禁止发布流量</label>
        <div class="am-u-sm-4">
        	<c:if test="${tSysconfInfoCustom.sysconfvalue6 == 0}">
        		 <label class="am-radio-inline"><input type="radio" value="1" name="sysconfvalue6" >是</label>
         		 <label class="am-radio-inline"><input type="radio" value="0" name="sysconfvalue6" checked="checked">否</label>
        	</c:if>
         	<c:if test="${tSysconfInfoCustom.sysconfvalue6 == 1}">
        		 <label class="am-radio-inline"><input type="radio" value="1" name="sysconfvalue6" checked="checked">是</label>
         		 <label class="am-radio-inline"><input type="radio" value="0" name="sysconfvalue6" >否</label>
        	</c:if>
        </div>
      </div>
    

    <div class="am-form-group">
      <div class="am-u-sm-3 am-u-sm-push-4">
        <button type="submit" class="am-btn am-btn-primary">
          <i class="am-icon-check"></i>保存
        </button>
      </div>
    </div>
    <span id="error" class="am-u-sm-push-2"></span>
  </form>
</div>
<script>
  $(function() {
		$(".admin-offcanvas-bar").load("${pageContext.request.contextPath}/backstage/admin/adminmenu.jsp");
    $('#setting-form').validate({
      
      submitHandler : function(form) {
        if (!$(form).valid()) {
          $('.error').eq(0).focus();
          return false;
        }
        $(form).ajaxSubmit({
          success : function(resp) {
            if (resp.ec == 0) {
              Message.info('修改成功！', true);
              setTimeout(function() {
                window.location.href = location;
              }, 2000);
            } else {
              Message.error('修改失败：' + resp.em, false);
            }
          },
          error : function() {
            Message.error('修改失败！');
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