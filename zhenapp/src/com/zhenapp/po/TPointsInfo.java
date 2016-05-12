package com.zhenapp.po;

public class TPointsInfo {
    private Integer pointspk;

    private String pointsid;

    private String userid;

    private String taskid;

    private String pointstype;

    private Integer pointsupdate;

    private Integer points;

    private String pointreason;

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

    public String getPointsid() {
        return pointsid;
    }

    public void setPointsid(String pointsid) {
        this.pointsid = pointsid == null ? null : pointsid.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getTaskid() {
        return taskid;
    }

    public void setTaskid(String taskid) {
        this.taskid = taskid == null ? null : taskid.trim();
    }

    public String getPointstype() {
        return pointstype;
    }

    public void setPointstype(String pointstype) {
        this.pointstype = pointstype == null ? null : pointstype.trim();
    }

    public Integer getPointsupdate() {
        return pointsupdate;
    }

    public void setPointsupdate(Integer pointsupdate) {
        this.pointsupdate = pointsupdate;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getPointreason() {
        return pointreason;
    }

    public void setPointreason(String pointreason) {
        this.pointreason = pointreason == null ? null : pointreason.trim();
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