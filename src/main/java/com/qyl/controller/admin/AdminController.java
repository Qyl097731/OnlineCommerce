package com.qyl.controller.admin;

import com.qyl.instance.Auser;
import com.qyl.service.admin.AdminService;
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
 * packageName: com.qyl.controller.admin
 * date: 2020-10-30 02:24
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    @Autowired(required = false)
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("/toPageAdminLogin")
    public String toPageAdminLogin(@ModelAttribute("auser") Auser auser){
        return "admin/login";
    }

    @RequestMapping("/login")
    public String login(@ModelAttribute("auser") Auser auser, BindingResult result, Model model, HttpSession session){
        return adminService.login(auser,result,model,session);
    }
    @RequestMapping("/exit")
    public String exit(@ModelAttribute("auser")Auser auser,HttpSession session){
        session.invalidate();
        return "admin/login";
    }
}