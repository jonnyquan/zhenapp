package com.zhenapp.po;

public class TScriptInfo {
    private Integer scriptpk;

    private String scriptid;

    private String scriptname;

    private String scriptpath;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    public Integer getScriptpk() {
        return scriptpk;
    }

    public void setScriptpk(Integer scriptpk) {
        this.scriptpk = scriptpk;
    }

    public String getScriptid() {
        return scriptid;
    }

    public void setScriptid(String scriptid) {
        this.scriptid = scriptid == null ? null : scriptid.trim();
    }

    public String getScriptname() {
        return scriptname;
    }

    public void setScriptname(String scriptname) {
        this.scriptname = scriptname == null ? null : scriptname.trim();
    }

    public String getScriptpath() {
        return scriptpath;
    }

    public void setScriptpath(String scriptpath) {
        this.scriptpath = scriptpath == null ? null : scriptpath.trim();
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