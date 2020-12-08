package com.qyl.dao;

import com.qyl.instance.Notice;
import org.springframework.ui.Model;

import java.util.ArrayList;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:47
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
public interface AdminNoticeDao {
    ArrayList<Notice> selectNotices();

    Void deleteNotice(ArrayList<Integer>list);

    void deleteANotice(Integer id);

    Integer addNotice(Notice notice);
}
