package com.zhenapp.po.Custom;

import com.zhenapp.po.TRechargeInfo;

public class TRechargeInfoCustom extends TRechargeInfo{
	private String rechargestatename;
	private String usernick;
	
	public String getUsernick() {
		return usernick;
	}

	public void setUsernick(String usernick) {
		this.usernick = usernick;
	}

	public String getRechargestatename() {
		return rechargestatename;
	}

	public void setRechargestatename(String rechargestatename) {
		this.rechargestatename = rechargestatename;
	}
	

}
