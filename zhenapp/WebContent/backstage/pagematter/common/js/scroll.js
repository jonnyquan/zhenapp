$(function(){
	var $backTop = this.$backTop = $('<style type="text/css">'+
	'#scroll{position:fixed;transition:bottom ease .3s;bottom:150px;z-index:3;cursor:pointer;left:50%;margin-left:610px;}'+
	'#scroll ul{width:50px;}'+
	'#scroll ul li{width:50px;height:50px;cursor:pointer;position:relative;}'+
	'#scroll ul li a{display:block;width:50px;height:50px;line-height:50px;background:url(pagematter/common/img/sliderImg.png) #bababa 0 -20px no-repeat;overflow:hidden;text-indent:-999999px;color:#fff;}'+
	'#scroll #gotop{display:none;}#scroll #gotop a{}'+
	'</style>'+
	'<div id="scroll">'+
		'<ul>'+
			'<li id="gotop"><a></a></li>'+
		'</ul>'+
	'</div>');
	$('body').append($backTop);
	$("#gotop a").click(function(event){
		$("html,body").animate({scrollTop:0},200);
	});
	jQuery(window).bind("scroll",function(){
		var scrollTop = $(window).scrollTop();
		scrollTop > 50 ? $("#gotop").fadeIn(200):$("#gotop").fadeOut(200);
    })
})
