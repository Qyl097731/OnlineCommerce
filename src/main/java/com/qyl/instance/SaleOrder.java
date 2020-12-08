package com.qyl.instance;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.instance
 * date: 2020-11-10 10:50
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public class SaleOrder {
    private Integer id;
    private String gname;
    private Double goprice;
    private Double grprice;
    private Integer gstore;
    private String gpicture;
    private Integer shoppingnum;
    private String description;

    @Override
    public String toString() {
        return "SaleOrder{" +
                "id=" + id +
                ", gname='" + gname + '\'' +
                ", goprice=" + goprice +
                ", grprice=" + grprice +
                ", gstore=" + gstore +
                ", gpicture='" + gpicture + '\'' +
                ", shoppingnum=" + shoppingnum +
                ", description='" + description + '\'' +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Double getGoprice() {
        return goprice;
    }

    public void setGoprice(Double goprice) {
        this.goprice = goprice;
    }

    public Double getGrprice() {
        return grprice;
    }

    public void setGrprice(Double grprice) {
        this.grprice = grprice;
    }

    public Integer getGstore() {
        return gstore;
    }

    public void setGstore(Integer gstore) {
        this.gstore = gstore;
    }

    public String getGpicture() {
        return gpicture;
    }

    public void setGpicture(String gpicture) {
        this.gpicture = gpicture;
    }

    public Integer getShoppingnum() {
        return shoppingnum;
    }

    public void setShoppingnum(Integer shoppingnum) {
        this.shoppingnum = shoppingnum;
    }

}