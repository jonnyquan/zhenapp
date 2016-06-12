package com.zhenapp.po;

public class TUsertestInfo {
    private Integer usertestpk;

    private String usertestid;

    private String usertestnick;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    public Integer getUsertestpk() {
        return usertestpk;
    }

    public void setUsertestpk(Integer usertestpk) {
        this.usertestpk = usertestpk;
    }

    public String getUsertestid() {
        return usertestid;
    }

    public void setUsertestid(String usertestid) {
        this.usertestid = usertestid == null ? null : usertestid.trim();
    }

    public String getUsertestnick() {
        return usertestnick;
    }

    public void setUsertestnick(String usertestnick) {
        this.usertestnick = usertestnick == null ? null : usertestnick.trim();
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