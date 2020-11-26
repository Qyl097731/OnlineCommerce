package com.qyl.instance;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.instance
 * date: 2020-10-30 03:02
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public class Cart {
    private Integer id;
    private Integer busertable_id;
    private Integer goodstbble_id;
    private Integer shoppinggnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusertable_id() {
        return busertable_id;
    }

    public void setBusertable_id(Integer busertable_id) {
        this.busertable_id = busertable_id;
    }

    public Integer getGoodstbble_id() {
        return goodstbble_id;
    }

    public void setGoodstbble_id(Integer goodstbble_id) {
        this.goodstbble_id = goodstbble_id;
    }

    public Integer getShoppinggnum() {
        return shoppinggnum;
    }

    public void setShoppinggnum(Integer shoppinggnum) {
        this.shoppinggnum = shoppinggnum;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", busertable_id=" + busertable_id +
                ", goodstbble_id=" + goodstbble_id +
                ", shoppinggnum=" + shoppinggnum +
                '}';
    }
}