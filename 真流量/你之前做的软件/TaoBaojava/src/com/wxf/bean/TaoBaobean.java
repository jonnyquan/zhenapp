package com.wxf.bean;

public class TaoBaobean {
	private String fullname;// ȫ����
	private String shortname;// ������
	private String price;// �Żݼ۸�
	private String map;// ��ͼ
	private String seller;// ���ҵ���
	private String oldprice;// ԭ�۸�
	private String sales;// ����
	private String freight;// �˷�
	private String goods;// ��Ʒ
	private String sort;// ��ѯ��ʽ
	private String keyword;// �ؼ���
	private String startPrice;
	private String endPrice;
	private String auctionURL;// ���ʵ�ַ
	private String coinInfo;// ��ҵֿ�
	private String commentCount;// ������
	private String ranking;// ����
	private boolean checkhot;// ֱͨ��



	public boolean isCheckhot() {
		return checkhot;
	}

	public void setCheckhot(boolean checkhot) {
		this.checkhot = checkhot;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getRanking() {
		return ranking;
	}

	public void setRanking(String ranking) {
		this.ranking = ranking;
	}

	public String getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}

	public String getCoinInfo() {
		return coinInfo;
	}

	public void setCoinInfo(String coinInfo) {
		this.coinInfo = coinInfo;
	}

	public String getAuctionURL() {
		return auctionURL;
	}

	public void setAuctionURL(String auctionURL) {
		this.auctionURL = auctionURL;
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getOldprice() {
		return oldprice;
	}

	public void setOldprice(String oldprice) {
		this.oldprice = oldprice;
	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	public String getGoods() {
		return goods;
	}

	public void setGoods(String goods) {
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "TaoBaobean [fullname=" + fullname + ", shortname=" + shortname
				+ ", price=" + price + ", map=" + map + ", seller=" + seller
				+ ", oldprice=" + oldprice + ", sales=" + sales + ", freight="
				+ freight + ", goods=" + goods + ", sort=" + sort
				+ ", keyword=" + keyword + ", startPrice=" + startPrice
				+ ", endPrice=" + endPrice + ", auctionURL=" + auctionURL
				+ ", coinInfo=" + coinInfo + ", commentCount=" + commentCount
				+ ", ranking=" + ranking + ", checkhot=" + checkhot + "]";
	}



}
