package dao;

import com.qyl.dao.AdminTypeDao;
import com.qyl.instance.GoodsType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

/**
 * projectName:  e-commerce
 * packageName: com.qyl.test
 * date: 2020-11-08 14:15
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml","classpath:/spring/applicationContext-mvc.xml"})
public class AdminTypeDaoTest {
    @Autowired
    private AdminTypeDao adminTypeDao;

    @Test
    public void selectGoodsType() {
    }

    @Test
    public void addType() {
        adminTypeDao.addType("电子产品");
    }

    @Test
    public void selectGoodsByType() {
        ArrayList<GoodsType> goodsTypes = adminTypeDao.selectGoodsType();
        System.out.println(goodsTypes.toString());
    }

    @Test
    public void deleteType() {
    }
}