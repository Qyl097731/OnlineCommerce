package com.qyl.dao;

import java.util.ArrayList;
import java.util.Map;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:48
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
public interface AdminOrderDao {
    /**
     * 查询所有订单信息
     * @return 订单信息集合
     */
    ArrayList<Map<String, Object>> orderInfo();

    /**
     * 删除订单详情
     * @param id
     */
    void deleteOrderDetail(Integer id);

    /**
     * 删除订单
     * @param id
     */
    void deleteOrderBase(Integer id);
}
