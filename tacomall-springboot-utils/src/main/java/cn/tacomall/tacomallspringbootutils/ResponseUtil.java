package cn.tacomall.tacomallspringbootutils;

import cn.tacomall.tacomallspringbootcommon.dto.ResponseDto;

public class ResponseUtil {

    ResponseDto<Object> resp;

    public ResponseUtil() {
        resp = new ResponseDto<>();
    }

    public ResponseUtil code(int code) {
        resp.setCode(code);
        return this;
    }

    public ResponseUtil data(Object data) {
        resp.setData(data);
        return this;
    }

    public ResponseDto success(String message) {
        resp.setMessage(message);
        return resp;
    }
}
