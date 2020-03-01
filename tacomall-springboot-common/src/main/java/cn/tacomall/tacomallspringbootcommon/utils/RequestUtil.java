package cn.tacomall.tacomallspringbootcommon.utils;

import com.alibaba.fastjson.JSONObject;

import cn.tacomall.tacomallspringbootutils.StringUtil;

public class RequestUtil extends JSONObject {

    public String getStr(String key) throws Exception {
        String value = super.getString(key);
        if (StringUtil.isBlank(value)) {
            ExceptionUtil.throwClientException("参数不能为空:" + key);
        }
        return value;
    }
}
