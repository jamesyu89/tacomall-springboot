package cn.codingtalk.tacomallapiadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
        "cn.codingtalk.tacomallcommon",
        "cn.codingtalk.tacomallapiadmin"
})
@MapperScan("cn.codingtalk.tacomallmapper")
public class ApiAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiAdminApplication.class, args);
    }

}
