package com.zhenapp.po;

public class TDataDicType {
    private Integer dictypeid;

    private String dictypename;

    private String dictypecode;

    private Integer dictypestate;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    public Integer getDictypeid() {
        return dictypeid;
    }

    public void setDictypeid(Integer dictypeid) {
        this.dictypeid = dictypeid;
    }

    public String getDictypename() {
        return dictypename;
    }

    public void setDictypename(String dictypename) {
        this.dictypename = dictypename == null ? null : dictypename.trim();
    }

    public String getDictypecode() {
        return dictypecode;
    }

    public void setDictypecode(String dictypecode) {
        this.dictypecode = dictypecode == null ? null : dictypecode.trim();
    }

    public Integer getDictypestate() {
        return dictypestate;
    }

    public void setDictypestate(Integer dictypestate) {
        this.dictypestate = dictypestate;
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