package com.zhenapp.po;

public class TElectricityInfo {
    private Integer electricitypk;

    private String electricityid;

    private String electricityname;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    private String electricitytext;

    public Integer getElectricitypk() {
        return electricitypk;
    }

    public void setElectricitypk(Integer electricitypk) {
        this.electricitypk = electricitypk;
    }

    public String getElectricityid() {
        return electricityid;
    }

    public void setElectricityid(String electricityid) {
        this.electricityid = electricityid == null ? null : electricityid.trim();
    }

    public String getElectricityname() {
        return electricityname;
    }

    public void setElectricityname(String electricityname) {
        this.electricityname = electricityname == null ? null : electricityname.trim();
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

    public String getElectricitytext() {
        return electricitytext;
    }

    public void setElectricitytext(String electricitytext) {
        this.electricitytext = electricitytext == null ? null : electricitytext.trim();
    }
}