package cn.tacomall.tacomallspringbootmapper.user;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.tacomall.tacomallspringbootentity.user.UserWeixin;

@Repository
public interface UserWeixinMapper extends BaseMapper<UserWeixin> {

    @Select("select * from user_weixin where user_id = #{id}")
    UserWeixin selectByUserId(int id);
}
