package com.qyl.dao;

import com.qyl.instance.OrderBase;

import java.util.ArrayList;
import java.util.Map;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:48
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
public interface OrderDao {
    /**
     * 增加订单
     * @param order
     */
    void addOrder(OrderBase order);

    /**
     * 增加订单详情
     * @param map
     */
    void addOrderDetail(Map<String, Object> map);

    /**
     * 查询商品数
     * @param uid
     * @return 商品信息集合
     */
    ArrayList<Map<String, Object>> selectGoodsShop(Integer uid);

    /**
     * 更新库存
     * @param map2
     */
    void updateStore(Map<String, Object> map2);

    /**
     * 清空购物车
     * @param uid
     */
    void clear(Integer uid);

    /**
     * 购买商品 更新订单的状态信息
     * @param orderSn
     */
    void pay(Integer orderSn);

    /**
     * 更新订单的状态信息
     * @param orderSn
     */
    void updateOrderStatue(Integer orderSn);
}
