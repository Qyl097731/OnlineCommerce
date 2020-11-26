package com.qyl.service.admin;

import com.qyl.dao.AdminOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Map;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.service.admin
 * date: 2020-11-08 18:19
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@Service
public class AdminOrderService {
    private final AdminOrderDao adminOrderDao;
    @Autowired
    public AdminOrderService(AdminOrderDao adminOrderDao) {
        this.adminOrderDao = adminOrderDao;
    }

    public String deleteorderManager(Integer id) {
        adminOrderDao.deleteOrderDetail(id);
        adminOrderDao.deleteOrderBase(id);
        return "forward:/adminOrder/orderInfo";
    }

    public String orderInfo(Model model) {
        ArrayList<Map<String,Object> >list = adminOrderDao.orderInfo();
        model.addAttribute("orderList",list);
        return "admin/orderManager";
    }
}