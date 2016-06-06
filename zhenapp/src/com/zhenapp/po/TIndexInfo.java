package com.zhenapp.po;

public class TIndexInfo {
    private Integer indexpk;

    private String indexid;

    private String indexname;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    private String indextext;

    public Integer getIndexpk() {
        return indexpk;
    }

    public void setIndexpk(Integer indexpk) {
        this.indexpk = indexpk;
    }

    public String getIndexid() {
        return indexid;
    }

    public void setIndexid(String indexid) {
        this.indexid = indexid == null ? null : indexid.trim();
    }

    public String getIndexname() {
        return indexname;
    }

    public void setIndexname(String indexname) {
        this.indexname = indexname == null ? null : indexname.trim();
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

    public String getIndextext() {
        return indextext;
    }

    public void setIndextext(String indextext) {
        this.indextext = indextext == null ? null : indextext.trim();
    }
}