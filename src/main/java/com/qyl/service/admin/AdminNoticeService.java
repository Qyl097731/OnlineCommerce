package com.qyl.service.admin;

import com.qyl.dao.AdminNoticeDao;
import org.springframework.stereotype.Service;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.service.admin
 * date: 2020-12-04 13:25
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Service
public class AdminNoticeService {
    private final AdminNoticeDao adminNoticeDao;

    public AdminNoticeService(AdminNoticeDao adminNoticeDao) {
        this.adminNoticeDao = adminNoticeDao;
    }
}