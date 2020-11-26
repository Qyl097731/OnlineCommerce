package com.qyl.controller.admin;

import com.qyl.service.admin.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.controller.admin
 * date: 2020-11-08 18:19
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Controller
@RequestMapping("/adminOrder")
public class AdminOrderController extends BaseController{

    private final AdminOrderService adminOrderService;
    @Autowired
    public AdminOrderController(AdminOrderService adminOrderService) {
        this.adminOrderService = adminOrderService;
    }

    @RequestMapping("orderInfo")
    public String orderInfo(Model model){
        return adminOrderService.orderInfo(model);
    }
    @RequestMapping("/deleteorderManager")
    public String deleteorderManager(Integer id){
        return adminOrderService.deleteorderManager(id);
    }
}