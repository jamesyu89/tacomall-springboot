package cn.tacomall.tacomallspringbootapiopen.serviceimpl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import org.springframework.stereotype.Service;

import cn.tacomall.tacomallspringbootapiopen.config.OssConfig;
import cn.tacomall.tacomallspringbootapiopen.service.OssService;

@Service
public class OssServiceImpl implements OssService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Map<String, Object> authorize(String dir) {
        Map<String, Object> map = new HashMap<>();
        try {
            OSSClient client = OssConfig.getOSSClient();

            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            long expireEndTime = System.currentTimeMillis() + OssConfig.expire * 1000;
            Date expiration = new Date(expireEndTime);
            String postPolicy = client.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);
            String postSignature = client.calculatePostSignature(postPolicy);
            map.put("accessKey", OssConfig.accessKey);
            map.put("dir", dir);
            map.put("expire", OssConfig.expire);
            map.put("host", OssConfig.host);
            map.put("policy", encodedPolicy);
            map.put("signature", postSignature);
        } catch (Exception e) {
            this.logger.info("storage authorize fail");
        }
        return map;
    }
}
