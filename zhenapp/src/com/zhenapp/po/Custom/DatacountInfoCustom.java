package com.zhenapp.po.Custom;

public class DatacountInfoCustom {
	private String date;//日期
	private String flowcount;//流量数量
	private String collectioncount;//收藏数量
	private String shoppingcount;//购物车数量
	private String buypoints;//购买积分
	private String expendpoints;//消耗积分
	private String handworkpoints;//后台操作
	private String sumflowcount;//流量数量统计数
	private String sumcollectioncount;//收藏数量统计数
	private String sumshoppingcount;//购物车数量统计数
	private String sumbuypoints;//购买积分统计数
	private String sumexpendpoints;//消耗积分统计数
	private String sumhandworkpoints;//后台操作统计数
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFlowcount() {
		return flowcount;
	}
	public void setFlowcount(String flowcount) {
		this.flowcount = flowcount;
	}
	public String getCollectioncount() {
		return collectioncount;
	}
	public void setCollectioncount(String collectioncount) {
		this.collectioncount = collectioncount;
	}
	public String getShoppingcount() {
		return shoppingcount;
	}
	public void setShoppingcount(String shoppingcount) {
		this.shoppingcount = shoppingcount;
	}
	public String getBuypoints() {
		return buypoints;
	}
	public void setBuypoints(String buypoints) {
		this.buypoints = buypoints;
	}
	public String getExpendpoints() {
		return expendpoints;
	}
	public void setExpendpoints(String expendpoints) {
		this.expendpoints = expendpoints;
	}
	public String getHandworkpoints() {
		return handworkpoints;
	}
	public void setHandworkpoints(String handworkpoints) {
		this.handworkpoints = handworkpoints;
	}
	public String getSumflowcount() {
		return sumflowcount;
	}
	public void setSumflowcount(String sumflowcount) {
		this.sumflowcount = sumflowcount;
	}
	public String getSumcollectioncount() {
		return sumcollectioncount;
	}
	public void setSumcollectioncount(String sumcollectioncount) {
		this.sumcollectioncount = sumcollectioncount;
	}
	public String getSumshoppingcount() {
		return sumshoppingcount;
	}
	public void setSumshoppingcount(String sumshoppingcount) {
		this.sumshoppingcount = sumshoppingcount;
	}
	public String getSumbuypoints() {
		return sumbuypoints;
	}
	public void setSumbuypoints(String sumbuypoints) {
		this.sumbuypoints = sumbuypoints;
	}
	public String getSumexpendpoints() {
		return sumexpendpoints;
	}
	public void setSumexpendpoints(String sumexpendpoints) {
		this.sumexpendpoints = sumexpendpoints;
	}
	public String getSumhandworkpoints() {
		return sumhandworkpoints;
	}
	public void setSumhandworkpoints(String sumhandworkpoints) {
		this.sumhandworkpoints = sumhandworkpoints;
	}
	@Override
	public String toString() {
		return "DatacountInfoCustom [date=" + date + ", flowcount=" + flowcount
				+ ", collectioncount=" + collectioncount + ", shoppingcount="
				+ shoppingcount + ", buypoints=" + buypoints
				+ ", expendpoints=" + expendpoints + ", handworkpoints="
				+ handworkpoints + ", sumflowcount=" + sumflowcount
				+ ", sumcollectioncount=" + sumcollectioncount
				+ ", sumshoppingcount=" + sumshoppingcount + ", sumbuypoints="
				+ sumbuypoints + ", sumexpendpoints=" + sumexpendpoints
				+ ", sumhandworkpoints=" + sumhandworkpoints + "]";
	}	
}
