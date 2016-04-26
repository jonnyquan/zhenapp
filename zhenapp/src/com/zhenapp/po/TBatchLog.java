package com.zhenapp.po;

public class TBatchLog {
    private Integer batchlogpk;

    private Integer batchlogid;

    private String batchlogname;

    private String batchlogstate;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    public Integer getBatchlogpk() {
        return batchlogpk;
    }

    public void setBatchlogpk(Integer batchlogpk) {
        this.batchlogpk = batchlogpk;
    }

    public Integer getBatchlogid() {
        return batchlogid;
    }

    public void setBatchlogid(Integer batchlogid) {
        this.batchlogid = batchlogid;
    }

    public String getBatchlogname() {
        return batchlogname;
    }

    public void setBatchlogname(String batchlogname) {
        this.batchlogname = batchlogname == null ? null : batchlogname.trim();
    }

    public String getBatchlogstate() {
        return batchlogstate;
    }

    public void setBatchlogstate(String batchlogstate) {
        this.batchlogstate = batchlogstate == null ? null : batchlogstate.trim();
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