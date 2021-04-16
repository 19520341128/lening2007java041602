package com.lening.entity;

import java.util.Date;

public class RecordBean {
    private Integer rId;

    private Date rDate;

    private Integer rDuration;

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Date getrDate() {
        return rDate;
    }

    public void setrDate(Date rDate) {
        this.rDate = rDate;
    }

    public Integer getrDuration() {
        return rDuration;
    }

    public void setrDuration(Integer rDuration) {
        this.rDuration = rDuration;
    }
}