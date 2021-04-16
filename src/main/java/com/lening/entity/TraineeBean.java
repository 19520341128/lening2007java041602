package com.lening.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class TraineeBean implements Serializable {
    private Integer tId;

    private String tName;

    private String tSex;

    private Integer tAge;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date tIndate;

    private Integer coachId;

    private String subjectName;
    private List<CoachBean> coachBeanList;
    private CoachBean coachBean;

    public CoachBean getCoachBean() {
        return coachBean;
    }

    public void setCoachBean(CoachBean coachBean) {
        this.coachBean = coachBean;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<CoachBean> getCoachBeanList() {
        return coachBeanList;
    }

    public void setCoachBeanList(List<CoachBean> coachBeanList) {
        this.coachBeanList = coachBeanList;
    }

    public Integer gettId() {
        return tId;
    }

    public void settId(Integer tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName == null ? null : tName.trim();
    }

    public String gettSex() {
        return tSex;
    }

    public void settSex(String tSex) {
        this.tSex = tSex == null ? null : tSex.trim();
    }

    public Integer gettAge() {
        return tAge;
    }

    public void settAge(Integer tAge) {
        this.tAge = tAge;
    }

    public Date gettIndate() {
        return tIndate;
    }

    public void settIndate(Date tIndate) {
        this.tIndate = tIndate;
    }

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }
}