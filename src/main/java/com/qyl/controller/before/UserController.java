package com.qyl.controller.before;

import com.qyl.instance.Auser;
import com.qyl.instance.Buser;
import com.qyl.service.before.IndexService;
import com.qyl.service.before.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.controller.before
 * date: 2020-11-12 16:32
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Controller
@RequestMapping("/before")
public class UserController {
    private final IndexService indexService;
    private final UserService userService;
    @Autowired
    public UserController(IndexService indexService, UserService userService) {
        this.indexService = indexService;
        this.userService = userService;
    }

    @RequestMapping("/toPageBeforeRegister")
    public String toPageBeforeRegister(Model model){
        /*
        * @Description: 注册界面跳转
        * @Param: [model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2021/1/4
        */
        return indexService.toRegister(model);
    }
    @RequestMapping("/register")
    public String register(@Valid @ModelAttribute("buser")Buser buser,BindingResult result,Model model, HttpSession session, String code){
        /*
        * @Description: 注册
        * @Param: [buser, result, model, session, code]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2021/1/4
        */
        return userService.register(buser,result,model,session,code);
    }
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        /*
        * @Description: 登录页面跳转
        * @Param: [model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2021/1/4
        */
        return indexService.toLogin(model);
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("buser") Buser buser,Model model,HttpSession session,String code){
        /*
        * @Description: 登录
        * @Param: [buser, model, session, code]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2021/1/4
        */
        return userService.login(buser,model,session,code);
    }
    @RequestMapping("/exit")
    public String exit(HttpSession session){
        /*
         * @Description: 删除session会话 返回登陆界面
         * @Param: [auser, session]
         * @return: java.lang.String
         * @Author: Mr.Qiu
         * @Date: 2020/11/26
         */
        session.invalidate();
        return "forward:/before";
    }
}