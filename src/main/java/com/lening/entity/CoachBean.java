package com.lening.entity;

import org.springframework.format.annotation.DateTimeFormat;
import sun.awt.SunHints;

import java.util.Date;

public class CoachBean {
    private Integer cId;

    private String cName;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date cBirth;

    private String cSex;

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Date getcBirth() {
        return cBirth;
    }

    public void setcBirth(Date cBirth) {
        this.cBirth = cBirth;
    }

    public String getcSex() {
        return cSex;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex == null ? null : cSex.trim();
    }
}