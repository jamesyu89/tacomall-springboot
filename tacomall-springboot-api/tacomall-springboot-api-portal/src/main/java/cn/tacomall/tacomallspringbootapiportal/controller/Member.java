package cn.tacomall.tacomallspringbootapiportal.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import cn.tacomall.tacomallspringbootcommon.utils.RequestUtil;
import cn.tacomall.tacomallspringbootcommon.utils.ResponseUtil;
import cn.tacomall.tacomallspringbootapiportal.annotation.IgnoreAuth;
import cn.tacomall.tacomallspringbootapiportal.annotation.RequireAuth;
import cn.tacomall.tacomallspringbootcommon.dto.ResponseDto;
import cn.tacomall.tacomallspringbootapiportal.service.member.*;

@Api(tags = "用户模块")
@RestController
@RequestMapping(value = "/portal/member/")
public class Member {

    @Autowired
    private MemberService memberService;

    @ApiOperation(value = "小程序用户注册接口", notes = "小程序用户注册接口", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "iv", value = "iv", required = true, paramType = "path"),
            @ApiImplicitParam(name = "code", value = "code", required = true, paramType = "path"),
            @ApiImplicitParam(name = "encryptedData", value = "encryptedData", required = true, paramType = "path")
    })
    @IgnoreAuth
    @PostMapping("miniAppLogin")
    public ResponseDto miniAppLogin(@RequestBody RequestUtil requestUtil, ResponseUtil responseUtil) throws Exception {
        JSONObject json = requestUtil.getJson("json");
        String token = memberService.miniAppLogin(json);
        responseUtil.data(token);
        return responseUtil.success();
    }

    @ApiOperation(value = "用户信息", notes = "用户信息接口", httpMethod = "POST")
    @ApiImplicitParams({})
    @RequireAuth
    @PostMapping("synopsis")
    public ResponseDto synopsis(@RequestBody RequestUtil requestUtil, ResponseUtil responseUtil) throws Exception {
        Object member = memberService.synopsis();
        responseUtil.data(member);
        return responseUtil.success();
    }
}
