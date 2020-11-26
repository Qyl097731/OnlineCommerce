package com.qyl.instance;

import java.sql.Timestamp;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.instance
 * date: 2020-10-30 03:12
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public class Notice {
    private Integer id;
    private String notitle;
    private String ncontent;
    private Timestamp ntime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotitle() {
        return notitle;
    }

    public void setNotitle(String notitle) {
        this.notitle = notitle;
    }

    public String getNcontent() {
        return ncontent;
    }

    public void setNcontent(String ncontent) {
        this.ncontent = ncontent;
    }

    public Timestamp getNtime() {
        return ntime;
    }

    public void setNtime(Timestamp ntime) {
        this.ntime = ntime;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", notitle='" + notitle + '\'' +
                ", ncontent='" + ncontent + '\'' +
                ", ntime=" + ntime +
                '}';
    }
}