<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>上传脚本</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/page/css/index.css" />
</head>
<body>
	<form id="form"
		action="${pageContext.request.contextPath}/util/uploadscript"
		method="post" enctype="multipart/form-data">
		<table style="width:100%;padding:5px;border: 1px solid #ddd;">
			<tr>
				<td align="center" width="30%">选择上传文件:<input type="file"
					name="file">
				</td>
				<td align="center" width="30%"><a class="easyui-linkbutton"
					onclick="check();">上传web信息</a></td>
			</tr>
		</table>
	</form>
	<table id="datagrid">
	</table>
	<div id="datagridtools" style="padding:5px;">
		<div style="padding:5px;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove"
				plain="true" onclick="obj.remove();">删除</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="#"
				class="easyui-linkbutton" iconCls="icon-save" plain="true"
				onclick="obj.save();">下载</a>
		</div>
		<div style="padding:5px;">
			<lable style="padding:0 10px 0 10px;">查询文件名:</lable>
			<input type="text" id="scriptname" class="textbox" width="110px" />
			<lable style="padding:0 10px 0 10px;">创建时间从:</lable>
			<input type="text" name="datefrom" class="easyui-datebox"
				width="110px" /> 到：<input type="text" name="dateto"
				class="easyui-datebox" width="110px" /> <a href="#"
				class="easyui-linkbutton" iconCls="icon-search"
				onclick="obj.search();">查询</a>
		</div>
	</div>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	var uri = "${pageContext.request.contextPath}";
	function check() {
		$("#form").submit();
	};

	$(function() {
		obj = {
			search : function() {
				$("#datagrid").datagrid('load', {
					scriptname : $("#scriptname").val(),
					datefrom : $("input[name='datefrom']").val(),
					dateto : $("input[name='dateto']").val(),
				});
			},
			save : function() {
				var rows = $("#datagrid").datagrid('getSelections');
				window
						.open("${pageContext.request.contextPath}/util/downloadFile/"
								+ rows[0].scriptid);
			},
			remove : function() {
				var rows = $("#datagrid").datagrid('getSelections');
				if (rows.length > 0) {
					$.messager
							.confirm(
									'确认',
									'您确认想要删除记录吗？',
									function(b) {
										if (b) {
											var scriptid = "";
											for (var i = 0; i < rows.length; i++) {
												scriptid = rows[i].scriptid;
											}
											$
													.ajax({
														type : "POST",
														url : "${pageContext.request.contextPath}/script/deletescriptByid",
														data : {
															scriptid : scriptid
														},
														beforeSend : function() {
															$("#datagrid")
																	.datagrid(
																			'loading');
														},
														success : function() {
															$("#datagrid")
																	.datagrid(
																			'loaded');
															$.messager.show({
																title : "提示消息",
																msg : "删除成功",
																width : 300,
																height : 200,
															});
															$("#datagrid")
																	.datagrid(
																			'load');
														},
													});
										}
									});
				} else {
					$.messager.alert('提示信息', "请选择要删除的信息", 'info');
				}
			},
		};
		$("#datagrid").datagrid({
			fit : true,
			title : '脚本文件管理',
			url : "${pageContext.request.contextPath}/script/findScriptByPage",
			columns : [ [ {
				field : 'scriptpk',
				title : '选择',
				checkbox:true,
			}, {
				field : 'scriptid',
				title : '脚本编号',
			}, {
				field : 'scriptname',
				title : '脚本文件名称',
			}, {
				field : 'createtime',
				title : '发布时间',
			} ] ],
			pagination : true,
			pageList : [ 1, 5, 10, 15, 20, 25 ],
			striped : true,
			nowrap : true,
			fitColumns : true,
			rownumbers : true,
			toolbar : '#datagridtools',
			singleSelect:true
		});

	});
</script>
</html>
