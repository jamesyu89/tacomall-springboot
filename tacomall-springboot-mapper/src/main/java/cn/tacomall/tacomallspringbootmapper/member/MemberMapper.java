package cn.tacomall.tacomallspringbootmapper.member;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.tacomall.tacomallspringbootentity.member.Member;

@Repository
public interface MemberMapper extends BaseMapper<Member> {

    Member getMemberByOpenId(String openId);

    Member getMemberSynopsis(String id);
}
