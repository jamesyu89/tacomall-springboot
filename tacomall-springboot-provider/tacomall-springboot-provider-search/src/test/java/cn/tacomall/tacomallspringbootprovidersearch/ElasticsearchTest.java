package cn.tacomall.tacomallspringbootprovidersearch;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import cn.tacomall.tacomallspringbootprovidersearch.pojo.goods.Goods;
import cn.tacomall.tacomallspringbootprovidersearch.service.goods.GoodsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchTest {

    @Autowired
    private GoodsService goodsService;

    @Test
    public void contextLoads() {
        System.out.println(goodsService.count());
    }

    @Test
    public void testInsert() {
        Goods goods = new Goods();
        goods.setId("1501009001");
        goods.setName("原味切片面包（10片装）");
        goods.setPrice(880);
        goods.setBrand("良品铺子");
        goodsService.save(goods);

        goods = new Goods();
        goods.setId("1501009002");
        goods.setName("原味切片面包（6片装）");
        goods.setPrice(680);
        goods.setBrand("良品铺子");
        goodsService.save(goods);

        goods = new Goods();
        goods.setId("1501009004");
        goods.setName("元气吐司850g");
        goods.setPrice(120);
        goods.setBrand("百草味");
        goodsService.save(goods);

    }

    @Test
    public void testDelete() {
        Goods goods = new Goods();
        goods.setId("1501009002");
        goodsService.delete(goods);
    }

    @Test
    public void testGetAll() {
        Iterable<Goods> iterable = goodsService.getAll();
        iterable.forEach(e->System.out.println(e.toString()));
    }

    @Test
    public void testGetByName() {
        List<Goods> list = goodsService.getByName("面包");
        System.out.println(list);
    }

    @Test
    public void testPage() {
        Page<Goods> page = goodsService.pageQuery(0, 10, "切片");
        System.out.println(page.getTotalPages());
        System.out.println(page.getNumber());
        System.out.println(page.getContent());
    }
}
