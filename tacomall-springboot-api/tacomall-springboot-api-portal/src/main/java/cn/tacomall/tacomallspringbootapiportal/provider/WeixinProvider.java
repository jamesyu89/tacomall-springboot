package cn.tacomall.tacomallspringbootapiportal.provider;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class WeixinProvider {

    @Autowired
    private RestTemplate restTemplate;

    public String login() {
        String result = restTemplate.getForObject("", String.class);
        return result;
    }
}
