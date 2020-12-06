package com.qyl.controller.before;

import com.qyl.instance.Goods;
import com.qyl.service.before.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.controller.before
 * date: 2020-11-08 19:53
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Controller
public class IndexController extends BaseBeforeController{
    private final IndexService indexService;
    @Autowired
    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }
    @RequestMapping("/before")
    public String before(Model model, HttpSession session, Goods goods){
        return indexService.before(model,session,goods);
    }
    @RequestMapping("/search")
    public String search(Model model,String mykey){
        return indexService.search(model,mykey);
    }
    @RequestMapping("/goodsDetail")
    public String goodsDetail(Model model,Integer id){
        return indexService.goodsDetail(model,id);
    }
}