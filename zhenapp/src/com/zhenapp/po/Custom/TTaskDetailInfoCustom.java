package com.zhenapp.po.Custom;

import com.zhenapp.po.TTaskDetailinfo;

public class TTaskDetailInfoCustom extends TTaskDetailinfo{
	
	public static StringBuffer Mosaicstr(TTaskDetailInfoCustom tTaskDetailInfoCustom) throws Exception{
		StringBuffer sb=new StringBuffer();
		sb.append(tTaskDetailInfoCustom.getTaskid()).append("&")
		.append("流量id").append("&")
		.append(tTaskDetailInfoCustom.getTaskkeyword()).append("&")
		.append(tTaskDetailInfoCustom.getSearchtype()).append("&")
		.append(tTaskDetailInfoCustom.getMinpicture()).append("&")
		.append("null").append("&")//地区
		.append("null").append("&")//是否免运费
		.append("null").append("&")//是否天猫
		.append(tTaskDetailInfoCustom.getIscollection().equals("1")?"是":"否").append("&")
		.append(tTaskDetailInfoCustom.getIsshopping().equals("1")?"是":"否").append("&")
		.append(tTaskDetailInfoCustom.getTaskkeynum()).append("&")
		.append(tTaskDetailInfoCustom.getMinpicture()).append("&")
		.append(tTaskDetailInfoCustom.getMaxpicture()).append("&")
		.append(tTaskDetailInfoCustom.getTasktype().equals("33")?"流量":"直通车").append("&")
		.append(tTaskDetailInfoCustom.getIscreativetitle()).append("&")
		.append(tTaskDetailInfoCustom.getIsshopcollect()).append("&")
		.append("否").append("&")//店铺收藏
		.append("否").append("&")//直通车是否自定义筛选价格范围
		.append("否").append("&")//直通车筛选的价格范围1
		.append("否").append("&")//直通车筛选的价格范围2
		.append("否");//自定义筛选的地区
		return sb;
	}
}
