package com.qyl.util;

import com.qyl.instance.Buser;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.util
 * date: 2020-11-08 14:33
 * copyright(c) 2020 南晓18卓工 邱依良
 */
public class MyUtil {
    public static String getStringID(){
        String id = null;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        id = sdf.format(date);
        return id;
    }
    public static Integer getUserID(HttpSession session){
        Buser ruser = (Buser)session.getAttribute("buser");
        return ruser.getId();
    }
}