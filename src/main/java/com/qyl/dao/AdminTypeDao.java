package com.qyl.dao;

import com.qyl.instance.Goods;
import com.qyl.instance.GoodsType;

import java.util.ArrayList;


/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:47
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public interface AdminTypeDao {
    ArrayList<GoodsType> selectGoodsType();

    void addType(String typeName);

    ArrayList<Goods> selectGoodsByType(Integer id);

    Integer deleteType(Integer id);
}
