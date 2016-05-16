<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
        <div class=" admin-offcanvas-bar">
           <ul class="am-list admin-sidebar-list">
            <!--  <li><a href="/admin"><span class="am-icon-home"></span> 首页</a></li>-->
            <li class="admin-parent"><a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span
                class="am-icon-user"></span>用户管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
              <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
                <li><a href="${pageContext.request.contextPath}/user/findUserByPageAndAdmin" class="am-cf"><span class="am-icon-list"></span>用户列表</a></li>
                <li><a href="${pageContext.request.contextPath}/points/responseconsumeadmin"><span class="am-icon-usd"></span>充值记录</a></li>
                <li><a href="${pageContext.request.contextPath}/points/responserecordspointsadmin"><span class="am-icon-money"></span>资金记录</a></li>
              </ul></li>
            <li><a href="${pageContext.request.contextPath}/task/responsetaskmanageadmin"><span class="am-icon-pencil-square-o"></span>订单查询</a></li>
            <li><a href="${pageContext.request.contextPath}/combo/findComboByadmin"><span class="am-icon-cubes"></span> 套餐信息</a></li>

            
             <li><a href="${pageContext.request.contextPath}/task/findproblemtaskadmin"><span class="am-icon-mobile"></span> 有问题任务查询</a></li>
             <li><a href="${pageContext.request.contextPath}/task/findtaskdetaillist"><span class="am-icon-mobile"></span> 任务详情</a></li> 
             <li><a href="${pageContext.request.contextPath}/task/findtasklocklist"><span class="am-icon-mobile"></span> 卡机任务查询</a></li> 
 			<!--   <li><a href="/admin/phoneTask/getMessage"><span class="am-icon-mobile"></span> 淘宝ID查询</a></li>
              <li><a href="/admin/phoneTask/problem"><span class="am-icon-mobile"></span> 手机状态信息</a></li>
              <li><a href="/admin/findProblemAssignKeyWords"><span class="am-icon-search"></span>问题宝贝查询</a></li>
              <li><a href="/admin/findProblemKeyWords"><span class="am-icon-search"></span>问题宝贝查询(简单)</a></li> -->
              <li><a href="${pageContext.request.contextPath}/note/findnoticeList"><span class="am-icon-bullhorn"></span> 公告管理</a></li>
              <li><a href="${pageContext.request.contextPath}/sysconf/responsesyssetting"><span class="am-icon-cog"></span>系统设置</a></li>
              <li><a href="${pageContext.request.contextPath}/agent/responseagentmanage"><span class="am-icon-sitemap"></span>代理管理</a></li>
              <li><a href="${pageContext.request.contextPath}/datacount/responsedatasumadmin"><span class="am-icon-bar-chart"></span>数据统计</a></li>
               <li class="admin-parent"><a class="am-cf" data-am-collapse="{target: '#collapse-navo'}"><span
                class="am-icon-sign-out"></span>其他 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
              <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-navo">
                <li><a href="${pageContext.request.contextPath}/script/responsescriptmanage" class="am-cf"><span class="am-icon-arrow-circle-up"></span>上传脚本</a></li>
                <li><a href="${pageContext.request.contextPath}/tbaoccount/responsetbaoccount"><span class="am-icon-upload"></span>上传淘宝账户</a></li>
                <li><a href="${pageContext.request.contextPath}/tbaoccount/responsetaobaoid"><span class="am-icon-eye"></span>查看淘宝账户信息</a></li>
              </ul></li>
          </ul>
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
        <label for="phone_tag" class="am-u-sm-4 am-form-label">手机标记</label>
        <div class="am-u-sm-4">
          <input type="text" name="sysconfvalue2" value="${tSysconfInfoCustom.sysconfvalue2}">
        </div>
      </div>
      
       <div class="am-form-group">
        <label for="min_account" class="am-u-sm-4 am-form-label">每个小号库最小账号数量</label>
        <div class="am-u-sm-4">
          <input type="text" name="sysconfvalue3" value="${tSysconfInfoCustom.sysconfvalue3}">
        </div>
        <div class="am-u-sm-2" style="padding: 0px;">个</div>
      </div>
      
       <div class="am-form-group">
        <label for="error_num" class="am-u-sm-4 am-form-label">宝贝错误次数（超过就终止）</label>
        <div class="am-u-sm-4">
          <input type="text" name="sysconfvalue4" value="${tSysconfInfoCustom.sysconfvalue4}">
        </div>
        <div class="am-u-sm-2" style="padding: 0px;">个</div>
      </div>
      
       <!--  <div class="am-form-group">
        <label for="end_hour" class="am-u-sm-4 am-form-label">当天平均模式最后结束时间</label>
        <div class="am-u-sm-4">
          <input type="text" name="sysconfvalue5" value="${tSysconfInfoCustom.sysconfvalue5}">
        </div>
        <div class="am-u-sm-2" style="padding: 0px;">点</div>
      </div>-->
      
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