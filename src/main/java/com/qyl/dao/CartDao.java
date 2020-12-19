package com.qyl.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:48
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
public interface CartDao {
    /**
     * 查看商品是否关注
     * @param map
     * @return 商品
     */
    List<Map<String, Object>> isFocus(Map<String, Object> map);

    /**
     * 关注商品
     * @param map
     * @return Integer
     */
    Integer focus(Map<String, Object> map);

    /**
     * 是否已经放入购物车
     * @param map
     * @return 商品
     */
    ArrayList<Map<String, Object>> isPutCart(Map<String, Object> map);
    /**
     * 是否已经放入购物车
     * @param map
     * @return 商品
     */
    void updateCart(Map<String, Object> map);
    /**
     * 是否已经放入购物车
     * @param map
     * @return 商品
     */
    void putCart(Map<String, Object> map);

    /**
     * 根据用户id查询购物车商品信息
     * @param uid
     * @return 购物车中的商品集合
     */
    ArrayList<Map<String,Object>> selectCart(Integer uid);

    /**
     * 删除一个商品
     * @param map
     */
    void deleteAgoods(Map<String, Object> map);

    /**
     * 清空购物车
     * @param uid
     */
    void clear(Integer uid);
}
