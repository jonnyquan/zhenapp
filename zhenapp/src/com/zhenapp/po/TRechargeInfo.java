package com.zhenapp.po;

public class TRechargeInfo {
    private Integer rechargepk;

    private String rechargeid;

    private String rechargeverification;

    private Integer rechargemoney;

    private Integer rechargepoints;

    private Integer rechargegivemoney;

    private Integer rechargegivepoints;

    private String rechargestate;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    public Integer getRechargepk() {
        return rechargepk;
    }

    public void setRechargepk(Integer rechargepk) {
        this.rechargepk = rechargepk;
    }

    public String getRechargeid() {
        return rechargeid;
    }

    public void setRechargeid(String rechargeid) {
        this.rechargeid = rechargeid == null ? null : rechargeid.trim();
    }

    public String getRechargeverification() {
        return rechargeverification;
    }

    public void setRechargeverification(String rechargeverification) {
        this.rechargeverification = rechargeverification == null ? null : rechargeverification.trim();
    }

    public Integer getRechargemoney() {
        return rechargemoney;
    }

    public void setRechargemoney(Integer rechargemoney) {
        this.rechargemoney = rechargemoney;
    }

    public Integer getRechargepoints() {
        return rechargepoints;
    }

    public void setRechargepoints(Integer rechargepoints) {
        this.rechargepoints = rechargepoints;
    }

    public Integer getRechargegivemoney() {
        return rechargegivemoney;
    }

    public void setRechargegivemoney(Integer rechargegivemoney) {
        this.rechargegivemoney = rechargegivemoney;
    }

    public Integer getRechargegivepoints() {
        return rechargegivepoints;
    }

    public void setRechargegivepoints(Integer rechargegivepoints) {
        this.rechargegivepoints = rechargegivepoints;
    }

    public String getRechargestate() {
        return rechargestate;
    }

    public void setRechargestate(String rechargestate) {
        this.rechargestate = rechargestate == null ? null : rechargestate.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }
}