package cn.codingtalk.tacomallcommon.utils;

import javax.servlet.http.HttpServletRequest;


import com.alibaba.fastjson.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RequestUtil extends JSONObject {

    public static JSONObject getLoginUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return (JSONObject) JSONObject.toJSON(request.getAttribute("LOGIN_USER_KEY"));
    }

    public String getStr(String key) throws Exception {
        String value = super.getString(key);
        if (StringUtil.isBlank(value)) {
            ExceptionUtil.throwClientException("参数不能为空:" + key);
        }
        return value;
    }

    public JSONObject getJson(String key) throws Exception {
        JSONObject value = super.getJSONObject(key);
        if (ObjectUtil.isNull(value)) {
            ExceptionUtil.throwClientException("参数不能为空:" + key);
        }
        return value;
    }
}
