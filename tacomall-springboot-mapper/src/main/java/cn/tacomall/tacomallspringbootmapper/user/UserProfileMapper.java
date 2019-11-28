package cn.tacomall.tacomallspringbootmapper.user;


import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.tacomall.tacomallspringbootentity.user.UserProfile;

@Repository
public interface UserProfileMapper extends BaseMapper<UserProfile> {
}
