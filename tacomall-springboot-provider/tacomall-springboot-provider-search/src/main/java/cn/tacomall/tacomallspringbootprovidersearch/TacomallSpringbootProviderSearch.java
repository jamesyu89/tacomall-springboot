package cn.tacomall.tacomallspringbootprovidersearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages={
        "cn.tacomall.tacomallspringbootcommon",
        "cn.tacomall.tacomallspringbootprovidersearch"
}, exclude= {DataSourceAutoConfiguration.class})
public class TacomallSpringbootProviderSearch {
    public static void main(String[] args) {
        SpringApplication.run(TacomallSpringbootProviderSearch.class, args);
    }
}
