package com.qyl.service.before;

import com.qyl.dao.UserDao;
import com.qyl.instance.Buser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.controller.before
 * date: 2020-11-12 16:37
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@Service
public class UserService {
    private final UserDao userDao;
    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public String toRegister(Model model){
        model.addAttribute("buser",new Buser());
        return "before/register";
    }
    public String register(Buser buser, Model model, HttpSession session,String code){
        if(!code.equalsIgnoreCase(session.getAttribute("code").toString())){
            model.addAttribute("codeError","验证码错误");
            return "before/register";
        }
        if(userDao.selectBuserByEmail(buser.getBemail()) != null){
            model.addAttribute("msg","用户已存在");
            return "before/register";
        }
        int n = userDao.register(buser);
        if(n > 0){
            return "before/login";
        }else {
            model.addAttribute("msg","注册失败");
            return "before/register";
        }
    }

    public String login(Buser buser, Model model, HttpSession session, String code) {
        if(!code.equalsIgnoreCase(session.getAttribute("code").toString())){
            model.addAttribute("msg","验证码错误");
            return "before/login";
        }
        Buser ruser = null;
        ArrayList<Buser>list = userDao.login(buser);
        if(list.size() > 0){
            ruser = list.get(0);
        }
        if(ruser != null){
            session.setAttribute("buser",buser);
            return "forward:/before";
        }else{
            model.addAttribute("msg","用户名或密码错误");
            return "before/login";
        }
    }
}