package com.qyl.controller.admin;

import com.qyl.instance.Goods;
import com.qyl.service.admin.AdminGoodsService;
import com.qyl.service.admin.AdminTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.controller.admin
 * date: 2020-11-08 14:21
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@Controller
@RequestMapping("/adminGoods")
public class AdminGoodsController extends BaseController{
    private final AdminGoodsService adminGoodsService;
    private final AdminTypeService adminTypeService;
    @Autowired
    public AdminGoodsController(AdminGoodsService adminGoodsService, AdminTypeService adminTypeService) {
        this.adminGoodsService = adminGoodsService;
        this.adminTypeService = adminTypeService;
    }

    @RequestMapping("/toAddGoods")
    public String toAddGoods(Model model){
        model.addAttribute("goodsType",adminTypeService.getAllTypes());
        model.addAttribute("goods",new Goods());
        return "admin/addGoods";
    }

    @RequestMapping("/addGoods")
    public String addGoods(@ModelAttribute("goods")Goods goods, HttpServletRequest request,String updateAct){
        return adminGoodsService.addOrUpdateGoods(goods,request,updateAct);
    }


    @RequestMapping("/selectGoods")
    public String selectGoods(Model model,Integer pageCur,String act){
        return adminGoodsService.selectGoods(model,pageCur,act);
    }

    @RequestMapping("/selectAGoods")
    public String selectAGoods(Model model,Integer id,String act){
        return adminGoodsService.selectAGoods(model,id,act);
    }
    @RequestMapping("/deleteGoods")
    public String deleteGoods(Integer ids[],Model model){
        return adminGoodsService.deleteGoods(ids,model);
    }
    @RequestMapping("/deleteAGoods")
    public String deleteAGoods(Integer id,Model model){
        return adminGoodsService.deleteAGoods(id,model);
    }

}