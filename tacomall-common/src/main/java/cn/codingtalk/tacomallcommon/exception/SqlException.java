package cn.codingtalk.tacomallcommon.exception;

import java.sql.SQLException;

public class SqlException extends SQLException {
    public SqlException(String message) {
        super(message);
    }
}
