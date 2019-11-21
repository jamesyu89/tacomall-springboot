package cn.tacomall.tacomallspringbootapiportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(scanBasePackages="cn.tacomall")
@MapperScan("cn.tacomall.tacomallspringbootmapper")
public class TacomallSpringbootApiPortal {
    public static void main(String[] args) {
        SpringApplication.run(TacomallSpringbootApiPortal.class, args);
    }

}
