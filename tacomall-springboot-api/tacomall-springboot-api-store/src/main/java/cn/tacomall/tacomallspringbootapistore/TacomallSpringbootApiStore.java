package cn.tacomall.tacomallspringbootapistore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages = {
        "cn.tacomall.tacomallspringbootcommon",
        "cn.tacomall.tacomallspringbootentity",
        "cn.tacomall.tacomallspringbootmapper",
        "cn.tacomall.tacomallspringbootsecurity.shiro",
        "cn.tacomall.tacomallspringbootapistore"
})
@MapperScan("cn.tacomall.tacomallspringbootmapper")
public class TacomallSpringbootApiStore {
    public static void main(String[] args) {
        SpringApplication.run(TacomallSpringbootApiStore.class, args);
    }
}
