package cn.tacomall.tacomallspringbootstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import cn.tacomall.tacomallspringbootcommon.dto.ResponseDto;
import cn.tacomall.tacomallspringbootutils.RequestUtil;
import cn.tacomall.tacomallspringbootutils.ResponseUtil;

@RestController
@RequestMapping(value = "/store/index/")
public class Index {

    @PostMapping("index")
    public ResponseDto index(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        String code = jsonRequest.getStr("code");
        return responseUtil.success(code); // 返回ResponseDto对象
    }
}
