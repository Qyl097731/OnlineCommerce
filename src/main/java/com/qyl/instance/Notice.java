package com.qyl.instance;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.instance
 * date: 2020-10-30 03:12
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
public class Notice {
    private Integer id;
    private String ntitle;
    private String ncontent;
    private MultipartFile logos;

    private String npicture;
    private Timestamp ntime;


    public String getNpicture() {
        return npicture;
    }

    public void setNpicture(String npicture) {
        this.npicture = npicture;
    }

    public MultipartFile getLogos() {
        return logos;
    }

    public void setLogos(MultipartFile logos) {
        this.logos = logos;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNtitle() {
        return ntitle;
    }

    public void setNtitle(String ntitle) {
        this.ntitle = ntitle;
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
                ", ntitle='" + ntitle + '\'' +
                ", ncontent='" + ncontent + '\'' +
                ", logos=" + logos +
                ", npictrue='" + npicture + '\'' +
                ", ntime=" + ntime +
                '}';
    }
}