package cn.tacomall.tacomallspringbootproviderweixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages={
        "cn.tacomall.tacomallspringbootcommon",
        "cn.tacomall.tacomallspringbootproviderweixin"
}, exclude= {DataSourceAutoConfiguration.class})
public class TacomallSpringbootProviderWeixin {
    public static void main(String[] args) {
        SpringApplication.run(TacomallSpringbootProviderWeixin.class, args);
    }
}
