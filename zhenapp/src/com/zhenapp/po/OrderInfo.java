package com.zhenapp.po;

public class OrderInfo {
	private double minprice;
	private int totalTask;
	private int totalCollectProduct;
	private int totalShoppingCart;
	private String kwd;
	private String nid;
	private Enum ktype;
	private Enum searchType;
	private String timecontrol;
	private String Image;
	public double getMinprice() {
		return minprice;
	}
	public void setMinprice(double minprice) {
		this.minprice = minprice;
	}
	public int getTotalTask() {
		return totalTask;
	}
	public void setTotalTask(int totalTask) {
		this.totalTask = totalTask;
	}
	public int getTotalCollectProduct() {
		return totalCollectProduct;
	}
	public void setTotalCollectProduct(int totalCollectProduct) {
		this.totalCollectProduct = totalCollectProduct;
	}
	public int getTotalShoppingCart() {
		return totalShoppingCart;
	}
	public void setTotalShoppingCart(int totalShoppingCart) {
		this.totalShoppingCart = totalShoppingCart;
	}
	public String getKwd() {
		return kwd;
	}
	public void setKwd(String kwd) {
		this.kwd = kwd;
	}
	public String getNid() {
		return nid;
	}
	public void setNid(String nid) {
		this.nid = nid;
	}
	public Enum getKtype() {
		return ktype;
	}
	public void setKtype(Enum ktype) {
		this.ktype = ktype;
	}
	public Enum getSearchType() {
		return searchType;
	}
	public void setSearchType(Enum searchType) {
		this.searchType = searchType;
	}
	public String getTimecontrol() {
		return timecontrol;
	}
	public void setTimecontrol(String timecontrol) {
		this.timecontrol = timecontrol;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	@Override
	public String toString() {
		return "OrderInfo [minprice=" + minprice + ", totalTask=" + totalTask
				+ ", totalCollectProduct=" + totalCollectProduct
				+ ", totalShoppingCart=" + totalShoppingCart + ", kwd=" + kwd
				+ ", nid=" + nid + ", ktype=" + ktype + ", searchType="
				+ searchType + ", timecontrol=" + timecontrol + ", Image="
				+ Image + "]";
	}
	
	
}
