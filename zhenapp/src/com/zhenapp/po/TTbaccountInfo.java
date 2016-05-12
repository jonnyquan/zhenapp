package com.zhenapp.po;

public class TTbaccountInfo {
    private Integer tbaccountpk;

    private String tbaccountid;

    private String tbaccountname;

    private String tbaccountpwd;

    private Integer tbaccounttime;

    private String tbaccountphoneid;

    private String tbaccountstate;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    public Integer getTbaccountpk() {
        return tbaccountpk;
    }

    public void setTbaccountpk(Integer tbaccountpk) {
        this.tbaccountpk = tbaccountpk;
    }

    public String getTbaccountid() {
        return tbaccountid;
    }

    public void setTbaccountid(String tbaccountid) {
        this.tbaccountid = tbaccountid == null ? null : tbaccountid.trim();
    }

    public String getTbaccountname() {
        return tbaccountname;
    }

    public void setTbaccountname(String tbaccountname) {
        this.tbaccountname = tbaccountname == null ? null : tbaccountname.trim();
    }

    public String getTbaccountpwd() {
        return tbaccountpwd;
    }

    public void setTbaccountpwd(String tbaccountpwd) {
        this.tbaccountpwd = tbaccountpwd == null ? null : tbaccountpwd.trim();
    }

    public Integer getTbaccounttime() {
        return tbaccounttime;
    }

    public void setTbaccounttime(Integer tbaccounttime) {
        this.tbaccounttime = tbaccounttime;
    }

    public String getTbaccountphoneid() {
        return tbaccountphoneid;
    }

    public void setTbaccountphoneid(String tbaccountphoneid) {
        this.tbaccountphoneid = tbaccountphoneid == null ? null : tbaccountphoneid.trim();
    }

    public String getTbaccountstate() {
        return tbaccountstate;
    }

    public void setTbaccountstate(String tbaccountstate) {
        this.tbaccountstate = tbaccountstate == null ? null : tbaccountstate.trim();
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