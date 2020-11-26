package dao;

import com.qyl.dao.CartDao;
import com.qyl.util.MyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * projectName:  e-commerce
 * packageName: dao
 * date: 2020-11-24 09:44
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml","classpath:/spring/applicationContext-mvc.xml"})
public class CartDaoTest {
    @Autowired
    private CartDao cartDao;
    Map<String,Object> map = new HashMap<>();

    @Test
    public void isFocus() {
    }

    @Test
    public void focus() {
    }

    @Test
    public void isPutCart() {
        map.put("uid",1);
        map.put("gid",1);
        System.out.println(cartDao.isPutCart(map));
    }

    @Test
    public void updateCart() {
        map.put("uid",1);
        map.put("gid",1);
        map.put("shoppingNum",1);
        cartDao.updateCart(map);
    }

    @Test
    public void putCart() {
        map.put("uid",1);
        map.put("gid",1);
        map.put("shoppingNum",1);
        cartDao.putCart(map);
    }

    @Test
    public void selectCart() {
        System.out.println(cartDao.selectCart(1).toString());
    }

    @Test
    public void deleteAgoods() {
        map.put("uid",1);
        map.put("gid",1);
        cartDao.deleteAgoods(map);
    }

    @Test
    public void clear() {
        cartDao.clear(1);
    }
}