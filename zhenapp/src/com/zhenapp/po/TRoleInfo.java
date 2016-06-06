package com.zhenapp.po;

public class TRoleInfo {
    private String roleid;

    private Integer rolepk;

    private String rolename;

    private String rolestates;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public Integer getRolepk() {
        return rolepk;
    }

    public void setRolepk(Integer rolepk) {
        this.rolepk = rolepk;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public String getRolestates() {
        return rolestates;
    }

    public void setRolestates(String rolestates) {
        this.rolestates = rolestates == null ? null : rolestates.trim();
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