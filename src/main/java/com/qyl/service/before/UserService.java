package com.qyl.service.before;

import com.qyl.dao.UserDao;
import com.qyl.instance.Buser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.controller.before
 * date: 2020-11-12 16:37
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public String toRegister(Model model) {
        model.addAttribute("buser", new Buser());
        return "before/register";
    }

    public String register(@Valid @ModelAttribute("buser") Buser buser, BindingResult result, Model model, HttpSession session, String code) {
        /*
         * @Description: 验证码不正确就直接返回注册界面 如果用户已经存在 或者 注册信息不符合标准 就回到注册界面
         * @Param: [buser, result, model, session, code]
         * @return: java.lang.String
         * @Author: Mr.Qiu
         * @Date: 2020/11/26
         */
        if (!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
            model.addAttribute("codeError", "验证码错误");
            return "before/register";
        }
        if (userDao.selectBuserByEmail(buser.getBemail()) != null) {
            result.rejectValue("bemail", "用户已经存在", "用户已经存在");
            return "before/register";
        }
        if (result.hasErrors()) {
            return "before/register";
        }
        int n = userDao.register(buser);
        if (n > 0) {
            return "before/login";
        } else {
            return "before/register";
        }
    }

    public String login(Buser buser, Model model, HttpSession session, String code) {
        /*
         * @Description: 验证码错误就回到登录界面 如果用户不存在或者密码不正确也回到登录界面
         *
         * @Param: [buser, model, session, code]
         * @return: java.lang.String
         * @Author: Mr.Qiu
         * @Date: 2020/11/26
         */
        if (!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
            model.addAttribute("codeError", "验证码错误");
            return "before/login";
        }
        Buser ruser = null;
        ArrayList<Buser> list = userDao.login(buser);
        if ( list.size() > 0) {
            ruser = list.get(0);
        }
        if (ruser == null) {
            model.addAttribute("buser", buser);
            model.addAttribute("bemailError", "用户不存在");
            return "before/login";
        }
        if (!buser.getBpwd().equals(ruser.getBpwd())) {
            model.addAttribute("buser", buser);
            model.addAttribute("passwordError", "密码错误");
            return "before/login";
        }
        session.setAttribute("buser",ruser);
        return "forward:/before";
    }
}
