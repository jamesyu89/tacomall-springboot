package cn.tacomall.tacomallspringbootcommon.utils;

import cn.tacomall.tacomallspringbootcommon.exception.*;

public class ExceptionUtil {
    public static void throwBizException(String message) throws BizException {
        throw new BizException(message);
    }

    public static void throwClientException(String message) throws ClientException {
        throw new ClientException(message);
    }

    public static void throwForbiddenException(String message) throws ForbiddenException {
        throw new ForbiddenException(message);
    }

    public static void throwRpcException(String message) throws RpcException {
        throw new RpcException(message);
    }

    public static void throwServerException(String message) throws ServerException {
        throw new ServerException(message);
    }

    public static void throwSqlException(String message) throws SqlException {
        throw new SqlException(message);
    }

    public static void throwUnauthorizedException(String message) throws UnauthorizedException {
        throw new UnauthorizedException(message);
    }
}
