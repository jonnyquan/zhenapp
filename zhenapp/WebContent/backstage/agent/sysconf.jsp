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
<div class="am-cf admin-main">
      <!-- sidebar start -->
      <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
        <div class=" admin-offcanvas-bar">
          <ul class="am-list admin-sidebar-list">
            <li class="admin-parent"><a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span
                class="am-icon-user"></span>用户管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
              <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
                <li><a href="${pageContext.request.contextPath}/user/findUserByPageandRole" class="am-cf"><span class="am-icon-list"></span>用户列表</a></li>
                <li><a href="${pageContext.request.contextPath}/points/responseconsumeagent"><span class="am-icon-usd"></span>充值记录</a></li>
                <li><a href="${pageContext.request.contextPath}/points/responserecordspointsagent"><span class="am-icon-money"></span>资金记录</a></li>
              </ul></li>
            <li><a href="${pageContext.request.contextPath}/task/responsetaskmanageagent"><span class="am-icon-pencil-square-o"></span>订单查询</a></li>
            <li><a href="${pageContext.request.contextPath}/combo/findComboByagent"><span class="am-icon-cubes"></span> 套餐信息</a></li>
            <li><a href="${pageContext.request.contextPath}/price/findPriceByAgentid"><span class="am-icon-puzzle-piece"></span>系统配置</a></li>
            <li><a href="${pageContext.request.contextPath}/web/findWebByAgentid"><span class="am-icon-puzzle-piece"></span>设置登录页面</a></li>
            <li><a href="${pageContext.request.contextPath}/user/findPointsByUsernick"><span class="am-icon-heart"></span>剩余积分</a></li>
            <li><a href="${pageContext.request.contextPath}/datacount/findDataByDateAndTasktype"><span class="am-icon-bar-chart"></span>数据统计</a></li>
          </ul>
        </div>
      </div>
<!-- sidebar end -->
      <div id="module-head"></div>
      
  <meta name="viewport" content="width=device-width, initial-scale=1">

<div class="admin-content">

  <div class="am-cf am-padding">
    <div class="am-fl am-cf">
      <strong class="am-text-primary am-text-lg">系统配置</strong>
    </div>
  </div>
  <form class="am-form am-form-horizontal am-padding" id="syssconf-form" action="${pageContext.request.contextPath}/price/updatePriceByAgentid" method="post">
    <input type="hidden" value="" name="id">
    
      <div class="am-form-group">
        <label for="cart_price" class="am-u-sm-4 am-form-label">购物车单价</label>
        <div class="am-u-sm-4">
          <input type="text" name="pricecounts2" placeholder="购物车单价" value="${tPriceInfoCustom.pricecounts2 }">
        </div>
        <div class="am-u-sm-2" style="padding: 0px;">积分/个</div>
      </div>
      
      <div class="am-form-group">
        <label for="collect_price" class="am-u-sm-4 am-form-label">收藏单价</label>
        <div class="am-u-sm-4">
          <input type="text" name="pricecounts3" placeholder="收藏单价" value="${tPriceInfoCustom.pricecounts3 }">
        </div>
        <div class="am-u-sm-2" style="padding: 0px;">积分/个</div>
      </div>
      
      <div class="am-form-group">
        <label for="train_price" class="am-u-sm-4 am-form-label">直通车单价</label>
        <div class="am-u-sm-4">
          <input type="text" name="pricecounts4" placeholder="直通车单价" value="${tPriceInfoCustom.pricecounts4 }">
        </div>
        <div class="am-u-sm-2" style="padding: 0px;">积分/个</div>
      </div>
      
      <div class="am-form-group">
        <label for="flow_price" class="am-u-sm-4 am-form-label">流量单价</label>
        <div class="am-u-sm-4">
          <input type="text" name="pricecounts1" placeholder="流量单价" value="${tPriceInfoCustom.pricecounts1 }">
        </div>
        <div class="am-u-sm-2" style="padding: 0px;">积分/个</div>
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
    
    jQuery.validator.addMethod("isprice", function(value, element) {
      var result = true;
      var vals = $("input[name='confval']");
      for (var i = 0; i < vals.length; i++) {
        if(vals[i].value == ''){
          result = false;
        }
      }
      return result;
    }, "每组对应值不能为空。");

    $('#syssconf-form').validate({
      rules : {
        confval : {
          required : true,
          isprice : true
        }
      },
      messages : {
        confval : {
          required : "每组对应值不能为空。",
        }
      },
      errorPlacement: function(error, element) { 
        $("#error").empty();
        error.appendTo("#error"); 
   		},
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