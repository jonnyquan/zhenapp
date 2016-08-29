package com.zhenapp.po;

public class TDatacountInfo {
    private Integer datacountpk;

    private String agentid;

    private String userid;

    private String date;

    private String finishcount;

    private String shoppingcount;

    private String collectioncount;

    private String ztccount;

    private String shoppingztccount;

    private String collectionztccount;

    private String buypoints;

    private String expendpoints;

    private String handworkpoints;

    public Integer getDatacountpk() {
        return datacountpk;
    }

    public void setDatacountpk(Integer datacountpk) {
        this.datacountpk = datacountpk;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid == null ? null : agentid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getFinishcount() {
        return finishcount;
    }

    public void setFinishcount(String finishcount) {
        this.finishcount = finishcount == null ? null : finishcount.trim();
    }

    public String getShoppingcount() {
        return shoppingcount;
    }

    public void setShoppingcount(String shoppingcount) {
        this.shoppingcount = shoppingcount == null ? null : shoppingcount.trim();
    }

    public String getCollectioncount() {
        return collectioncount;
    }

    public void setCollectioncount(String collectioncount) {
        this.collectioncount = collectioncount == null ? null : collectioncount.trim();
    }

    public String getZtccount() {
        return ztccount;
    }

    public void setZtccount(String ztccount) {
        this.ztccount = ztccount == null ? null : ztccount.trim();
    }

    public String getShoppingztccount() {
        return shoppingztccount;
    }

    public void setShoppingztccount(String shoppingztccount) {
        this.shoppingztccount = shoppingztccount == null ? null : shoppingztccount.trim();
    }

    public String getCollectionztccount() {
        return collectionztccount;
    }

    public void setCollectionztccount(String collectionztccount) {
        this.collectionztccount = collectionztccount == null ? null : collectionztccount.trim();
    }

    public String getBuypoints() {
        return buypoints;
    }

    public void setBuypoints(String buypoints) {
        this.buypoints = buypoints == null ? null : buypoints.trim();
    }

    public String getExpendpoints() {
        return expendpoints;
    }

    public void setExpendpoints(String expendpoints) {
        this.expendpoints = expendpoints == null ? null : expendpoints.trim();
    }

    public String getHandworkpoints() {
        return handworkpoints;
    }

    public void setHandworkpoints(String handworkpoints) {
        this.handworkpoints = handworkpoints == null ? null : handworkpoints.trim();
    }
}