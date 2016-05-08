//页面弹出登录窗口
$(function(){	
	$('#verifyImg').on('click', function(){changeVerifyi('verifyImg');});//更换验证码
});
//登陆框
function loginbox(){
	$('.xubox_shade,.xubox_layer').remove();
	var pagei = $.layer({
		type: 1,
		title:false, 
		border:false, 
		move:false,
		closeBtn:false,
		shade: [0.6,'#000'],
		fadeIn:300,
		shadeClose:true,
		area: ['560px','360px'],   // 控制层宽高 当设置为auto时，意味着采用自适应（iframe层不能设置auto）, 对于宽度，并不推荐您设置auto
		page: {html:login_layer()},
	});
	$('#pagebtn,#regbtn').on('click', function(){layer.close(pagei);});	//自设关闭按钮
	$("#uloginbox").Validform({
		tiptype:4,
		postonce:true,
		ajaxPost:true,
		beforeSubmit:function(curform){
			load_ucenter_login('lay');
		},
		callback:function(data){
			showmsgbox(data.info,data.type,3,data.url);
		}
	});
}
//QQ登录
function toLogin(){
	$('.xubox_shade,.xubox_layer').remove();
	$.layer({
		type: 2,
		shadeClose: true,
		title: false,
		closeBtn: [0, false],
		shade: [0.6,'#000'],
		border: false,
		fadeIn:300,
		area: ['720px','480px'],
		iframe: {src:'/User/Api/qqlogin',scrolling:'no'}
	}); 
}
/*Uc同步登陆 - ajaxbox*/
function load_ucenter_login(ev){
	var username = $('#'+ev+'_username').val();
	var password = $('#'+ev+'_password').val();
	$.post('/User/Ucenter/uclogin.html',{'username':username,'password':password},function(result){
		$('body').append(result);
	},'html');
}
/*Uc同步修改密码 - ajaxbox*/
function load_ucenter_passwd(md5pass){
	$.post('/User/Ucenter/ucpasswd.html',{'md5pass':md5pass},function(result){
		$('body').append(result);
	},'html');
}
/*退出登录*/
function loginout(){
	//退出Ucenter
	$.get('/User/Ucenter/ucloginout.html',function(result){
		$('body').append(result);
	},'html');
	//退出本项目
	$.get('/User/Login/loginout.html',function(result){
		showmsgbox(result.data,9,3,'');
	},'json');	
}

/*
 * 会员签到
*/
function usersign(){
	$.get('/User/Sign/usersign.html',function(re){
		if (re.status ==1){
			$('#usersign').addClass('signed').html(re.msg);
			showmsgbox(re.info,9);
		}else{
			showmsgbox(re.info,8);
		}
		
	},'json');
}

function changeVerifyi(objname){
	var verifyUrl = $('#'+objname).attr('src')+"?_" + new Date();
	$('#'+objname).attr('src',verifyUrl);
}

function login_layer(){
	var layer_html = '<div class="layForm clearfix">\
        	<div class="row_l lay_userBox">\
				<h2>会员登录</h2>\
				<form id="uloginbox" action="/User/Login/ajaxlogin.html" method="post">\
				<div class="lay_control">\
                <input class="form_input input228" type="text" name="username" id="lay_username" placeholder="用户名" datatype="s4-20" sucmsg="用户名格式正确" nullmsg="请输入用户名" errormsg="用户名格式错误"/><label id="name_check" class="Validform_checktip"></label>\
				</div>\
				<div class="lay_control">\
                <input class="form_input input228" type="password" name="password" id="lay_password" placeholder="密码" datatype="*6-20" sucmsg="密码格式正确" nullmsg="请输入6-20密码" errormsg="密码格式不正确"/><label class="Validform_checktip"></label>\
                </div>\
				<div class="lay_control">\
                <input name="verify" type="text" class="form_input input228" id="lay_verify" maxlength="5" placeholder="验证码" ajaxurl="/User/Ajax/checkVerify.html" datatype="s5-5"  sucmsg="验证码输入正确" errormsg="请填写5位验证码" nullmsg="请填写验证码"/><label class="Validform_checktip"></label><input type="hidden"  value="0" name="verify_code" id="verify_code"/>\
				</div>\
				<div class="lay_control codeimg">\
				<img alt="点击切换验证码" src="/User/Ajax/verify.html" id="lay_verifyImg" style="width:248px;height:50px;" onclick="changeVerifyi(\'lay_verifyImg\');">\
				</div>\
				<div class="lay_control">\
                    <div class="botton"><button type="submit" name="submit" id="loginbtn" class="form_btn">登 录</button></div>\
				</div>\
            	</form>\
            </div>\
            <div class="row_r lay_api">\
            	<h2>关联账户登录</h2>\
                <ul class="layapi_info">\
                	<li><a href="javascript:;" class="api_qq" onclick="toLogin()">腾讯QQ登录</a></li>\
					<li><a href="/Seller/login.html" class="api_seller">腾讯QQ登录</a></li>\
					<li class="btn clearfix"><button type="button" id="pagebtn" name="submit" class="close_lay">返 回</button><a href="/User/register" target="_blank" class="register" id="regbtn">注册新帐号</a></li>\
                </ul>\
            </div>\
		</div>';	
	return layer_html;
}
/*
 * 读秒倒计时后跳转
*/
function countDownReturn(evname,times,url){
	var isinerval = setInterval(
		function(){
			if (times < 1){
				window.location.href = url;
				clearInterval(isinerval);
				return;
			}
			times--;
			$("#"+evname).html(times);			
		}
	,1000);
}
/*
 * 读秒倒计时
*/
function countDown(evname,tips,times){
	var isinerval = setInterval(
		function(){
			if (times < 1){
				$("#"+evname).removeClass('disabled').html(tips);
				clearInterval(isinerval);
				return;
			}
			times--;
			$("#"+evname).html(times+'秒后，'+tips);
		}
	,1000);
}
/*
* 获取手机验证码
*/
function getMobilecode(userid,obj,tip){
	$mobile = $('#'+obj).val();
	$("#"+tip).addClass('disabled').html('验证码正在发送中...');
	$.post("/User/Ajax/sentMobilecode.html",{'mobile':$mobile,'userid':userid},function(re){
		if (re.status == 1){
			$("#"+obj).attr("readonly",true).addClass('readonly');
			showmsgbox('验证码发送成功，请输入验证码完成验证',9,3,'none');			
			countDown(tip,'重新发送验证码',re.info);
		}else if(re.status == -1){
			showmsgbox(re.info+'秒后可重新发送，请不要频繁操作！',8,3,'none');
			countDown(tip,'重新发送验证码',re.info);
		}else{
			showmsgbox(re.info,8,3,'none');
			$("#"+tip).removeClass('disabled').html('免费获取验证码');			
		}
	},'json');
}

/*
* 获取邮箱验证码
*/
function getMailcode(userid,obj,tip){
	$email = $('#'+obj).val();
	$("#"+tip).addClass('disabled').html('验证码正在发送中...');
	$.post("/User/Ajax/sentMailcode.html",{'email':$email,'userid':userid},function(re){
		if (re.status == 1){
			$("#"+obj).attr("readonly",true).addClass('readonly');
			showmsgbox('验证码发送成功，请输入验证码完成验证',9,3,'none');			
			countDown(tip,'重新发送验证码',re.info);
		}else if(re.status == -1){
			showmsgbox(re.info+'秒后可重新发送，请不要频繁操作！',8,3,'none');
			countDown(tip,'重新发送验证码',re.info);
		}else{
			showmsgbox(re.info,8,3,'none');
			$("#"+tip).removeClass('disabled').html('免费获取验证码');			
		}
	},'json');
}

/*找回密码 发送邮件*/

function getchkMailcode(obj,tip){
	$email = $('#'+obj).val();
	$("#"+tip).addClass('disabled').html('验证码正在发送中...');
	$.post("/User/Ajax/sentchkMailcode.html",{'email':$email},function(re){
		if (re.status == 1){
			$("#"+obj).attr("readonly",true).addClass('readonly');
			showmsgbox('验证码发送成功，请输入验证码完成验证',9,3,'none');			
			countDown(tip,'重新发送验证码',re.info);
		}else if(re.status == -1){
			showmsgbox(re.info+'秒后可重新发送，请不要频繁操作！',8,3,'none');
			countDown(tip,'重新发送验证码',re.info);
		}else{
			showmsgbox(re.info,8,3,'none');
			$("#"+tip).removeClass('disabled').html('免费获取验证码');			
		}
	},'json');
}
