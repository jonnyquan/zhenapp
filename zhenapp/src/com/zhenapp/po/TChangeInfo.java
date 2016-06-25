package com.zhenapp.po;

public class TChangeInfo {
    private Integer tbaccountstate;

    private String updatetime;

    public Integer getTbaccountstate() {
        return tbaccountstate;
    }

    public void setTbaccountstate(Integer tbaccountstate) {
        this.tbaccountstate = tbaccountstate;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }
}