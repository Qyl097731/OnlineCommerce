package com.qyl.dao;

import com.qyl.instance.FocusOrder;
import com.qyl.instance.Goods;
import com.qyl.instance.Notice;
import com.qyl.instance.SaleOrder;

import java.util.ArrayList;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:48
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
public interface IndexDao {
    /**
     * 获取销售订单
     * @return 销售订单集合
     */
    ArrayList<SaleOrder> getSaleOrder();

    /**
     * 获取所有的关注
     * @return 关注集合
     */
    ArrayList<FocusOrder> getFocusOrder();

    /**
     * 获取所有的公告
     * @return 公告集合
     */
    ArrayList<Notice> selectNotice();

    /**
     * 获取最近商品
     * @param goods
     * @return 商品集合
     */
    ArrayList<Goods> getLastedGoods(Goods goods);

    /**
     * 模糊查询商品
     * @param mykey
     * @return 商品集合
     */
    ArrayList<Goods> search(String mykey);

    /**
     * 根据id查询商品
     * @param id
     * @return 商品
     */
    Goods selectGoodsById(Integer id);

    /**
     * 查询某物品关注数目
     * @param id
     * @return Integer
     */
    Integer getFocusNum(Integer id);

    /**
     * 查询某物品成交单数
     * @param id
     * @return Integer
     */
    Integer getSaleNum(Integer id);

    /**
     * 根据类型id查商品集合
     * @param id
     * @return 商品集合
     */
    ArrayList<Goods> selectGoodsByTypeId(Integer id);
}
