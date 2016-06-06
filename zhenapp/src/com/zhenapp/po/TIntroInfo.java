package com.zhenapp.po;

public class TIntroInfo {
    private Integer intropk;

    private String introid;

    private String introname;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    private String introtext;

    public Integer getIntropk() {
        return intropk;
    }

    public void setIntropk(Integer intropk) {
        this.intropk = intropk;
    }

    public String getIntroid() {
        return introid;
    }

    public void setIntroid(String introid) {
        this.introid = introid == null ? null : introid.trim();
    }

    public String getIntroname() {
        return introname;
    }

    public void setIntroname(String introname) {
        this.introname = introname == null ? null : introname.trim();
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

    public String getIntrotext() {
        return introtext;
    }

    public void setIntrotext(String introtext) {
        this.introtext = introtext == null ? null : introtext.trim();
    }
}