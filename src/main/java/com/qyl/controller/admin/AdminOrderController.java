package com.qyl.controller.admin;

import com.qyl.service.admin.AdminOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/orderInfo")
    public String orderInfo(Model model,@RequestParam(value = "pageCur",defaultValue = "1") Integer pageCur){
        /*
        * @Description: 分页查询订单
        * @Param: [model, pageCur]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2021/1/4
        */
        return adminOrderService.orderInfo(model,pageCur);
    }
    @RequestMapping("/deleteorderManager")
    public String deleteorderManager(Integer id){
        /*
        * @Description: 根据id删除订单
        * @Param: [id]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2021/1/4
        */
        return adminOrderService.deleteorderManager(id);
    }
}