package com.qyl.instance;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.instance.Buser
 * date: 2020-10-29 18:32
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public class Buser {
    private Integer id;
    @NotBlank(message = "{user.username.required}")
    private String bemail;
    @Length(min=6,max=50,message = "{user.password.invalid}")
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