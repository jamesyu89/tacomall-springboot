package cn.tacomall.tacomallspringbootutils;

import com.alibaba.fastjson.JSONObject;

public class RequestUtil extends JSONObject {

    public String getStr(String key) throws Exception {
        String value = super.getString(key);
        if (StringUtil.isBlank(value)) {
            ExceptionUtil.throwClientException("参数不能为空:" + key);
        }
        return value;
    }
}
