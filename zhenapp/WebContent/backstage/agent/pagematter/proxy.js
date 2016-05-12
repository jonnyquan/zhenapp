$(function() {

  $('#proxy-form').validate({
    rules : {
      name : {
        required : true,
      },
      domain : {
        required : true,
      },
      url : {
        required : true,
      },
      qq : {
        required : true,
      },
      qq_group : {
        required : true,
      },
      qq_group_url : {
        required : true,
      },
      weixin : {
        required : true,
      }
    },
    messages : {
      name : {
        required : '请输入网站名称。',
      },
      domain : {
        required : '请输入域名。',
      },
      url : {
        required : '请输入网站网址。',
      },
      qq : {
        required : '请输入QQ号。',
      },
      qq_group : {
        required : '请输入QQ群号。',
      },
      qq_group_url : {
        required : '请输入QQ群代码。',
      },
      weixin : {
        required : '请输入微信号。',
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
            Message.info('提交成功！', false);
            setTimeout(function() {
              window.location.href = location;
            }, 2000);

          } else {
            Message.error('提交失败：' + resp.em, false);
          }
        },
        error : function() {
          Message.error('提交失败！', false);
        }
      });
    }
  });
});