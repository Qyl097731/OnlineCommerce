package com.qyl.instance;

import org.springframework.web.multipart.MultipartFile;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.instance
 * date: 2020-10-30 03:09
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
public class Goods {
    private Integer id;
    private String gname;
    private Double goprice;
    private Double grprice;
    private Integer gstore;
    private String gpicture;
    private Integer gtypeId;
    private String description;
    private MultipartFile logoImage;
    private String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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


    public Integer getGtypeId() {
        return gtypeId;
    }

    public void setGtypeId(Integer gtypeId) {
        this.gtypeId = gtypeId;
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getLogoImage() {
        return logoImage;
    }

    public void setLogoImage(MultipartFile logoImage) {
        this.logoImage = logoImage;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", gname='" + gname + '\'' +
                ", goprice=" + goprice +
                ", grprice=" + grprice +
                ", gstore=" + gstore +
                ", gpicture='" + gpicture + '\'' +
                ", gtype_id=" + gtypeId +
                ", description='" + description + '\'' +
                ", logoImage=" + logoImage +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}