/**
 * projectName: tacomall-sprinboot
 * fileName: TacomallSpringbootApiPortal.java
 * packageName: cn.tacomall.tacomallsprinbootapiportal
 * date: 2019年11月23日下午12:28:39
 * copyright(c) 2019-2020 芒果教育科技有限公司
 */

package cn.tacomall.tacomallspringbootapiportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.mybatis.spring.annotation.MapperScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: running-cat
 * @className: TacomallSpringbootApiPortal
 * @packageName: cn.tacomall.tacomallsprinbootapiportal
 * @description: 移动端启动类
 * @data: 2019年11月23日下午12:28:39
 **/

@SpringBootApplication(scanBasePackages={
        "cn.tacomall.tacomallspringbootcommon",
        "cn.tacomall.tacomallspringbootentity",
        "cn.tacomall.tacomallspringbootmapper",
        "cn.tacomall.tacomallspringbootapiportal"
})
@MapperScan("cn.tacomall.tacomallspringbootmapper")
@EnableSwagger2
public class TacomallSpringbootApiPortal {
    public static void main(String[] args) {
        SpringApplication.run(TacomallSpringbootApiPortal.class, args);
    }

}
