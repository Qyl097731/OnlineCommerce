package com.qyl.controller.before;

import com.qyl.service.before.CartService;
import com.qyl.service.before.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.controller.before
 * date: 2020-11-24 10:13
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Controller
public class OrderController extends BaseBeforeController{
    private final OrderService orderService;
    private final CartService cartService;
    @Autowired
    public OrderController(OrderService orderService, CartService cartService) {
        this.orderService = orderService;
        this.cartService = cartService;
    }

    @RequestMapping("/orderConfirm")
    public String orderConfirm(Model model, HttpSession session){
        /*
        * @Description: 去结算
        * @Param: [model, session]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/11/24
        */
        return cartService.orderConfirm(model,session);
    }
    @RequestMapping("/orderSubmit")
    public String orderSubmit(Model model,HttpSession session,Double amount){
        /*
        * @Description: 提交订单
        * @Param: [model, session, amount]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/11/24
        */
        return orderService.orderSubmit(model,session,amount);
    }
    @RequestMapping("/pay")
    public String pay(Integer orderSn){
        /*
        * @Description: 支付订单
        * @Param: [orderSn]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/11/24
        */
        return orderService.pay(orderSn);
    }
    @RequestMapping("/updateOrderStatue")
    public String updateOrderStatue(Integer orderSn) {
        return orderService.updateOrderStatue(orderSn);
    }
}