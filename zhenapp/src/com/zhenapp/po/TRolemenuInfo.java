package com.zhenapp.po;

public class TRolemenuInfo {
    private Integer rolemenupk;

    private String rolemenuid;

    private String roleid;

    private String menuid;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    public Integer getRolemenupk() {
        return rolemenupk;
    }

    public void setRolemenupk(Integer rolemenupk) {
        this.rolemenupk = rolemenupk;
    }

    public String getRolemenuid() {
        return rolemenuid;
    }

    public void setRolemenuid(String rolemenuid) {
        this.rolemenuid = rolemenuid == null ? null : rolemenuid.trim();
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid == null ? null : menuid.trim();
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