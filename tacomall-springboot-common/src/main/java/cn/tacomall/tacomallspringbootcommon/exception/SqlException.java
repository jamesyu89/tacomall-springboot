package cn.tacomall.tacomallspringbootcommon.exception;

public class SqlException extends RuntimeException {
    public SqlException(String message) {
        super(message);
    }
}
