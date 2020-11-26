package com.qyl.dao;

import com.qyl.instance.Buser;

import java.util.ArrayList;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.dao.AdminDao
 * date: 2020-10-30 02:49
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public interface UserDao {
    int register(Buser buser);
    Buser selectBuserByEmail(String email);
    ArrayList<Buser> login(Buser buser);
}
