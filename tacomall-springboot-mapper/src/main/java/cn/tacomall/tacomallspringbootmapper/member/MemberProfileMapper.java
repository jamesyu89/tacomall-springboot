package cn.tacomall.tacomallspringbootmapper.member;


import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.tacomall.tacomallspringbootentity.member.MemberProfile;

@Repository
public interface MemberProfileMapper extends BaseMapper<MemberProfile> {

    @Select("select * from member_profile where member_id = #{id}")
    MemberProfile selectByMemberId(int id);

}
