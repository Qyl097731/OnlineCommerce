package dao;

import com.qyl.dao.AdminGoodsDao;
import com.qyl.dao.CartDao;
import com.qyl.dao.OrderDao;
import com.qyl.instance.OrderBase;
import com.qyl.util.MyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * projectName:  e-commerce
 * packageName: dao
 * date: 2020-11-24 10:54
 * copyright(c) 2020 南晓18卓工 邱依良
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml","classpath:/spring/applicationContext-mvc.xml"})
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private AdminGoodsDao goodsDao;
    @Test
    public void addOrder() {
        ArrayList<Map<String,Object>> list = cartDao.selectCart(1);
        OrderBase order = new OrderBase();
        double amount = 0;
        for(Map<String,Object> map : list ){
            amount= amount + (Double)map.get("smallSum");
        }
        order.setBusertable_id(1);
        order.setAmount(amount);
        //生成订单，并将主键返回order
        orderDao.addOrder(order);
    }

    @Test
    public void addOrderDetail() {
        ArrayList<Map<String,Object>> list = cartDao.selectCart(1);
        OrderBase order = new OrderBase();
        double amount = 0;
        for(Map<String,Object> map : list ){
            amount= amount + (Double)map.get("smallSum");
        }
        order.setBusertable_id(1);
        order.setAmount(amount);
        //生成订单，并将主键返回order
        orderDao.addOrder(order);
        //生成订单详情
        Map<String,Object> map = new HashMap<>();
        map.put("orderSn",order.getId());
        map.put("uid",1);
        orderDao.addOrderDetail(map);
    }

    @Test
    public void selectGoodsShop() {
        ArrayList<Map<String,Object>>list = orderDao.selectGoodsShop(1);
        for(Map<String,Object> map2:list){
            orderDao.updateStore(map2);
        }
    }

    @Test
    public void updateStore() {
        System.out.println(goodsDao.selectGoods());
    }

    @Test
    public void clear() {
        orderDao.clear(1);
    }

    @Test
    public void pay() {
        orderDao.pay(1);
    }
}