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
    ArrayList<SaleOrder> getSaleOrder();

    ArrayList<FocusOrder> getFocusOrder();

    ArrayList<Notice> selectNotice();

    ArrayList<Goods> getLastedGoods(Goods goods);

    ArrayList<Goods> search(String mykey);

    Goods selectGoodsById(Integer id);

    Integer getFocusNum(Integer id);

    Integer getSaleNum(Integer id);

    ArrayList<Goods> selectGoodsByTypeId(Integer id);
}
