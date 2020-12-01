package dao;

import com.qyl.dao.AdminOrderDao;
import com.qyl.dao.AdminUserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * projectName:  e-commerce
 * packageName: dao
 * date: 2020-12-01 19:14
 * copyright(c) 2020 南晓18卓工 邱依良
 * author 邱依良
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml","classpath:/spring/applicationContext-mvc.xml"})
public class AdminUserDaoTest {
    @Autowired
    private AdminUserDao adminUserDao;
    @Test
    public void userInfo() {
    }

    @Test
    public void deleteOrderBaseByUId() {
        adminUserDao.deleteOrderBaseByUId(1);
    }

    @Test
    public void deleteFocusByUId() {
    }
}