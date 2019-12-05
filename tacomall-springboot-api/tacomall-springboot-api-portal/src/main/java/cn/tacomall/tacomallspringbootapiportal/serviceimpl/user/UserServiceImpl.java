/**
 * projectName: tacomall-sprinboot
 * fileName: Index.java
 * packageName: cn.tacomall.tacomallsprinbootapiportal.serviceimpl.user
 * date: 2019年11月23日下午12:28:39
 * <p>
 * 修改履历:
 * 日期                          修正者           主要内容
 * 2019年11月23日下午12:28:39    running-cat      初版完成
 * <p>
 * copyright(c) 2019-2020 芒果教育科技有限公司
 */

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

import cn.tacomall.tacomallspringbootutils.ExceptionUtil;
import cn.tacomall.tacomallspringbootutils.ObjectUtil;
import cn.tacomall.tacomallspringbootutils.ConstantUtil;
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

/**
 * @author: running-cat
 * @className: UserServiceImpl
 * @packageName: cn.tacomall.tacomallsprinbootapiportal.controller
 * @description: 移动端用户业务实现类
 * @data: 2019年11月23日下午12:28:39
 **/

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

    /**
     * @author: running-cat
     * @methodsName: miniAppLogin
     * @description: 微信用户登录
     * @param: iv code encryptedData
     * @return: Map<String, Object>
     * @throws:
     */

    @Override
    public Map<String, Object> miniAppLogin(String iv, String code, String encryptedData) throws Exception {
        JSONObject json = weixinMaProvider.login(iv, code, encryptedData).getJSONObject("data");

        User user = baseMapper.getUserByOpenId(json.getString("openId"));
        if (ObjectUtil.isNull(user)) {
            TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
            try {

                /**
                 * 用户主表数据插入
                 */

                user = new User();
                user.setStatus(1);
                baseMapper.insert(user);

                /**
                 * 用户资料表数据插入
                 */
                UserProfile userProfile = new UserProfile();
                userProfile.setUserId(user.getId());
                userProfile.setNickname(json.getString("nickName"));
                userProfile.setAvatar(json.getString("avatarUrl"));
                userProfileMapper.insert(userProfile);

                /**
                 * 用户微信表数据插入
                 */
                UserWeixin userWeixin = new UserWeixin();
                userWeixin.setUserId(user.getId());
                userWeixin.setOpenId(json.getString("openId"));
                userWeixin.setNickname(json.getString("nickName"));
                userWeixin.setGender(json.getString("gender"));
                userWeixin.setAvatarUrl(json.getString("avatarUrl"));
                userWeixinMapper.insert(userWeixin);

                /**
                 * 提交事务
                 */
                dataSourceTransactionManager.commit(transactionStatus);
            } catch (Exception e) {
                /**
                 * 事务回滚
                 * 抛出sql异常类
                 */
                dataSourceTransactionManager.rollback(transactionStatus);
                ExceptionUtil.throwSqlException("sql错误");
            }
        }

        Map<String, Object> map = new HashMap<>(2);
        try {
            Map<String, String> claims = new HashMap<>(1);
            claims.put("id", IntUtil.toString(user.getId()));
            map.put("token", JwtUtil.create(claims));
        } catch (Exception e) {
            ExceptionUtil.throwBizException("token生成失败");
        }
        return map;
    }

    /**
     * @author: running-cat
     * @methodsName: synopsis
     * @description: 用户信息
     * @param:
     * @return: Map<String, Object>
     * @throws:
     */

    @Override
    public Map<String, Object> synopsis() {
        return ConstantUtil.EMPTY_MAP;
    }

}
