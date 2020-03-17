package cn.codingtalk.tacomallapiportal.service.esgoods.impl;

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

import cn.codingtalk.tacomallapiportal.entity.EsGoods;
import cn.codingtalk.tacomallapiportal.mapper.EsGoodsMapper;
import cn.codingtalk.tacomallapiportal.service.esgoods.EsGoodsService;

@Service
public class EsGoodsServiceImpl implements EsGoodsService {

    @Autowired
    private EsGoodsMapper esGoodsMapper;


    @Override
    public long count() {
        return esGoodsMapper.count();
    }

    @Override
    public EsGoods save(EsGoods goods) {
        return esGoodsMapper.save(goods);
    }

    @Override
    public void delete(EsGoods goods) {
        esGoodsMapper.delete(goods);
    }

    @Override
    public Iterable<EsGoods> getAll() {
        return esGoodsMapper.findAll();
    }

    @Override
    public List<EsGoods> getByName(String name) {
        List<EsGoods> list = new ArrayList<>();
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("name", name);
        Iterable<EsGoods> iterable = esGoodsMapper.search(matchQueryBuilder);
        iterable.forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Page<EsGoods> pageQuery(int index, int size, String kw) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchPhraseQuery("name", kw))
                .withPageable(PageRequest.of(index, size))
                .build();
        return esGoodsMapper.search(searchQuery);
    }


}

