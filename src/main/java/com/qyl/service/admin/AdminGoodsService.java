package com.qyl.service.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qyl.dao.AdminGoodsDao;
import com.qyl.instance.Goods;
import com.qyl.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.service.admin
 * date: 2020-11-08 14:25
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Service
public class AdminGoodsService {
    private final AdminGoodsDao adminGoodsDao;
    private final String update = "update";
    private final String deleteSelect = "deleteSelect";
    private final String updateSelect = "updateSelect";
    private final String updateAGoods = "updateAGoods";

    @Autowired
    public AdminGoodsService(AdminGoodsDao adminGoodsDao) {
        this.adminGoodsDao = adminGoodsDao;
    }


    public String addOrUpdateGoods(Goods goods, HttpServletRequest request, String updateAct) {
        String newFileName = "";
        String fileName = goods.getLogoImage().getOriginalFilename();
        if (fileName.length() > 0) {
            String realPath = request.getServletContext().getRealPath("logos");
            //实现文件上传
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            //防止文件名崇明
            newFileName = MyUtil.getStringID() + fileType;
            goods.setGpicture(newFileName);
            File targetFile = new File(realPath, newFileName);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            try {
                goods.getLogoImage().transferTo(targetFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (update.equals(updateAct)) {
            //修改数据库
            if (adminGoodsDao.updateGoodsById(goods) > 0) {
                return "forward:/adminGoods/selectGoods?act=updateSelect";
            } else {
                return "admin/updateAgoods";
            }
        } else {
            //保存到数据库
            if (adminGoodsDao.addGoods(goods) > 0) {
                //转发到查询的controller
                return "forward:/adminGoods/selectGoods";
            } else {
                return "card/addCard";
            }
        }
    }

    public String selectGoods(Model model, Integer pageCur, String act) {
        PageHelper.startPage(pageCur, 20);
        ArrayList<Goods> allGoods = adminGoodsDao.selectGoods();
        PageInfo<Goods> info = new PageInfo<>(allGoods, 5);
        int[] nums = info.getNavigatepageNums();
        long total = info.getTotal();
        model.addAttribute("nums", nums);
        model.addAttribute("allGoods", allGoods);
        model.addAttribute("total", total);
        model.addAttribute("info", info);
        if (deleteSelect.equals(act)) {
            return "admin/deleteSelectGoods";
        } else if (updateSelect.equals(act)) {
            return "admin/updateSelectGoods";
        } else {
            return "admin/selectGoods";
        }
    }

    public String selectAGoods(Model model, Integer id, String act) {
        Goods goods = adminGoodsDao.selectGoodsById(id);
        model.addAttribute("goods", goods);
        //修改界面
        if (updateAGoods.equals(act)) {
            return "admin/updateAgoods";
        }
        //详情界面
        return "admin/goodsDetail";
    }

    public String deleteGoods(Integer[] ids, Model model) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            if (adminGoodsDao.selectCartGoods(ids[i]).size() > 0 ||
                adminGoodsDao.selectFocusGoods(ids[i]).size() > 0 ||
                adminGoodsDao.selectOrderDetailGoods(ids[i]).size() > 0){
                model.addAttribute("msg","商品有关联，不允许删除！");
                return "forward:/adminGoods/selectGoods?act=deleteSelect";
            }
            list.add(ids[i]);
        }
        adminGoodsDao.deleteGoods(list);
        model.addAttribute("msg","成功删除商品");
        return "forward:/adminGoods/selectGoods?act=deleteSelect";
    }

    public String deleteAGoods(Integer id, Model model) {
        if (adminGoodsDao.selectCartGoods(id).size() > 0 ||
                adminGoodsDao.selectFocusGoods(id).size() > 0 ||
                adminGoodsDao.selectOrderDetailGoods(id).size() > 0){
            model.addAttribute("msg","商品有关联，不允许删除！");
            return "forward:/adminGoods/selectGoods?act=deleteSelect";
        }
        adminGoodsDao.deleteAGoods(id);
        return "forward:/adminGoods/selectGoods?act=deleteSelect";
    }
}