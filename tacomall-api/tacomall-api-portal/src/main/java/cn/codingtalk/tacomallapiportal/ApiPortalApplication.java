package cn.codingtalk.tacomallapiportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {
        "cn.codingtalk.tacomallcommon",
        "cn.codingtalk.tacomallapiportal"
})
@MapperScan("cn.codingtalk.tacomallmapper")
@EnableSwagger2
public class ApiPortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiPortalApplication.class, args);
    }

}
