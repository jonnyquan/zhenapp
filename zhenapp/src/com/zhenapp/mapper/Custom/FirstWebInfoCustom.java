package com.zhenapp.mapper.Custom;

public class FirstWebInfoCustom {
	private boolean success;
	private long product_id;
	private int error;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return "FirstWebInfoCustom [success=" + success + ", product_id="
				+ product_id + ", error=" + error + "]";
	}
	
}
