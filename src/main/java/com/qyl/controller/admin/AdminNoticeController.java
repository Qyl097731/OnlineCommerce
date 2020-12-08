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
public class AdminNoticeController {
    private final AdminNoticeService adminNoticeService;

    public AdminNoticeController(AdminNoticeService adminNoticeService) {
        this.adminNoticeService = adminNoticeService;
    }


    @RequestMapping("/toAddNotice")
    public String toAddNotice(Model model){
        model.addAttribute("notice",new Notice());
        return "admin/addNotice";
    }
    @RequestMapping("/addNotice")
    public String addNotice(@ModelAttribute("notice") Notice notice, HttpServletRequest request){

        return adminNoticeService.addNotice(notice,request);
    }


    @RequestMapping("/selectNotices")
    public String selectNotices(Model model, @RequestParam(value = "pageCur",defaultValue = "1", required = false) Integer pageCur, String act){
        return adminNoticeService.selectNotices(model,pageCur,act);
    }
    @RequestMapping("/deleteNotice")
    public String deleteNotice(Integer[] ids, Model model){
        return adminNoticeService.deleteNotice(ids,model);
    }
    @RequestMapping("/deleteANotice")
    public String deleteANotice(Integer id,Model model){
        return adminNoticeService.deleteANotice(id,model);
    }

}