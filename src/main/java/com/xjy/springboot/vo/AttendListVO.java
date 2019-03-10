package com.xjy.springboot.vo;

import java.io.Serializable;

public class AttendListVO implements Serializable {

    private String travelId;

    private String openId;

    private String comment;

    public String getTravelId() {
        return travelId;
    }

    public void setTravelId(String travelId) {
        this.travelId = travelId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String opendId) {
        this.openId = opendId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
