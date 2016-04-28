package com.zhenapp.po;

public class TFilepathInfo {
    private Integer filepathpk;

    private String filepathid;

    private String filepath;

    private String filepathdesc;

    private String createuser;

    private String createtime;

    private String updateuser;

    private String updatetime;

    public Integer getFilepathpk() {
        return filepathpk;
    }

    public void setFilepathpk(Integer filepathpk) {
        this.filepathpk = filepathpk;
    }

    public String getFilepathid() {
        return filepathid;
    }

    public void setFilepathid(String filepathid) {
        this.filepathid = filepathid == null ? null : filepathid.trim();
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath == null ? null : filepath.trim();
    }

    public String getFilepathdesc() {
        return filepathdesc;
    }

    public void setFilepathdesc(String filepathdesc) {
        this.filepathdesc = filepathdesc == null ? null : filepathdesc.trim();
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