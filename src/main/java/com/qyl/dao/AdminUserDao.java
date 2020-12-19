package com.qyl.dao;

import com.qyl.instance.Buser;
import com.qyl.instance.Focus;
import com.qyl.instance.OrderBase;

import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Map;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:48
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
public interface AdminUserDao {
    /**
     * 查询所有用户信息
     * @return 用户集合
     */
    ArrayList<Buser> userInfo();

    /**
     * 删除订单信息根据用户id
     * @param id
     * @return Integer
     */
    Integer deleteOrderBaseByUId(Integer id);
    /**
     * 删除订单详情根据用户id
     * @param id
     * @return Integer
     */
    Integer deleteOrderDetailByUId(Integer id);
    /**
     * 删除关注列表根据用户id
     * @param id
     * @return Integer
     */
    Integer deleteFocusByUId(Integer id);
    /**
     * 删除用户根据用户id
     * @param id
     * @return Integer
     */
    Integer deleteUserByUId(Integer id);
    /**
     * 查询订单信息根据用户id
     * @param id
     * @return 订单详情集合
     */
    ArrayList<OrderBase>selectOrderBaseByUId(Integer id);
    /**
     * 删除关注列表信息根据用户id
     * @param id
     * @return Integer
     */
    ArrayList<Focus>selectFocusByUId(Integer id);
}
