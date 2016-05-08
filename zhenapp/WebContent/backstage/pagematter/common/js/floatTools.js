var floatTools = '<div class="floatTools clearfix">\
	<div class="row_r btn" id="ToolsBtn">\
	<a class="Open hide" title="查看在线客服">展开</a>\
	<a class="Close" title="关闭在线客服">收缩</a>\
	</div>\
	<div id="ToolsView" class="row_l box">\
	<div class="cn radius5">\
	<h3>真流量</h3>\
	<ul>\
	<li><a target="_blank" href="tencent://message/?uin=319809430&Site=&Menu=yes" title="点击这里给我发消息">流量客服</a></li>\
	<li><a target="_blank" href="tencent://message/?uin=319809430&Site=&Menu=yes" title="点击这里给我发消息">技术咨询</a></li>\
	<li><a target="_blank" href="tencent://message/?uin=319809430&Site=&Menu=yes" title="点击这里给我发消息">流量托管</a></li>\
	<li class="call"><span>服务时间: 9:00-17:00</span> </li>\
	</ul>\
	</div>\
	</div>\
	</div>';
	$('body').append(floatTools);
	$("#ToolsBtn .Close").bind("click",function(){
		$(this).addClass('hide');
		$("#ToolsBtn .Open").removeClass('hide');
		$('#ToolsView').animate({width:'show',opacity:'show'},100,function(){$('#ToolsView').show();});			
	});
	$("#ToolsBtn .Open").bind("click",function(){
		$(this).addClass('hide');
		$("#ToolsBtn .Close").removeClass('hide');		
		$('#ToolsView').animate({width:'hide',opacity:'hide'},100,function(){$('#ToolsView').hide();});
	});