package cn.codingtalk.tacomallcommon.exception;

public class RpcException extends RuntimeException {
    public RpcException(String message) {
        super(message);
    }
}
