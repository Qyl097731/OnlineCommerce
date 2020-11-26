package com.qyl.service.admin;

import com.qyl.dao.AdminTypeDao;
import com.qyl.instance.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.service.admin
 * date: 2020-11-08 13:13
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@Service
public class AdminTypeService {
    private final AdminTypeDao adminTypeDao;
    @Autowired
    public AdminTypeService(AdminTypeDao adminTypeDao) {
        this.adminTypeDao = adminTypeDao;
    }


    public ArrayList<GoodsType> getAllTypes(){
        return adminTypeDao.selectGoodsType();
    }

    public String toAddType(Model model) {
        /*
        * @Description: 查出种类 并且回显
        * @Param: [model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/11/8
        */
        model.addAttribute("allTypes",adminTypeDao.selectGoodsType());
        return "forward:/admin/addType";
    }

    public String addType(String typeName, Model model, HttpSession session){
        adminTypeDao.addType(typeName);
        //添加商品与修改商品页面使用
        session.setAttribute("goodsType",adminTypeDao.selectGoodsType());
        return "forward:/adminType/toAddType";
    }

    public String toDeleteType(Model model) {
        model.addAttribute("allTypes",adminTypeDao.selectGoodsType());
        return "admin/deleteType";
    }

    public String deleteType(Integer id, Model model) {
        //类型有关联
        if(adminTypeDao.selectGoodsByType(id).size() > 0 ){
            model.addAttribute("msg","类型有关联，不允许删除");
        }
        if(adminTypeDao.deleteType(id) > 0){
            model.addAttribute("msg","类型成功删除");
        }
        return "forward:/adminType/toDeleteType";
    }
}