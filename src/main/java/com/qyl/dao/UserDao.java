package com.qyl.dao;

import com.qyl.instance.Buser;

import java.util.ArrayList;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:49
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
public interface UserDao {
    /**
     * 注册用户
     * @param buser
     * @return int
     */
    int register(Buser buser);

    /**
     * 根据Email查询用户
     * @param email
     * @return Buser
     */
    Buser selectBuserByEmail(String email);

    /**
     * 登录 根据登录信息查询用户
     * @param buser
     * @return Buser
     */
    ArrayList<Buser> login(Buser buser);
}
