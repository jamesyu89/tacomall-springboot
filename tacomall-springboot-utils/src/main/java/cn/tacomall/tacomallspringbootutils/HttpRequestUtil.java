package cn.tacomall.tacomallspringbootutils;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class HttpRequestUtil {

    private RestTemplate restTemplate;
    private String baseUrl;

    public HttpRequestUtil(RestTemplate request, String url) {
        restTemplate = request;
        baseUrl = url;
    }

    public JSONObject post(String path, Map<String, Object> params) {
        JSONObject json = new JSONObject();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/json; charset=UTF-8"));
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON_UTF8));
        HttpEntity httpEntity = new HttpEntity(params, headers);
        try {
            ResponseEntity<JSONObject> request = restTemplate.postForEntity(baseUrl + path, httpEntity, JSONObject.class);
            json = request.getBody();
        } catch (Exception ex) {
            ExceptionUtil.throwRpcException("rpc错误");
        }
        return json;
    }
}
