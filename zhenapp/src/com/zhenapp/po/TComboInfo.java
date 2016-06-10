package com.zhenapp.po;

public class TComboInfo {
    private Integer combopk;

    private String comboid;

    private String agentid;

    private String comboname;

    private Integer combomoney;

    private String discount;

    private String unitprice;

    private Integer combointegral;

    private Integer combogivemoney;

    private Integer combogiveintegral;

    private String combodesc;

    private String createuser;

    private String createtime;

    private String updateuser;

    private String updatetime;

    public Integer getCombopk() {
        return combopk;
    }

    public void setCombopk(Integer combopk) {
        this.combopk = combopk;
    }

    public String getComboid() {
        return comboid;
    }

    public void setComboid(String comboid) {
        this.comboid = comboid == null ? null : comboid.trim();
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid == null ? null : agentid.trim();
    }

    public String getComboname() {
        return comboname;
    }

    public void setComboname(String comboname) {
        this.comboname = comboname == null ? null : comboname.trim();
    }

    public Integer getCombomoney() {
        return combomoney;
    }

    public void setCombomoney(Integer combomoney) {
        this.combomoney = combomoney;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount == null ? null : discount.trim();
    }

    public String getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice == null ? null : unitprice.trim();
    }

    public Integer getCombointegral() {
        return combointegral;
    }

    public void setCombointegral(Integer combointegral) {
        this.combointegral = combointegral;
    }

    public Integer getCombogivemoney() {
        return combogivemoney;
    }

    public void setCombogivemoney(Integer combogivemoney) {
        this.combogivemoney = combogivemoney;
    }

    public Integer getCombogiveintegral() {
        return combogiveintegral;
    }

    public void setCombogiveintegral(Integer combogiveintegral) {
        this.combogiveintegral = combogiveintegral;
    }

    public String getCombodesc() {
        return combodesc;
    }

    public void setCombodesc(String combodesc) {
        this.combodesc = combodesc == null ? null : combodesc.trim();
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