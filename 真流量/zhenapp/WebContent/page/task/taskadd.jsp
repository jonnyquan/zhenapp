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

<title>发布任务</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/easyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/page/css/index.css" />

<style type="text/css">
#table1 td {
	border: 1px solid #aaa;
}

.hour {
	width: 40px;
}
</style>
<body>
	<div>
		<table class="table">
			<tr class="success">
				<td>费用概览</td>
			</tr>
			<tr class="active">
				<td>【流量数：<span id="lls_1">0</span>个，单价：<span id="lls_2">10</span>(积分)/个，总计：<span id="lls_3">0</span>(积分)】</td>
			</tr>
			<tr class="active">
				<td>【收藏数：<span id="scs_1">0</span>个，<span id="scs_2">10</span>(积分)/个，总计：<span id="scs_3">0</span>(积分)】</td>
			</tr>
			<tr class="active">
				<td>【购物车数：<span id="gwcs_1">0</span>个，单价：<span id="gwcs_2">10</span>/个，总计：<span id="gwcs_3">0</span>(积分)】</td>
			</tr>
			<tr class="danger">
				<td>总费用:<span id="sum">0</span></td>
			</tr>
		</table>
	</div>
	<div id="accordionbox">
		<div title="任务基本信息区" style="padding:10px 0 0 150px;height:260px;">
			<div>
				<form class="form-horizontal">
					<div class="form-group" style="width:500px;">
						<div class="col-sm-3 control-label">
							<label>宝贝id</label>
						</div>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="taskid"
								placeholder="请输入宝贝id" />
						</div>
					</div>
					<div class="form-group" style="width:500px;">
						<div class="col-sm-3 control-label">
							<label>关键词</label>
						</div>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="taskid"
								placeholder="请输入关键词" />
						</div>
					</div>
					<div class="form-group" style="width:500px;">
						<div class="col-sm-3 control-label">
							<label>无线端标题</label>
						</div>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="taskid"
								placeholder="请输入无线端标题" />
						</div>
					</div>
				</form>
			</div>
			<div class="form-group">
				<table>
					<tr width=100%>
						<td width=10% align="right">搜索方式</td>
						<td width="2%"></td>
						<td width=78% colspan="6" align="left"><label
							class="radio-inline"> <input type="radio"
								name="tasksearchType" value="1">综合
						</label> <label class="radio-inline"> <input type="radio"
								name="tasksearchType" value="2">信号
						</label> <label class="radio-inline"> <input type="radio"
								name="tasksearchType" value="3">价格低到高
						</label> <label class="radio-inline"> <input type="radio"
								name="tasksearchType" value="4">价格高到低
						</label> <label class="radio-inline"> <input type="radio"
								name="tasksearchType" value="5">销量
						</label></td>
					</tr>
					<tr height="10px">
						<td></td>
					</tr>
					<tr>
						<td width=10% align="right">搜索价格区间</td>
						<td width=2%></td>
						<td width=15%><input type="text" class="form-control"
							name="taskminprice" /></td>
						<td width=5% align="center">--</td>
						<td width=15%><input type="text" class="form-control"
							name="taskmaxprice" /></td>
						<td width=10%>元</td>
						<td width=53%></td>
					</tr>
				</table>
			</div>
		</div>
	</div>
	<div class="easyui-accordion">
		<div title="本次刷流量共需费用" style="padding:10px 0 0 150px;">
			<form class="form-horizontal">
				<div class="form-group" style="width:500px;">
					<div class="col-sm-3 control-label">
						<label>访问数</label>
					</div>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="taskcount" id="taskcount"
							placeholder="请输入需要的流量数" onblur="fpll(this)"
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')" />
					</div>
				</div>
				<div class="form-group" style="width:800px;">
					<div class="col-sm-2 control-label">
						<label>每时访问</label>
					</div>
					<div class="col-sm-10">
						<table id="table1">
							<tr align="center">
								<td>0点</td>
								<td>1点</td>
								<td>2点</td>
								<td>3点</td>
								<td>4点</td>
								<td>5点</td>
								<td>6点</td>
								<td>7点</td>
								<td>8点</td>
								<td>9点</td>
								<td>10点</td>
								<td>11点</td>
							</tr>
							<tr align="center">
								<td><input type="text" class="hour" name="hour"
									id="hour_0" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_1" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_2" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_3" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_4" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_5" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_6" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_7" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_8" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_9" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_10" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_11" onblur="checkNum(this)" value="0" maxlength="3"></td>
							</tr>
							<tr align="center">
								<td>12点</td>
								<td>13点</td>
								<td>14点</td>
								<td>15点</td>
								<td>16点</td>
								<td>17点</td>
								<td>18点</td>
								<td>19点</td>
								<td>20点</td>
								<td>21点</td>
								<td>22点</td>
								<td>23点</td>
							</tr>
							<tr align="center">
								<td><input type="text" class="hour" name="hour"
									id="hour_12" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_13" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_14" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_15" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_16" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_17" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_18" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_19" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_20" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_21" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_22" onblur="checkNum(this)" value="0" maxlength="3"></td>
								<td><input type="text" class="hour" name="hour"
									id="hour_23" onblur="checkNum(this)" value="0" maxlength="3"></td>
							</tr>

						</table>
					</div>
				</div>
				<div class="form-group" style="width:500px;">
					<div class="col-sm-3 control-label">
						<label>收藏数</label>
					</div>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="taskid"
							placeholder="请输入收藏数" onblur="fpsc(this)"
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')" />
					</div>
				</div>
				<div class="form-group" style="width:500px;">
					<div class="col-sm-3 control-label">
						<label>加入购物车数</label>
					</div>
					<div class="col-sm-9">
						<input type="text" class="form-control" name="taskid"
							placeholder="请输入购物车数"  onblur="fpgwc(this)"
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
					</div>
				</div>
				<div class="form-group container" style="padding:0 0 0 200px;">
					<button class="btn btn-info">发布流量信息</button>
				</div>
			</form>
		</div>
	</div>











</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/js/user.js"></script>
<script type="text/javascript">
	var uri = "${pageContext.request.contextPath}";
	var myDate = new Date();
	var hour = myDate.getHours();
	;$(function() {
		for (var i = 0; i < hour; i++) {
			$("#hour_" + i).val("0");
			$("#hour_" + i).attr("disabled", true);
		}

		$("#accordionbox").accordion({
			border : false,
			multiple : true,
		});
		$("#accordionbox").resize();
	});

	function checkNum(obj) {
		var number = /^\d+$/;
		var temp = obj.value;
		if (!number.test(temp)) {
			alert("每时数量必须为0到150之间的数字");
			obj.value = "0";
		}else{
			var sum=0;
			for(var i=0;i<24;i++){
				sum=sum+parseInt($("#hour_" +  i).val());
			}
			$("#taskcount").val(sum);
			fpll($("#taskcount")[0]);
		}
	}
	
	function fpll(obj) {
		var number = /^\d+$/;
		var temp = obj.value;
		if (number.test(temp)) {
			$("#lls_1").html(temp);
			$("#lls_3").html(parseInt($('#lls_2').text())*temp);
			$("#sum").html(parseInt($("#lls_3").text())+parseInt($("#scs_3").text())+parseInt($("#gwcs_3").text()));
			var ys = temp / (24 - hour);
			var fps = temp % (24 - hour);
			for (var i = hour; i < 24; i++) {
				$("#hour_" + i).val(parseInt(ys));
			}
			for (var i = 0; i < fps; i++) {
				var str = parseInt($("#hour_" + (hour + i)).val()) + 1;
				$("#hour_" + (hour + i)).val(str);
			}
		}
	}
	function fpsc(obj) {
		var number = /^\d+$/;
		var temp = obj.value;
		if (number.test(temp)) {
			$("#scs_1").html(temp);
			$("#scs_3").html(parseInt($("#scs_2").text())*temp);
			$("#sum").html(parseInt($("#lls_3").text())+parseInt($("#scs_3").text())+parseInt($("#gwcs_3").text()));
		}
	}
	function fpgwc(obj) {
		var number = /^\d+$/;
		var temp = obj.value;
		if (number.test(temp)) {
			$("#gwcs_1").html(temp);
			$("#gwcs_3").html(parseInt($("#gwcs_2").text())*temp);
			$("#sum").html(parseInt($("#lls_3").text())+parseInt($("#scs_3").text())+parseInt($("#gwcs_3").text()));
		}
	}
	
</script>
</html>
