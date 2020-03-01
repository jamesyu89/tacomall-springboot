package cn.tacomall.tacomallspringbootproviderweixin.properties;

import java.util.List;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "wx.miniapp")
public class MaProperties {

    private List<Config> configs;

    @Data
    public static class Config {
        private String appid;

        private String secret;

        private String token;

        private String aesKey;

        private String msgDataFormat;
    }

}
