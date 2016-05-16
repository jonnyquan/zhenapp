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
<title>公告管理</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/agent/pagematter/amazeui.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/agent/pagematter/admin.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/agent/pagematter/lanyunying.css" />
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/jquery-1.9.1.min.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/jquery.form.min.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/backstage/agent/pagematter/lanyunying.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/agent/pagematter/default.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/backstage/agent/pagematter/kindeditor/kindeditor-all.js"></script>
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

<script type="text/javascript">
	var editor;
	KindEditor.ready(function(K) {
		editor = K.create('textarea[name="content"]', {
			uploadJson : '/admin/image/upload',
			fileManagerJson : '/admin/image/manage',
			allowFileManager : true,
			afterChange : function() {
				this.sync();
			}
		});
	});
</script>
<div class="admin-content">

  <div class="am-cf am-padding">
    <div class="am-fl am-cf">
      <strong class="am-text-primary am-text-lg">添加公告</strong>
    </div>
  </div>

  <div class="am-g">
    <!-- 表单 -->
    <div class="am-u-sm-10">
      <form class="am-form am-form-horizontal" id="publisFlow" action="${pageContext.request.contextPath}/note/updatenote" method="post">
        <!-- am-form-group 的基础上添加了 am-form-group-sm -->
         <input type="hidden" value="${tNoteInfoCustom.noteid}" name="noteid" id="id" class="am-form-field" >
        <div class="am-form-group am-form-group-sm">
          <label for="kwd" class="am-u-sm-2 am-form-label">标题</label>
          <div class="am-u-sm-10">
            <input type="text" name="notename" value="${tNoteInfoCustom.notename }" id="title" class="am-form-field" placeholder="输入你的标题">
          </div>
        </div>
        <div class="am-form-group am-form-group-sm">
          <label for="contentType"  class="am-u-sm-2 am-form-label">类型</label>
          <div class="am-u-sm-10">
		      <select name="notetype" id="contentType">
		       <option value="2"  >常见问题</option>
		       <option value="3"  >新手教程</option>
		       <option value="5"  >优势与保障</option>
		       <option value="6"   selected="selected">关于发布流量</option>
		       <option value="7"  >关于购买点币</option>
		       <option value="8"  >关于账户充值</option>
		       <option value="9"  >关于注册</option>
		       <option value="10"  >关于登录</option>
		       <option value="11"  >注册登录</option>
		       <option value="12"  >发布流量</option>
		       <option value="14"  >网站公告</option>
		       <option value="17"  >我们的流量</option>
		      </select>
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
            <button type="submit" class="am-btn am-btn-primary">提交</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
<script>
$(function(){
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
                window.location.href = '${pageContext.request.contextPath}/note/findnoticeList';
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
