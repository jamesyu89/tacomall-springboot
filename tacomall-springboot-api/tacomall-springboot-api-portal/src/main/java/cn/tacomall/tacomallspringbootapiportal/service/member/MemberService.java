package cn.tacomall.tacomallspringbootapiportal.service.member;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import cn.tacomall.tacomallspringbootentity.member.Member;

public interface MemberService extends IService<Member> {

    String miniAppLogin(JSONObject json) throws Exception;

    Object synopsis();
}
