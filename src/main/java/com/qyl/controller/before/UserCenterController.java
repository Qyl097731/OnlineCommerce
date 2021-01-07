package com.qyl.controller.before;

import com.qyl.service.before.UserCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.controller.before
 * date: 2020-11-24 13:06
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Controller
public class UserCenterController extends BaseBeforeController{
    private final UserCenterService userCenterService;
    @Autowired
    public UserCenterController(UserCenterService userCenterService) {
        this.userCenterService = userCenterService;
    }

    @RequestMapping("/myFocus")
    public String myFocus(HttpSession session, Model model){
        /*
        * @Description: 我的收藏
        * @Param: [session, model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2021/1/4
        */
        return userCenterService.myFocus(session,model);
    }

    @RequestMapping("/myOrder")
    public String myOrder(HttpSession session, Model model){
        /*
        * @Description: 我的订单
        * @Param: [session, model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2021/1/4
        */
        return userCenterService.myOrder(session,model);
    }
    @RequestMapping("/deleteAFocus")
    public String deleteAFocus(Integer id,HttpSession session){
        /*
        * @Description: 删除一收藏商品
        * @Param: [id, session]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2021/1/4
        */
        return userCenterService.deleteAFocus(id,session);
    }
    @RequestMapping("/orderDetail")
    public String orderDetail(Model model,Integer orderSn){
        /*
        * @Description: 订单详情
        * @Param: [model, orderSn]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2021/1/4
        */
        return userCenterService.orderDetail(model,orderSn);
    }
}