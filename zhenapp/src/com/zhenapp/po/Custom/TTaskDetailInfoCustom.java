package com.zhenapp.po.Custom;

import com.zhenapp.po.TTaskDetailinfo;

public class TTaskDetailInfoCustom extends TTaskDetailinfo{
	private String isshoppingname;
	private String iscollectionname;
	private String visitname;
	private String collectname;
	private String trolleyname;
	private String tasktypename;
	
	
	
	public String getTasktypename() {
		return tasktypename;
	}

	public void setTasktypename(String tasktypename) {
		this.tasktypename = tasktypename;
	}

	public String getVisitname() {
		return visitname;
	}

	public void setVisitname(String visitname) {
		this.visitname = visitname;
	}

	public String getCollectname() {
		return collectname;
	}

	public void setCollectname(String collectname) {
		this.collectname = collectname;
	}

	public String getTrolleyname() {
		return trolleyname;
	}

	public void setTrolleyname(String trolleyname) {
		this.trolleyname = trolleyname;
	}

	public String getIsshoppingname() {
		return isshoppingname;
	}

	public void setIsshoppingname(String isshoppingname) {
		this.isshoppingname = isshoppingname;
	}

	public String getIscollectionname() {
		return iscollectionname;
	}

	public void setIscollectionname(String iscollectionname) {
		this.iscollectionname = iscollectionname;
	}



	public static StringBuffer Mosaicstr(TTaskDetailInfoCustom tTaskDetailInfoCustom) throws Exception{
		StringBuffer sb=new StringBuffer();
		sb.append(tTaskDetailInfoCustom.getTaskid()).append("&")
		.append(tTaskDetailInfoCustom.getTaskdetailid()).append("&")
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
