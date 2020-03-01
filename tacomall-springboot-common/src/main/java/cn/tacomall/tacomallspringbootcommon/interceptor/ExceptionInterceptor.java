package cn.tacomall.tacomallspringbootcommon.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import cn.tacomall.tacomallspringbootcommon.dto.ErrorDto;
import cn.tacomall.tacomallspringbootcommon.exception.*;

@RestControllerAdvice
public class ExceptionInterceptor {

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ErrorDto<String> bizErrorHandler(HttpServletRequest req, BizException e) throws Exception {
        ErrorDto<String> bizError = new ErrorDto<>();
        bizError.setMessage(e.getMessage());
        bizError.setCode(ErrorDto.ERROR);
        bizError.setData("Some Data");
        bizError.setUrl(req.getRequestURL().toString());
        return bizError;
    }

    @ExceptionHandler(value = ClientException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto<String> clientSideErrorHandler(HttpServletRequest req, ClientException e) throws Exception {
        ErrorDto<String> clientSideError = new ErrorDto<>();
        clientSideError.setMessage(e.getMessage());
        clientSideError.setCode(ErrorDto.ERROR);
        clientSideError.setData("Some Data");
        clientSideError.setUrl(req.getRequestURL().toString());
        return clientSideError;
    }

    @ExceptionHandler(value = ForbiddenException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorDto<String> forbiddenErrorHandler(HttpServletRequest req, ForbiddenException e) throws Exception {
        ErrorDto<String> forbiddenError = new ErrorDto<>();
        forbiddenError.setMessage(e.getMessage());
        forbiddenError.setCode(ErrorDto.ERROR);
        forbiddenError.setData("Some Data");
        forbiddenError.setUrl(req.getRequestURL().toString());
        return forbiddenError;
    }

    @ExceptionHandler(value = RpcException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto<String> rpcErrorHandler(HttpServletRequest req, RpcException e) throws Exception {
        ErrorDto<String> rpcError = new ErrorDto<>();
        rpcError.setMessage(e.getMessage());
        rpcError.setCode(ErrorDto.ERROR);
        rpcError.setData("Some Data");
        rpcError.setUrl(req.getRequestURL().toString());
        return rpcError;
    }

    @ExceptionHandler(value = ServerException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto<String> serverSideErrorHandler(HttpServletRequest req, ServerException e) throws Exception {
        ErrorDto<String> serverSideError = new ErrorDto<>();
        serverSideError.setMessage(e.getMessage());
        serverSideError.setCode(ErrorDto.ERROR);
        serverSideError.setData("Some Data");
        serverSideError.setUrl(req.getRequestURL().toString());
        return serverSideError;
    }

    @ExceptionHandler(value = SqlException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDto<String> sqlErrorHandler(HttpServletRequest req, SqlException e) throws Exception {
        ErrorDto<String> sqlError = new ErrorDto<>();
        sqlError.setMessage(e.getMessage());
        sqlError.setCode(ErrorDto.ERROR);
        sqlError.setData("Some Data");
        sqlError.setUrl(req.getRequestURL().toString());
        return sqlError;
    }

    @ExceptionHandler(value = UnauthorizedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorDto<String> unauthorizedErrorHandler(HttpServletRequest req, UnauthorizedException e) throws Exception {
        ErrorDto<String> unauthorizedError = new ErrorDto<>();
        unauthorizedError.setMessage(e.getMessage());
        unauthorizedError.setCode(ErrorDto.ERROR);
        unauthorizedError.setData("Some Data");
        unauthorizedError.setUrl(req.getRequestURL().toString());
        return unauthorizedError;
    }
}