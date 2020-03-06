package cn.tacomall.tacomallspringbootmapper.member;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.tacomall.tacomallspringbootentity.member.MemberWeixin;

@Repository
public interface MemberWeixinMapper extends BaseMapper<MemberWeixin> {

    @Select("select * from member_weixin where member_id = #{id}")
    MemberWeixin selectByMemberId(int id);
}
