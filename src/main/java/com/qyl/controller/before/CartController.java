package com.qyl.controller.before;

import com.qyl.service.before.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.controller.before
 * date: 2020-11-24 08:44
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Controller
@RequestMapping("/cart")
public class CartController extends BaseBeforeController{
    private final CartService cartService;
    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @RequestMapping("/focus")
    public String focus(Model model, Integer id, HttpSession session){
        /*
        * @Description: 根据用户id查询收藏的商品
        * @Param: [model, id, session]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2021/1/4
        */
        return cartService.focus(model,id,session);
    }

    @RequestMapping("/putCart")
    public String putCart(Model model,Integer shoppingNum,Integer id,HttpSession session){
        /*
        * @Description: 添加购物车
        * @Param: [model, shoppingNum, id, session]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/11/24
        */
        return cartService.putCart(model,shoppingNum,id,session);
    }
    @RequestMapping("/selectCart")
    public String selectCart(Model model,HttpSession session){
        /*
        * @Description: 查询所有购物车商品
        * @Param: [model, session]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/11/24
        */
        return cartService.selectCart(model,session);
    }
    @RequestMapping("/deleteAGoods")
    public String deleteAgoods(Integer id,HttpSession session){
        /*
        * @Description: 删除购物车
        * @Param: [id, session]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/11/24
        */
        return cartService.deleteAgoods(id,session);
    }
    @RequestMapping("/clear")
    public String clear(HttpSession session){
        /*
        * @Description: 清空购物车
        * @Param: [session]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/11/24
        */
        return cartService.clear(session);
    }

}