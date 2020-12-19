package com.qyl.dao;

import java.util.ArrayList;
import java.util.Map;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:49
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
public interface UserCenterDao {
    /**
     * 查询所有的订单
     * @param uid
     * @return
     */
    ArrayList<Map<String,Object>> myOrder(Integer uid);

    /**
     * 查询关注列表
     * @param uid
     * @return
     */
    ArrayList<Map<String,Object>> myFocus(Integer uid);

    /**
     * 根据订单号查询订单详情
     * @param orderSn
     * @return
     */
    Map<String,Object> orderDetail(Integer orderSn);

    /**
     * 删除一个关注商品
     * @param map
     */
    void deleteAFocus(Map<String, Object> map);
}
