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
<script type="text/javascript">
	var uri = "${pageContext.request.contextPath}";
	var myDate = new Date();
	var hour = myDate.getHours();
	var llmax = 1000;//最大流量数
	var gwcmax = 0;//最大购物车数
	var scmax = 0;//最大收藏数量
	var keywords=1;//关键词数量
	var days=1;//天数
	
	;$(function() {
		$('#datefrom').datebox({
			onSelect : function(date){
				var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
				var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0" + (date.getMonth() + 1);
				var day2 = myDate.getDate() > 9 ? myDate.getDate() : "0" + myDate.getDate();
				var month2 = (myDate.getMonth() + 1) > 9 ? (myDate.getMonth() + 1) : "0" + (myDate.getMonth() + 1);
				var datevalue1 = date.getFullYear() + "" + month + "" +day;
				var datevalue2 = myDate.getFullYear() + "" + month2 + "" +day2;
				if(datevalue1 < datevalue2){
					$.messager.alert('消息提示', '不允许回忆从前哦!', 'info', function () {
						$('#datefrom').datebox('setValue',"");
					});
				}
			},
		});
		
		$('#dateto').datebox({
			onSelect : function(date){
				var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
				var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0" + (date.getMonth() + 1);
				var datevalue1 = date.getFullYear() + "" + month + "" +day;
				var datevalue2 = $("input[name='datefrom']")[0].value;
				var datevalue3 = datevalue2.replace("-","").replace("-","");
				if(datevalue3.length <1){
					$.messager.alert('消息提示', '请先选择开始时间!', 'info', function () {
						$('#dateto').datebox('setValue',"");
					});
					return false;
				}
				if(datevalue1 < datevalue3){
					$.messager.alert('消息提示', '结束日期不允许小于开始日期!', 'info', function () {
						$('#dateto').datebox('setValue',"");
					});
				}
				days = parseInt(datevalue1)-parseInt(datevalue3);
			},
		});
		//开始日期验证
		$("input[name='datefrom']").validatebox({
			required : true,
			missingMessage : '请输入开始日期',
			invalidMessage : '开始日期不得为空',
		});
		//结束日期验证
		$("input[name='dateto']").validatebox({
			required : true,
			missingMessage : '请输入结束日期',
			invalidMessage : '结束日期不得为空',
		});
		//宝贝id验证
		$('#taskkeynum').validatebox({
			required : true,
			missingMessage : '请输入宝贝id',
			invalidMessage : '宝贝id不得为空',
		});
		//发布流量数验证
		$('#flowcount').validatebox({
			required : true,
			missingMessage : '请输入发布流量数',
			invalidMessage : '发布流量数不得为空',
		});
		//发布收藏数验证
		$('#collectioncount').validatebox({
			required : true,
			missingMessage : '请输入发布收藏数',
			invalidMessage : '发布收藏数不得为空',
		});
		//发布购物车数验证
		$('#shoppingcount').validatebox({
			required : true,
			missingMessage : '请输入发布购物车数',
			invalidMessage : '发布购物车数不得为空',
		});
		
		
		/*
		发布流量
		*/
		$("#subbtn").click(function () {
			if (!$('#taskkeynum').validatebox('isValid')) {
				$.messager.alert('消息提示', '请输入宝贝id!', 'info', function () {
					$('#taskkeynum').focus();
				});
				return false;
			}
			if (!$('#flowcount').validatebox('isValid')) {
				$.messager.alert('消息提示', '请输入发布流量数!', 'info', function () {
					$('#taskkeynum').focus();
				});
				return false;
			}
			if (!$('#collectioncount').validatebox('isValid')) {
				$.messager.alert('消息提示', '请输入发布收藏数!', 'info', function () {
					$('#taskkeynum').focus();
				});
				return false;
			}
			if (!$('#shoppingcount').validatebox('isValid')) {
				$.messager.alert('消息提示', '请输入发布购物车数!', 'info', function () {
					$('#taskkeynum').focus();
				});
				return false;
			}
			if($("input[name='datefrom']")[0].value.length < 1){
				$.messager.alert('消息提示', '请输入开始日期!', 'info', function () {
					$('#datefrom').focus();
				});
				return false;
			}
			if($("input[name='dateto']")[0].value.length < 1){
				$.messager.alert('消息提示', '请输入结束日期!', 'info', function () {
					$('#dateto').focus();
				});
				return false;
			}
			var taskkeywords = [];
			var inputtaskkeywords = $("input[name='taskkeywords']");
			for(var i=0;i<inputtaskkeywords.length;i++){
				if(inputtaskkeywords[i].value.length<1){
					$.messager.alert('消息提示', '关键词不允许为空', 'info');
					return false;
				}
			}
			inputtaskkeywords.each(function(){
				var me = $(this);
				taskkeywords.push(me.val());//保存value到一个数组中
			});
			var taskhourcounts = [];
			var inputtaskhourcounts = $("input[name='taskhourcounts']");
			inputtaskhourcounts.each(function(){
				var me = $(this);
				taskhourcounts.push(me.val());//保存value到一个数组中
			});
			$.ajax({
				url : "${pageContext.request.contextPath}/task/insertTaskInfo",
				type : "POST",
				data : {
					taskkeynum : $("#taskkeynum").val(),
					taskkeywords : taskkeywords.join('===='),
					tasktype:"0",
					taskstartdate:$("input[name='datefrom']")[0].value,
					taskenddate:$("input[name='dateto']")[0].value,
					taskhourcounts : taskhourcounts.join(','),
					taskminprice : $("#taskminprice").val(),
					taskmaxprice : $("#taskmaxprice").val(),
					tasksearchtype : $("input[name='tasksearchType']:checked").val(),
					flowcount : $("#flowcount").val(),
					collectioncount : $("#collectioncount").val(),
					shoppingcount : $("#shoppingcount").val(),
				},
				success:function(data,state){
					if(data.data=="insertsuccess"){
						$.messager.alert('消息提示', '任务发布成功!', 'info', function () {
							window.location.href="${pageContext.request.contextPath}/page/task/tasklladd.jsp";
						});
					}
				}
			});
		});
		
		/*
		将超过当天时刻的置为不可输入
		
		for (var i = 0; i <= hour; i++) {
			$("#hour_" + i).val("0");
			$("#hour_" + i).attr("disabled", true);
		}
		*/
		
	});

	/*
	检查每小时输入的数字是否为数字
	*/
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
			$("#flowcount").val(sum);
			var number = /^\d+$/;
			var temp = $("#flowcount")[0].value;
			if (number.test(temp)) {
				$("#lls_1").html(temp);
				$("#lls_3").html(parseInt($('#lls_2').text())*temp);
				$("#sum").html(parseInt($("#lls_3").text())+parseInt($("#scs_3").text())+parseInt($("#gwcs_3").text()));
				$("#sum").html(parseInt($("#sum").text())*keywords*days);
			}
		}
	}
	/*
	检查输入的流量数
	*/
	function fpll(obj) {
		var number = /^\d+$/;
		var temp = obj.value;
		if(temp>llmax){
			$.messager.alert('消息提示', '该宝贝id发布流量数不能大于允许发布的最大流量数!', 'info', function () {
				$("#flowcount").val(llmax);
				return false;
			});
		}
		if (number.test(temp)) {
			$("#lls_1").html(temp);
			$("#lls_3").html(parseInt($('#lls_2').text())*temp);
			$("#sum").html(parseInt($("#lls_3").text())+parseInt($("#scs_3").text())+parseInt($("#gwcs_3").text()));
			$("#sum").html(parseInt($("#sum").text())*keywords*days);
			var ys = temp / (24 - hour-1);
			var fps = temp % (24 - hour-1);
			for (var i = hour+1; i < 24; i++) {
				$("#hour_" + i).val(parseInt(ys));
			}
			for (var i = 0; i < fps; i++) {
				var str = parseInt($("#hour_" + (hour+1 + i)).val()) + 1;
				$("#hour_" + (hour+1 + i)).val(str);
			}
		}
	}
	function fpsc(obj) {
		var number = /^\d+$/;
		var temp = obj.value;
		if(temp.length<1){
			$('#collectioncount').val("0");
			temp=0;
		}
		if (number.test(temp)) {
			$("#scs_1").html(temp);
			$("#scs_3").html(parseInt($("#scs_2").text())*temp);
			$("#sum").html(parseInt($("#lls_3").text())+parseInt($("#scs_3").text())+parseInt($("#gwcs_3").text()));
			$("#sum").html(parseInt($("#sum").text())*keywords*days);
		}
	}
	function fpgwc(obj) {
		var number = /^\d+$/;
		var temp = obj.value;
		if(temp.length<1){
			$('#shoppingcount').val("0");
			temp=0;
		}
		if (number.test(temp)) {
			$("#gwcs_1").html(temp);
			$("#gwcs_3").html(parseInt($("#gwcs_2").text())*temp);
			$("#sum").html(parseInt($("#lls_3").text())+parseInt($("#scs_3").text())+parseInt($("#gwcs_3").text()));
			$("#sum").html(parseInt($("#sum").text())*keywords*days);
		}
	}
	/*
	检查宝贝id当天可以发布多少流量数
	*/
	function checkkeynum(obj){
		if(obj.value.length<1){
			llmax=1000;
		}else{
			$.ajax({
				url : "${pageContext.request.contextPath}/phone/findAllPhoneInfoBykeynum/"+obj.value,
				type : "POST",
				success:function(data,state){
					llmax=data.count;
					if($("#flowcount").val()>llmax){
						$.messager.alert('消息提示', '该宝贝id发布流量数不能大于允许发布的最大流量数!', 'info', function () {
							$("#flowcount").val(llmax);
							fpll($("#flowcount")[0]);
						});
					}
					
				}
			});
		}
		$("#span").html("最多可发布流量数:"+llmax);
	}
	
	/*
	添加多关键词
	 */
	function addinput(){ 
		var trNumber=document.getElementById("tab_keyword").rows.length; 
		if(trNumber<4){
			var newTr=document.getElementById("tab_keyword").insertRow(trNumber); 
			newTr.insertCell(0).innerHTML="<input type='text' name='taskkeywords' class='form-control' placeholder='请输入关键词' />"; 
			newTr.insertCell(1).innerHTML="<input type='button' class='easyui-linkbutton' iconCls='icon-remove' onclick='delRow(this)' value='删除' />";
		}
		keywords = $("input[name='taskkeywords']").length;
	}
	/*
	删除添加的多关键词
	 */
	function delRow(r){ 
		document.getElementById("tab_keyword").deleteRow(r.parentNode.parentNode.rowIndex);
		keywords = $("input[name='taskkeywords']").length;
	}
</script>
</html>
