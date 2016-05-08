<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
                <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <meta name="keywords" content="真流量
无线流量
无限流量代运营
无线刷流量 "/>
        <meta name="description" content="真流量
无线流量
无限流量代运营
无线刷流量 "/>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/pagematter/common/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/pagematter/common/css/global.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/pagematter/common/css/common.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/backstage/pagematter/common/css/sweetalert.css">

        <script type="text/javascript" src="${pageContext.request.contextPath}/backstage/pagematter/common/js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/backstage/pagematter/common/js/common.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/backstage/pagematter/common/js/sweetalert-dev.js"></script>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/pagematter/common/css/layer_user.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/pagematter/common/css/user.css" type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/backstage/pagematter/common/css/validform.style.css" type="text/css">

    <style type="text/css">
        .login_box {
            width: 930px;
            padding-bottom: 20px;
        }

        .form_control {
            margin-top: 5px;
            height: 25px;
            line-height: 25px;
            font-size: 12px;
            border-bottom: 1px dashed #dedede;
            padding-bottom: 5px;
        }

        .form_control_t {
            margin-top: 5px;
        }

        .form_control .form_label {
            height: 25px;
            line-height: 25px;
            font-size: 12px;
            width: 180px;
        }

        .form_control .form_input {
            height: 23px;
            line-height: 23px;
            font-size: 12px;
        }

        .form_control .form_select {
            height: 23px;
            line-height: 23px;
            font-size: 12px;
            list-style: 20px;
        }

        .form_control .form_radio {
            height: 25px;
            line-height: 25px;
            font-size: 12px;
        }

        .form_control .form_radio span {
            margin: 0 20px 0 5px;
        }

        .form_control .input_tip {
            height: 25px;
            line-height: 25px;
            font-size: 12px;
        }

        .form_control .Validform_checktip {
            height: 25px;
            line-height: 25px;
        }

        .form_control .form_btn {
            width: 150px;
            height: 30px;
            line-height: 30px;
            font-size: 14px;
            font-weight: normal;
        }

        .form_control a.form_abtn {
            height: 30px;
            line-height: 30px;
            font-size: 14px;
            font-weight: normal
        }

        .form_control_t .form_label {
            float: left;
            display: block;
            width: 140px;
            text-align: right;
            padding-right: 10px;
            height: 25px;
            line-height: 25px;
            font-size: 12px;
        }

        .form_control .Validform_wrong {
            background-position: 15px -95px;
        }

        .form_control .Validform_right {
            background-position: 15px -145px;
        }

        .form_control .Validform_loading {
            background-position: 15px 4px;
        }

        .taxkTips {
            padding-bottom: 10px;
        }

        .taxkTips h2 {
            height: 30px;
            line-height: 30px;
            text-indent: 20px;
            border-bottom: 1px solid #dedede;
            font-size: 12px;
            color: #666;
            font-weight: bold;
            background-color: #f0f0f0;
            margin-top: 10px;
        }
    </style>

    <title>积分账户 - 真流量</title>
</head>

<body>

<div id="topbar">
    <div class="warp1200">
        <div class="clearfix">
            <div class="welcome row_l"><div class="welcome row_l"></div></div>
            <div class="userlogininfo row_r">
                <div class="islogin" id="islogin">
                    <a href="/user"><i class="fa fa-user"></i><span id="username">fekong</span></a>
                    <a href="/user"><i class="fa fa-cog"></i>会员中心</a>
                    <a href="/auth/logout"><i class="fa fa-sign-out"></i>退出</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="pageFull">
    <div class="webHeader clearfix">
        <div class="logo row_l">
				<a href="${pageContext.request.contextPath}/frontend/index" title="电商流量">真流量</a>
			</div>
			<div class="channel row_r">
				<ul class="clearfix">
					<li><a href="${pageContext.request.contextPath}/frontend/index" title="电商流量"
						class="scl1">网站首页</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/intro" class="scl2">服务介绍</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/anli" class="scl3">成功案例</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/articlenews" class="scl4" title="电商干货">电商干货</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/articleguide" class="scl5">新手指引</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/authlogin" class="scl6" title="真流量用户中心">用户中心</a></li>
					<li><a href="${pageContext.request.contextPath}/frontend/about" class="scl7">联系我们</a></li>
				</ul>
			</div>
    </div>
</div>
<script type="text/javascript">
    $('.scl6').addClass('hover');
</script>

<div class="uc_warp">
    <div class="userbody clearfix">
        <div class="leftmenu row_l">
					<dl>
						<dt>
							<a href="${pageContext.request.contextPath}/user/responseuser">个人中心</a>
						</dt>
						<dd>
							<p>
								<a href="${pageContext.request.contextPath}/user/responsepersonal" id="info"><i class="fa fa-angle-right"></i>基本信息</a>
							</p>
							<p>
								<!-- <a href="/user/broker" id="account"><i class="fa fa-angle-right"></i>我的推广</a> -->
								<a href="javascript:void(0);" id="account"><i class="fa fa-angle-right"></i>我的推广</a>
							</p>
						</dd>
					</dl>
					<dl>
						<dt>
							<a href="javascript:void(0);">流量任务管理</a>
						</dt>
						<dd>
							<p>
								<a href="${pageContext.request.contextPath}/task/responsetaskadd" id="addtask"><i class="fa fa-angle-right"></i>发布任务</a>
							</p>

							<p>
								<a href="${pageContext.request.contextPath}/task/responsetaskmanage" id="managetask"><i class="fa fa-angle-right"></i>任务管理</a>
							</p>
						</dd>
					</dl>
					<dl>
						<dt>
							<a href="/user/cash/records">财务中心</a>
						</dt>
						<dd class="acc">
							<p>
								<a href="${pageContext.request.contextPath}/points/responsebuypoints" id="purchase"><i class="fa fa-angle-right"></i>购买积分</a>
							</p>
							<p>
								<a href="${pageContext.request.contextPath}/points/responserecordspoints" id="point"><i class="fa fa-angle-right"></i>积分明细</a>
							</p>
						</dd>
					</dl>
				</div>       
    <script type="text/javascript">
        $('#purchase').addClass('hover');
    </script>

    <div class="rightbox row_r">
        <div class="u_outbox">
            <div class="tabtitle clearfix">
                <a href="/user/points" class="row_l hover">购买积分套餐</a>
                <a href="/user/points/consume" class="row_l">购买记录</a>
                <a href="/user/points/records" class="row_l">积分明细</a>
            </div>
            <div class="umainbox">
                <!--main-->
                <form class="koo_fromBox" action="/user/points" method="post">
    <input type="hidden" name="_token" value="t1yIDXF06aLrBmCEySsRpefqJxLY1EARgWOjXaYV">

    <div class="taxkTips"><h2>可选套餐</h2></div>

            <div class="form_control clearfix">
            <label class="form_label">体验套餐 :</label>
            <label class="form_radio">
                <input type="radio" name="package" value="1">
                <span>价格：30 元</span>
                <span>积分数量：2000</span>
                <span>赠送积分：0</span>
                <span>总计：2000 积分</span>
            </label>
        </div>
            <div class="form_control clearfix">
            <label class="form_label">A套餐 :</label>
            <label class="form_radio">
                <input type="radio" name="package" value="2">
                <span>价格：150 元</span>
                <span>积分数量：10700</span>
                <span>赠送积分：0</span>
                <span>总计：10700 积分</span>
            </label>
        </div>
            <div class="form_control clearfix">
            <label class="form_label">B套餐 :</label>
            <label class="form_radio">
                <input type="radio" name="package" value="3">
                <span>价格：300 元</span>
                <span>积分数量：23000</span>
                <span>赠送积分：0</span>
                <span>总计：23000 积分</span>
            </label>
        </div>
            <div class="form_control clearfix">
            <label class="form_label">C套餐 :</label>
            <label class="form_radio">
                <input type="radio" name="package" value="4">
                <span>价格：600 元</span>
                <span>积分数量：50000</span>
                <span>赠送积分：0</span>
                <span>总计：50000 积分</span>
            </label>
        </div>
            <div class="form_control clearfix">
            <label class="form_label">D套餐 :</label>
            <label class="form_radio">
                <input type="radio" name="package" value="5">
                <span>价格：1000 元</span>
                <span>积分数量：90800</span>
                <span>赠送积分：0</span>
                <span>总计：90800 积分</span>
            </label>
        </div>
            <div class="form_control clearfix">
            <label class="form_label">E套餐 :</label>
            <label class="form_radio">
                <input type="radio" name="package" value="6">
                <span>价格：2000 元</span>
                <span>积分数量：200000</span>
                <span>赠送积分：0</span>
                <span>总计：200000 积分</span>
            </label>
        </div>
            <div class="form_control clearfix">
            <label class="form_label">F套餐 :</label>
            <label class="form_radio">
                <input type="radio" name="package" value="7">
                <span>价格：5000 元</span>
                <span>积分数量：600000</span>
                <span>赠送积分：0</span>
                <span>总计：600000 积分</span>
            </label>
        </div>
    
    <div class="form_control clearfix" style="margin-top:20px; border-bottom:none;">
        <div class="botton">
            <button type="submit" name="submit" class="form_btn">确定购买</button>
        </div>
    </div>

</form>                        <!--main-->
            </div>
        </div>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/backstage/pagematter/common/js/layer_user.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/backstage/pagematter/common/js/Validform_v5.3.2.js"></script>
    </div>
</div>


<div class="copyRight">
    <div class="warp1200 footer">
        <p>
			Copyright (c) 2015 <a href="${pageContext.request.contextPath}/frontend/index" title="淘宝流量">淘宝流量</a> | <a href="${pageContext.request.contextPath}/frontend/index" title="真流量">真流量</a>(www.zhenapp.cn) Inc. All Rights. 浙ICP备140452118号-5.
		</p>
    </div>
</div>

</body>
</html>