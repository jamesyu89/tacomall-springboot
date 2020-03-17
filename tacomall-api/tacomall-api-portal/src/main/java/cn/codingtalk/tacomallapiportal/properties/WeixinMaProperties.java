package cn.codingtalk.tacomallapiportal.properties;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@Component
@ConfigurationProperties(prefix = "provider.wx.ma")
public class WeixinMaProperties {

    private String url;

    private String appid;
}
