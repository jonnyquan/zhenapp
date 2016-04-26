package com.zhenapp.po;

public class TDataDicInfo {
    private Integer dicinfoid;

    private String dicinfoname;

    private String dicinfocode;

    private Integer dicinfostate;

    private Integer dictypeid;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    public Integer getDicinfoid() {
        return dicinfoid;
    }

    public void setDicinfoid(Integer dicinfoid) {
        this.dicinfoid = dicinfoid;
    }

    public String getDicinfoname() {
        return dicinfoname;
    }

    public void setDicinfoname(String dicinfoname) {
        this.dicinfoname = dicinfoname == null ? null : dicinfoname.trim();
    }

    public String getDicinfocode() {
        return dicinfocode;
    }

    public void setDicinfocode(String dicinfocode) {
        this.dicinfocode = dicinfocode == null ? null : dicinfocode.trim();
    }

    public Integer getDicinfostate() {
        return dicinfostate;
    }

    public void setDicinfostate(Integer dicinfostate) {
        this.dicinfostate = dicinfostate;
    }

    public Integer getDictypeid() {
        return dictypeid;
    }

    public void setDictypeid(Integer dictypeid) {
        this.dictypeid = dictypeid;
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