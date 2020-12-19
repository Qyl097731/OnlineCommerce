package com.qyl.dao;

import com.qyl.instance.Goods;
import com.qyl.instance.GoodsType;

import java.util.ArrayList;


/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:47
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
public interface AdminTypeDao {
    /**
     * 查询所有商品种类
     * @return 商品种类集合
     */
    ArrayList<GoodsType> selectGoodsType();

    /**
     * 增加商品种类
     * @param typeName
     */
    void addType(String typeName);

    /**
     * 查询商品按照商品种类
     * @param id
     * @return 商品集合
     */
    ArrayList<Goods> selectGoodsByType(Integer id);

    /**
     * 根据id删除商品种类
     * @param id
     * @return Integer
     */
    Integer deleteType(Integer id);
}
