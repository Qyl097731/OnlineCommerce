package dao;

import com.qyl.dao.AdminGoodsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.test
 * date: 2020-11-08 15:23
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml","classpath:/spring/applicationContext-mvc.xml"})
public class AdminGoodsDaoTest {
    @Autowired
    private AdminGoodsDao adminGoodsDao;
    @Test
    public void updateGoodsById() {
    }

    @Test
    public void addGoods() {
    }

    @Test
    public void selectGoods() {
        System.out.println(adminGoodsDao.selectGoods().toString());
    }

    @Test
    public void selectGoodsById() {
    }
}