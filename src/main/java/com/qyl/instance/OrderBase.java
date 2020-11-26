package com.qyl.instance;

import java.sql.Timestamp;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.instance
 * date: 2020-10-30 03:13
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public class OrderBase {
    private Integer id;
    private Integer busertable_id;
    private Double amount;
    private Integer status;
    private Timestamp orderdate;

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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Timestamp orderdate) {
        this.orderdate = orderdate;
    }

    @Override
    public String toString() {
        return "OrderBase{" +
                "id=" + id +
                ", busertable_id=" + busertable_id +
                ", amount=" + amount +
                ", status=" + status +
                ", orderdate=" + orderdate +
                '}';
    }
}