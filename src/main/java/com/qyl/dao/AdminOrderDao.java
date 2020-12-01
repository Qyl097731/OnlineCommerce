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
    ArrayList<Map<String, Object>> orderInfo();

    void deleteOrderDetail(Integer id);

    void deleteOrderBase(Integer id);
}
