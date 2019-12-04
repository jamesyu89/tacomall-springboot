package cn.tacomall.tacomallspringbootcommon.exception;

public class RpcException extends RuntimeException {
    public RpcException(String message) {
        super(message);
    }
}
