package cn.tacomall.tacomallspringbootapiopen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
        "cn.tacomall.tacomallspringbootcommon",
        "cn.tacomall.tacomallspringbootapiopen"
})
@MapperScan("cn.tacomall.tacomallspringbootmapper")
public class TacomallSpringbootApiOpen {
    public static void main(String[] args) {
        SpringApplication.run(TacomallSpringbootApiOpen.class, args);
    }
}
