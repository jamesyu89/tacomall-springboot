package cn.codingtalk.tacomallapiportal.service.esgoods;

import java.util.List;

import cn.codingtalk.tacomallapiportal.entity.EsGoods;
import org.springframework.data.domain.Page;

public interface EsGoodsService {

    long count();

    EsGoods save(EsGoods goods);

    void delete(EsGoods goods);

    Iterable<EsGoods> getAll();

    List<EsGoods> getByName(String name);

    Page<EsGoods> pageQuery(int index, int size, String kw);

}
