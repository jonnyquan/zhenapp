package com.wxf.bean;

public class TaoBaoQuery{
	private TaoBaobean taobao;
	private String check;
	private String keyword;
	private String itemId;
	private String sort;
	private String startPrice;
	private String endPrice;
	private String pagecount;
	private String isSeller;
	private String isGoods;
	private String isFreight;
	private String isPrice;
	public TaoBaobean getTaobao() {
		return taobao;
	}
	public void setTaobao(TaoBaobean taobao) {
		this.taobao = taobao;
	}
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getStartPrice() {
		return startPrice;
	}
	public void setStartPrice(String startPrice) {
		this.startPrice = startPrice;
	}
	public String getEndPrice() {
		return endPrice;
	}
	public void setEndPrice(String endPrice) {
		this.endPrice = endPrice;
	}
	public String getPagecount() {
		return pagecount;
	}
	public void setPagecount(String pagecount) {
		this.pagecount = pagecount;
	}
	public String getIsSeller() {
		return isSeller;
	}
	public void setIsSeller(String isSeller) {
		this.isSeller = isSeller;
	}
	public String getIsGoods() {
		return isGoods;
	}
	public void setIsGoods(String isGoods) {
		this.isGoods = isGoods;
	}
	public String getIsFreight() {
		return isFreight;
	}
	public void setIsFreight(String isFreight) {
		this.isFreight = isFreight;
	}
	public String getIsPrice() {
		return isPrice;
	}
	public void setIsPrice(String isPrice) {
		this.isPrice = isPrice;
	}
	@Override
	public String toString() {
		return "TaoBaoQuery [check=" + check + ", endPrice=" + endPrice
				+ ", isFreight=" + isFreight + ", isGoods=" + isGoods
				+ ", isPrice=" + isPrice + ", isSeller=" + isSeller
				+ ", itemId=" + itemId + ", keyword=" + keyword
				+ ", pagecount=" + pagecount + ", sort=" + sort
				+ ", startPrice=" + startPrice + ", taobao=" + taobao + "]";
	}


}
