package cn.tacomall.tacomallspringbootmapper.user;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.tacomall.tacomallspringbootentity.user.User;

@Repository
public interface UserMapper extends BaseMapper<User> {

    User getUserByOpenId(String openId);

    User getUserSynopsis(String id);
}
