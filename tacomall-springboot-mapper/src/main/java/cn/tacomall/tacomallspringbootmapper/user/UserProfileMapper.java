package cn.tacomall.tacomallspringbootmapper.user;


import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.tacomall.tacomallspringbootentity.user.UserProfile;

@Repository
public interface UserProfileMapper extends BaseMapper<UserProfile> {

    @Select("select * from user_profile where user_id = #{id}")
    UserProfile selectByUserId(int id);

}
