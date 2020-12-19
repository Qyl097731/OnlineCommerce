package com.qyl.dao;

import com.qyl.instance.Auser;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:31
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
public interface AdminDao {
    /**
     * 根据用户名查询用户
     * @param aname
     * @return Auser
     */
    Auser selectAuserByAname(String aname);

    /**
     * 更新用户信息 返回是否成功
     * @param auser
     * @return Integer
     */
    Integer updateInfo(Auser auser);
}