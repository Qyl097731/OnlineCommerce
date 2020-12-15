package com.qyl.controller.admin;

import com.qyl.exception.admin.AdminLoginNoException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.controller.admin
 * date: 2020-10-29 18:21
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Controller
public class BaseController {


    @ModelAttribute
    public void isLogin(HttpSession session) throws AdminLoginNoException {
        if(session.getAttribute("auser") == null){
            throw new AdminLoginNoException("没有登录");
        }
    }
}