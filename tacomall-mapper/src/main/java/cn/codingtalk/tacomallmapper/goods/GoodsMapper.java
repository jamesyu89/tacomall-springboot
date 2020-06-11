/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-06-11 21:30:57
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-mapper\src\main\java\cn\codingtalk\tacomallmapper\goods\GoodsMapper.java
 * @Just do what I think it is right
 */
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
