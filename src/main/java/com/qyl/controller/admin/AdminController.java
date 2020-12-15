package com.qyl.controller.admin;

import com.qyl.instance.Auser;
import com.qyl.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.controller.admin
 * date: 2020-10-30 02:24
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    @Autowired(required = false)
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("/toPageMain")
    public String toPageMain(Model model){
        /*
        * @Description: 跳转主页
        * @Param: []
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/12/1
        */
        return adminService.toPageMain(model);
    }
    
    @RequestMapping("/toPageAdminLogin")
    public String toPageAdminLogin(@ModelAttribute("auser") Auser auser){
        /*
        * @Description: 单纯跳转到登录界面
        * @Param: [auser]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/11/26
        */

        return "admin/login";
    }

    @RequestMapping("/toUpdateInfo")
    public String toUpdateInfo(Model model,HttpSession session){
        /*
        * @Description: 跳转到信息更新页面
        * @Param: []
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/12/1
        */
        return adminService.toUpdateInfo(model,session);
    }
    @RequestMapping("/updateInfo")
    public String updateInfo(Model model,Auser auser){
        return adminService.updateInfo(model,auser);
    }
    @RequestMapping("/login")
    public String login(@ModelAttribute("auser") Auser auser,String code, Model model, HttpSession session){
        /*
        * @Description: 验证码错误直接返回登陆界面并提示错误信息
        * @Param: [auser, code, model, session]
        * @return: java.lang.String---
        * @Author: Mr.Qiu
        * @Date: 2020/11/26
        */
        if(!session.getAttribute("code").toString().equalsIgnoreCase(code)){
            model.addAttribute("codeError","验证码错误");
            return "admin/login";
        }
        return adminService.login(auser,model,session);
    }
    @RequestMapping("/exit")
    public String exit(@ModelAttribute("auser")Auser auser,HttpSession session){
        /*
        * @Description: 删除session会话 返回登陆界面
        * @Param: [auser, session]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/11/26
        */
        session.invalidate();
        return "admin/login";
    }
}