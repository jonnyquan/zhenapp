package com.zhenapp.po.Custom;

import com.zhenapp.po.TTaskInfo;

public class TTaskInfoCustom extends TTaskInfo{
	private Integer finishflowcount;
    private Integer finishcollectioncount;
    private Integer finishshoppingcount;
    private Integer finishstorecollectioncount;
    private Integer finishfakechatcount;
    private Integer errorcount;
    private String dicinfoname;
    private String tasktypename;
    private String usernick;
    private String taskdaterange;
    private int counts;
    
	public Integer getFinishstorecollectioncount() {
		return finishstorecollectioncount;
	}
	public void setFinishstorecollectioncount(Integer finishstorecollectioncount) {
		this.finishstorecollectioncount = finishstorecollectioncount;
	}
	public Integer getFinishfakechatcount() {
		return finishfakechatcount;
	}
	public void setFinishfakechatcount(Integer finishfakechatcount) {
		this.finishfakechatcount = finishfakechatcount;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public String getTaskdaterange() {
		return taskdaterange;
	}
	public void setTaskdaterange(String taskdaterange) {
		this.taskdaterange = taskdaterange;
	}
	public String getUsernick() {
		return usernick;
	}
	public void setUsernick(String usernick) {
		this.usernick = usernick;
	}
	public String getTasktypename() {
		return tasktypename;
	}
	public void setTasktypename(String tasktypename) {
		this.tasktypename = tasktypename;
	}
	public Integer getFinishflowcount() {
		return finishflowcount;
	}
	public void setFinishflowcount(Integer finishflowcount) {
		this.finishflowcount = finishflowcount;
	}
	public Integer getFinishcollectioncount() {
		return finishcollectioncount;
	}
	public void setFinishcollectioncount(Integer finishcollectioncount) {
		this.finishcollectioncount = finishcollectioncount;
	}
	public Integer getFinishshoppingcount() {
		return finishshoppingcount;
	}
	public void setFinishshoppingcount(Integer finishshoppingcount) {
		this.finishshoppingcount = finishshoppingcount;
	}
	public Integer getErrorcount() {
		return errorcount;
	}
	public void setErrorcount(Integer errorcount) {
		this.errorcount = errorcount;
	}
	public String getDicinfoname() {
		return dicinfoname;
	}
	public void setDicinfoname(String dicinfoname) {
		this.dicinfoname = dicinfoname;
	}
   
}
