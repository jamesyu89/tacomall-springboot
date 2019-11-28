package cn.tacomall.tacomallspringbootproviderweixin.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

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
