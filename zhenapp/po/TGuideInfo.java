package com.zhenapp.po;

public class TGuideInfo {
    private Integer guidepk;

    private String guideid;

    private String guidename;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    private String guidetext;

    public Integer getGuidepk() {
        return guidepk;
    }

    public void setGuidepk(Integer guidepk) {
        this.guidepk = guidepk;
    }

    public String getGuideid() {
        return guideid;
    }

    public void setGuideid(String guideid) {
        this.guideid = guideid == null ? null : guideid.trim();
    }

    public String getGuidename() {
        return guidename;
    }

    public void setGuidename(String guidename) {
        this.guidename = guidename == null ? null : guidename.trim();
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

    public String getGuidetext() {
        return guidetext;
    }

    public void setGuidetext(String guidetext) {
        this.guidetext = guidetext == null ? null : guidetext.trim();
    }
}