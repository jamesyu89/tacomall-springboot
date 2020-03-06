package cn.tacomall.tacomallspringbootapiadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
        "cn.tacomall.tacomallspringbootcommon",
        "cn.tacomall.tacomallspringbootapiadmin"
})
@MapperScan("cn.tacomall.tacomallspringbootmapper")
public class TacomallSpringbootApiAdmin {
    public static void main(String[] args) {
        SpringApplication.run(TacomallSpringbootApiAdmin.class, args);
    }

}
