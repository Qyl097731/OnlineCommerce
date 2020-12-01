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
    ArrayList<Buser> userInfo();
    Integer deleteOrderBaseByUId(Integer id);
    Integer deleteOrderDetailByUId(Integer id);
    Integer deleteFocusByUId(Integer id);

    Integer deleteUserByUId(Integer id);
    ArrayList<OrderBase>selectOrderBaseByUId(Integer id);
    ArrayList<Focus>selectFocusByUId(Integer id);
}
