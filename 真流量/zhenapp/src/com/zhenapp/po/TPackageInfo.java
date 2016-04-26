package com.zhenapp.po;

public class TPackageInfo {
    private Integer packagepk;

    private Integer packageid;

    private String packagename;

    private String packageprice;

    private Integer packagestate;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    public Integer getPackagepk() {
        return packagepk;
    }

    public void setPackagepk(Integer packagepk) {
        this.packagepk = packagepk;
    }

    public Integer getPackageid() {
        return packageid;
    }

    public void setPackageid(Integer packageid) {
        this.packageid = packageid;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename == null ? null : packagename.trim();
    }

    public String getPackageprice() {
        return packageprice;
    }

    public void setPackageprice(String packageprice) {
        this.packageprice = packageprice == null ? null : packageprice.trim();
    }

    public Integer getPackagestate() {
        return packagestate;
    }

    public void setPackagestate(Integer packagestate) {
        this.packagestate = packagestate;
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