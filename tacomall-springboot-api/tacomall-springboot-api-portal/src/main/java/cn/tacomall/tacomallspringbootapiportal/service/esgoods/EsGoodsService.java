package cn.tacomall.tacomallspringbootapiportal.service.esgoods;

import java.util.List;

import org.springframework.data.domain.Page;

import cn.tacomall.tacomallspringbootapiportal.entity.EsGoods;

public interface EsGoodsService {

    long count();

    EsGoods save(EsGoods goods);

    void delete(EsGoods goods);

    Iterable<EsGoods> getAll();

    List<EsGoods> getByName(String name);

    Page<EsGoods> pageQuery(int index, int size, String kw);

}
