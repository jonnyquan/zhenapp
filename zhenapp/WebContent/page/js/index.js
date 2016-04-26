$(function() {

	$('#nav').tree(
			{
				url : uri + '/menu/findAllMenuById',
				width : 400,
				lines : true,
				iconCls : 'icon-edit',
				onClick : function(node) {
					var content = '<iframe scrolling="no" frameborder="0"'
							+ 'src="' + uri + node.url
							+ '" style="width:100%;height:100%;"></iframe>';
					if (node.url) {
						if ($('#tabs').tabs('exists', node.text)) {
							$('#tabs').tabs('select', node.text);
						} else {
							$('#tabs').tabs('add', {
								title : node.text,
								iconCls : node.iconCls,
								closable : true,
								content : content,
							});
						}
					}
				}
			});

	$('#tabs').tabs({
		fit : true,
		border : false,
	});

	$.messager.show({
		title : "提示消息",
		msg : "欢迎登录系统",
		width : 300,
		height : 200,
	});

});