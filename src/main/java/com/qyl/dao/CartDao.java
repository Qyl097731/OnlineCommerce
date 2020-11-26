package com.qyl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:48
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public interface CartDao {
    List<Map<String, Object>> isFocus(Map<String, Object> map);

    Integer focus(Map<String, Object> map);

    ArrayList<Map<String, Object>> isPutCart(Map<String, Object> map);

    void updateCart(Map<String, Object> map);

    void putCart(Map<String, Object> map);

    ArrayList<Map<String,Object>> selectCart(Integer uid);

    void deleteAgoods(Map<String, Object> map);

    void clear(Integer uid);
}
