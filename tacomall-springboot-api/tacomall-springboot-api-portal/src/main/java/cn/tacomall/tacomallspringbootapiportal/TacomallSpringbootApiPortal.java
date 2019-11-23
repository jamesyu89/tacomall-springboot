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

/**
 * @version: V1.0
 * @author: running-cat
 * @className: TacomallSpringbootApiPortal
 * @packageName: cn.tacomall.tacomallsprinbootapiportal
 * @description: 移动端启动类
 * @data: 2019年11月23日下午12:28:39
 **/

@SpringBootApplication(scanBasePackages="cn.tacomall")
@MapperScan("cn.tacomall.tacomallspringbootmapper")
public class TacomallSpringbootApiPortal {
    public static void main(String[] args) {
        SpringApplication.run(TacomallSpringbootApiPortal.class, args);
    }

}
