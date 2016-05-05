<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<style type="text/css">
#table1 td {
	border: 1px solid #aaa;
}
.hour {
	width: 40px;
}
</style>
<body>
<div class="easyui-accordion">
	<div title="费用概览">
		<table class="table" style="margin-bottom:0px;">
			<tr class="info">
				<td>【流量数：<span id="lls_1">0</span>个，单价：<span id="lls_2">${tPriceInfoCustom.pricecounts1}</span>(积分)/个，总计：<span id="lls_3">0</span>(积分)】</td>
			</tr>
			<tr class="default">
				<td>【收藏数：<span id="scs_1">0</span>个，<span id="scs_2">${tPriceInfoCustom.pricecounts2}</span>(积分)/个，总计：<span id="scs_3">0</span>(积分)】</td>
			</tr>
			<tr class="active">
				<td>【购物车数：<span id="gwcs_1">0</span>个，单价：<span id="gwcs_2">${tPriceInfoCustom.pricecounts3}</span>/个，总计：<span id="gwcs_3">0</span>(积分)】</td>
			</tr>
			<tr class="success">
				<td>总费用:<span id="sum">0</span></td>
			</tr>
		</table>
	</div>
</div>	
	<table class="table">
		<tr>
			<td>
				宝贝id
			</td>
			<td>
				<input type="text" name="taskkeynum" id="taskkeynum"
								placeholder="请输入宝贝id" class='form-control' value="528712405918" onblur="checkkeynum(this);" />
								<span id="span" style="color:#aaa;"></span>
			</td>
		</tr>
		<tr>
			<td>
				关键词
			</td>
			<td>
				<table id="tab_keyword">
					<tr>
						<td>
							<input type="text" name="taskkeywords" class='form-control' style="width:600px;" placeholder="请输入关键词" value="2016夏季新款亚麻女装"/>		
						</td>
						<td>
							<button class="easyui-linkbutton" iconCls="icon-add" onclick="addinput();" id="btnkeywordadd">添加</button>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				发布时间
			</td>
			<td>
				<lable style="padding:0 10px 0 10px;">从:</lable>
				<input type="text" name="datefrom" id="datefrom"  width="110px"  />
				到：<input type="text" name="dateto" id="dateto"  width="110px"  />
			</td>
		</tr>
		<tr>
			<td>
				无线端标题
			</td>
			<td>
				<input type="text" name="taskwxbi" class='form-control' placeholder="请输入无线端标题" value="2016夏季新款亚麻女装"/>
			</td>
		</tr>
		<tr>
			<td>搜索方式</td>
			<td>
				<label class="radio-inline"> 
					<input type="radio" name="tasksearchType" value="0" checked="checked">综合
				</label> 
				<label class="radio-inline">
					 <input type="radio" name="tasksearchType" value="1">信用
				</label> 
				<label class="radio-inline"> 
				     <input type="radio" name="tasksearchType" value="2">价格低到高
				</label> 
				<label class="radio-inline">
					 <input type="radio" name="tasksearchType" value="3">价格高到低
				</label> 
				<label class="radio-inline">
					 <input type="radio" name="tasksearchType" value="4">销量
				</label>
			</td>
		</tr>
		<tr>
			<td>搜索价格区间</td>
			<td><input type="text" name="taskminprice" id="taskminprice" value="97" />
				 --
				<input type="text" name="taskmaxprice" id="taskmaxprice" value="99" />元
			</td>
		</tr>
		<tr>
			<td>
				访问数
			</td>
			<td>
				<input type="text" class="form-control" name="flowcount" id="flowcount"
							placeholder="请输入需要的流量数" onblur="fpll(this)"
							onchange="fpll(this)"
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')" />
			</td>
		</tr>
		<tr>
			<td>
				每时访问
			</td>
			<td>
				<table>
					<tr>
						<td>
							0点	
						</td>
						<td>
							1点	
						</td>
						<td>
							2点	
						</td>
						<td>
							3点	
						</td>
						<td>
							4点	
						</td>
						<td>
							5点	
						</td>
						<td>
							6点	
						</td>
						<td>
							7点	
						</td>
						<td>
							8点	
						</td>
						<td>
							9点	
						</td>
						<td>
							10点	
						</td>
						<td>
							11点	
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_0"	onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_1"	onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_2"	onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_3"	onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_4"	onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_5"	onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_6"	onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_7"	onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_8"	onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_9"	onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_10" onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_11" onblur="checkNum(this)" value="0" maxlength="3">
						</td>
					</tr>
					<tr>
						<td>
							12点	
						</td>
						<td>
							13点	
						</td>
						<td>
							14点	
						</td>
						<td>
							15点	
						</td>
						<td>
							16点	
						</td>
						<td>
							17点	
						</td>
						<td>
							18点	
						</td>
						<td>
							19点	
						</td>
						<td>
							20点	
						</td>
						<td>
							21点	
						</td>
						<td>
							22点	
						</td>
						<td>
							23点	
						</td>
					</tr>
					<tr>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_12" onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_13" onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_14" onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_15" onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_16" onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_17" onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_18" onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_19" onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_20" onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_21" onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_22" onblur="checkNum(this)" value="0" maxlength="3">
						</td>
						<td>
							<input type="text" class="hour" name="taskhourcounts"
								id="hour_23" onblur="checkNum(this)" value="0" maxlength="3">
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				收藏数
			</td>
			<td>
				<input type="text" name="collectioncount" id="collectioncount"
							placeholder="请输入收藏数" onblur="fpsc(this)"
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')"  value="13"/>
			</td>
		</tr>
		<tr>
			<td>
				加购物车数
			</td>
			<td>
				<input type="text" name="shoppingcount" id="shoppingcount"
							placeholder="请输入购物车数"  onblur="fpgwc(this)"
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')" value="12"/>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" class="btn btn-info" id="subbtn" value="发布流量信息">
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/page/js/tasklladd.js"></script>
<script type="text/javascript">
	var uri = "${pageContext.request.contextPath}";
</script>
</html>
