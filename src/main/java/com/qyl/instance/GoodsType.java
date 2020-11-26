package com.qyl.instance;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.instance
 * date: 2020-10-30 03:11
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public class GoodsType {
    private Integer id;
    private String typename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                '}';
    }
}