package com.qyl.controller.before;

import com.qyl.exception.before.UserLoginNoException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.controller.admin
 * date: 2020-10-29 18:21
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Controller
public class BaseBeforeController {


    @ModelAttribute
    public void isLogin(HttpSession session, HttpServletRequest request) throws UserLoginNoException {
        if(session.getAttribute("buser") == null){
            throw new UserLoginNoException("没有登录");
        }
    }
}