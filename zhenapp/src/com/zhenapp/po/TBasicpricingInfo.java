package com.zhenapp.po;

public class TBasicpricingInfo {
    private Integer basicpricingpk;

    private String basicpricingid;

    private String agentid;

    private String basicpricingname1;

    private String basicpricingvalue1;

    private String basicpricingname2;

    private String basicpricingvalue2;

    private String basicpricingname3;

    private String basicpricingvalue3;

    private String createuser;

    private String createtime;

    private String updateuser;

    private String updatetime;

    public Integer getBasicpricingpk() {
        return basicpricingpk;
    }

    public void setBasicpricingpk(Integer basicpricingpk) {
        this.basicpricingpk = basicpricingpk;
    }

    public String getBasicpricingid() {
        return basicpricingid;
    }

    public void setBasicpricingid(String basicpricingid) {
        this.basicpricingid = basicpricingid == null ? null : basicpricingid.trim();
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid == null ? null : agentid.trim();
    }

    public String getBasicpricingname1() {
        return basicpricingname1;
    }

    public void setBasicpricingname1(String basicpricingname1) {
        this.basicpricingname1 = basicpricingname1 == null ? null : basicpricingname1.trim();
    }

    public String getBasicpricingvalue1() {
        return basicpricingvalue1;
    }

    public void setBasicpricingvalue1(String basicpricingvalue1) {
        this.basicpricingvalue1 = basicpricingvalue1 == null ? null : basicpricingvalue1.trim();
    }

    public String getBasicpricingname2() {
        return basicpricingname2;
    }

    public void setBasicpricingname2(String basicpricingname2) {
        this.basicpricingname2 = basicpricingname2 == null ? null : basicpricingname2.trim();
    }

    public String getBasicpricingvalue2() {
        return basicpricingvalue2;
    }

    public void setBasicpricingvalue2(String basicpricingvalue2) {
        this.basicpricingvalue2 = basicpricingvalue2 == null ? null : basicpricingvalue2.trim();
    }

    public String getBasicpricingname3() {
        return basicpricingname3;
    }

    public void setBasicpricingname3(String basicpricingname3) {
        this.basicpricingname3 = basicpricingname3 == null ? null : basicpricingname3.trim();
    }

    public String getBasicpricingvalue3() {
        return basicpricingvalue3;
    }

    public void setBasicpricingvalue3(String basicpricingvalue3) {
        this.basicpricingvalue3 = basicpricingvalue3 == null ? null : basicpricingvalue3.trim();
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