package com.zhenapp.po.Custom;

import com.zhenapp.po.TTaskDetailinfo;
import com.zhenapp.util.StringUtilWxf;

public class TTaskDetailInfoCustom extends TTaskDetailinfo{
	private String isshoppingname;
	private String iscollectionname;
	private String visitname;
	private String collectname;
	private String trolleyname;
	private String tasktypename;
	private String taskpk;
	private int shoppingcount;
	private int collectioncount;
	private int ztccount;
	private int shoppingztccount;
	private int collectionztccount;
	private int shoppingsum;
	private int collectionsum;
	private int ztcsum;
	private int shoppingztcsum;
	private int collectionztcsum;
	private String taskstatename;
	
	
	public int getShoppingztcsum() {
		return shoppingztcsum;
	}

	public void setShoppingztcsum(int shoppingztcsum) {
		this.shoppingztcsum = shoppingztcsum;
	}

	public int getCollectionztcsum() {
		return collectionztcsum;
	}

	public void setCollectionztcsum(int collectionztcsum) {
		this.collectionztcsum = collectionztcsum;
	}

	public int getShoppingztccount() {
		return shoppingztccount;
	}

	public void setShoppingztccount(int shoppingztccount) {
		this.shoppingztccount = shoppingztccount;
	}

	public int getCollectionztccount() {
		return collectionztccount;
	}

	public void setCollectionztccount(int collectionztccount) {
		this.collectionztccount = collectionztccount;
	}

	public int getZtcsum() {
		return ztcsum;
	}

	public void setZtcsum(int ztcsum) {
		this.ztcsum = ztcsum;
	}

	public int getZtccount() {
		return ztccount;
	}

	public void setZtccount(int ztccount) {
		this.ztccount = ztccount;
	}

	public String getTaskstatename() {
		return taskstatename;
	}

	public void setTaskstatename(String taskstatename) {
		this.taskstatename = taskstatename;
	}

	public int getShoppingsum() {
		return shoppingsum;
	}

	public void setShoppingsum(int shoppingsum) {
		this.shoppingsum = shoppingsum;
	}

	public int getCollectionsum() {
		return collectionsum;
	}

	public void setCollectionsum(int collectionsum) {
		this.collectionsum = collectionsum;
	}

	public int getShoppingcount() {
		return shoppingcount;
	}

	public void setShoppingcount(int shoppingcount) {
		this.shoppingcount = shoppingcount;
	}

	public int getCollectioncount() {
		return collectioncount;
	}

	public void setCollectioncount(int collectioncount) {
		this.collectioncount = collectioncount;
	}

	public String getTaskpk() {
		return taskpk;
	}

	public void setTaskpk(String taskpk) {
		this.taskpk = taskpk;
	}

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
		//.append(StringUtilWxf.checkcode(tTaskDetailInfoCustom.getSearchtype())).append("&")
		//.append(tTaskDetailInfoCustom.getMinpicture()).append("&")
		.append("null").append("&")//排序类型
		.append("null").append("&")//最小价格
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
		.append(tTaskDetailInfoCustom.getIsstorecollection()).append("&")
		.append("否").append("&")//店铺收藏
		.append("否").append("&")//直通车是否自定义筛选价格范围
		.append("否").append("&")//直通车筛选的价格范围1
		.append("否").append("&")//直通车筛选的价格范围2
		.append("否").append("&")//自定义筛选的地区
		//.append(tTaskDetailInfoCustom.getMinpicture()).append("&")//最小价格
		//.append(tTaskDetailInfoCustom.getMaxpicture()).append("&")//最大价格
		.append(tTaskDetailInfoCustom.getPrice()).append("&");//宝贝价格
		if(tTaskDetailInfoCustom.getTaskimgztc()!=null && tTaskDetailInfoCustom.getTaskimgztc().length()>2){
			sb.append(StringUtilWxf.strtonull(tTaskDetailInfoCustom.getTaskimgztc())).append("&")//直通车图片地址
			.append("null");//创意标题
			
		}else{
			sb.append("null").append("&")//直通车图片地址
			.append(StringUtilWxf.trimFirstChar(StringUtilWxf.strtonull(tTaskDetailInfoCustom.getCreativetitle()), " "));//创意标题
			
		}
		
		//.append(tTaskDetailInfoCustom.getIsstorecollection().equals("1")?"是":"否").append("&")//是否店铺收藏
		//.append(tTaskDetailInfoCustom.getIsfakechat().equals("1")?"是":"否").append("&")//是否假聊
		//.append(tTaskDetailInfoCustom.getFakechatstr1()).append("&")//假聊信息第一句
		//.append(tTaskDetailInfoCustom.getFakechatstr2()).append("&")//假聊信息第二句
		//.append(tTaskDetailInfoCustom.getFakechatstr3()).append("&")//假聊信息第三句
		//.append(tTaskDetailInfoCustom.getFakechatstr4());//假聊信息第四句
		return sb;
	}
}
