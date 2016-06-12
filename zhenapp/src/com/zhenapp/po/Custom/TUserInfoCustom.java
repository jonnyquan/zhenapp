package com.zhenapp.po.Custom;

import com.zhenapp.po.TUserInfo;

public class TUserInfoCustom extends TUserInfo {
	private String rolename;
	private String statename;
	private String usernickagent;
	private String usertestnick;
	
	
	public String getUsertestnick() {
		return usertestnick;
	}

	public void setUsertestnick(String usertestnick) {
		this.usertestnick = usertestnick;
	}

	public String getUsernickagent() {
		return usernickagent;
	}

	public void setUsernickagent(String usernickagent) {
		this.usernickagent = usernickagent;
	}

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
