package com.qyl.service.admin;

import com.qyl.dao.AdminDao;
import com.qyl.dao.AdminTypeDao;
import com.qyl.instance.Auser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.service.AdminService
 * date: 2020-10-30 02:25
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@Service
public class AdminService {
    private final AdminDao adminDao;
    private final AdminTypeDao adminTypeDao;
    @Autowired(required = false)
    public AdminService(AdminDao adminDao, AdminTypeDao adminTypeDao) {
        this.adminDao = adminDao;
        this.adminTypeDao = adminTypeDao;
    }

    public String login(@Valid  Auser auser, BindingResult result, Model model, HttpSession session){
        if(result.hasErrors()){
            return "admin/login";
        }
        Auser auser1 = adminDao.selectAuserByAname(auser.getAname());
        if(auser1 != null && auser1.getApwd().equals(auser.getApwd())) {
            session.setAttribute("auser",auser);
            //添加商品与修改商品的页面所要的信息
            session.setAttribute("goodsType",adminTypeDao.selectGoodsType());
            return "admin/main";
        }
        model.addAttribute("msg","账号或密码错误");
        return "admin/login";
    }

}