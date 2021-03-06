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
<title>积分明细</title>
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
      <strong class="am-text-primary am-text-lg">用户管理</strong>/<small>资金管理</small>
    </div>
  </div>
  <div class="am-g">
    <!-- 表单 -->
    <div class="am-u-sm-7">
      <form class="am-form am-form-horizontal" id="publisFlow" action="${pageContext.request.contextPath}/user/handworkrechargeadminforagent" method="post">
        <input type="hidden" id="userpk" name="userpk" value="${userpk }" />
        <div class="am-form-group am-form-group-sm">
          <label for="" class="am-u-sm-3 am-form-label">用户积分</label>
          <div class="am-u-sm-9">
            <label class="am-radio-inline">${points} </label>
          </div>
        </div>
        <div class="am-form-group am-form-group-sm">
          <label for="" class="am-u-sm-3 am-form-label">操作</label>
          <div class="am-u-sm-9">
            <label class="am-radio-inline"> <input class="recharge" type="radio" checked="checked" value="recharge" name="recharge">充值
            </label> <label class="am-radio-inline"> <input class="recharge" type="radio" value="deduct" name="recharge">扣款
            </label>
          </div>
        </div>
        <!-- am-form-group 的基础上添加了 am-form-group-sm -->
        <div class="am-form-group am-form-group-sm">
          <label for="nid" class="am-u-sm-3 am-form-label">金额</label>
          <div class="am-u-sm-9">
            <input type="text" name="updatepoints" id="updatepoints" class="am-form-field" placeholder="输入积分">
          </div>
        </div>

        <div class="am-form-group am-form-group-sm">
          <label for="kwd" class="am-u-sm-3 am-form-label">备注</label>
          <div class="am-u-sm-9">
            <input type="text" name="memo" id="memo" class="am-form-field" placeholder="备注">
          </div>
        </div>

        <div class="am-form-group">
          <div class="am-u-sm-9 am-u-sm-offset-3">
            <button type="submit" class="am-btn am-btn-primary">提交</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
<script>
  $(function() {
	  $(".admin-offcanvas-bar").load("${pageContext.request.contextPath}/backstage/admin/adminmenu.jsp");
    $('#publisFlow').validate({
      rules : {
    	updatepoints : {
          required : true,
          digits : true
        },
        memo : {
          required : true,
          minlength : 2,
          maxlength : 15
        }
      },
      messages : {
    	  updatepoints : {
          required : '不呢个为空。',
          digits : '必须是数字'
        },
        memo : {
          required : '请输入搜索备注',
          minlength : '请输入备注在2到15个字符',
          maxlength : '请输入备注在2到15个字符'
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
              Message.info('提交成功：', false);
              setTimeout(function() {
                window.location.href = '${pageContext.request.contextPath}/agent/responseagentmanage';
              }, 2000);

            } else {
              Message.error('提交失败：' + resp.em, false);
            }
          },
          error : function() {
            Message.error('提交失败！', false);
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
    <p class="am-padding-left">Copyright (c) 2015 Inc. All Rights. 浙ICP备140452118号-5</p>
  </footer>
</body>
</html>