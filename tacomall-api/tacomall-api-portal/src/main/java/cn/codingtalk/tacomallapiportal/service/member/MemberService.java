package cn.codingtalk.tacomallapiportal.service.member;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;

import cn.codingtalk.tacomallentity.member.Member;

public interface MemberService extends IService<Member> {

    String wxMaLogin(JSONObject json) throws Exception;

    Object synopsis();
}
