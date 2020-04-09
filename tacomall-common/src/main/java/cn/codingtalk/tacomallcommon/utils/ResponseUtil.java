package cn.codingtalk.tacomallcommon.utils;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;

public class ResponseUtil {

    ResponseVo<Object> resp;

    public ResponseUtil() {
        resp = new ResponseVo<>();
    }

    public ResponseUtil code(int code) {
        resp.setCode(code);
        return this;
    }

    public ResponseUtil data(Object data) {
        resp.setData(data);
        return this;
    }

    public ResponseVo success() {
        resp.setMessage("操作成功");
        return resp;
    }

    public ResponseVo success(String message) {
        resp.setMessage(message);
        return resp;
    }

    public ResponseVo error() {
        resp.setMessage("操作失败");
        return resp;
    }

    public ResponseVo error(String message) {
        resp.setMessage(message);
        return resp;
    }
}
