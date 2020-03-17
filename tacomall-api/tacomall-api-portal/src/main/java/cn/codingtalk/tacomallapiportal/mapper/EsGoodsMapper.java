package cn.codingtalk.tacomallapiportal.mapper;

import cn.codingtalk.tacomallapiportal.entity.EsGoods;
import org.springframework.stereotype.Repository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

@Repository
public interface EsGoodsMapper extends ElasticsearchRepository<EsGoods, String> {

}
