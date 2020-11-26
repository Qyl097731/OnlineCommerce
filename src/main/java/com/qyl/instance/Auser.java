package com.qyl.instance;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.instance.Auser
 * date: 2020-10-29 18:32
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public class Auser {
    private String aname;
    private String apwd;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    @Override
    public String toString() {
        return "Auser{" +
                "aname='" + aname + '\'' +
                ", apwd='" + apwd + '\'' +
                '}';
    }
}