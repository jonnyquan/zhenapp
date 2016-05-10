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
<title>登录页设置</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/myPage.css">
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
<div class="am-cf admin-main">
      <!-- sidebar start -->
      <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
        <div class=" admin-offcanvas-bar">
          <ul class="am-list admin-sidebar-list">
            <li><a href="/admin"><span class="am-icon-home"></span> 首页</a></li>
            <li class="admin-parent"><a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span
                class="am-icon-user"></span>用户管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
              <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
                <li><a href="/admin/user" class="am-cf"><span class="am-icon-list"></span>用户列表</a></li>
                <li><a href="/admin/user/listRecharge"><span class="am-icon-usd"></span>充值记录</a></li>
                <li><a href="/admin/user/listCoin"><span class="am-icon-money"></span>资金记录</a></li>
              </ul></li>
            <li><a href="/admin/user/taskList"><span class="am-icon-pencil-square-o"></span>订单查询</a></li>
            <li><a href="/admin/combo"><span class="am-icon-cubes"></span> 套餐信息</a></li>

            
            
              <li><a href="/admin/sysconf"><span class="am-icon-puzzle-piece"></span>系统配置</a></li>
              <li><a href="/admin/proxy/setting"><span class="am-icon-puzzle-piece"></span>设置登录页面</a></li>
              <li><a href="/admin/proxy/points"><span class="am-icon-heart"></span>剩余积分</a></li>
              <li><a href="/admin/stat"><span class="am-icon-bar-chart"></span>数据统计</a></li>
            

          </ul>
        </div>
      </div>
<!-- sidebar end -->
      <div id="module-head"></div>
      
  <meta name="viewport" content="width=device-width, initial-scale=1">

<script src="/libs/jquery/jquery.ui.widget.js"></script>
<script src="/libs/jquery/jquery.iframe-transport.js"></script>
<script src="/libs/jquery/jquery.fileupload.js"></script>
<script src="/js/proxy.js"></script>
<div class="admin-content">
  <div class="am-cf am-padding">
    <div class="am-fl am-cf">
      <strong class="am-text-primary am-text-lg">代理设置登录页面</strong>
    </div>
  </div>

  <div class="am-g">
    <form class="am-form am-form-horizontal am-padding" id="proxy-form" action="/admin/proxy/save" method="post">
      <input type="hidden" value="" name="id" id="proxyId">
      <div class="am-form-group">
        <label for="user-name" class="am-u-sm-3 am-form-label">网站名称</label>
        <div class="am-u-sm-7">
          <input type="text" id="name" name="name" placeholder="网站名称" value="${tAgentInfoCustom.agentname }">
        </div>
      </div>
      <div class="am-form-group">
        <label for="user-name" class="am-u-sm-3 am-form-label">域名</label>
        <div class="am-u-sm-7">
          <input type="text" id="domain" name="domain" placeholder="域名" value="${tAgentInfoCustom.agentwww }">(如：http://www.baodu.com)
        </div>
      </div>
      <div class="am-form-group">
        <label for="user-name" class="am-u-sm-3 am-form-label">网站地址</label>
        <div class="am-u-sm-7">
          <input type="text" id="url" name="url" placeholder="网站地址" value="${tAgentInfoCustom.agenthttp }">(如：http://www.baodu.com)
        </div>
      </div>

      <div class="am-form-group">
        <label for="email" class="am-u-sm-3 am-form-label">QQ号</label>
        <div class="am-u-sm-7">
          <input type="text" id="qq" name="qq" placeholder="QQ" value="${tWebInfoCustom.qq }">
        </div>
      </div>

      <div class="am-form-group">
        <label for="user-phone" class="am-u-sm-3 am-form-label">QQ群号</label>
        <div class="am-u-sm-7">
          <input type="text" id="qq_group" name="qq_group" placeholder="QQ群" value="${tWebInfoCustom.qqgroup } ">
        </div>
      </div>
      <div class="am-form-group">
        <label for="user-phone" class="am-u-sm-3 am-form-label">QQ群代码</label>
        <div class="am-u-sm-7">
          <input type="text" id="qq_group_url" name="qq_group_url" placeholder="${tWebInfoCustom.qqgroup }">
        </div>
      </div>
      <div class="am-form-group">
        <label for="user-phone" class="am-u-sm-3 am-form-label">微信</label>
        <div class="am-u-sm-7">
          <input type="text" id="weixin" name="weixin" placeholder="微信" value="${tWebInfoCustom.wechat }">
        </div>
      </div>
      <div class="am-form-group">
        <label for="user-name" class="am-u-sm-3 am-form-label">网站logo</label>
        <div class="am-u-sm-7">
          
            <img src="http://daibile.b0.upaiyun.com//data/repo/product/1457241117855TWVBJ.png" class="img_u" height="40%" width="100%">
          
          <input type="hidden" class="imgUrl" id="logo" name="logo"> <input type="file" class="fileupload"
            name="image_file">(宽：150px x 高:45px)
          <div class="container"></div>
        </div>
      </div>
      <div class="am-form-group">
        <label for="email" class="am-u-sm-3 am-form-label">顶部广告图</label>
        <div class="am-u-sm-7">
          
            <img src="http://daibile.b0.upaiyun.com//data/repo/product/1456065355145HAO3R.png" class="img_u" height="40%" width="100%">
          
          <input type="hidden" class="imgUrl" id="ad_first" name="ad_first"> <input type="file"
            class="fileupload" name="image_file">(宽：1350px x 高:90px)
          <div class="container"></div>
        </div>
      </div>
      <div class="am-form-group">
        <label for="user-phone" class="am-u-sm-3 am-form-label">客服背景图</label>
        <div class="am-u-sm-7">
          
            <img src="http://daibile.b0.upaiyun.com//data/repo/product/1457240199780E2EET.png"  class="img_u" style="height: 40%;">
          
          <input type="hidden" class="imgUrl" id="left_image" name="left_image"> <input type="file"
            class="fileupload" name="image_file"><a target="_blank" href="http://daibile.b0.upaiyun.com//data/repo/product/1453735179431QZM7B.gif">参考</a>
          <div class="container"></div>
        </div>
      </div>
      <div class="am-form-group">
        <label for="image" class="am-u-sm-3 am-form-label">轮播图</label>
        <div class="am-u-sm-7">
          <div id="image-list">
            <div class="am-alert am-alert-secondary" data-am-alert>
              
                <img src="http://daibile.b0.upaiyun.com//data/repo/product/1456065374346YTURV.jpg" class="img_u" height="40%" width="100%">
              
              <input type="hidden" class="imgUrl" id="shuffling_first" name="shuffling_first"> <input
                type="file" class="fileupload" name="image_file">
              <div class="container"></div>
            </div>
            <div class="am-alert am-alert-secondary" data-am-alert>
              
                <img src="http://daibile.b0.upaiyun.com//data/repo/product/14560653808453LPOC.jpg" class="img_u" height="40%" width="100%">
              
              <input type="hidden" class="imgUrl" id="shuffling_sec" name="shuffling_sec"> <input type="file"
                class="fileupload" name="image_file">
              <div class="container"></div>
            </div>
            <div class="am-alert am-alert-secondary" data-am-alert>
              
                <img src="http://daibile.b0.upaiyun.com//data/repo/product/1456065386954S8KMJ.jpg"  class="img_u" height="40%" width="100%">
              
              <input type="hidden" class="imgUrl" id="shuffling_third" name="shuffling_third"> <input
                type="file" class="fileupload" name="image_file">(宽：1749px x 高:393px)
              <div class="container"></div>
            </div>
          </div>
        </div>
      </div>
      <div class="am-form-group">
        <label for="user-phone" class="am-u-sm-3 am-form-label">广告图</label>
        <div class="am-u-sm-7">
          <img src="http://daibile.b0.upaiyun.com//data/repo/product/1457241094225Q7BUC.jpg" height="40%" class="img_u" width="100%"> <input type="hidden"
            class="imgUrl" id="ad_sec" name="ad_sec"> <input type="file" class="fileupload" name="image_file">(宽：1749px x 高:不限)
          <div class="container"></div>
        </div>
      </div>
      <div class="am-form-group">
        <label for="user-phone" class="am-u-sm-3 am-form-label">备案信息</label>
        <div class="am-u-sm-7">
          <input type="text" id="record" name="record" placeholder="备案信息" value="Copyright (c) 2015 zhenapp.cn Inc. All Rights. 浙ICP备140452118号-5">(如:Copyright (c) 2015 zhenapp.cn Inc. All Rights. 浙ICP备140452118号-5)
        </div>
      </div>
      <div class="am-form-group">
        <label for="user-phone" class="am-u-sm-3 am-form-label">支付宝账号</label>
        <div class="am-u-sm-7">
          <input type="text" id="alipay" name="alipay" placeholder="支付宝账号" value="15268671339">(收款支付宝)
        </div>
      </div>
      <div class="am-form-group">
        <div class="am-u-sm-8 am-u-sm-push-3">
          <button type="button" id="saveInfo" class="am-btn am-btn-primary">
            <i class="am-icon-check"></i>提交
          </button>
        </div>
      </div>
    </form>
  </div>
  <script>
      $(function() {
        $("#saveInfo").click(function() {
          $.ajax({
            type : "post",
            dataType : "json",
            url : "/admin/proxy/save",
            data : {
              id : $("#proxyId").val(),
              name : $("#name").val(),
              domain : $("#domain").val(),
              url : $("#url").val(),
              qq : $("#qq").val(),
              qq_group : $("#qq_group").val(),
              qq_group_url : $("#qq_group_url").val(),
              weixin : $("#weixin").val(),
              logo : $("#logo").val(),
              record : $("#record").val(),
              alipay : $("#alipay").val(),
              ad_first : $("#ad_first").val(),
              left_image : $("#left_image").val(),
              ad_sec : $("#ad_sec").val(),
              shuffling_first : $("#shuffling_first").val(),
              shuffling_sec : $("#shuffling_sec").val(),
              shuffling_third : $("#shuffling_third").val()
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