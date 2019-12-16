package cn.tacomall.tacomallspringbootcommon.aspect;

import java.util.Date;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.tacomall.tacomallspringbootcommon.annotation.SysLogger;
import cn.tacomall.tacomallspringbootutils.JsonUtil;
import cn.tacomall.tacomallspringbootutils.IpUtil;
import cn.tacomall.tacomallspringbootentity.sys.SysLog;
import cn.tacomall.tacomallspringbootmapper.sys.SysLogMapper;

@Aspect
@Component
public class SysLoggerAspect {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Pointcut("@annotation(cn.tacomall.tacomallspringbootcommon.annotation.SysLogger)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        saveSysLog(point, time);

        return result;
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        SysLog log = new SysLog();
        if (method.getAnnotation(SysLogger.class) != null) {
            SysLogger sysLogger = method.getAnnotation(SysLogger.class);
            log.setOperation(sysLogger.value());
        }
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        log.setMethod(className + "." + methodName + "()");
        Object[] args = joinPoint.getArgs();
        try {
            String params = JsonUtil.toJson(args);
            log.setParams(params);
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            log.setIp(IpUtil.getIpAddr(request));
            log.setCreateTime(new Date());
            sysLogMapper.insert(log);
        } catch (Exception ignored) {

        }
    }
}
