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
        /*
        * @Description: 跳转到主页 并且显示热搜 公告 感兴趣的商品集合
        * @Param: [model, session, goods]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/12/15
        */
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
        /*
        * @Description: 模糊查询商品
        * @Param: [model, mykey]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/12/15
        */
        ArrayList<Goods>list = indexDao.search(mykey);
        model.addAttribute("searchlist",list);
        return "before/searchResult";
    }

    public String selectGoodsByTypeId(Integer id,Model model) {
        /*
         * @Description: 按照种类查找商品
         * @Param: [id]
         * @return: java.lang.String
         * @Author: Mr.Qiu
         * @Date: 2020/12/15
         */
        ArrayList<Goods>list = indexDao.selectGoodsByTypeId(id);
        model.addAttribute("searchlist",list);
        return "before/searchResult";
    }
    public String toRegister(Model model) {
        /*
        * @Description: 去注册
        * @Param: [model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/12/15
        */
        model.addAttribute("buser",new Buser());
        return "before/register";
    }

    public String goodsDetail(Model model, Integer id) {
        /*
        * @Description: 商品详情
        * @Param: [model, id]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/12/15
        */
        Goods goods = indexDao.selectGoodsById(id);
        Integer focusNum = indexDao.getFocusNum(id);
        Integer saleNum = indexDao.getSaleNum(id);
        model.addAttribute("goods",goods);
        model.addAttribute("focusNum",focusNum);
        model.addAttribute("saleNum",saleNum);
        return "before/goodsDetail";
    }

    public String toLogin(Model model) {
        /*
        * @Description: 去登录
        * @Param: [model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/12/15
        */
        model.addAttribute("buser",new Buser());
        return "before/login";
    }
}