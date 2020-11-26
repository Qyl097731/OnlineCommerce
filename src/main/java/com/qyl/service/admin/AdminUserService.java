package com.qyl.service.admin;

import com.qyl.dao.AdminUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Map;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.service.admin
 * date: 2020-11-08 18:34
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@Service
public class AdminUserService {
    private final AdminUserDao adminUserDao;
    @Autowired
    public AdminUserService(AdminUserDao adminUserDao) {
        this.adminUserDao = adminUserDao;
    }

    public String deleteuserManager(Integer id) {
//        adminUserDao.deleteUserDetail(id);
//        adminUserDao.deleteOrderBase(id);
        return "forward:/adminOrder/orderInfo";
    }

    public String userInfo(Model model) {
//        ArrayList<Map<String,Object>> list = adminUserDao.orderInfo();
//        model.addAttribute("orderList",list);
        return "admin/orderManager";
    }
}