package com.qyl.service.before;

import com.qyl.dao.UserCenterDao;
import com.qyl.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.service.before
 * date: 2020-11-24 13:07
 * copyright(c) 2020 南晓18卓工 邱依良
 * @author 邱依良
 */
@Service
public class UserCenterService {
    private final UserCenterDao userCenterDao;
    @Autowired
    public UserCenterService(UserCenterDao userCenterDao) {
        this.userCenterDao = userCenterDao;
    }

    public String userCenter(HttpSession session, Model model) {
        model.addAttribute("myOrder",userCenterDao.myOrder(MyUtil.getUserID(session)));
        model.addAttribute("myFocus",userCenterDao.myFocus(MyUtil.getUserID(session)));
        return "before/userCenter";
    }

    public String orderDetail(Model model, Integer orderSn) {
        model.addAttribute("myOrderDetail",userCenterDao.oderDetail(orderSn));
        return "before/userOrderDetail";
    }
}