package com.qyl.service.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qyl.dao.AdminUserDao;
import com.qyl.instance.Buser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Map;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.service.admin
 * date: 2020-11-08 18:34
 * copyright(c) 2020 南晓18卓工 邱依良
 *
 * @author 邱依良
 */
@Service
public class AdminUserService {
    private final AdminUserDao adminUserDao;

    @Autowired
    public AdminUserService(AdminUserDao adminUserDao) {
        this.adminUserDao = adminUserDao;
    }

    public String deleteuserManager(Integer id, Model model) {
        /*
        * @Description: 删除用户
        * @Param: [id, model]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/12/15
        */
        adminUserDao.deleteOrderBaseByUId(id);
        adminUserDao.deleteFocusByUId(id);
        adminUserDao.deleteOrderDetailByUId(id);
        adminUserDao.deleteUserByUId(id);
        model.addAttribute("msg", "删除成功");
        return "forward:/adminUser/userInfo";
    }

    public String userInfo(Model model, @RequestParam(value = "pageCur", defaultValue = "1") Integer pageCur) {
        /*
        * @Description: 查找所有用户信息
        * @Param: [model, pageCur]
        * @return: java.lang.String
        * @Author: Mr.Qiu
        * @Date: 2020/12/15
        */
        PageHelper.startPage(pageCur, 20);
        ArrayList<Buser> userList = adminUserDao.userInfo();
        PageInfo<Buser> info = new PageInfo<>(userList, 5);
        int[] nums = info.getNavigatepageNums();
        long total = info.getTotal();
        model.addAttribute("nums", nums);
        model.addAttribute("userList", userList);
        model.addAttribute("total", total);
        model.addAttribute("info", info);
        return "admin/managerUser";
    }
}