package com.qyl.service.before;

import com.qyl.dao.CartDao;
import com.qyl.dao.IndexDao;
import com.qyl.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.service.before
 * date: 2020-11-24 08:45
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@Service
public class CartService {
    private final IndexDao indexDao;
    private final CartDao cartDao;
    @Autowired
    public CartService(IndexDao indexDao, CartDao cartDao) {
        this.indexDao = indexDao;
        this.cartDao = cartDao;
    }

    public String focus(Model model, Integer id, HttpSession session){
        Map<String ,Object> map = new HashMap<>();
        map.put("uid", MyUtil.getUserID(session));
        map.put("gid",id);
        map.put("gpicture",indexDao.selectGoodsById(id).getGpicture());
        List<Map<String,Object> >list = cartDao.isFocus(map);
        if(list.size() > 0){
            model.addAttribute("msg","已关注该商品");
        }else{
            int n = cartDao.focus(map);
            if(n > 0){
                model.addAttribute("msg","成功关注该商品");
            }else{
                model.addAttribute("msg","关注失败");
            }
        }
        return "forward:/goodsDetail?id="+id;
    }

    public String putCart(Model model, Integer shoppingNum, Integer id, HttpSession session) {
        Map<String,Object> map = new HashMap<>();
        map.put("uid",MyUtil.getUserID(session));
        map.put("gid",id);
        map.put("shoppingNum",shoppingNum);
        //是否已经添加购物车
        ArrayList<Map<String,Object>> list = cartDao.isPutCart(map);
        if(list.size() > 0){
            cartDao.updateCart(map);
        }else{
            cartDao.putCart(map);
        }
        return "forward:/cart/selectCart";
    }

    public String selectCart(Model model, HttpSession session) {
        ArrayList<Map<String,Object>> list = cartDao.selectCart(MyUtil.getUserID(session));
        double sum = 0;
        for(Map<String,Object> map : list){
            sum = sum+(Double)map.get("smallSum");
        }
        model.addAttribute("total",sum);
        model.addAttribute("cartList",list);
        return "before/cart";
    }

    public String deleteAgoods(Integer id, HttpSession session) {
        Map<String,Object> map = new HashMap<>();
        map.put("uid",MyUtil.getUserID(session));
        map.put("gid",id);
        cartDao.deleteAgoods(map);
        return "forward:/cart/selectCart";
    }

    public String clear(HttpSession session) {
        cartDao.clear(MyUtil.getUserID(session));
        return "forward:/cart/selectCart";
    }


    public String orderConfirm(Model model, HttpSession session) {
        ArrayList<Map<String,Object>> list = cartDao.selectCart(MyUtil.getUserID(session));
        double sum = 0;
        for(Map<String,Object>map : list){
            sum = sum + (Double)map.get("smallSum");
        }
        model.addAttribute("total",sum);
        model.addAttribute("cartList",list);
        return "before/orderConfirm";
    }
}