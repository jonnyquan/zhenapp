package com.zhenapp.po;

public class TPointsInfo {
    private Integer pointspk;

    private Integer pointsid;

    private Integer userid;

    private Integer pointsnew;

    private Integer pointsold;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    public Integer getPointspk() {
        return pointspk;
    }

    public void setPointspk(Integer pointspk) {
        this.pointspk = pointspk;
    }

    public Integer getPointsid() {
        return pointsid;
    }

    public void setPointsid(Integer pointsid) {
        this.pointsid = pointsid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPointsnew() {
        return pointsnew;
    }

    public void setPointsnew(Integer pointsnew) {
        this.pointsnew = pointsnew;
    }

    public Integer getPointsold() {
        return pointsold;
    }

    public void setPointsold(Integer pointsold) {
        this.pointsold = pointsold;
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