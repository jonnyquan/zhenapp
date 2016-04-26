package com.zhenapp.po;

public class TTaskDetailinfo {
    private Integer taskdetailpk;

    private Integer taskdetailid;

    private Integer taskid;

    private String taskkeyword;

    private String taskkeynum;

    private String iscollection;

    private String isshopping;

    private String taskstate;

    private String taskcount;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    public Integer getTaskdetailpk() {
        return taskdetailpk;
    }

    public void setTaskdetailpk(Integer taskdetailpk) {
        this.taskdetailpk = taskdetailpk;
    }

    public Integer getTaskdetailid() {
        return taskdetailid;
    }

    public void setTaskdetailid(Integer taskdetailid) {
        this.taskdetailid = taskdetailid;
    }

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public String getTaskkeyword() {
        return taskkeyword;
    }

    public void setTaskkeyword(String taskkeyword) {
        this.taskkeyword = taskkeyword == null ? null : taskkeyword.trim();
    }

    public String getTaskkeynum() {
        return taskkeynum;
    }

    public void setTaskkeynum(String taskkeynum) {
        this.taskkeynum = taskkeynum == null ? null : taskkeynum.trim();
    }

    public String getIscollection() {
        return iscollection;
    }

    public void setIscollection(String iscollection) {
        this.iscollection = iscollection == null ? null : iscollection.trim();
    }

    public String getIsshopping() {
        return isshopping;
    }

    public void setIsshopping(String isshopping) {
        this.isshopping = isshopping == null ? null : isshopping.trim();
    }

    public String getTaskstate() {
        return taskstate;
    }

    public void setTaskstate(String taskstate) {
        this.taskstate = taskstate == null ? null : taskstate.trim();
    }

    public String getTaskcount() {
        return taskcount;
    }

    public void setTaskcount(String taskcount) {
        this.taskcount = taskcount == null ? null : taskcount.trim();
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