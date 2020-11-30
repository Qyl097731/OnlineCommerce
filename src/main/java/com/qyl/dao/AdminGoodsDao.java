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

    Integer updateGoodsById(Goods goods);

    Integer addGoods(Goods goods);

    ArrayList<Goods> selectGoods();

    Goods selectGoodsById(Integer id);

    ArrayList<Cart> selectCartGoods(Integer id);

    ArrayList<Focus> selectFocusGoods(Integer id);

    ArrayList<OrderDetail> selectOrderDetailGoods(Integer id);

    void deleteGoods(ArrayList<Integer> list);

    void deleteAGoods(Integer id);
}
