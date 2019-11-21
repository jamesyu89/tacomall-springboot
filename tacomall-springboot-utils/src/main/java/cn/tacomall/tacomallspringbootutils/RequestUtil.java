package cn.tacomall.tacomallspringbootutils;

import com.alibaba.fastjson.JSONObject;

import cn.tacomall.tacomallspringbootutils.StringUtil;
import cn.tacomall.tacomallspringbootutils.ExceptionUtil;

public class RequestUtil extends JSONObject {
    public String getStr(String key) throws Exception {
        String value = super.getString(key);
        if (StringUtil.isBlank(value)) {
            ExceptionUtil.throwClientException("参数不能为空:" + key);
        }
        return value;
    }
}
