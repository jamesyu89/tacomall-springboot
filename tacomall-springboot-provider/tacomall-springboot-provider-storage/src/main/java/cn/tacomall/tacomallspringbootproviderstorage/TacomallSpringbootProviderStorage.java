package cn.tacomall.tacomallspringbootproviderstorage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
        "cn.tacomall.tacomallspringbootcommon",
        "cn.tacomall.tacomallspringbootproviderstorage"
})

@MapperScan("cn.tacomall.tacomallspringbootmapper")
public class TacomallSpringbootProviderStorage {
    public static void main(String[] args) {
        SpringApplication.run(TacomallSpringbootProviderStorage.class, args);
    }
}
