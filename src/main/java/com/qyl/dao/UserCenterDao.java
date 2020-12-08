package com.qyl.dao;

import java.util.ArrayList;
import java.util.Map;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:49
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public interface UserCenterDao {
    ArrayList<Map<String,Object>> myOrder(Integer uid);

    ArrayList<Map<String,Object>> myFocus(Integer uid);

    Map<String,Object> orderDetail(Integer orderSn);

    void deleteAFocus(Map<String, Object> map);
}
