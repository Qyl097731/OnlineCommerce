package com.qyl.dao;

import com.qyl.instance.Goods;

import java.util.ArrayList;
import java.util.Collection;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:43
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public interface AdminGoodsDao {
    Integer updateGoodsById(Goods goods);

    Integer addGoods(Goods goods);

    ArrayList<Goods> selectGoods();

    Goods selectGoodsById(Integer id);

    ArrayList<Goods> selectCartGoods(Integer id);

    ArrayList<Goods> selectFocusGoods(Integer id);

    ArrayList<Goods> selectOrderDetailGoods(Integer id);

    void deleteGoods(ArrayList<Integer> list);

    void deleteAGoods(Integer id);
}
