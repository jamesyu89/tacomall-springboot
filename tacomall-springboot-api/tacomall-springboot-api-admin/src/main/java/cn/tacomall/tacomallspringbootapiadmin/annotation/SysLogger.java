package cn.tacomall.tacomallspringbootapiadmin.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLogger {
    String value() default "系统日志";
}
