package cn.codingtalk.tacomallcommon.exceptionInterceptor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallcommon.exceptionInterceptor.exception.BizException;

@RestControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseVo<String> bizErrorHandler(HttpServletRequest req, BizException e) throws Exception {
        ResponseVo<String> bizError = new ResponseVo<>();
        bizError.setCode(400);
        bizError.setMessage(e.getMessage());
        return bizError;
    }
}
