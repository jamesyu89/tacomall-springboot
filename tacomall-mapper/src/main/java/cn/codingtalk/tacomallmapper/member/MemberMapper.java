package cn.codingtalk.tacomallmapper.member;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.codingtalk.tacomallentity.member.Member;

@Repository
public interface MemberMapper extends BaseMapper<Member> {

    Member getMemberByOpenId(String openId);

    Member getMemberSynopsis(String id);
}
