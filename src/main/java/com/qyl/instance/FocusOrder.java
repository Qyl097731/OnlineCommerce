package com.qyl.instance;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.instance
 * date: 2020-11-10 11:16
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
public class FocusOrder {
    private Integer id;
    private Integer focusNum;
    private String gname;
    private Double grprice;
    private String gpicture;
    private String description;

    @Override
    public String toString() {
        return "FocusOrder{" +
                "id=" + id +
                ", focusNum=" + focusNum +
                ", gname='" + gname + '\'' +
                ", grprice=" + grprice +
                ", gpicture='" + gpicture + '\'' +
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

    public Integer getFocusNum() {
        return focusNum;
    }

    public void setFocusNum(Integer focusNum) {
        this.focusNum = focusNum;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Double getGrprice() {
        return grprice;
    }

    public void setGrprice(Double grprice) {
        this.grprice = grprice;
    }

    public String getGpicture() {
        return gpicture;
    }

    public void setGpicture(String gpicture) {
        this.gpicture = gpicture;
    }

}