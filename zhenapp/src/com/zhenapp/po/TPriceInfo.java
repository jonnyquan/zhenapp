package com.zhenapp.po;

public class TPriceInfo {
    private Integer pricepk;

    private String priceid;

    private String agentid;

    private String pricetype;

    private String pricecode;

    private String pricecounts;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    public Integer getPricepk() {
        return pricepk;
    }

    public void setPricepk(Integer pricepk) {
        this.pricepk = pricepk;
    }

    public String getPriceid() {
        return priceid;
    }

    public void setPriceid(String priceid) {
        this.priceid = priceid == null ? null : priceid.trim();
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid == null ? null : agentid.trim();
    }

    public String getPricetype() {
        return pricetype;
    }

    public void setPricetype(String pricetype) {
        this.pricetype = pricetype == null ? null : pricetype.trim();
    }

    public String getPricecode() {
        return pricecode;
    }

    public void setPricecode(String pricecode) {
        this.pricecode = pricecode == null ? null : pricecode.trim();
    }

    public String getPricecounts() {
        return pricecounts;
    }

    public void setPricecounts(String pricecounts) {
        this.pricecounts = pricecounts == null ? null : pricecounts.trim();
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