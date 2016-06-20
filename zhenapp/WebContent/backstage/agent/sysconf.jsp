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
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1" />
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
  <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<title>${tAgentInfoCustom.agentname} -- 价格维护</title>
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
    <strong>${tAgentInfoCustom.agentname}</strong> <small>后台管理系统</small>
  </div>
  <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
    data-am-collapse="{target: '#topbar-collapse'}">
    <span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
  </button>
  <div class="am-collapse am-topbar-collapse" id="topbar-collapse"> 
    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li class="am-dropdown" data-am-dropdown>
    	<a href="${pageContext.request.contextPath}/user/findUserByPageandRole">
    		积分：${points}
    	</a>
      </li>  
      <li class="am-dropdown" data-am-dropdown>
      </li>
      <li class="am-dropdown" data-am-dropdown>
      	<a href="${pageContext.request.contextPath}/user/authlogout">
      		<span class="am-icon-power-off"></span>退出
      	</a>
      </li>
    </ul>
  </div>
</header>
<div class="am-cf admin-main">
     <div id="menu" class="admin-sidebar am-offcanvas"></div>

      <div id="module-head"></div>      
<meta name="viewport" content="width=device-width, initial-scale=1">
<div class="admin-content">

  <div class="am-cf am-padding">
    <div class="am-fl am-cf">
      <strong class="am-text-primary am-text-lg">价格维护</strong>
    </div>
  </div>
  <form class="am-form am-form-horizontal am-padding" id="syssconf-form" action="${pageContext.request.contextPath}/price/updatePriceByAgentid" method="post">
    <input type="hidden" value="" name="id">
      <div class="am-form-group">
        <label for="flow_price" class="am-u-sm-4 am-form-label">流量单价</label>
        <div class="am-u-sm-4">
          <input type="text" name="pricecounts1" placeholder="流量单价" value="${tPriceInfoCustom.pricecounts1 }">
        </div>
        <div class="am-u-sm-2" style="padding: 0px;">积分/个</div>
      </div>
      
      <div class="am-form-group">
        <label for="cart_price" class="am-u-sm-4 am-form-label">购物车单价(流量)</label>
        <div class="am-u-sm-4">
          <input type="text" name="pricecounts2" placeholder="购物车单价" value="${tPriceInfoCustom.pricecounts2 }">
        </div>
        <div class="am-u-sm-2" style="padding: 0px;">积分/个</div>
      </div>
      
      <div class="am-form-group">
        <label for="collect_price" class="am-u-sm-4 am-form-label">收藏单价(流量)</label>
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
        <label for="cart_price" class="am-u-sm-4 am-form-label">购物车单价(直通车)</label>
        <div class="am-u-sm-4">
          <input type="text" name="pricecounts5" placeholder="购物车单价(直通车)" value="${tPriceInfoCustom.pricecounts5 }">
        </div>
        <div class="am-u-sm-2" style="padding: 0px;">积分/个</div>
      </div>
      
      <div class="am-form-group">
        <label for="collect_price" class="am-u-sm-4 am-form-label">收藏单价(直通车)</label>
        <div class="am-u-sm-4">
          <input type="text" name="pricecounts6" placeholder="收藏单价(直通车)" value="${tPriceInfoCustom.pricecounts6 }">
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
	  $("#menu").load("${pageContext.request.contextPath}/backstage/agent/menu.jsp");
	  
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