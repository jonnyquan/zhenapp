package com.zhenapp.po;


public class TaskApi {
	private String name;
	private String keywords;
	private String product_url;
	private String start_date;
	private String end_date;
	private int[] hour_counts;
	private int duration;
	private boolean plus;
	private int gprs_pct;
	private int tmall_app_pct;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getProduct_url() {
		return product_url;
	}
	public void setProduct_url(String product_url) {
		this.product_url = product_url;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	public int[] getHour_counts() {
		return hour_counts;
	}
	public void setHour_counts(int[] hour_counts) {
		this.hour_counts = hour_counts;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public boolean isPlus() {
		return plus;
	}
	public void setPlus(boolean plus) {
		this.plus = plus;
	}
	public int getGprs_pct() {
		return gprs_pct;
	}
	public void setGprs_pct(int gprs_pct) {
		this.gprs_pct = gprs_pct;
	}
	public int getTmall_app_pct() {
		return tmall_app_pct;
	}
	public void setTmall_app_pct(int tmall_app_pct) {
		this.tmall_app_pct = tmall_app_pct;
	}
	
	
}
