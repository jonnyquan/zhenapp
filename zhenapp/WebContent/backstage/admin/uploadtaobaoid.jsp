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
<title>上传淘宝账号</title>
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
      <strong class="am-text-primary am-text-lg">上传脚本</strong>
    </div>
  </div>

 <div class="am-u-sm-12">
	<form action="${pageContext.request.contextPath}/tbaoccount/uploadTbaccount" method="post" enctype="Multipart/Form-data" id="accountForm" accept-charset="UTF-8">
		<div class="am-form-group am-form-file">
			<button type="button" class="am-btn am-btn-default am-btn-sm">
				<i class="am-icon-cloud-upload"></i> 选择要上传的文件
			</button>
			<input type="file" name="file" id="file_id" multiple>
		</div>
		<button type="submit" class="am-btn am-btn-default">提交</button>
	</form>
	<p class="am-text-primary">
		<a id="putBigAccount" href="javascript:void(0);" class="am-btn am-btn-default">[1] 放入大号库</a>
	</p>
	<p class="am-text-primary">
		<a id="putPhoneAccount" href="javascript:void(0);" class="am-btn am-btn-default">[2] 按照手机分配</a>
	</p>
	<p class="am-text-primary">
	<form class="am-form-inline" id="avgForm" role="form"
		action="${pageContext.request.contextPath}/tbaoccount/avgAccount" method="post" accept-charset="UTF-8">
		<div class="am-form-group">
			<input type="text" id="phoneCount" name="phoneCount"
				class="am-form-field" placeholder="分配手机数">
		</div>
		<div class="am-form-group">
			<input type="text" id="avgnum" name="num" class="am-form-field"
				placeholder="每部手机分配的数目">
		</div>
		<button type="submit" id="avgePhoneBtn" class="am-btn am-btn-default">平均分配</button>
	</form>
	</p>
	<p class="am-text-primary">
	<form class="am-form-inline" role="form">
		<div class="am-form-group">
			<input type="text" id="phoneId" name="phoneId" class="am-form-field"
				placeholder="输入手机号">
		</div>
		<a id="phoneAccountBtn" href="javascript:void(0);" class="am-btn am-btn-default">[2] 按手机号分配</a>
	</form>
	</p>
	
	<p class="am-text-primary">
	<form class="am-form-inline" role="form">
		<div class="am-form-group">
			<input type="text" id="phoneTag" name="phoneTag" class="am-form-field"
				placeholder="手机标记">
		</div>
		<a id="changeAccountBtn" href="javascript:void(0);" class="am-btn am-btn-default">设置一键换号</a>
	</form>
	</p>

	<table
		class="am-table am-table-bordered am-table-striped am-table-compact">
		<thead>
			<tr>
				<th>内容</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="content" id="tempchars"></td>
			</tr>

		</tbody>
	</table>

</div>
</div>

<script>
	$(function() {
		
		$("#changeAccountBtn").click(function() {
			$.ajax({
				type : "post",
				dataType : "json",
				url : "${pageContext.request.contextPath}/tbaoccount/phoneChange",
				data:{
					phoneTag:$("#phoneTag").val()
				},
				success : function(resp) {
					if (resp && resp.ec == 0) {
						Message.info('保存成功：', false);
					} else {
						Message.error('保存失败,' + resp.em, false);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
				  Message.error('保存失败！');
				}
			});
		});
		
		$('#accountForm').validate({
			rules : {
				file_name : {
					required : true
				},
			},
			messages : {
				file_name : {
					required : '不能为空。'
				},
			},
			submitHandler : function(form) {
				if (!$(form).valid()) {
					$('.error').eq(0).focus();
					return false;
				}
				$(form).ajaxSubmit({
					success : function(resp) {
						if (resp && resp.ec == 0) {
							Message.info('上传成功：', false);
							var html = "共有" + resp.rst.length + "条记录</br>";
							for (var i = 0; i < resp.rst.length; i++) {
								html += resp.rst[i] + "</br>";
							}
							$(".content").html(html);
						} else {
							Message.error('上传失败：' + resp.em, false);
						}
					},
					error : function() {
						Message.error('上传失败！', false);
					}
				});
			}
		});
		$("#putBigAccount").click(function() {
			$.ajax({
				type : "post",
				dataType : "json",
				url : "${pageContext.request.contextPath}/tbaoccount/saveAccount",
				success : function(resp) {
					if (resp && resp.ec == 0) {
						Message.info('保存成功：', false);
						$(".content").html("");
					} else {
						Message.error('保存失败,' + resp.em, false);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
				  Message.error('保存失败！');
				}
			});
		});

		$("#putPhoneAccount").click(function() {
			$.ajax({
				type : "post",
				dataType : "json",
				url : "${pageContext.request.contextPath}/tbaoccount/saveAccount",
				success : function(resp) {
					if (resp && resp.ec == 0) {
						Message.info('保存成功：', false);
						$(".content").html("");
					} else {
						Message.error('保存失败,' + resp.em, false);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
				  Message.error('保存失败！');
				}
			});
		});

		$("#phoneAccountBtn").click(function() {
			var phoneId = $("#phoneId").val();
			if (parseInt(phoneId) <= 0) {
				alert("请输入手机号");
				return false;
			}
			$.ajax({
				type : "post",
				dataType : "json",
				url : "${pageContext.request.contextPath}/tbaoccount/saveAccountByphone",
				data : {
					phoneid : phoneId
				},
				success : function(resp) {
					if (resp && resp.ec == 0) {
						Message.info('保存成功：', false);
						$(".content").html("");
					} else {
						Message.error('保存失败,' + resp.em, false);
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
				  Message.error('保存失败！');
				}
			});
		});

		$('#avgForm').validate({
			rules : {
				phoneCount : {
					required : true,
					number : true
				},
				num : {
					required : true,
					number : true
				}
			},
			messages : {
				phoneCount : {
					required : '不能为空。',
					number : "必须为数字"
				},
				num : {
					required : '不能为空。',
					number : "必须为数字"
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
							Message.info('保存成功：', false);

							$(".content").text(resp.em);
						} else {
							Message.error('保存失败：' + resp.em, false);
						}
					},
					error : function() {
						Message.error('保存失败！', false);
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