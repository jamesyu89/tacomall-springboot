package cn.tacomall.tacomallspringbootprovidersearch.service.goods;

import java.util.List;

import org.springframework.data.domain.Page;

import cn.tacomall.tacomallspringbootprovidersearch.pojo.goods.Goods;

public interface GoodsService {

    long count();

    Goods save(Goods goods);

    void delete(Goods goods);

    Iterable<Goods> getAll();

    List<Goods> getByName(String name);

    Page<Goods> pageQuery(int index, int size, String kw);

}
