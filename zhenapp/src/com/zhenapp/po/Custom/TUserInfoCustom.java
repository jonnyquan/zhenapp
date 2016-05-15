package com.zhenapp.po.Custom;

import com.zhenapp.po.TUserInfo;

public class TUserInfoCustom extends TUserInfo {
	private String rolename;
	private String statename;
	
	public String getStatename() {
		return statename;
	}

	public void setStatename(String statename) {
		this.statename = statename;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
}
