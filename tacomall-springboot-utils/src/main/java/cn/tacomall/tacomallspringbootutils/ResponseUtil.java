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

    public ResponseDto success() {
        resp.setMessage("操作成功");
        return resp;
    }

    public ResponseDto success(String message) {
        resp.setMessage(message);
        return resp;
    }
}
