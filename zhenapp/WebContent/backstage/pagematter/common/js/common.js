$(document).ready(function(){

});

// layer插件 提示框
//function showmsgbox(msg,type,time,url){
//	$('.xubox_shade,.xubox_layer').remove();
//	//type  1-对勾  8-哭脸 9-笑脸
//	if (!isExitsVariable(type)){type = 1;}
//	if (!isExitsVariable(time)){time = 3;}
//	if (!isExitsVariable(url)){url = 'reload';}
//	$.layer({
//		type: 0,
//		shadeClose: true,
//		title: false,
//		closeBtn: [0, false],
//		fadeIn:300,
//		border:[4,0.4,'#000'],
//		time:time,
//		dialog: {type:type,msg:msg},
//		end: function(){
//			switch(url){
//				case 'reload':
//					location.reload();
//					break;
//				case 'none':
//					break;
//				default:
//					window.location.href = url;
//					break;
//			}
//		}
//	});
//}
//
//function isExitsVariable(variableName){
//    try {
//        if (typeof(variableName) == "undefined") {
//            return false;
//        } else {
//            return true;
//        }
//    } catch(e) {}
//    return false;
//}
//
//function tryDaoshiji(times){
//	format_counttime(times);
//	var isinerval = setInterval(
//		function(){
//			if (times < 1){
//				window.location.reload();
//				clearInterval(isinerval);
//				return;
//			}
//			times--;
//			format_counttime(times);
//		}
//	,1000);
//}
//function  format_counttime(times){
//	if (times > 86400){
//		days = Math.floor(times / 86400);
//		times = times % 86400;
//	}else{
//		days = 0;
//	}
//	if (times > 3600){
//		hours = Math.floor(times / 3600);
//		times = times % 3600;
//	}else{
//		hours = 0;
//	}
//	if (times > 60){
//		munites = Math.floor(times / 60);
//		times = times % 60;
//	}else{
//		munites = 0;
//	}
//
//	$("#count_day").html(days);
//	$("#count_hour").html(hours);
//	$("#count_munite").html(munites);
//	$("#count_second").html(times);
//}
//***********************************************************************************
/*元素固定在页面顶部
 * $('#demo').smartFloat();
*/
$.fn.smartFloat = function(){
	var position = function(element) {
	var top = element.position().top, pos = element.css("position");
	$(window).scroll(function() {
		var scrolls = $(this).scrollTop();
		if (scrolls > top){
			if (window.XMLHttpRequest) {
				element.css({
				position: "fixed",
				top: 0
				});	
			}else{
				element.css({
				top: scrolls
				});	
			}
		}else{
			element.css({
			position: pos,
			top: top
			});	
		}
	});
	};
	return $(this).each(function(){position($(this));});
};
//function check_so(){
//	var sokey=$('#sokey').val();
//	if (sokey == ''){alert('请输入搜索关键词');
//		return false;
//	}
//}
//function strToJson(str){
//	var json = eval('(' + str + ')');
//	return json;
//}
jQuery.fn.smartFocus = function(text) {
    $(this).val(text).focus(function() {
        if ($(this).val() == text) {
            $(this).val('');
        }
    }).blur(function() {
        if ($(this).val() == '') {
            $(this).val(text);
        }
    });
};

function goScroll(objname){
	if (objname == 'index'){
		$("html,body").animate({scrollTop:0},500);
	}else{
		$("html,body").animate({scrollTop:$('#'+objname).offset().top},500);
	}
}