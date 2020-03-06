package cn.tacomall.tacomallspringbootapiportal.mapper;

import org.springframework.stereotype.Repository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import cn.tacomall.tacomallspringbootapiportal.entity.EsGoods;

@Repository
public interface EsGoodsMapper extends ElasticsearchRepository<EsGoods, String> {

}
