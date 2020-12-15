package com.qyl.service.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qyl.dao.AdminDao;
import com.qyl.dao.AdminGoodsDao;
import com.qyl.dao.AdminTypeDao;
import com.qyl.instance.Auser;
import com.qyl.instance.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.service.AdminService
 * date: 2020-10-30 02:25
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@Service
public class AdminService {
    private final AdminDao adminDao;
    private final AdminGoodsDao adminGoodsDao;
    private final AdminTypeDao adminTypeDao;
    @Autowired(required = false)
    public AdminService(AdminDao adminDao, AdminGoodsDao adminGoodsDao, AdminTypeDao adminTypeDao) {
        this.adminDao = adminDao;
        this.adminGoodsDao = adminGoodsDao;
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
            PageHelper.startPage(1, 20);
            ArrayList<Goods> allGoods = adminGoodsDao.selectGoods();
            PageInfo<Goods> info = new PageInfo<>(allGoods,5);
            int[] nums = info.getNavigatepageNums();
            long total = info.getTotal();
            model.addAttribute("nums", nums);
            model.addAttribute("allGoods", allGoods);
            model.addAttribute("total", total);
            model.addAttribute("info", info);
            session.setAttribute("goodsType",adminTypeDao.selectGoodsType());
            return "admin/main";
        }
        if(auser1 == null){
            model.addAttribute("auser",auser);
            model.addAttribute("anameError","用户不存在");
            return "admin/login";
        }
        if(!auser1.getApwd().equals(auser.getApwd()) ){
            model.addAttribute("asuer",auser) ;
            model.addAttribute("passwordError","密码错误");
            return "admin/login";
        }
        return "admin/login";
    }
    public String toUpdateInfo(Model model,HttpSession session){
        /*
        * @Description: 到更新个人信息页面 显示当前个人信息
        * @Param: [model, session]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/12/15
        */
        Auser auser = (Auser)session.getAttribute("auser");
        model.addAttribute("auser",adminDao.selectAuserByAname(auser.getAname()));
        return "admin/updateInfo";
    }
    public String toPageMain(Model model) {
        /*
        * @Description: 跳转到后台页面
        * @Param: [model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/12/15
        */
        PageHelper.startPage(1, 10);
        ArrayList<Goods> allGoods = adminGoodsDao.selectGoods();
        PageInfo<Goods> info = new PageInfo<>(allGoods, 5);
        int[] nums = info.getNavigatepageNums();
        long total = info.getTotal();
        model.addAttribute("nums", nums);
        model.addAttribute("allGoods", allGoods);
        model.addAttribute("total", total);
        model.addAttribute("info", info);
        return "admin/main";
    }

    public String updateInfo(Model model, Auser auser) {
        /*
        * @Description: 更新个人信息
        * @Param: [model, auser]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/12/15
        */
        if(adminDao.updateInfo(auser) > 1){
            model.addAttribute("msg","修改成功");
        }else{
            model.addAttribute("msg","修改失败");
        }
        return "forward:/admin/toUpdateInfo";
    }
}