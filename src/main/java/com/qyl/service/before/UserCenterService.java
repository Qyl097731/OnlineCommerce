package com.qyl.service.before;

import com.qyl.dao.UserCenterDao;
import com.qyl.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.service.before
 * date: 2020-11-24 13:07
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Service
public class UserCenterService {
    private final UserCenterDao userCenterDao;
    @Autowired
    public UserCenterService(UserCenterDao userCenterDao) {
        this.userCenterDao = userCenterDao;
    }

    public String myOrder(HttpSession session, Model model) {
        /*
        * @Description: 查找我的订单
        * @Param: [session, model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/12/15
        */
        model.addAttribute("myOrder",userCenterDao.myOrder(MyUtil.getUserID(session)));
        return "before/orderList";
    }

    public String myFocus(HttpSession session, Model model) {
        /*
        * @Description: 查找我的关注
        * @Param: [session, model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/12/15
        */
        model.addAttribute("myFocus",userCenterDao.myFocus(MyUtil.getUserID(session)));
        return "before/focusList";
    }
    public String deleteAFocus(Integer id, HttpSession session) {
        /*
        * @Description: 删除一个关注商品
        * @Param: [id, session]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/12/15
        */
        Map<String,Object> map = new HashMap<>();
        map.put("uid",MyUtil.getUserID(session));
        map.put("gid",id);
        userCenterDao.deleteAFocus(map);
        return "forward:/myFocus";
    }

    public String orderDetail(Model model, Integer orderSn) {
        /*
        * @Description: 订单详情
        * @Param: [model, orderSn]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/12/15
        */
        model.addAttribute("myOrderDetail",userCenterDao.orderDetail(orderSn));
        return "before/userOrderDetail";
    }
}