package cn.tacomall.tacomallspringbootprovidersearch.dao.goods;

import org.springframework.stereotype.Repository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import cn.tacomall.tacomallspringbootprovidersearch.pojo.goods.Goods;

@Repository
public interface GoodsRepository extends ElasticsearchRepository<Goods, String> {

}
