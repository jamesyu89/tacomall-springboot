package cn.tacomall.tacomallspringbootapiportal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.annotations.*;

import cn.tacomall.tacomallspringbootcommon.dto.ResponseDto;
import cn.tacomall.tacomallspringbootutils.RequestUtil;
import cn.tacomall.tacomallspringbootutils.ResponseUtil;
import cn.tacomall.tacomallspringbootapiportal.annotation.IgnoreAuth;

@Api(tags = "portal domain and index module")
@RestController
@RequestMapping(value = "/portal/index/")
public class Index {
    @ApiOperation(value = "index", notes = "index method", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "verify code", required = true, paramType = "path"),
    })
    @IgnoreAuth
    @PostMapping("index")
    public ResponseDto index(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        String code = jsonRequest.getStr("code");
        return responseUtil.success(code);
    }
}
