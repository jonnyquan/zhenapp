package com.zhenapp.po;

public class TAgentInfo {
    private Integer agentpk;

    private String agentid;

    private String agentuserid;

    private String agentperson;

    private String agentphone;

    private String agentname;

    private String domain;

    private String url;

    private String agentstate;

    private String createtime;

    private String createuser;

    private String updatetime;

    private String updateuser;

    public Integer getAgentpk() {
        return agentpk;
    }

    public void setAgentpk(Integer agentpk) {
        this.agentpk = agentpk;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid == null ? null : agentid.trim();
    }

    public String getAgentuserid() {
        return agentuserid;
    }

    public void setAgentuserid(String agentuserid) {
        this.agentuserid = agentuserid == null ? null : agentuserid.trim();
    }

    public String getAgentperson() {
        return agentperson;
    }

    public void setAgentperson(String agentperson) {
        this.agentperson = agentperson == null ? null : agentperson.trim();
    }

    public String getAgentphone() {
        return agentphone;
    }

    public void setAgentphone(String agentphone) {
        this.agentphone = agentphone == null ? null : agentphone.trim();
    }

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname == null ? null : agentname.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getAgentstate() {
        return agentstate;
    }

    public void setAgentstate(String agentstate) {
        this.agentstate = agentstate == null ? null : agentstate.trim();
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