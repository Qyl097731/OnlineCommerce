package dao;

import com.qyl.dao.IndexDao;
import com.qyl.instance.FocusOrder;
import com.qyl.instance.Goods;
import com.qyl.instance.SaleOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * projectName:  e-commerce
 * packageName: dao
 * date: 2020-11-10 10:57
 * copyright(c) 2020 南晓18卓工 邱依良
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring/applicationContext.xml","classpath:/spring/applicationContext-mvc.xml"})
public class IndexDaoTest {
    @Autowired
    private IndexDao indexDao;
    @Test
    public void getSaleOrder() {
        ArrayList<SaleOrder>saleOrder = indexDao.getSaleOrder();
        System.out.println(saleOrder.toString());
    }

    @Test
    public void getFocusOrder() {
        ArrayList<FocusOrder>focusOrders = indexDao.getFocusOrder();
        System.out.println(focusOrders.toString());
    }

    @Test
    public void selectNotice() {
    }

    @Test
    public void getLastedGoods() {
        Goods goods = new Goods();
        goods.setGtypeId(1);
        ArrayList<Goods>goodsArrayList = indexDao.getLastedGoods(goods);
        System.out.println(goodsArrayList.toString());
    }

    @Test
    public void search() {
        ArrayList<Goods>goodsArrayList = indexDao.search("薯");
        System.out.println(goodsArrayList.toString());
    }
    @Test
    public void selectGoodsById(){
        Goods goods = indexDao.selectGoodsById(1);
        System.out.println(goods.toString());
    }
}