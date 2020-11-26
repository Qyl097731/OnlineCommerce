package com.qyl.instance;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.instance.Buser
 * date: 2020-10-29 18:32
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public class Buser {
    private Integer id;
    private String bemail;
    private String bpwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBemail() {
        return bemail;
    }

    public void setBemail(String bemail) {
        this.bemail = bemail;
    }

    public String getBpwd() {
        return bpwd;
    }

    public void setBpwd(String bpwd) {
        this.bpwd = bpwd;
    }

    @Override
    public String toString() {
        return "Buser{" +
                "id=" + id +
                ", bemail='" + bemail + '\'' +
                ", bpwd='" + bpwd + '\'' +
                '}';
    }
}