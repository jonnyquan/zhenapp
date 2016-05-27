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
<title>登录页设置</title>
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
          
        </div>
      </div>
<!-- sidebar end -->
      <div id="module-head"></div>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/jquery.ui.widget.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/jquery.iframe-transport.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/proxy.js"></script>
<div class="admin-content">
  <div class="am-cf am-padding">
    <div class="am-fl am-cf">
      <strong class="am-text-primary am-text-lg">代理设置登录页面</strong>
    </div>
  </div>
<form id="formdata" method="post">
  <input type="hidden" name="agentid" id="agentid" value="${tAgentInfoCustom.agentid}" />
  <input type="hidden" name="webid" id="webid" value="${tWebInfoCustom.webid}" />
  <table class="am-table">
  	<tr>
  		<td width="150px">
  			<label>网站名称</label>
  		</td>
  		<td>
  			<input type="text" name="agentname" id="agentname" placeholder="网站名称" class='form-control' value="${tAgentInfoCustom.agentname }" />
  		</td>
  	</tr>
  	<tr>
  		<td width="150px">
  			<label>网站联系人</label>
  		</td>
  		<td>
  			<input type="text" name="agentperson" id="agentperson" placeholder="网站联系人" class='form-control' value="${tAgentInfoCustom.agentperson }" />
  		</td>
  	</tr>
  	<tr>
  		<td width="150px">
  			<label>网站联系方式</label>
  		</td>
  		<td>
  			<input type="text" name="agentphone" id="agentphone" placeholder="网站联系方式" class='form-control' value="${tAgentInfoCustom.agentphone }" />
  		</td>
  	</tr>
  	<tr>
  		<td width="150px">
  			<label>网站地址</label>
  		</td>
  		<td>
  			<input type="text" id="url" name="url" placeholder="网站地址" class='form-control' value="${tAgentInfoCustom.url }">(如：http://www.baodu.com)
  		</td>
  	</tr>
  	<tr>
  		<td width="150px">
  			<label>备案信息</label>
  		</td>
  		<td>
  			<input type="text" id="record" name="record" placeholder="备案信息" class='form-control' value="${tWebInfoCustom.record}">(如:Copyright (c) 2015 zhenapp.cn Inc. All Rights. 浙ICP备140452118号-5)
  		</td>
  	</tr>
  	<tr>
  		<td width="150px">
  			<label>支付宝账号</label>
  		</td>
  		<td>
  			<input type="text" id="alipay" name="alipay" placeholder="支付宝账号" class='form-control' value="${tWebInfoCustom.alipay}">(收款支付宝)
  		</td>
  	</tr>
  	<tr>
  		<td width="150px">
  			<label>qq号</label>
  		</td>
  		<td>
  			<input type="text" id="qq" name="qq" placeholder="qq号" class='form-control' value="${tWebInfoCustom.qq}">
  		</td>
  	</tr>
  	<tr>
  		<td width="150px">
  			<label>qq群</label>
  		</td>
  		<td>
  			<input type="text" id="qqgroup" name="qqgroup" placeholder="qq群" class='form-control' value="${tWebInfoCustom.qqgroup}">
  		</td>
  	</tr>
  	<tr>
  		<td width="150px">
  			<label>微信号</label>
  		</td>
  		<td>
  			<input type="text" id="wechat" name="wechat" placeholder="微信号" class='form-control' value="${tWebInfoCustom.wechat}">
  		</td>
  	</tr>
  	<tr>
  		<td width="150px">
  			<label>网站logo(280*80)</label>
  		</td>
  		<td>
  		  <img src="${pageContext.request.contextPath}/webimg/${tWebInfoCustom.logo}" class="img_u" height="80px" width="280px">
          <input type="hidden" class="imgUrl" id="logo" name="logo" value="${tWebInfoCustom.logo}"> 
          <input type="file" class="fileupload" name="image_file">
          <div class="container" style="width: 280px;"></div>
  		</td>
  	</tr>
  	<tr>
  		<td width="150px">
  			<label>客服背景图01</label>
  		</td>
  		<td>
  		  <img src="${pageContext.request.contextPath}/webimg/${tWebInfoCustom.bg01}" class="img_u" height="437px" width="282px">
          <input type="hidden" class="imgUrl" id="bg01" name="bg01" value="${tWebInfoCustom.bg01}"> 
          <input type="file" class="fileupload" name="image_file">
          <div class="container" style="width: 280px;"></div>
  		</td>
  	</tr>
  	<tr>
  		<td width="150px">
  			<label>客服背景图02</label>
  		</td>
  		<td>
  		  <img src="${pageContext.request.contextPath}/webimg/${tWebInfoCustom.bg02}" class="img_u" height="80px" width="280px">
          <input type="hidden" class="imgUrl" id="bg02" name="bg02" value="${tWebInfoCustom.bg02}"> 
          <input type="file" class="fileupload" name="image_file">
          <div class="container" style="width: 280px;"></div>
  		</td>
  	</tr>
  	
  	<tr>
  		<td width="150px">
  			<label>第一张轮播图</label>
  		</td>
  		<td>
  		  <img src="${pageContext.request.contextPath}/webimg/${tWebInfoCustom.carousel01}" class="img_u" height="50%" width="100%">
          <input type="hidden" class="imgUrl" id="carousel01" name="carousel01" value="${tWebInfoCustom.carousel01}"> 
          <input type="file" class="fileupload" name="image_file">
          <div class="container"></div>
  		</td>
  	</tr>
  	<tr>
  		<td width="150px">
  			<label>第二张轮播图</label>
  		</td>
  		<td>
  		  <img src="${pageContext.request.contextPath}/webimg/${tWebInfoCustom.carousel02}" class="img_u" height="50%" width="100%">
          <input type="hidden" class="imgUrl" id="carousel02" name="carousel02" value="${tWebInfoCustom.carousel02}"> 
          <input type="file" class="fileupload" name="image_file">
          <div class="container"></div>
  		</td>
  	</tr>
  	<tr>
  		<td width="150px">
  			<label>第三张轮播图</label>
  		</td>
  		<td>
  		  <img src="${pageContext.request.contextPath}/webimg/${tWebInfoCustom.carousel03}" class="img_u" height="50%" width="100%">
          <input type="hidden" class="imgUrl" id="carousel03" name="carousel03" value="${tWebInfoCustom.carousel03}"> 
          <input type="file" class="fileupload" name="image_file">
          <div class="container"></div>
  		</td>
  	</tr>
  	<tr>
  		<td colspan="2" style="padding-left: 200px;">
  			<input type="button" id="saveInfo" class="btn btn-info" value="提交" />
  		</td>
  	</tr>
  </table>
 </form>
  <script>
      $(function() {
    		$(".admin-offcanvas-bar").load("${pageContext.request.contextPath}/backstage/admin/adminmenu.jsp");
    	  
        $("#saveInfo").click(function() {
          $.ajax({
            type : "post",
            dataType : "json",
            url : "${pageContext.request.contextPath}/web/agentAndwebSave",
            data : {
            	agentid : $("#agentid").val(),
            	webid : $("#webid").val(),
            	agentname : $("#agentname").val(),
            	agentperson : $("#agentperson").val(),
            	agentphone : $("#agentphone").val(),
            	url : $("#url").val(),
            	record : $("#record").val(),
            	alipay : $("#alipay").val(),
            	qq : $("#qq").val(),
            	qqgroup : $("#qqgroup").val(),
            	wechat : $("#wechat").val(),
            	logo : $("#logo").val(),
            	bg01 : $("#bg01").val(),
            	bg02 : $("#bg02").val(),
            	carousel01 : $("#carousel01").val(),
            	carousel02 : $("#carousel02").val(),
            	carousel03 : $("#carousel03").val()
            },
            success : function(resp) {
              if (resp && resp.ec == 0) {
                Message.info('保存成功：', true);
                setTimeout(function() {
                  window.location.href = location;
                }, 2000);
              } else {
                Message.error('保存失败,' + resp.em, false);
              }
            },
            error : function(XMLHttpRequest, textStatus, errorThrown) {
              Message.error('保存失败！');
            }
          });
        });
        $('.fileupload').fileupload(
            {
              url : '/api/image/save',
              dataType : 'json',
              add : function(e, data) {
                data.submit();
              },
              done : function(e, data) {
                var resp = data.result;
                if (resp && resp.ec == 0) {
                  $(this).parent().find('.imgUrl').val(resp.rst);
                  $(this).parent().find('.img_u').remove();
                  $(this).next().append(
                      '<img src="http://daibile.b0.upaiyun.com/' + resp.rst + '" height="40%" width="100%">');
                  $(this).remove();
                }
              },
              progressall : function(e, data) {
                // update progress.
                var progress = parseInt(data.loaded / data.total * 100, 10);
                $('.container').css('width', progress + '%');
              }
            }).prop('disabled', !$.support.fileInput).parent().addClass($.support.fileInput ? undefined : 'disabled');
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