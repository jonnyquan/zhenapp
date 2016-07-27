var myDate = new Date();
var hour = myDate.getHours();
var llmax = 10000;//最大流量数
var gwcmax = 0;//最大购物车数
var scmax = 0;//最大收藏数量
var keywords=1;//关键词数量
var days=1;//天数
var subtractll = 0;//统计消耗积分时要去掉的当天不发布的流量数
var istaskword="";
var taskkeynumval="";
var isurl=false;
var mode=0;
var pricemode=0;
var taskminpricestr=0;
var taskmaxpricestr=0;
var istitle=0;
var ispass=0;

;$(function() {
	$("#div_dialog").dialog({model:true}).dialog('close');
	//$("#div_dialog").hide();
	$("#a_return").click(function(){
		$("#div_dialog").dialog('close');
		$("#a_check").focus();
	});
	$("#a_compel").click(function(){
		ispass=1;
		$("#div_dialog").dialog('close');
		$("#a_check").focus();
	});
	
	
	$("#a_check").click(function(){
		$("#div_dialog").dialog('close');
		$("#div_image").hide();
		$("#div_bur").show();
		$("#a_check").attr("disabled","disabled"); 
		
		var taskkeynumval="";
		var taskkeywords="";
		var creativetitle = $("#creativetitle").val();
		var taskimgztc = $("#taskimgztc").val();
		var taskurl = $("#taskurl").val();
		var url=taskurl.split("&");
		
		for(var i =0;i<url.length;i++){
			
			if(url[i].indexOf("id=")!=-1){
				if(!isNaN(url[i].split("=")[1])){
					$("#span_taskurl").html("宝贝url填写正确!");
					$("#span_taskurl").css("color","green");
					taskkeynumval = url[i].split("id=")[1];
					isurl=true;
					break;
				 }else{
					 $("#span_taskurl").html("请检查宝贝url!");
					 $("#span_taskurl").css("color","red");
					 $("#taskurl").focus();
					 $("#div_bur").hide();
						$("#a_check").attr("disabled",false);
					 return false;
				 }
			}
		}
		
		var taskkeywords = [];
		var inputtaskkeywords = $("input[name='taskkeywords']");
		for(var i=0;i<inputtaskkeywords.length;i++){
			if(inputtaskkeywords[i].value.length<1){
				$.messager.alert('消息提示', '关键词不允许为空', 'info');
				$("#div_bur").hide();
				$("#a_check").attr("disabled",false);
				return false;
			}
		}
		inputtaskkeywords.each(function(){
			var me = $(this);
			taskkeywords.push(me.val());//保存value到一个数组中
		});
		
		checkpricemode($("input[name=priceMode]:checked")[0]);
		taskminpricestr = $("#taskminprice").val();
		$.ajax({
			url : uri+"/api/search/"+taskkeywords+"/"+taskkeynumval+"/"+taskminpricestr,
			type : "POST",
			success:function(data,state){
				$("#div_bur").hide();
				$("#a_check").attr("disabled",false);
				if(data!=null && data.status=='y'){
					ispass=1;
					$("#img_ztc").attr("src", data.pic_path);
					$("#img_ztc2").attr("src", data.pic_path2);
					$("#div_image").css("display","block");
				}else{
					ispass=0;
					$("#div_dialog").show().dialog("open");
					$("#a_check").focus();
					return false;
				}
			}
		});
		
	});
	
	checkpricemode($("input[name=priceMode]:checked")[0]);
	
	$("#taskurl").focus();
	$(".box").show();
	$(".box").click(function(){
	});
	
	if($("#taskurl").val().length >1){
		checkurl_2($("#taskurl")[0]);
		
		checkword($("#taskkeywordcheck")[0]);
	}
	
	
	fpll($("#flowcount")[0]);//默认加载一次分配流量数
	
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
			days = parseInt(datevalue1)-parseInt(datevalue3)+1;
			totalsum();
		},
	});
	
	//开始日期验证
	$("input[name='datefrom']").validatebox({
		required : true,
		missingMessage : '请输入开始日期',
		invalidMessage : '开始日期不得为空',
		disabled : true,
	});
	//结束日期验证
	$("input[name='dateto']").validatebox({
		required : true,
		missingMessage : '请输入结束日期',
		invalidMessage : '结束日期不得为空',
		disabled : true,
	});
	//宝贝url验证
	$('#taskurl').validatebox({
		required : true,
		missingMessage : '请输入宝贝url',
		invalidMessage : '宝贝url不得为空',
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
	/*深入点击验证
	$('#deepclick').validatebox({
		required : true,
		missingMessage : '请输入深入点击比例',
		invalidMessage : '深入点击比例不得为空',
	});*/
	//宝贝价格验证
	$('#taskprice').validatebox({
		required : true,
		missingMessage : '请输入宝贝价格',
		invalidMessage : '宝贝价格不得为空',
	});
	//最小价格验证
	$('#taskminprice').validatebox({
		required : true,
		missingMessage : '请输入最小价格',
		invalidMessage : '最小价格不得为空',
	});
	//最大价格验证
	$('#taskmaxprice').validatebox({
		required : true,
		missingMessage : '请输入最大价格',
		invalidMessage : '最大价格不得为空',
	});
	//直通车图片验证
	$('#taskimgztc').validatebox({
		required : true,
		missingMessage : '请输入直通车图片',
		invalidMessage : '直通车图片不得为空',
	});
	//创意标题验证
	$('#creativetitle').validatebox({
		required : true,
		missingMessage : '请输入创意标题',
		invalidMessage : '创意标题不得为空',
	});
	

	/*
	发布流量
	*/
	$("#subbtn").click(function () {
		/*if(ispass!=1){
			$.messager.alert('消息提示', '请校验直通车排名', 'info', function () {
				$('#taskurl').focus();
			});
			return false;
		}*/
		
		//checkpricemode($("#priceMode2")[0]);
		
		if (!$('#taskurl').validatebox('isValid')) {
			$.messager.alert('消息提示', '请输入宝贝url!', 'info', function () {
				$('#taskurl').focus();
			});
			return false;
		}
		
		if(isurl == false){
			$("#taskurl").focus();
			$.messager.alert('消息提示', '请检查宝贝url!', 'info', function () {
			});
			return false;
		}
		
		if(istaskword!=""){
			var inputtaskkeywords = $("input[name='taskkeywords']");
			for(var i=0;i<inputtaskkeywords.length;i++){
				if(inputtaskkeywords[i].value==istaskword){
					$.messager.alert('消息提示', '关键词验证不通过!', 'info', function () {
						$("input[name='taskkeywords']")[i].focus();
					});
					return false;
				}
			}
		}
		if(mode==1){
			if (!$('#taskimgztc').validatebox('isValid')) {
				$.messager.alert('消息提示', '请输入直通车图片!', 'info', function () {
					$('#taskimgztc').focus();
				});
				return false;
			}
		}else{
			checktitle();
			if(istitle==0){
				$.messager.alert('消息提示', '请正确输入创意标题!', 'info', function () {
					$('#creativetitle').focus();
				});
				return false;
			}
			if (!$('#creativetitle').validatebox('isValid')) {
				$.messager.alert('消息提示', '请输入创意标题!', 'info', function () {
					$('#creativetitle').focus();
				});
				return false;
			}
		}
		if(pricemode=1){
			if (!$('#taskminprice').validatebox('isValid')) {
				$.messager.alert('消息提示', '请输入最小价格!', 'info', function () {
					$('#taskminprice').focus();
				});
				return false;
			}
			if (!$('#taskmaxprice').validatebox('isValid')) {
				$.messager.alert('消息提示', '请输入最大价格!', 'info', function () {
					$('#taskmaxprice').focus();
				});
				return false;
			}
		}
		if (!$('#taskprice').validatebox('isValid')) {
			$.messager.alert('消息提示', '请输入宝贝价格!', 'info', function () {
				$('#taskprice').focus();
			});
			return false;
		}
		
		if (!$('#flowcount').validatebox('isValid')) {
			$.messager.alert('消息提示', '请输入发布流量数!', 'info', function () {
				$('#flowcount').focus();
			});
			return false;
		}
		if (!$('#collectioncount').validatebox('isValid')) {
			$.messager.alert('消息提示', '请输入发布收藏数!', 'info', function () {
				$('#collectioncount').focus();
			});
			return false;
		}
		if(parseInt($('#collectioncount').val())>parseInt($('#flowcount').val())){
			$.messager.alert('消息提示', '发布的收藏数必须小于或等于流量数!', 'info', function () {
				$('#collectioncount').focus();
			});
			return false;
		}
		if (!$('#shoppingcount').validatebox('isValid')) {
			$.messager.alert('消息提示', '请输入发布购物车数!', 'info', function () {
				$('#shoppingcount').focus();
			});
			return false;
		}
		if(parseInt($('#shoppingcount').val())>parseInt($('#flowcount').val())){
			$.messager.alert('消息提示', '发布的加购物车数必须小于或等于流量数!', 'info', function () {
				$('#shoppingcount').focus();
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
		var temphourcounts=0;
		inputtaskhourcounts.each(function(){
			var me = $(this);
			temphourcounts=parseInt(temphourcounts)+parseInt(me.val());
			taskhourcounts.push(parseInt(me.val()));//保存value到一个数组中
		});
		
		if(temphourcounts==0){
			$.messager.alert('消息提示', '流量数最少不能小于1', 'info');
			return false;
		}
		$("#subbtn").attr("disabled","true");
		$.ajax({
			url : uri+"/task/saveTaskInfo",
			type : "POST",
			data : {
				llmax :llmax,
				scmax : scmax,
				gwcmax : gwcmax,
				taskurl : $("#taskurl").val(),
				taskimgztc : $("#taskimgztc").val(),
				creativetitle : $("#creativetitle").val(),
				mode : mode,
				deepclick : "0",
				shipaddress : "Alladdress",
				taskkeynum : taskkeynumval,
				taskkeywords : taskkeywords.join('===='),
				tasktype:"34",
				taskstartdate:$("input[name='datefrom']")[0].value,
				taskenddate:$("input[name='dateto']")[0].value,
				taskhourcounts : taskhourcounts.join(','),
				taskminprice : $('#taskminprice').val(),
				taskmaxprice : $('#taskmaxprice').val(),
				taskprice : $("#taskprice").val(),
				tasksearchtype : $("#tasksearchType").val(),
				flowcount : $("#flowcount").val(),
				collectioncount : $("#collectioncount").val(),
				shoppingcount : $("#shoppingcount").val(),
				subtractpoints : $("#sum").text(),
			},
			success:function(data,state){
				$('#subbtn').removeAttr("disabled");
				if(data.data=="insertsuccess"){
					$.messager.alert('消息提示', '任务发布成功!', 'info', function () {
						window.location.href=uri+"/task/responsetaskadd";
					});
				}else if(data.data=="refuse"){
					$.messager.alert('消息提示', '系统维护暂停任务发布!', 'info', function () {
						window.location.href=uri+"/task/responsetaskadd";
					});
				}else if(data.data=="agentlow"){
					$.messager.alert('消息提示', '代理积分不足,任务发布失败!', 'info', function () {
						window.location.href=uri+"/task/responsetaskadd";
					});
				}else if(data.data=="allocationing"){
					$.messager.alert('消息提示', '该宝贝id有待分配状态的任务,任务发布失败!', 'info', function () {
						window.location.href=uri+"/task/responsetaskadd";
					});
				}else if(data.data=="low"){
					$.messager.alert('消息提示', '余额不足,任务发布失败!', 'info', function () {
						window.location.href=uri+"/task/responsetaskadd";
					});
				}else if(data.data=="llmaxerror"){
					$.messager.alert('消息提示', '超出允许发布的最大流量数,任务发布失败!', 'info', function () {
						window.location.href=uri+"/task/responsetaskadd";
					});
				}else if(data.data=="scmaxerror"){
					$.messager.alert('消息提示', '超出允许发布的最大收藏数,任务发布失败!', 'info', function () {
						window.location.href=uri+"/task/responsetaskadd";
					});
				}else if(data.data=="gwcmaxerror"){
					$.messager.alert('消息提示', '超出允许发布的最大加购数,任务发布失败!', 'info', function () {
						window.location.href=uri+"/task/responsetaskadd";
					});
				}else if(data.data=="gwcnotsc"){
					$.messager.alert('消息提示', '加购数必须等于收藏数,任务发布失败!', 'info', function () {
						window.location.href=uri+"/task/responsetaskadd";
					});
				}else if(data.data=="count0"){
					$.messager.alert('消息提示', '发布的任务数必须为正整数,任务发布失败!', 'info', function () {
						window.location.href=uri+"/task/responsetaskadd";
					});
				}else if(data.data=="flowerror"){
					$.messager.alert('消息提示', '流量数与单位小时流量数之和不匹配,任务发布失败!', 'info', function () {
						window.location.href=uri+"/task/responsetaskadd";
					});
				}else{
					$.messager.alert('消息提示', '发布失败!', 'info', function () {
						window.location.href=uri+"/task/responsetaskadd";
					});
				}
			}
		});
	});
});
function totalsum(){
	var temp1 = $("#flowcount")[0].value;
	if(temp1.length<1){
		temp1=0;
	}
	$("#lls_1").html(temp1);
	$("#lls_3").html(parseInt($('#lls_2').text())*temp1);
	var temp2 = $("#collectioncount")[0].value;
	if(temp2.length<1){
		temp2=0;
	}
	$("#scs_1").html(temp2);
	$("#scs_3").html(parseInt($('#scs_2').text())*temp2);
	var temp3 = $("#shoppingcount")[0].value;
	if(temp3.length<1){
		temp3=0;
	}
	$("#gwcs_1").html(temp3);
	$("#gwcs_3").html(parseInt($('#gwcs_2').text())*temp3);
	if(parseInt(temp1) < parseInt(temp2)){
		$("#span_flowcount").html("发布流量数不得小于收藏数");
		$("#span_flowcount").css("color","red");
		//$("#flowcount").focus();
		return false;
	}
	if(parseInt(temp1) < parseInt(temp3)){
		$("#span_flowcount").html("发布流量数不得小于加购物车数!");
		$("#span_flowcount").css("color","red");
		//$("#flowcount").focus();
		return false;
	}
	$("#sum").html(parseInt($("#lls_3").text())+parseInt($("#scs_3").text())+parseInt($("#gwcs_3").text()));
	$("#sum").html(parseInt($("#sum").text())*keywords*days);
}

/*
 * 检查每小时输入的数字是否为数字
 */
function checkNum(obj) {
	var number = /^\d+$/;
	var temp = obj.value;
	if (!number.test(temp)) {
		$.messager.alert('消息提示', '每时数量必须为0到150之间的数字!', 'info');
		obj.value = "0";
		totalsum();
	}else{
		var sum=0;
		for(var i=0;i<24;i++){
			sum=sum+parseInt($("#hour_" +  i).val());
		}
		$("#flowcount").val(sum);
		var number = /^\d+$/;
		var temp = $("#flowcount")[0].value;
		if (number.test(temp)) {
			totalsum();
		}
	}
}

/*
检查输入的流量数
*/
function fpll(obj) {
	var number = /^\d+$/;
	var temp = obj.value;
	if(parseInt(temp) > parseInt(llmax)){
		$("#span_flowcount").html("该宝贝发布流量数不能大于允许发布的最大流量数!");
		$("#span_flowcount").css("color","red");
		$("#flowcount").val(llmax);
		temp=llmax;
	}else{
		$("#span_flowcount").html("该宝贝发布流量数填写正确!");
		$("#span_flowcount").css("color","green");
	}
	if (number.test(temp)) {
		totalsum();
		$("#hour_" + hour).val(parseInt(temp));
	}
}
function fpsc(obj) {
	var number = /^\d+$/;
	var temp = obj.value;
	if(temp.length<1){
		$('#collectioncount').val("0");
		temp=0;
	}
	if(parseInt(temp) > parseInt($("#flowcount").val())){
		$("#span_collection").show();
		$("#span_collection").html("该宝贝发布收藏数不能大于发布的流量数");
		$("#span_collection").css("color","red");
		$("#span_collection").hide(2000);
		$("#collectioncount").val($("#flowcount").val());
		$('#shoppingcount').val($("#flowcount").val());
	}else{
		$("#span_collection").show();
		$("#span_collection").html("该宝贝发布收藏数填写正确!");
		$("#span_collection").css("color","green");
		$('#shoppingcount').val(temp);
		$("#span_shopping").html("该宝贝发布加购数填写正确!");
		$("#span_shopping").css("color","green");
	}
	if (number.test(temp)) {
		totalsum();
	}
}
function fpgwc(obj) {
	var number = /^\d+$/;
	var temp = obj.value;
	if(temp.length<1){
		$('#shoppingcount').val("0");
		temp=0;
	}
	if(parseInt(temp) > parseInt($("#flowcount").val())){
		$("#span_shopping").show();
		$("#span_shopping").html("该宝贝发布加购数不能大于发布的流量数");
		$("#span_shopping").css("color","red");
		$("#span_shopping").hide(2000);
		$("#shoppingcount").val($("#flowcount").val());
		$('#collectioncount').val($("#flowcount").val());
	}else{
		$("#span_shopping").show();
		$("#span_shopping").html("该宝贝发布加购数填写正确!");
		$("#span_shopping").css("color","green");
		$('#collectioncount').val(temp);
		$("#span_collection").html("该宝贝发布收藏数填写正确!");
		$("#span_collection").css("color","green");
	}
	if (number.test(temp)) {
		totalsum();
	}
}
/*
检查宝贝id当天可以发布多少流量数
*/
function checkurl(obj){
	isurl=false;
	taskkeynumval="";
	//清空关键词
	var inputtaskkeywords = $("input[name='taskkeywords']");
	for(var i=0;i<inputtaskkeywords.length;i++){
		inputtaskkeywords[i].value="";
	}
	var url=obj.value.split("&");
	for(var i =0;i<url.length;i++){
		if(url[i].indexOf("id=")!=-1){
			if(!isNaN(url[i].split("=")[1])){
				$("#span_taskurl").html("宝贝url填写正确!");
				$("#span_taskurl").css("color","green");
				taskkeynumval = url[i].split("id=")[1];
				isurl=true;
				break;
			 }else{
				 $("#span_taskurl").html("请检查宝贝url!");
				 $("#span_taskurl").css("color","red");
				 $("#taskurl").focus();
				 return false;
			 }
		}
	}
	if(taskkeynumval.length<1){
		 $("#span_taskurl").html("请检查输入的宝贝url中的宝贝id!");
		 $("#span_taskurl").css("color","red");
		 $("#taskurl").focus();
		 return false;
	}else{
		$("#span_taskurl").html("宝贝url填写正确!");
		$("#span_taskurl").css("color","green");
	}
}


/*
 *验证关键词
 */
function checkword(obj){
	isurl=false;
	var taskurl = $("#taskurl").val();
	var url=taskurl.split("&");
	for(var i =0;i<url.length;i++){
		if(url[i].indexOf("id=")!=-1){
			if(!isNaN(url[i].split("=")[1])){
				taskkeynumval = url[i].split("id=")[1];
				isurl=true;
				break;
			 }else{
				 $("#span_taskurl").html("请检查宝贝url!");
				 $("#span_taskurl").css("color","red");
				 $("#taskurl").focus();
				 return false;
			 }
		}
	}
	if(taskkeynumval.length>1){
		$.ajax({
			url : uri+"/api/keywords/validateztc/"+obj.value+"/"+taskkeynumval,
			type : "POST",
			success:function(data,state){
				if(data.msg == 0){
					$.messager.alert('消息提示', '关键词与该宝贝无法匹配!', 'info', function () {
						//obj.focus();
						$(obj).parent().next().next().next().next().html("关键词与该宝贝无法匹配");
						$(obj).parent().next().next().next().next().css("color","red");
						return false;
					});
					istaskword=obj.value;
				}else{
					istaskword="";
					$(obj).parent().next().next().next().next().html("关键词填写正确");
					$(obj).parent().next().next().next().next().css("color","green");
					llmax=data.count/keywords;
					scmax=data.countztc/keywords;
					gwcmax=data.countztc/keywords;
					$("#span_flowcount_text").html("  今天最多还可发:"+llmax);
					$("#span_shopping_text").html("  今天最多还可发:"+gwcmax);
					$("#span_collection_text").html("  今天最多还可发:"+scmax);
					if(parseInt($("#flowcount").val()) > parseInt(llmax)){
						$("#span_flowcount").html("该宝贝发布流量数不允许超过："+llmax);
						$("#span_flowcount").css("color","red");
						$("#flowcount").val(llmax);
						fpll($("#flowcount")[0]);
					}else{
						$("#span_flowcount").html("该宝贝发布流量数填写正确!");
						$("#span_flowcount").css("color","green");
						fpll($("#flowcount")[0]);
					}
					if(parseInt($("#collectioncount").val()) > parseInt(scmax)){
						$("#span_collection").html("该宝贝发布收藏数不能大于允许发布的最大收藏数");
						$("#span_collection").css("color","red");
						$("#collectioncount").val(scmax);
					}else{
						$("#span_collection").html("该宝贝发布收藏数填写正确!");
						$("#span_collection").css("color","green");
					}
					if(parseInt($("#shoppingcount").val()) > parseInt(gwcmax)){
						$("#span_shoppingcount").html("该宝贝发布加购数不能大于允许发布的最大加购数");
						$("#span_shoppingcount").css("color","red");
						$("#shoppingcount").val(gwcmax);
					}else{
						$("#span_shopping").html("该宝贝发布加购数填写正确!");
						$("#span_shopping").css("color","green");
					}
				}
			}
		});
	}else{
		$("#span_taskurl").html("请检查宝贝url!");
		 $("#span_taskurl").css("color","red");
		 $("#taskurl").focus();
		 return false;
	}
}
/*
添加多关键词
 */
function addinput(){ 
	var trNumber=document.getElementById("tab_keyword").rows.length; 
	if(trNumber<4){
		var newTr=document.getElementById("tab_keyword").insertRow(trNumber); 
		newTr.insertCell(0).innerHTML="";
		newTr.insertCell(1).innerHTML="";
		newTr.insertCell(2).innerHTML="<input type='text' name='taskkeywords' style='width:200px;' onchange='checkword(this);'/>"; 
		newTr.insertCell(3).innerHTML="";
		newTr.insertCell(4).innerHTML='<input type="button" class="easyui-linkbutton" iconCls="icon-remove" onclick="delRow(this)" value="&nbsp;&nbsp;删&nbsp;除 &nbsp;&nbsp;" />';
		newTr.insertCell(5).innerHTML="";
		newTr.insertCell(6).innerHTML="";
	}
	keywords = $("input[name='taskkeywords']").length;
	checkurl($("#taskurl")[0]);
	totalsum();
}
/*
删除添加的多关键词
 */
function delRow(r){ 
	document.getElementById("tab_keyword").deleteRow(r.parentNode.parentNode.rowIndex);
	keywords = $("input[name='taskkeywords']").length;
	checkurl($("#taskurl")[0]);
	totalsum();
}	

/*
检查宝贝id当天可以发布多少直通车流量数
*/
function checkurl_2(obj){
	isurl=false;
	taskkeynumval="";
	var url=obj.value.split("&");
	for(var i =0;i<url.length;i++){
		if(url[i].indexOf("id=")!=-1){
			if(!isNaN(url[i].split("=")[1])){
				$("#span_taskurl").html("宝贝url填写正确!");
				$("#span_taskurl").css("color","green");
				taskkeynumval = url[i].split("id=")[1];
				isurl=true;
				break;
			 }else{
				 $("#span_taskurl").html("请检查宝贝url!");
				 $("#span_taskurl").css("color","red");
				 $("#taskurl").focus();
				 return false;
			 }
		}
	}
	if(taskkeynumval.length<1){
		 $("#span_taskurl").html("请检查输入的宝贝urlid长度!");
		 $("#span_taskurl").css("color","red");
		 $("#taskurl").focus();
		 return false;
	}else{
		$("#span_taskurl").html("宝贝url填写正确!");
		$("#span_taskurl").css("color","green");
	}
}
/*
检查模式
*/
function checkmode(obj){
	if(obj.checked==true){
		if(obj.value=='1'){
			mode=1;
			$("#div_taskimgztc").show();
			$("#div_creativetitle").hide();
		}else{
			mode=0;
			$("#div_creativetitle").show();
			$("#div_taskimgztc").hide();
		}
	}
}

/*
 *价格变化设置值
 */
function setprice(){
	taskminpricestr = $("#taskminprice").val();
	taskmaxpricestr = $("#taskmaxprice").val();
	checkpricemode($("input[name=priceMode]:checked")[0]);
}
/*
检查卡价格模式
*/
function checkpricemode(obj){
	var teststr=/^[1-9]\d*.\d*|0.\d*[1-9]\d*|0?.0+|0$/;
	var price = $("#taskprice").val();
	if(teststr.test(price)){
		if(obj.checked==true){
			if(obj.value=='3'){
				taskminpricestr=0;
				taskmaxpricestr=0;
				$("#taskminprice").attr("disabled",false);
				$("#taskmaxprice").attr("disabled",false);
			}else if(obj.value=='0'){
				taskminpricestr=0;
				taskmaxpricestr=0;
				$("#taskminprice").val("0");
				$("#taskmaxprice").val("0");
				$("#taskminprice").attr("disabled","disabled"); 
				$("#taskmaxprice").attr("disabled","disabled");
			}else if(obj.value=='1'){
				var pricearr=price.split(".");
				if(pricearr.length>1){
					if(parseInt(price)<1){
						taskminpricestr=0;
					}else{
						taskminpricestr= (parseInt(price.split(".")[0])-1)+"."+price.split(".")[1];
					}
					taskmaxpricestr= (parseInt(price.split(".")[0])+10)+"."+price.split(".")[1];
				}else{
					if(parseInt(price)<1){
						taskminpricestr=0;
					}else{
						taskminpricestr= (parseInt(price.split(".")[0])-1);
					}
					taskmaxpricestr= (parseInt(price.split(".")[0])+10);
				}
				$("#taskminprice").val(taskminpricestr);
				$("#taskmaxprice").val(taskmaxpricestr);
				$("#taskminprice").attr("disabled","disabled"); 
				$("#taskmaxprice").attr("disabled","disabled");
			}else if(obj.value=='2'){
				var pricearr=price.split(".");
				if(pricearr.length>1){
					if(parseInt(price)<10){
						taskminpricestr=0;
					}else{
						taskminpricestr= (parseInt(price.split(".")[0])-10) + "." + price.split(".")[1];
					}
					taskmaxpricestr= (parseInt(price.split(".")[0])+10) + "." + price.split(".")[1];
				}else{
					if(parseInt(price)<10){
						taskminpricestr=0;
					}else{
						taskminpricestr= (parseInt(price.split(".")[0])-10);
					}
					taskmaxpricestr= (parseInt(price.split(".")[0])+10);
				}
				$("#taskminprice").val(taskminpricestr);
				$("#taskmaxprice").val(taskmaxpricestr);
				$("#taskminprice").attr("disabled","disabled"); 
				$("#taskmaxprice").attr("disabled","disabled");
			}
		}
		$("#span_taskprice").html("输入价格正确!");
		$("#span_taskprice").css("color","green");
	}else{
		$("#span_taskprice").html("请先输入正确的价格!");
		$("#span_taskprice").css("color","red");
		$("#span_taskprice").val("0");
	}
}

function checktitle(){
	var title = $("#creativetitle").val();
	if(title.length<9){
		istitle=0;
		$("#span_creativetitle").html("创意标题不得少于9位");
		$("#span_creativetitle").css("color","red");
		$("#creativetitle").focus();
	}else{
		istitle=1;
		$("#span_creativetitle").html("创意标题输入正确");
		$("#span_creativetitle").css("color","green");
	}
}