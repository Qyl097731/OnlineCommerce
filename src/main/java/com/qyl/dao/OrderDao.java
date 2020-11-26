package com.qyl.dao;

import com.qyl.instance.OrderBase;

import java.util.ArrayList;
import java.util.Map;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:48
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public interface OrderDao {
    void addOrder(OrderBase order);

    void addOrderDetail(Map<String, Object> map);

    ArrayList<Map<String, Object>> selectGoodsShop(Integer uid);

    void updateStore(Map<String, Object> map2);

    void clear(Integer uid);

    void pay(Integer orderSn);
}
