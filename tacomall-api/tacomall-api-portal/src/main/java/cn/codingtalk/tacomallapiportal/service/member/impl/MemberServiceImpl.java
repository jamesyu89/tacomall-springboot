package cn.codingtalk.tacomallapiportal.service.member.impl;

import java.util.Map;
import java.util.HashMap;

import cn.codingtalk.tacomallapiportal.service.member.MemberService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import cn.codingtalk.tacomallcommon.utils.RequestUtil;
import cn.codingtalk.tacomallcommon.utils.ObjectUtil;
import cn.codingtalk.tacomallcommon.utils.IntUtil;
import cn.codingtalk.tacomallentity.member.Member;
import cn.codingtalk.tacomallmapper.member.MemberMapper;
import cn.codingtalk.tacomallentity.member.MemberProfile;
import cn.codingtalk.tacomallmapper.member.MemberProfileMapper;
import cn.codingtalk.tacomallentity.member.MemberWeixin;
import cn.codingtalk.tacomallmapper.member.MemberWeixinMapper;
import cn.codingtalk.tacomallcommon.utils.ExceptionUtil;
import cn.codingtalk.tacomallcommon.utils.JwtUtil;

@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

    @Autowired
    private MemberProfileMapper memberProfileMapper;

    @Autowired
    private MemberWeixinMapper memberWeixinMapper;

    @Autowired
    TransactionDefinition transactionDefinition;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

    @Override
    public String wxMaLogin(JSONObject json) throws Exception {

        Member member = baseMapper.getMemberByOpenId(json.getString("openId"));
        if (ObjectUtil.isNull(member)) {
            TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
            try {

                member = new Member();
                member.setStatus(1);
                baseMapper.insert(member);

                MemberProfile memberProfile = new MemberProfile();
                memberProfile.setMemberId(member.getId());
                memberProfile.setNickname(json.getString("nickName"));
                memberProfile.setAvatar(json.getString("avatarUrl"));
                memberProfileMapper.insert(memberProfile);

                MemberWeixin memberWeixin = new MemberWeixin();
                memberWeixin.setMemberId(member.getId());
                memberWeixin.setOpenId(json.getString("openId"));
                memberWeixin.setNickname(json.getString("nickName"));
                memberWeixin.setGender(json.getString("gender"));
                memberWeixin.setAvatarUrl(json.getString("avatarUrl"));
                memberWeixinMapper.insert(memberWeixin);

                dataSourceTransactionManager.commit(transactionStatus);
            } catch (Exception e) {
                dataSourceTransactionManager.rollback(transactionStatus);
                ExceptionUtil.throwSqlException("sql错误");
            }
        }

        String token = "";
        try {
            Map<String, String> claims = new HashMap<>(1);
            claims.put("id", IntUtil.toString(member.getId()));
            token = JwtUtil.create(claims);
        } catch (Exception e) {
            ExceptionUtil.throwBizException("token生成失败");
        }
        return token;
    }

    @Override
    public Object synopsis() {
        return baseMapper.getMemberSynopsis(RequestUtil.getLoginUser().getString("id"));
    }

}
