var state_nick="0";
var state_userpwd1="0";
var state_userpwd2="0";
var state_regemail="0";
var state_agree="0";
	$(function(){
		
		$("#usernick").change(function(){
			$.ajax({
				type:"post",
				url:uri+"/user/findUserByNick.action",
				data:$("form").serializeArray(),
				dataTepy:'json',
				success:function(response,states,xhr){
					if(response=="1"){
						$('#nickdiv').html("<font color='red'>×</font>&nbsp;&nbsp;用户名已存在");
						$('#reg_btn').attr("disabled", true);
					}else{
						$('#nickdiv').html("<font color='green'>×</font>&nbsp;&nbsp;用户名可以使用");
						$('#reg_btn').attr("disabled", false);
					}
				},
				error:function(xhr,errorText,errorType){
					alert("错啦");
				}
			});
		});
		$("#userpwd1").change(function(){
			if($("#userpwd1").val().length<6){
				$('#userpwd1div').html("<font color='red'>×</font>&nbsp;&nbsp;密码长度不足6位");
				$('#reg_btn').attr("disabled", true);
			}else{
				$('#userpwd1div').html("");
				$('#reg_btn').attr("disabled", false);
			}
		});
		
		$("#userpwd2").change(function(){
			if($("#userpwd1").val()!=$("#userpwd2").val()){
				$('#userpwd2div').html("<font color='red'>×</font>&nbsp;&nbsp;两次输入密码不一致");
				$('#reg_btn').attr("disabled", true);
			}else{
				$('#userpwd2div').html("");
				$('#reg_btn').attr("disabled", false);
			}
		});
		emaile=$("#regemail").change(function(){
			var reg=/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
			if(!reg.test($("#regemail").val())){
				$('#regemaildiv').html("<font color='red'>×</font>&nbsp;&nbsp;输入的电子邮箱不符合校验规则");
				$('#reg_btn').attr("disabled", true);
			}else{
				$('#regemaildiv').html("");
				$('#reg_btn').attr("disabled", false);
			}
		});
		
		$.ajax({
			type:"post",
			url:uri+"/note/findNoteInfo.action",
			dataTepy:'json',
			success:function(response,states,xhr){
				$("#zcxz").html(response.notetext);
			},
			error:function(xhr,errorText,errorType){
				alert(errorType+"注册须知获取异常");
			}
		});
		
		
		$("#reg_btn").click(function(){
			//emaile();
			var val=$('input:radio[name="register"]:checked').val();
			if(val=="agree"){
				if($("#usernick").val()!=""){
					if($("#userpwd2").val()!=""){
						if($("#regemail").val()!=""){
							$("form").submit();
						}else{
							alert("电子邮箱不能为空");
						}
					}else{
						alert("两次输入密码必须一致");
					}
				}else{
					alert("用户名不能为空");
				}
			}else{
				alert("必须同意本平台的使用协议,才可成为本网站会员");
			}
		});
		
	});