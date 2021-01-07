package com.qyl.controller.admin;

import com.qyl.instance.Goods;
import com.qyl.instance.Notice;
import com.qyl.service.admin.AdminNoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.controller.admin
 * date: 2020-12-04 13:24
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Controller
@RequestMapping("/adminNotice")
public class AdminNoticeController extends BaseController{
    private final AdminNoticeService adminNoticeService;

    public AdminNoticeController(AdminNoticeService adminNoticeService) {
        this.adminNoticeService = adminNoticeService;
    }


    @RequestMapping("/toAddNotice")
    public String toAddNotice(Model model){
        /*
        * @Description: 前往公告添加界面
        * @Param: [model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2021/1/4
        */
        model.addAttribute("notice",new Notice());
        return "admin/addNotice";
    }
    @RequestMapping("/addNotice")
    public String addNotice(@ModelAttribute("notice") Notice notice, HttpServletRequest request){
        /*
        * @Description: 添加公告
        * @Param: [notice, request]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2021/1/4
        */
        return adminNoticeService.addNotice(notice,request);
    }


    @RequestMapping("/selectNotices")
    public String selectNotices(Model model, @RequestParam(value = "pageCur",defaultValue = "1", required = false) Integer pageCur, String act){
        /*
        * @Description: 分页查询公告
        * @Param: [model, pageCur, act]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2021/1/4
        */
        return adminNoticeService.selectNotices(model,pageCur,act);
    }
    @RequestMapping("/deleteNotice")
    public String deleteNotice(Integer[] ids, Model model){
        /*
        * @Description: 根据ids删除批量删除公告
        * @Param: [ids, model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2021/1/4
        */
        return adminNoticeService.deleteNotice(ids,model);
    }
    @RequestMapping("/deleteANotice")
    public String deleteANotice(Integer id,Model model){
        /*
        * @Description: 根据id删除公告
        * @Param: [id, model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2021/1/4
        */
        return adminNoticeService.deleteANotice(id,model);
    }

}