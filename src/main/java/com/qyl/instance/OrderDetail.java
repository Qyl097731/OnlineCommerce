package com.qyl.instance;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.instance
 * date: 2020-10-30 03:16
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public class OrderDetail {
    private Integer id;
    private Integer orderbasetable_id;
    private Integer goodstable_id;
    private Integer shoppinggnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderbasetable_id() {
        return orderbasetable_id;
    }

    public void setOrderbasetable_id(Integer orderbasetable_id) {
        this.orderbasetable_id = orderbasetable_id;
    }

    public Integer getGoodstable_id() {
        return goodstable_id;
    }

    public void setGoodstable_id(Integer goodstable_id) {
        this.goodstable_id = goodstable_id;
    }

    public Integer getShoppinggnum() {
        return shoppinggnum;
    }

    public void setShoppinggnum(Integer shoppinggnum) {
        this.shoppinggnum = shoppinggnum;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orderbasetable_id=" + orderbasetable_id +
                ", goodstable_id=" + goodstable_id +
                ", shoppinggnum=" + shoppinggnum +
                '}';
    }
}