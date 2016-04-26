package com.zhenapp.po;

public class TDurationInfo {
    private Integer durationpk;

    private Integer durationid;

    private String durationmin;

    private String durationmax;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    public Integer getDurationpk() {
        return durationpk;
    }

    public void setDurationpk(Integer durationpk) {
        this.durationpk = durationpk;
    }

    public Integer getDurationid() {
        return durationid;
    }

    public void setDurationid(Integer durationid) {
        this.durationid = durationid;
    }

    public String getDurationmin() {
        return durationmin;
    }

    public void setDurationmin(String durationmin) {
        this.durationmin = durationmin == null ? null : durationmin.trim();
    }

    public String getDurationmax() {
        return durationmax;
    }

    public void setDurationmax(String durationmax) {
        this.durationmax = durationmax == null ? null : durationmax.trim();
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