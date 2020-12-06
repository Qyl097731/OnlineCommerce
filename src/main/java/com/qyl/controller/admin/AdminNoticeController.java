package com.qyl.controller.admin;

import com.qyl.instance.Notice;
import com.qyl.service.admin.AdminNoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/selectNotices")
    public String selectNotices(Model model){
        return null;
    }
    @RequestMapping("/toAddNotice")
    public String toAddNotice(Model model){
        return null;
    }
}