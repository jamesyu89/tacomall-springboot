package cn.tacomall.tacomallspringbootapiportal.serviceimpl.user;

import java.util.Map;
import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import cn.tacomall.tacomallspringbootsecurity.jwt.utils.RequestUserUtil;
import cn.tacomall.tacomallspringbootutils.ExceptionUtil;
import cn.tacomall.tacomallspringbootutils.ObjectUtil;
import cn.tacomall.tacomallspringbootutils.JwtUtil;
import cn.tacomall.tacomallspringbootutils.IntUtil;
import cn.tacomall.tacomallspringbootentity.user.User;
import cn.tacomall.tacomallspringbootmapper.user.UserMapper;
import cn.tacomall.tacomallspringbootentity.user.UserProfile;
import cn.tacomall.tacomallspringbootmapper.user.UserProfileMapper;
import cn.tacomall.tacomallspringbootentity.user.UserWeixin;
import cn.tacomall.tacomallspringbootmapper.user.UserWeixinMapper;
import cn.tacomall.tacomallspringbootapiportal.service.user.UserService;
import cn.tacomall.tacomallspringbootapiportal.provider.WeixinMaProvider;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    WeixinMaProvider weixinMaProvider;

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Autowired
    private UserWeixinMapper userWeixinMapper;

    @Autowired
    TransactionDefinition transactionDefinition;

    @Autowired
    DataSourceTransactionManager dataSourceTransactionManager;

    @Override
    public String miniAppLogin(String iv, String code, String encryptedData) throws Exception {
        JSONObject json = weixinMaProvider.login(iv, code, encryptedData).getJSONObject("data");

        User user = baseMapper.getUserByOpenId(json.getString("openId"));
        if (ObjectUtil.isNull(user)) {
            TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
            try {

                user = new User();
                user.setStatus(1);
                baseMapper.insert(user);

                UserProfile userProfile = new UserProfile();
                userProfile.setUserId(user.getId());
                userProfile.setNickname(json.getString("nickName"));
                userProfile.setAvatar(json.getString("avatarUrl"));
                userProfileMapper.insert(userProfile);

                UserWeixin userWeixin = new UserWeixin();
                userWeixin.setUserId(user.getId());
                userWeixin.setOpenId(json.getString("openId"));
                userWeixin.setNickname(json.getString("nickName"));
                userWeixin.setGender(json.getString("gender"));
                userWeixin.setAvatarUrl(json.getString("avatarUrl"));
                userWeixinMapper.insert(userWeixin);

                dataSourceTransactionManager.commit(transactionStatus);
            } catch (Exception e) {
                dataSourceTransactionManager.rollback(transactionStatus);
                ExceptionUtil.throwSqlException("sql错误");
            }
        }

        String token = "";
        try {
            Map<String, String> claims = new HashMap<>(1);
            claims.put("id", IntUtil.toString(user.getId()));
            token = JwtUtil.create(claims);
        } catch (Exception e) {
            ExceptionUtil.throwBizException("token生成失败");
        }
        return token;
    }

    @Override
    public Object synopsis() {
        return baseMapper.getUserSynopsis(RequestUserUtil.get().getString("id"));
    }

}
