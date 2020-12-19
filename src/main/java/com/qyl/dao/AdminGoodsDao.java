package com.qyl.dao;

import com.qyl.instance.Cart;
import com.qyl.instance.Focus;
import com.qyl.instance.Goods;
import com.qyl.instance.OrderDetail;

import java.util.ArrayList;
import java.util.Collection;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:43
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
public interface AdminGoodsDao {
    /**
     * 根据id查询商品
     * @param goods
     * @return Integer
     */
    Integer updateGoodsById(Goods goods);

    /**
     * 增加商品
     * @param goods
     * @return Integer
     */
    Integer addGoods(Goods goods);

    /**
     * 查询所有商品
     * @return 商品集合
     */
    ArrayList<Goods> selectGoods();

    /**
     * 根据id查询商品信息
     * @param id
     * @return 商品信息
     */
    Goods selectGoodsById(Integer id);

    /**
     * 根据id查询购物车商品信息
     * @param id
     * @return 购物车商品信息
     */
    ArrayList<Cart> selectCartGoods(Integer id);

    /**
     * 根据id查询收藏夹商品信息
     * @param id
     * @return 收藏夹商品信息
     */
    ArrayList<Focus> selectFocusGoods(Integer id);

    /**
     * 根据id查询订单详情
     * @param id
     * @return 订单详情
     */
    ArrayList<OrderDetail> selectOrderDetailGoods(Integer id);

    /**
     * 批量删除
     * @param list
     */
    void deleteGoods(ArrayList<Integer> list);

    /**
     * 根据id删除商品
     * @param id
     */
    void deleteAGoods(Integer id);
}
