package cn.tacomall.tacomallspringbootcommon.exception;

import java.sql.SQLException;

public class SqlException extends SQLException {
    public SqlException(String message) {
        super(message);
    }
}
