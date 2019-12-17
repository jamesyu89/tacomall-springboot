package cn.tacomall.tacomallspringbootapiportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {
        "cn.tacomall.tacomallspringbootsecurity.jwt",
        "cn.tacomall.tacomallspringbootcommon",
        "cn.tacomall.tacomallspringbootapiportal"
})
@MapperScan("cn.tacomall.tacomallspringbootmapper")
@EnableSwagger2
public class TacomallSpringbootApiPortal {
    public static void main(String[] args) {
        SpringApplication.run(TacomallSpringbootApiPortal.class, args);
    }

}
