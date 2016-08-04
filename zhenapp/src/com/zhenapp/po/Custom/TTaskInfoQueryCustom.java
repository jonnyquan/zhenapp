package com.zhenapp.po.Custom;

import com.zhenapp.po.TTaskInfoQuery;

public class TTaskInfoQueryCustom extends TTaskInfoQuery{
	private String taskstaterange;
	private String createtimename;
	
	public String getCreatetimename() {
		return createtimename;
	}

	public void setCreatetimename(String createtimename) {
		this.createtimename = createtimename;
	}

	public String getTaskstaterange() {
		return taskstaterange;
	}

	public void setTaskstaterange(String taskstaterange) {
		this.taskstaterange = taskstaterange;
	}
	
}