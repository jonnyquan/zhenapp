package com.zhenapp.po;

public class TPhoneInfo {
    private Integer phonepk;

    private String phoneid;

    private Integer phonestate;

    private Integer phonetasknum;

    private Integer phonesurplusnum;

    private Integer phonealreadynum;

    private String phonetype;

    public Integer getPhonepk() {
        return phonepk;
    }

    public void setPhonepk(Integer phonepk) {
        this.phonepk = phonepk;
    }

    public String getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(String phoneid) {
        this.phoneid = phoneid == null ? null : phoneid.trim();
    }

    public Integer getPhonestate() {
        return phonestate;
    }

    public void setPhonestate(Integer phonestate) {
        this.phonestate = phonestate;
    }

    public Integer getPhonetasknum() {
        return phonetasknum;
    }

    public void setPhonetasknum(Integer phonetasknum) {
        this.phonetasknum = phonetasknum;
    }

    public Integer getPhonesurplusnum() {
        return phonesurplusnum;
    }

    public void setPhonesurplusnum(Integer phonesurplusnum) {
        this.phonesurplusnum = phonesurplusnum;
    }

    public Integer getPhonealreadynum() {
        return phonealreadynum;
    }

    public void setPhonealreadynum(Integer phonealreadynum) {
        this.phonealreadynum = phonealreadynum;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype == null ? null : phonetype.trim();
    }
}