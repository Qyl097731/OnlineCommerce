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
    /**
     * 查询所有公告
     * @return 公告集合
     */
    ArrayList<Notice> selectNotices();

    /**
     * 批量删除公告
     * @param list
     * @return null
     */
    Void deleteNotice(ArrayList<Integer>list);

    /**
     * 根据id删除公告
     * @param id
     */
    void deleteANotice(Integer id);

    /**
     * 添加公告
     * @param notice
     * @return Integer
     */
    Integer addNotice(Notice notice);
}
