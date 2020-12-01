package com.qyl.service.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qyl.dao.AdminOrderDao;
import com.qyl.instance.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

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

    public String orderInfo(Model model,@RequestParam(value = "pageCur",defaultValue = "1") Integer pageCur) {
        PageHelper.startPage(pageCur, 10);
        ArrayList<Map<String,Object> > list = adminOrderDao.orderInfo();
        PageInfo<Map<String,Object>> info = new PageInfo<>(list, 5);
        int[] nums = info.getNavigatepageNums();
        long total = info.getTotal();
        model.addAttribute("nums", nums);
        model.addAttribute("orderList", list);
        model.addAttribute("total", total);
        model.addAttribute("info", info);
        return "admin/managerOrder";
    }
}