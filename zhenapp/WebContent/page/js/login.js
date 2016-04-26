$(function () {
	
	//登录界面
	$('#div_login').dialog({
		title : '登录后台',
		width : 320,
		height : 200,
		modal : true,
		maximizable:true,
		iconCls : 'icon-login',
		buttons : '#btn_login',
	});
	
	//管理员帐号验证
	$('#username').validatebox({
		required : true,
		missingMessage : '请输入管理员帐号',
		invalidMessage : '管理员帐号不得为空',
	});
	
	//管理员密码验证
	$('#password').validatebox({
		required : true,
		validType : 'length[6,30]',
		missingMessage : '请输入管理员密码',
		invalidMessage : '管理员密码不得少于6位',
	});
	
	//加载时判断验证
	if (!$('#username').validatebox('isValid')) {
		$('#username').focus();
	} else if (!$('#password').validatebox('isValid')) {
		$('#password').focus();
	}
	
	
	//单击登录
	$('#btn_login_a').click(function () {
		if (!$('#username').validatebox('isValid')) {
			$('#username').focus();
		} else if (!$('#password').validatebox('isValid')) {
			$('#password').focus();
		} else {
			$.ajax({
				url : uri+'/user/Loginrest/'+$('#username').val()+"/"+$('#password').val(),
				type : 'post',
				data : {
					username : $('#username').val(),
					password : $('#password').val(),
				},
				beforeSend : function () {
					$.messager.progress({
						text : '正在登录中...',
					});
				},
				success : function (data, response, status) {
					$.messager.progress('close');
					
					if (data!="") {
						location.href = uri+'/page/main/index.jsp';
					} else {
						$.messager.alert('登录失败！', '用户名或密码错误！', 'warning', function () {
							$('#password').select();
						});
					}
				},
				error:function(response,status,xhr){
					$.messager.progress('close');
					$.messager.alert('登录失败！', '服务器异常', 'error', function () {
						$('#password').select();
						
					}); 
				},
				timeout:20000
			});
		}
	});
	
});








