package com.lening.entity;

public class SubjectBean {
    private Integer sId;

    private String sName;

    private Integer sDuration;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public Integer getsDuration() {
        return sDuration;
    }

    public void setsDuration(Integer sDuration) {
        this.sDuration = sDuration;
    }
}