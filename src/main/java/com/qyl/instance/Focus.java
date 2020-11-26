package com.qyl.instance;

import java.sql.Timestamp;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.instance
 * date: 2020-10-30 03:05
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public class Focus {
    private Integer id;
    private Integer goodstable_id;
    private Integer busertable_id;
    private Timestamp focustime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodstable_id() {
        return goodstable_id;
    }

    public void setGoodstable_id(Integer goodstable_id) {
        this.goodstable_id = goodstable_id;
    }

    public Integer getBusertable_id() {
        return busertable_id;
    }

    public void setBusertable_id(Integer busertable_id) {
        this.busertable_id = busertable_id;
    }

    public Timestamp getFocustime() {
        return focustime;
    }

    public void setFocustime(Timestamp focustime) {
        this.focustime = focustime;
    }

    @Override
    public String toString() {
        return "Focus{" +
                "id=" + id +
                ", goodstable_id=" + goodstable_id +
                ", busertable_id=" + busertable_id +
                ", focustime=" + focustime +
                '}';
    }
}