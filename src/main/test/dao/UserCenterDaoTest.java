package dao;

import com.qyl.dao.UserCenterDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * projectName:  e-commerce
 * packageName: dao
 * date: 2020-11-24 13:20
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml","classpath:/spring/applicationContext-mvc.xml"})
public class UserCenterDaoTest {
    @Autowired
    private UserCenterDao userCenterDao;
    @Test
    public void myOrder() {
        System.out.println(userCenterDao.myOrder(1));
    }

    @Test
    public void myFocus() {
        System.out.println(userCenterDao.myFocus(1));
    }

    @Test
    public void orderDetail() {
        System.out.println(userCenterDao.orderDetail(1));
    }
}