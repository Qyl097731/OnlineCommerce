package com.qyl.controller.admin;

import com.qyl.service.admin.AdminTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.controller.admin
 * date: 2020-11-08 13:14
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@Controller
@RequestMapping("/adminType")
public class AdminTypeController extends BaseController{
    private final AdminTypeService adminTypeService;

    @Autowired
    public AdminTypeController(AdminTypeService adminTypeService) {
        this.adminTypeService = adminTypeService;
    }
    @RequestMapping("/toAddType")
    public String toAddType(Model model){
        /*
        * @Description: 到添加类型界面
        * @Param: [model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/11/8
        */
        return adminTypeService.toAddType(model);
    }

    @RequestMapping("/addType")
    public String addType(String typeName, Model model, HttpSession session){
        return adminTypeService.addType(typeName,model,session);
    }

    @RequestMapping("/toDeleteType")
    public String toDeleteType(Model model){
        /*
        * @Description: 到删除类型界面
        * @Param: [model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/11/8
        */
        return adminTypeService.toDeleteType(model);
    }

    @RequestMapping("/deleteType")
    public String deleteType(Integer id,Model model){
        return adminTypeService.deleteType(id,model);
    }
}