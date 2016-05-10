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
<title>真流量</title>
<link rel="stylesheet" href="/libs/amazeui/css/amazeui.min.css?v=20150723" />
<link rel="stylesheet" href="/libs/amazeui/css/admin.css?v=20150723" />
<link rel="stylesheet" href="/css/lanyunying.css" />
<!--[if lt IE 9]><script src="/libs/amazeui/js/amazeui.ie8polyfill.min.js?v=20150723"></script><![endif]-->
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
  <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<script src="/libs/jquery/jquery-1.9.1.min.js?v=20150723"></script>
<script src="/libs/jquery/jquery.validate.min.js?v=20150723"></script>
<script src="/libs/jquery/jquery.form.min.js?v=20150723"></script>
<script src="/libs/amazeui/js/amazeui.min.js?v=20150723"></script>

<script src="/js/lanyunying.js"></script>
<link rel="stylesheet" href="/js/kindeditor/themes/default/default.css" />
<script type="text/javascript" src="/js/kindeditor/kindeditor.js"></script>
<script type="text/javascript" src="/js/kindeditor/lang/zh_CN.js"></script>


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
<!-- 
    <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
      <li class="am-dropdown" data-am-dropdown><a href="/admin/user/signout"><span class="am-icon-power-off"></span>
          退出</a></li>
      <li class="am-dropdown" data-am-dropdown><a href="/admin/user/delPhoneLog"><span class="am-icon-power-off"></span>
          清理数据（不要点）</a></li>
      <li class="am-dropdown" data-am-dropdown><a href="/admin/user/searchJob"><span class="am-icon-power-off"></span>
          查询数据（不要点）</a></li>
      <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span class="am-icon-arrows-alt"></span>
          <span class="admin-fullText">开启全屏</span></a></li>
    </ul>
 -->
  </div>
</header>
  
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

<div class="admin-content">

  <div class="am-cf am-padding">
    <div class="am-fl am-cf">
      <strong class="am-text-primary am-text-lg">用户管理</strong>/<small>用户列表</small>
    </div>
  </div>

  <div class="am-g" style="margin-bottom: 10px;">
    <div class="am-u-sm-12">
      <form class="am-form-inline" role="form">
        <div class="am-form-group">
          <input type="text" id="userId" value="" class="am-form-field" placeholder="用户ID">
        </div>
        <div class="am-form-group">
          <input type="text" id="userName" value="" class="am-form-field" placeholder="用户名">
        </div>
        <div class="am-form-group">
          <input type="text" id="mobile" value="" class="am-form-field" placeholder="手机号">
        </div>
        <button type="button" class="am-btn am-btn-default" id="search">搜索</button>
      </form>
    </div>

  </div>
  <div class="am-u-sm-12">
    <form class="am-form">
      <table class="am-table am-table-striped am-table-hover" style="font-size: 1.4rem;">
        <thead>
          <tr class="am-success">
            <th>用户ID</th>
            <th>用户名</th>
            <th>手机号</th>
            <th>邮箱</th>
            <th>积分</th>
            <th>创建时间</th>
            <th>更新时间</th>
            <th>状态</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
          
            <tr data-id="3685">
              <th>3685</th>
              <td>hua1453041743</td>
              <td>15623259738</td>
              <td>1453041743@qq.com</td>
              <td>0</td>
              <td>  2016-05-10 11:42:36</td>
              <td>  2016-05-10 11:42:36</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3685" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3685" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3685" data-id="3685" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3684">
              <th>3684</th>
              <td>hylxh2013</td>
              <td>13958663437</td>
              <td>326003866@qq.com</td>
              <td>0</td>
              <td>  2016-05-10 11:24:01</td>
              <td>  2016-05-10 11:24:01</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3684" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3684" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3684" data-id="3684" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3683">
              <th>3683</th>
              <td>yangguangyefeng</td>
              <td>15818113037</td>
              <td>53824627@qq.com</td>
              <td>1200</td>
              <td>  2016-05-10 11:10:25</td>
              <td>  2016-05-10 11:27:40</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3683" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3683" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3683" data-id="3683" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3682">
              <th>3682</th>
              <td>唐家三少nts</td>
              <td>15919303208</td>
              <td>5042026@qq.com</td>
              <td>25900</td>
              <td>  2016-05-10 09:30:41</td>
              <td>  2016-05-10 11:15:56</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3682" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3682" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3682" data-id="3682" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3681">
              <th>3681</th>
              <td>hodis</td>
              <td>13370555888</td>
              <td>hodis@sina.com</td>
              <td>0</td>
              <td>  2016-05-10 06:45:34</td>
              <td>  2016-05-10 06:45:34</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3681" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3681" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3681" data-id="3681" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3680">
              <th>3680</th>
              <td>欣欣</td>
              <td>15573530139</td>
              <td>3235954842@qq.com</td>
              <td>0</td>
              <td>  2016-05-09 20:20:43</td>
              <td>  2016-05-09 20:20:43</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3680" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3680" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3680" data-id="3680" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3679">
              <th>3679</th>
              <td>407402611</td>
              <td>13973852323</td>
              <td>407402611@qq.com</td>
              <td>25740</td>
              <td>  2016-05-09 19:08:11</td>
              <td>  2016-05-10 01:30:00</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3679" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3679" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3679" data-id="3679" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3677">
              <th>3677</th>
              <td>2823881722</td>
              <td>13232371382</td>
              <td>2823881722@qq.com</td>
              <td>0</td>
              <td>  2016-05-09 16:03:38</td>
              <td>  2016-05-09 16:03:38</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3677" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3677" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3677" data-id="3677" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3676">
              <th>3676</th>
              <td>时尚男女衣橱</td>
              <td>18258831774</td>
              <td>872168064@qq.com</td>
              <td>0</td>
              <td>  2016-05-09 15:10:46</td>
              <td>  2016-05-09 15:10:46</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3676" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3676" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3676" data-id="3676" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3675">
              <th>3675</th>
              <td>cookie110</td>
              <td>18620031923</td>
              <td>3851446@qq.com</td>
              <td>0</td>
              <td>  2016-05-09 14:15:34</td>
              <td>  2016-05-09 14:15:34</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3675" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3675" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3675" data-id="3675" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3673">
              <th>3673</th>
              <td>xkshagua</td>
              <td>15101030972</td>
              <td>80323707@qq.com</td>
              <td>0</td>
              <td>  2016-05-09 12:27:35</td>
              <td>  2016-05-09 12:27:35</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3673" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3673" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3673" data-id="3673" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3670">
              <th>3670</th>
              <td>shuala</td>
              <td>18588580372</td>
              <td>39780683@qq.com</td>
              <td>0</td>
              <td>  2016-05-09 02:36:30</td>
              <td>  2016-05-09 02:36:30</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3670" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3670" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3670" data-id="3670" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3669">
              <th>3669</th>
              <td>guhuangduse</td>
              <td>18692245775</td>
              <td>371639697@qq.com</td>
              <td>0</td>
              <td>  2016-05-09 00:07:05</td>
              <td>  2016-05-09 00:07:05</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3669" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3669" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3669" data-id="3669" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3668">
              <th>3668</th>
              <td>635584334</td>
              <td>13713785174</td>
              <td>635584334@qq.com</td>
              <td>0</td>
              <td>  2016-05-08 23:56:04</td>
              <td>  2016-05-08 23:56:04</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3668" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3668" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3668" data-id="3668" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3666">
              <th>3666</th>
              <td>zxc123</td>
              <td>13357999666</td>
              <td>2811816818@qq.cim</td>
              <td>0</td>
              <td>  2016-05-08 21:32:12</td>
              <td>  2016-05-08 21:32:12</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3666" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3666" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3666" data-id="3666" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3665">
              <th>3665</th>
              <td>xzllwei</td>
              <td>15875430555</td>
              <td>78041136@qq.com</td>
              <td>0</td>
              <td>  2016-05-08 21:27:12</td>
              <td>  2016-05-08 21:27:12</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3665" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3665" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3665" data-id="3665" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3664">
              <th>3664</th>
              <td>mmaspuer</td>
              <td>18050388750</td>
              <td>934289113@qq.com</td>
              <td>1110</td>
              <td>  2016-05-08 21:13:53</td>
              <td>  2016-05-09 23:21:02</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3664" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3664" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3664" data-id="3664" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3663">
              <th>3663</th>
              <td>434553210</td>
              <td>15601976266</td>
              <td>434553210@qq.com</td>
              <td>0</td>
              <td>  2016-05-08 21:04:04</td>
              <td>  2016-05-08 21:04:04</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3663" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3663" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3663" data-id="3663" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3662">
              <th>3662</th>
              <td>欧阳</td>
              <td>18357632489</td>
              <td>642569708@qq.com</td>
              <td>0</td>
              <td>  2016-05-08 19:29:40</td>
              <td>  2016-05-08 19:29:40</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3662" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3662" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3662" data-id="3662" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
            <tr data-id="3660">
              <th>3660</th>
              <td>zhanghuayu</td>
              <td>13735567500</td>
              <td>454630829@qq.com</td>
              <td>0</td>
              <td>  2016-05-08 17:47:00</td>
              <td>  2016-05-08 17:47:00</td>
              <td>
                  
                  正常
                </td>
              
                <td><a href="/admin/user/recharge?id=3660" class="am-badge am-badge-primary">充值/扣款</a> 
                    <a data-id="3660" class="am-badge am-badge-primary deleteUser">删除</a>
                  <a href="/admin/user/doLogin?id=3660" data-id="3660" class="am-badge am-badge-primary">登录</a>
                  </td>
              
            </tr>
          
        </tbody>
      </table>
      <div class="am-cf">
        共 1992 条记录
        <div class="am-fr">
          <ul class="am-pagination">
            <li><a href="/admin/user?page=1">首页</a></li>
            
              
                
                  <li class="am-active"><a href="#">1</a></li>
                
                
              
            
              
                
                
                  <li><a href="/admin/user?page=2">2</a></li>
                
              
            
              
                
                
                  <li><a href="/admin/user?page=3">3</a></li>
                
              
            
              
                
                
                  <li><a href="/admin/user?page=4">4</a></li>
                
              
            
            <li><a href="/admin/user?page=100">尾页</a></li>
          </ul>
        </div>
      </div>
    </form>
  </div>
</div>

<script>
  $(function() {
    $("#search").click(function() {
      var name = $("#userName").val();
      var id = $("#userId").val();
      var mobile = $("#mobile").val();
      location.href = "/admin/user?page=1&name=" + name + "&id=" + id + "&mobile=" + mobile;
    });

    $(document).on("click", ".deleteUser", function() {
      if (confirm("你确定要删除吗？")) {
        $.getJSON('/admin/user/delete', {
          id : $(this).attr("data-id")
        }, function(resp) {
          if (resp && resp.ec == 0) {
            location.href = '/admin/user';
          } else {
            Message.error('删除失败！', true);
          }
        });
      }
    });

    $(".setproxy").click(function() {
      if (confirm("你确定要将此用户设为代理吗？")) {
        $.getJSON('/admin/user/proxy', {
          id : $(this).attr("data-id")
        }, function(resp) {
          if (resp && resp.ec == 0) {
            	location.href = '/admin/user';
          } else {
            Message.error('操作失败！', true);
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
