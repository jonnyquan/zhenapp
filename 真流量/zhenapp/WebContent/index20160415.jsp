<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
</head>
<body>
	<a href="${pageContext.request.contextPath}/index/findwebinfo/<%=request.getServerName()%>">跳转到网站首页</a>
	<br>
	<a href="${pageContext.request.contextPath}/page/main/reg.jsp">快去注册</a> | 
	<a href="${pageContext.request.contextPath}/page/main/login.jsp">快去登录</a>
	
	<br/><br/><br/>
	
	<div style="border: 1px dashed red;">
		<form action="http://localhost:8080/zhenapp/api/platform/searchBalance" method="post">
			用户名:<input type="text" name="partnerId"/>
			密码:<input type="text" name="password"/>
			<input type="submit" value="提交"/>
		</form>
	</div>
	
	<div>
		<input type="text" class="easyui-validatebox" data-options="required:true,validType:'email'" />
		<input type="text" class="easyui-validatebox" data-options="required:true,validType:'url'" />
		<input type="text" class="easyui-validatebox" data-options="required:true,validType:'length[2,10]'" />
		<br/>
		<input type="text" id="boxtext"/>
	</div>
	
	<input type="text" id="box2" />
	
	
	<form id="formbox" action="">
		
	</form>
	
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/js/user.js"></script>
<script type="text/javascript">
		var uri="${pageContext.request.contextPath}";
		$(function(){
			//$.messager.alert('警告框','警告信息','info',function(){
			//	alert('警告');
			//});		
			/*$.messager.confirm('确认框','你真的要删除吗？',function(flag){
				if(flag){
					alert('点击了确认');
				}
			});*/
			/*$.messager.prompt('提示框','请输入你的名字',function(content){
				if(content){
					alert(content);
				}
			})
			$.messager.progress({
				title:'zhixingzhiong',
				msg:'努力上传中...',
				
			});
			$.messager.show({
				title:'我的消息',
				msg:'弹出的消息',
				timeout:5000,
				showType:'fade',
			});
		$("#box2").calendar({
			//fit:true,
			firstDay:1,
			current:new Date(2015,6,1),
			
		});	*/
			$("#box2").datebox({
				currentText:'今天',
				closeText:'今天',
				okText:'确定',
				//buttons:[]
				formatter:function(date){
					var y = date.getFullYear();
					var m = date.getMonth()+1;
					var d = date.getDate();
					return m+':'+d+':'+y;
				}

			});	
		});
</script>
	
</html>