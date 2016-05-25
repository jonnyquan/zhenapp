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
<title>${tAgentInfoCustom.agentname} -- 套餐信息</title>
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
      <!-- sidebar start 
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
      </div>-->
      <div id="module-head"></div>
  <meta name="viewport" content="width=device-width, initial-scale=1">
<div class="admin-content">
  <div class="am-cf am-padding">
    <div class="am-fl am-cf">
      <strong class="am-text-primary am-text-lg">套餐信息</strong>
    </div>
  </div>
  <div class="am-g" id="module-head" style="margin-bottom: 10px;">
    <div class="am-u-sm-12 am-u-md-9">
      <div class="am-btn-toolbar">
        <div class="am-btn-group am-btn-group-xs">
          <button type="button" class="am-btn am-btn-default" id="addBtn">
            <span class="am-icon-plus"></span> 新增
          </button>
        </div>
      </div>
    </div>
  </div>
  <div class="am-g">
    <div class="am-u-sm-12">
      <form class="am-form">
        <table class="am-table am-table-striped am-table-hover" style="font-size: 1.4rem;">
          <thead>
            <tr class="am-success">
              <th>序号</th>
              <th>套餐名称</th>
              <th>原价格</th>
              <th>价格积分</th>
              <th>赠送价格</th>
              <th>赠送积分</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${tComboInfoCustomlist }" var="list">
            	<tr data-id="${list.combopk }">
                 <td>${list.combopk}</td>
                 <td>${list.comboname }</td>
                 <td>${list.combomoney}</td>
                 <td>${list.combointegral }</td>
			     <td>${list.combogivemoney}</td>
				 <td>${list.combogiveintegral}</td>
				 <td>
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<a class="am-btn am-btn-default am-btn-xs am-text-secondary"
								onclick="edit('${list.combopk}');"> <span
								class="am-icon-pencil-square-o"></span> 编辑
							</a> <a
								class="am-btn am-btn-default am-btn-xs am-text-danger"
								onclick="del('${list.combopk}')"> <span
								class="am-icon-trash-o"></span> 删除
							</a>
						</div>
					</div>
				</td>
				</tr>
            </c:forEach>
          </tbody>
        </table>
        <div>
			<ul class="pagination" id="pagination">
			</ul>
			<input type="hidden" id="PageCount" runat="server" value="${total}"/>
			<input type="hidden" id="PageSize" runat="server" value="10" />
			<input type="hidden" id="countindex" runat="server" value="10"/>
			<!--设置最多显示的页码数 可以手动设置 默认为7-->
			<input type="hidden" id="visiblePages" runat="server" value="12" />
		  </div>
        <hr>
        <p>说明：套餐信息列表，对套餐信息进行增加、删除、修改、查询操作。</p>
      </form>
    </div>
  </div>
</div>
<div class="am-popup" id="add-combo">
  <div class="am-popup-inner">
    <div class="am-popup-hd">
      <h4 class="am-popup-title">添加套餐信息</h4>
      <span data-am-modal-close class="am-close">&times;</span>
    </div>
    <div class="am-popup-bd">
      <form class="am-form am-form-horizontal am-padding" id="combo-form" action="${pageContext.request.contextPath}/combo/savecombo" method="post">
      <input type="hidden" name="combopk" id="combopk">
      <div class="am-form-group">
        <label for="name" class="am-u-sm-3 am-form-label">套餐名称</label>
        <div class="am-u-sm-7">
          <input type="text" id="name" name="comboname" placeholder="套餐名称">
        </div>
      </div>

      <div class="am-form-group">
        <label for="price" class="am-u-sm-3 am-form-label">原价格</label>
        <div class="am-u-sm-7">
          <input type="text" id="price" name="combomoney" placeholder="原价格">
        </div>
      </div>
      <div class="am-form-group">
        <label for="cion" class="am-u-sm-3 am-form-label">价格积分</label>
        <div class="am-u-sm-7">
          <input type="text" id="cion" name="combointegral" placeholder="价格积分">
        </div>
      </div>
      <div class="am-form-group">
        <label for="presentPrice" class="am-u-sm-3 am-form-label">赠送价格</label>
        <div class="am-u-sm-7">
          <input type="text" id="presentPrice" name="combogivemoney" placeholder="赠送价格">
        </div>
      </div>
      <div class="am-form-group">
        <label for="presentCoin" class="am-u-sm-3 am-form-label">赠送积分</label>
        <div class="am-u-sm-7">
          <input type="text" id="presentCoin" name="combogiveintegral" placeholder="赠送积分">
        </div>
      </div>
      <div class="am-form-group">
        <div class="am-u-sm-8 am-u-sm-push-3">
          <button type="submit" class="am-btn am-btn-primary">
            <i class="am-icon-check"></i>提交
          </button>
        </div>
      </div>
    </form>
    </div>
  </div>
</div>
<script>
  function edit(id) {
    $("#combopk").val(id);
    $("#name").val($('tr[data-id=' + id + ']').children().eq(1).text());
    $("#price").val($('tr[data-id=' + id + ']').children().eq(2).text());
    $("#cion").val($('tr[data-id=' + id + ']').children().eq(3).text());
    $("#presentPrice").val($('tr[data-id=' + id + ']').children().eq(4).text());
    $("#presentCoin").val($('tr[data-id=' + id + ']').children().eq(5).text());
    $(".am-popup-title").html("修改套餐信息");
    $("#add-combo").modal('open');
  }

  function del(pk) {
    $.getJSON('${pageContext.request.contextPath}/combo/deletecombo', {
    	pk : pk
    }, function(resp) {
      if (resp && resp.ec == 0) {
        $('tr[data-id=' + pk + ']').remove();
        Message.info('套餐信息删除成功！', true);
      } else {
        Message.error('套餐信息删除失败！', true);
      }
    });
  }

  ;$(function() {
	  $("#menu").load("${pageContext.request.contextPath}/backstage/agent/menu.jsp");
	  
    $("#addBtn").click(function(){
      $('input').val("");
      $("#add-combo").modal('open');
    });
    
    $('#combo-form').validate({
      rules : {
        name : {
          required : true
        },
        price : {
          required : true
        },
        cion : {
          required : true
        },
        presentPrice : {
          required : true
        },
        presentCoin : {
          required : true
        }
      },
      messages : {
        name : {
          required : "请输入套餐名称。",
        },
        price : {
          required : "请输入原价格。",
        },
        cion : {
          required : "请输入赠送积分。",
        },
        presentPrice : {
          required : "请输入赠送价格。",
        },
        presentCoin : {
          required : "请输入赠送积分。",
        }
      },
      submitHandler : function(form) {
        $('tr').removeClass('highlight');
        if (!$(form).valid()) {
          $('.error').eq(0).focus();
          return false;
        }
        $(form).ajaxSubmit({
          success : function(resp) {
            if (resp.ec == 0) {
              $("#add-combo").modal('close');
              Message.info('操作成功！', true);
              setTimeout(function() {
                window.location.href = location;
              }, 2000);
            } else {
              Message.error('操作失败：' + resp.em, false);
            }
          },
          error : function() {
            Message.error('操作失败！');
          }
        });
      }
    });
  });
  
  
  var index = Number("${pagenum}");
	if (index.length < 1) {
		index = 1;
	}
	function loadpage() {
		var myPageCount = parseInt($("#PageCount").val());
		var myPageSize = parseInt($("#PageSize").val());
		var countindex = myPageCount % myPageSize > 0 ? (myPageCount / myPageSize) + 1
				: (myPageCount / myPageSize);
		if(countindex==0){
			countindex=1;
		}
		$("#countindex").val(countindex);
		$.jqPaginator('#pagination',
						{
							totalPages : parseInt($("#countindex").val()),
							visiblePages : parseInt($("#visiblePages").val()),
							currentPage : index,
							first : '<li class="first"><a href="${pageContext.request.contextPath}/combo/findComboByagent?page=1">首页</a></li>',
							prev : '<li class="prev"><a href="javascript:;">上一页</a></li>',
							next : '<li class="next"><a href="javascript:;">下一页</a></li>',
							last : '<li class="last"><a href="javascript:;">末页</a></li>',
							page : '<li class="page"><a href="javascript:;">{{page}}</a></li>',
							onPageChange : function(num, type) {
								if (type == "change") {
									//exeData(num, type);
									window.location.href = "${pageContext.request.contextPath}/combo/findComboByagent?page=" + num;
								}
							}
						});
	}
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