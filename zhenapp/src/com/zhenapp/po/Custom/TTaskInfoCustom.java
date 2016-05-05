package com.zhenapp.po.Custom;

import com.zhenapp.po.TTaskInfo;

public class TTaskInfoCustom extends TTaskInfo{
	private Integer finishflowcount;

    private Integer finishcollectioncount;

    private Integer finishshoppingcount;
    
    private Integer errorcount;
    
    private String dicinfoname;
    private String tasktypename;
    

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
