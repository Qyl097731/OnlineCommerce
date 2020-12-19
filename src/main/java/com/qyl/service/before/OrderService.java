package com.qyl.service.before;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.qyl.config.AlipayConfig;
import com.qyl.dao.CartDao;
import com.qyl.dao.OrderDao;
import com.qyl.dao.UserCenterDao;
import com.qyl.instance.OrderBase;
import com.qyl.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.service.before
 * date: 2020-11-24 10:13
 * copyright(c) 2020 南晓18卓工 邱依良
 *
 * @author 邱依良
 */
@Service
public class OrderService {
    private final UserCenterDao userCenterDao;
    private final OrderDao orderDao;
    private final CartDao cartDao;

    @Autowired
    public OrderService(UserCenterDao userCenterDao, OrderDao orderDao, CartDao cartDao) {
        this.userCenterDao = userCenterDao;
        this.orderDao = orderDao;
        this.cartDao = cartDao;
    }


    public String orderSubmit(Model model, HttpSession session, Double amount) {
        /*
         * @Description: 订单提交
         * @Param: [model, session, amount]
         * @return: java.lang.String
         * @Author: Mr.Qiu
         * @Date: 2020/12/15
         */
        OrderBase order = new OrderBase();
        order.setAmount(amount);
        order.setBusertable_id(MyUtil.getUserID(session));
        //生成订单，并将主键返回order
        orderDao.addOrder(order);
        //生成订单详情
        Map<String, Object> map = new HashMap<>();
        map.put("orderSn", order.getId());
        map.put("uid", MyUtil.getUserID(session));
        orderDao.addOrderDetail(map);
        //更新商品库存
        //更新商品库存，查询商品购买量，方便更新库存使用
        ArrayList<Map<String, Object>> list = orderDao.selectGoodsShop(MyUtil.getUserID(session));
        //更新商品库存，根据商品购买量更新库存
        for (Map<String, Object> map2 : list) {
            orderDao.updateStore(map2);
        }
        //清空购物车
        orderDao.clear(MyUtil.getUserID(session));
        model.addAttribute("orderSn", order.getId());
        return "forward:/alipay?orderSn="+order.getId();
    }

    public String pay(Integer orderSn) {
        /*
         * @Description: 支付订单
         * @Param: [orderSn]
         * @return: java.lang.String
         * @Author: Mr.Qiu
         * @Date: 2020/12/15
         */
        orderDao.pay(orderSn);
        return "before/payDone";
    }

    public String updateOrderStatue(Integer orderSn) {
        /*
         * @Description: 更新订单信息
         * @Param: [orderSn]
         * @return: java.lang.String
         * @Author: Mr.Qiu
         * @Date: 2020/12/15
         */
        orderDao.updateOrderStatue(orderSn);
        return "forward:/myOrder";
    }

    public void alipay(Integer orderSn, HttpServletResponse httpResponse) throws Exception {
        //获取订单详情
        Map<String, Object> orderDetail = userCenterDao.orderDetail(orderSn);
        //实例化客户端,填入所需参数
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.GATEWAY_URL, AlipayConfig.APP_ID, AlipayConfig.APP_PRIVATE_KEY, AlipayConfig.FORMAT, AlipayConfig.CHARSET, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        //在公共参数中设置回跳和通知地址
        request.setReturnUrl(AlipayConfig.RETURN_URL);
        request.setNotifyUrl(AlipayConfig.NOTIFY_URL);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        //生成随机Id
        String out_trade_no = MyUtil.getStringID();
        //付款金额，必填
        Double total_amount =  (Double)orderDetail.get("amount");
        //订单名称，必填
        String subject = (String) orderDetail.get("gname");
        request.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        String form = "";
        try {
            form = alipayClient.pageExecute(request).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        orderDao.pay(orderSn);
        httpResponse.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();
    }
}