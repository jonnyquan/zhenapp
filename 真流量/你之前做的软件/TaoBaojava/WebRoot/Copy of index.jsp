<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.wxf.bean.TaoBaobean"%>
<%
String path = request.getContextPath();
String path2=request.getSession().getServletContext().getRealPath("/")+"temp.bmp";
System.out.println(path2);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String zt=request.getAttribute("zt")==null?"0":request.getAttribute("zt").toString();
TaoBaobean taobao=request.getAttribute("taobao")==null?null:(TaoBaobean)request.getAttribute("taobao");
String keyword=request.getAttribute("keyword")==null?"":request.getAttribute("keyword").toString();
String itemId=request.getAttribute("itemId")==null?"":request.getAttribute("itemId").toString();
String startPrice=request.getAttribute("startPrice")==null?"":request.getAttribute("startPrice").toString();
String endPrice=request.getAttribute("endPrice")==null?"":request.getAttribute("endPrice").toString();
String pagecount=request.getAttribute("pagecount")==null?"100":request.getAttribute("pagecount").toString();
String check=request.getAttribute("check")==null?"100":request.getAttribute("check").toString();
String Seller=taobao==null?"":taobao.getSeller();
String Goods=taobao==null?"":taobao.getGoods();
String Freight=taobao==null?"":taobao.getFreight();
String Price=taobao==null?"":taobao.getPrice();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
  </head>
  
  <body>
  <form id="form1" action="<%=basePath%>Taobaomain" method="post"> 
  <input type="hidden" name="check" id="check">
  使用次数:<input type="text" name="zt" id="zt" value="<%=zt %>" />
    	<table>
    		<tr>
    			<td>关键词：<input type="text" name="keyword" id="keyword" value="<%=(keyword==null||keyword.equals(""))?"男装":keyword %>"><font color="red">*男装 </font></td>
    			<td>商品ID：<input type="text" name="itemId" id="itemId" value="<%=(itemId==null||itemId.equals(""))?"42369515833":itemId %>"><font color="red">*40439254139</font></td>
    			
    		</tr>
    		<TR><td>
    				排序方式：
    				<select id="sort" name="sort">
    					<option value="_coefp">综合</option>
    					<option value="_coefp">人气</option>
    					<option value="_ratesum">信用</option>
    					<option value="_sale">销量</option>
    					<option value="bid">价格从低到高</option>
    					<option value="_bid">价格从高到低</option>
    				</select>
    			</td>
    			<td>查询前<input type="text" name="pagecount" id="pagecount" value="<%=pagecount %>"/>页</td>
    			<td colspan="3">
    				价格区间：
    				<input type="text" name="startPrice" id="startPrice" value="<%=startPrice %>">--
    				<input type="text" name="endPrice" id="endPrice" value="<%=endPrice %>">
    			</td>
    			
    		</tr>
    		<tr>		<td>
    					地区：<input type="text" name="Seller" id="Seller" value="<%=Seller==null?"":Seller %>"/>
	    				</td>
	    				<td>
	    				<%if(Seller==null || Seller.equals("")){ %>
	    					<input type="checkbox"  name="isSeller" id="isSeller" value="1"/>启用地区筛选
	    				<%}else{ %>
	    					<input type="checkbox" checked="checked" name="isSeller" id="isSeller" value="0"/>启用地区筛选
	    				<%} %>
	    				</td>
	    				<td>
	    				<%if(Goods==null || Goods.equals("") || Goods.equals("淘宝")){ %>
	    					<input type="checkbox" name="isGoods" id="isGoods" value="1"/>启用天猫筛选
	    				<%}else{ %>
	    					<input type="checkbox" checked="checked" name="isGoods" id="isGoods" value="0"/>启用天猫筛选
	    				<%} %>
	    				
	    				</td>
	    				<td>
	    				<%if(Freight==null || Freight.equals("")|| !Freight.equals("免运费")  ){ %>
	    					<input type="checkbox" name="isFreight" id="isFreight" value="1"/>启用免运费筛选
	    				<%}else{ %>
	    					<input type="checkbox" checked="checked" name="isFreight" id="isFreight" value="0"/>启用免运费筛选
	    				<%} %>
	    				</td>
	    				<td>
	    				<%if(Price==null || Price.equals("")){ %>
	    					<input type="checkbox" name="isPrice" id="isPrice" value="1"/>启用价格筛选
	    				<%}else{ %>
	    					<input type="checkbox" checked="checked" name="isPrice" id="isPrice" value="0"/>启用价格筛选
	    				<%} %>
	    				</td>
    		</tr>
    		<tr>
	    			<td colspan="4">
	    				宝贝主图地址：<input type="text" name="ztimgurl" value="" size="130"><br/>
	    				直通车地址：<input type="text" name="ztcimgurl" value="<%=taobao==null?"":taobao.getMap().replace("60x60","220x220")%>" size="130">
	    			</td>	
	    		</tr>
    		<tr>
    			<td><input type="button"  value="查询"  onclick="cx()"></td>
    			<td><input type="button"  value="直通车查询" onclick="ztccx()"></td>
    		</tr>
    	</table>
    	</form>
    	<br/><br/>
    <% if(taobao!=null && taobao.getFullname()!=null){%>
    <%if(check.equals("1")){ %>
是否直通车:<%=taobao.isCheckhot()?"是":"不是" %><br/>
<%if(taobao.isCheckhot()){%>
贴图：<img src="<%=taobao.getMap().replace("60x60","220x220")%>" /> <input type="button" onclick="openwindow('<%=taobao.getMap().replace("60x60","220x220")%>')" value="大图地址（另外打开页面）"/><a href="<%=taobao.getMap().replace("60x60","220x220")%>">大图地址(本页面打开)</a><br/>
<%}%>
<%}
if(check.equals("0")){ 
 %>
全名称：<%=taobao.getFullname() %><br/>
排名:<%=taobao.getRanking()==null?"未查询到排名":taobao.getRanking() %><br/>
优惠价格：<%=taobao.getPrice()%><br/>
贴图：<img src="<%= basePath %>temp.bmp" /> <input type="button" onclick="openwindow('<%=taobao.getMap().replace("60x60","220x220")%>')" value="大图地址（另外打开页面）"/><a href="<%=taobao.getMap().replace("60x60","220x220")%>">大图地址(本页面打开)</a><br/>
卖家地区：<%=taobao.getSeller() %><br/>
原价格：<%=taobao.getOldprice() %><br/>
销量（评论数）：<%=taobao.getCommentCount()%><br/>
运费：<%=taobao.getFreight() %><br/>
金币抵扣：<%=taobao.getCoinInfo().equals("")?"无抵扣":taobao.getCoinInfo() %><br/>
是否天猫：<%=taobao.getGoods()%><br/>
店铺访问地址:<a href="<%=taobao.getAuctionURL() %>">点击访问(本页面打开)</a>
<input type="button" onclick="openwindow('<%=taobao.getAuctionURL() %>')" value="点击访问（另外打开页面）"/>
    <%}} else{%>
    <font color="red">未查询到相关宝贝信息！</font>
    <%} %>
    
  </body>
  
  <script type="text/javascript">
  	function openwindow(url){
  		window.open(url);
  	}
  	
  	function ztccx(){
  		document.getElementById("form1").action="<%=basePath%>ztc";
  		document.getElementById("check").value="1";
  		document.getElementById("form1").submit();
  	}
  	function cx(){
  		document.getElementById("form1").action="<%=basePath%>Taobaomain";
  		document.getElementById("check").value="0";
  		document.getElementById("form1").submit();
  	}
  	
  </script>
</html>
