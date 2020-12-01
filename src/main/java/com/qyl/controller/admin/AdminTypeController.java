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
 * @author 邱依良
 */
@Controller
@RequestMapping("/adminType")
public class AdminTypeController{
    private final AdminTypeService adminTypeService;

    @Autowired
    public AdminTypeController(AdminTypeService adminTypeService) {
        this.adminTypeService = adminTypeService;
    }
    @RequestMapping("/toManagerType")
    public String toManageType(Model model){
        /*
        * @Description: 到添加类型界面
        * @Param: [model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/11/8
        */
        return adminTypeService.toManagerType(model);
    }

    @RequestMapping("/addType")
    public String addType(String typename, Model model, HttpSession session){
        /*
        * @Description: 增加种类
        * @Param: [typeName, model, session]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/11/26
        */
        return adminTypeService.addType(typename,model,session);
    }

    @RequestMapping("/deleteType")
    public String deleteType(Integer id,Model model){
        /*
        * @Description: 删除种类
        * @Param: [id, model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/11/26
        */
        return adminTypeService.deleteType(id,model);
    }
}