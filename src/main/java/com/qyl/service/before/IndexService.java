package com.qyl.service.before;

import com.qyl.dao.AdminTypeDao;
import com.qyl.dao.IndexDao;
import com.qyl.instance.Buser;
import com.qyl.instance.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.service.before
 * date: 2020-11-08 19:54
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@Service
public class IndexService {
    private final AdminTypeDao adminTypeDao;
    private final IndexDao indexDao;
    @Autowired
    public IndexService(AdminTypeDao adminTypeDao, IndexDao indexDao) {
        this.adminTypeDao = adminTypeDao;
        this.indexDao = indexDao;
    }

    public String before(Model model, HttpSession session, Goods goods) {
        session.setAttribute("goodsType",adminTypeDao.selectGoodsType());
        model.addAttribute("salelist",indexDao.getSaleOrder());
        model.addAttribute("focuslist",indexDao.getFocusOrder());
        model.addAttribute("noticelist",indexDao.selectNotice());
        if(goods.getId() == null){
            goods.setId(0);
        }
        model.addAttribute("lastedlist",indexDao.getLastedGoods(goods));
        return "before/index";
    }
    public String search(Model model,String mykey){
        ArrayList<Goods>list = indexDao.search(mykey);
        model.addAttribute("searchlist",list);
        return "before/searchResult";
    }

    public String toRegister(Model model) {
        model.addAttribute("buser",new Buser());
        return "before/register";
    }

    public String goodsDetail(Model model, Integer id) {
        Goods goods = indexDao.selectGoodsById(id);
        model.addAttribute("goods",goods);
        return "before/goodsDetail";
    }
}