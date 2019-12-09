package cn.tacomall.tacomallspringbootprovidersearch.serviceimpl.goods;

import java.util.List;
import java.util.ArrayList;

import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import cn.tacomall.tacomallspringbootprovidersearch.pojo.goods.Goods;
import cn.tacomall.tacomallspringbootprovidersearch.dao.goods.GoodsRepository;
import cn.tacomall.tacomallspringbootprovidersearch.service.goods.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;


    @Override
    public long count() {
        return goodsRepository.count();
    }

    @Override
    public Goods save(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public void delete(Goods goods) {
        goodsRepository.delete(goods);
    }

    @Override
    public Iterable<Goods> getAll() {
        return goodsRepository.findAll();
    }

    @Override
    public List<Goods> getByName(String name) {
        List<Goods> list = new ArrayList<>();
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("name", name);
        Iterable<Goods> iterable = goodsRepository.search(matchQueryBuilder);
        iterable.forEach(e->list.add(e));
        return list;
    }

    @Override
    public Page<Goods> pageQuery(int index, int size, String kw) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchPhraseQuery("name", kw))
                .withPageable(PageRequest.of(index, size))
                .build();
        return goodsRepository.search(searchQuery);
    }


}
