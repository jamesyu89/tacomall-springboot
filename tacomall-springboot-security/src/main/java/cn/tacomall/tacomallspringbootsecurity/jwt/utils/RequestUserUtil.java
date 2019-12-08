package cn.tacomall.tacomallspringbootsecurity.jwt.utils;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class RequestUserUtil {
    public static JSONObject get() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
                .getRequest();
        return (JSONObject) JSONObject.toJSON(request.getAttribute("LOGIN_USER_KEY"));
    }
}
