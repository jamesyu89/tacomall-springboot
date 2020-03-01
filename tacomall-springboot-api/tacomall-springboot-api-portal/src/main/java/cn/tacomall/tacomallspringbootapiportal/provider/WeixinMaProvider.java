package cn.tacomall.tacomallspringbootapiportal.provider;

import java.util.Map;
import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import cn.tacomall.tacomallspringbootcommon.utils.HttpRequestUtil;
import cn.tacomall.tacomallspringbootapiportal.properties.WeixinMaProperties;

@Component
public class WeixinMaProvider {

    @Autowired
    WeixinMaProperties weixinMaProperties;

    @Autowired
    RestTemplate restTemplate;

    public HttpRequestUtil httpRequestUtil() {
        return new HttpRequestUtil(restTemplate, weixinMaProperties.getUrl());
    }

    public JSONObject login(String iv, String code, String encryptedData) {
        Map<String, Object> params = new HashMap<>();
        params.put("appid", weixinMaProperties.getAppid());
        params.put("iv", iv);
        params.put("code", code);
        params.put("encryptedData", encryptedData);
        return httpRequestUtil().post("weixin/ma/login", params);
    }
}
