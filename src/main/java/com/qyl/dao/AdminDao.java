package com.qyl.dao;

import com.qyl.instance.Auser;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:31
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public interface AdminDao {
    Auser selectAuserByAname(String aname);
}