package com.qyl.service.before;

import com.qyl.dao.CartDao;
import com.qyl.dao.OrderDao;
import com.qyl.instance.OrderBase;
import com.qyl.util.MyUtil;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.service.before
 * date: 2020-11-24 10:13
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Service
public class OrderService {
    private final OrderDao orderDao;
    private final CartDao cartDao;
    @Autowired
    public OrderService(OrderDao orderDao, CartDao cartDao) {
        this.orderDao = orderDao;
        this.cartDao = cartDao;
    }


    public String orderSubmit(Model model, HttpSession session, Double amount) {
        OrderBase order = new OrderBase();
        order.setAmount(amount);
        order.setBusertable_id(MyUtil.getUserID(session));
        //生成订单，并将主键返回order
        orderDao.addOrder(order);
        //生成订单详情
        Map<String,Object> map = new HashMap<>();
        map.put("orderSn",order.getId());
        map.put("uid",MyUtil.getUserID(session));
        orderDao.addOrderDetail(map);
        //更新商品库存
        //更新商品库存，查询商品购买量，方便更新库存使用
        ArrayList<Map<String,Object>>list = orderDao.selectGoodsShop(MyUtil.getUserID(session));
        //更新商品库存，根据商品购买量更新库存
        for(Map<String,Object> map2:list){
            orderDao.updateStore(map2);
        }
        //清空购物车
        orderDao.clear(MyUtil.getUserID(session));
        System.out.println(order.getId());
        model.addAttribute("orderSn",order.getId());
        return "before/orderDone";
    }

    public String pay(Integer orderSn) {
        orderDao.pay(orderSn);
        return "before/payDone";
    }

    public String updateOrderStatue(Integer orderSn) {
        orderDao.updateOrderStatue(orderSn);
        return "forward:/myOrder";
    }
}