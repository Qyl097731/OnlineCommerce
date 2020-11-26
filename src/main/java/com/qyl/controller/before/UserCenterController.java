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
 */
@Controller
public class UserCenterController extends BaseBeforeController{
    private final UserCenterService userCenterService;
    @Autowired
    public UserCenterController(UserCenterService userCenterService) {
        this.userCenterService = userCenterService;
    }

    @RequestMapping("/userCenter")
    public String userCenter(HttpSession session, Model model){
        return userCenterService.userCenter(session,model);
    }

    @RequestMapping("/orderDetail")
    public String orderDetail(Model model,Integer orderSn){
        return userCenterService.orderDetail(model,orderSn);
    }
}