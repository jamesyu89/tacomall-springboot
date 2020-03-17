package cn.codingtalk.tacomallmapper.goods;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.codingtalk.tacomallentity.goods.Goods;

@Repository
public interface GoodsMapper extends BaseMapper<Goods> {

    IPage<Goods> selectPage(Page page, @Param("state") Integer state);
}
