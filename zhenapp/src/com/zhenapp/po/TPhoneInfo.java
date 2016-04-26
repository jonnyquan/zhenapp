package com.zhenapp.po;

public class TPhoneInfo {
    private Integer phonepk;

    private String phoneid;

    private String phonestate;

    private String phonetype;

    private String createuser;

    private String createtime;

    private String updateuser;

    private String updatetime;

    public Integer getPhonepk() {
        return phonepk;
    }

    public void setPhonepk(Integer phonepk) {
        this.phonepk = phonepk;
    }

    public String getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(String phoneid) {
        this.phoneid = phoneid == null ? null : phoneid.trim();
    }

    public String getPhonestate() {
        return phonestate;
    }

    public void setPhonestate(String phonestate) {
        this.phonestate = phonestate == null ? null : phonestate.trim();
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype == null ? null : phonetype.trim();
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }
}