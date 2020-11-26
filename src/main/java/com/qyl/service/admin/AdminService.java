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

    public String login(Auser auser, Model model, HttpSession session){
        /*
        * @Description: 验证码正确之后 我按照用户名查找用户
        *               如果用户不存在我就让他返回用户不存在 如果密码错误 就提示密码错误
        *               如果正确就到后台管理也买你
        * @Param: [auser, model, session]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/11/26
        */
        Auser auser1 = adminDao.selectAuserByAname(auser.getAname());
        if(auser1 != null && auser1.getApwd().equals(auser.getApwd())) {
            session.setAttribute("auser",auser);
            //添加商品与修改商品的页面所要的信息
            session.setAttribute("goodsType",adminTypeDao.selectGoodsType());
            return "admin/main";
        }
        if(auser1 == null){
            model.addAttribute("auser",auser);
            model.addAttribute("anameError","用户不存在");
            return "admin/login";
        }
        if(auser1.getApwd().equals(auser.getApwd()) == false){
            model.addAttribute("asuer",auser) ;
            model.addAttribute("passwordError","密码错误");
            return "admin/login";
        }
        return "admin/login";
    }

}