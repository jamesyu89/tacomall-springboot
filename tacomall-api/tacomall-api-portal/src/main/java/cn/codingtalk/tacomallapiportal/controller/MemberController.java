package cn.codingtalk.tacomallapiportal.controller;

import cn.codingtalk.tacomallapiportal.service.member.MemberService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import cn.codingtalk.tacomallcommon.utils.RequestUtil;
import cn.codingtalk.tacomallcommon.utils.ResponseUtil;
import cn.codingtalk.tacomallapiportal.annotation.IgnoreAuth;
import cn.codingtalk.tacomallapiportal.annotation.RequireAuth;
import cn.codingtalk.tacomallcommon.vo.ResponseVo;

@Api(tags = "用户模块")
@RestController
@RequestMapping(value = "/portal/member/")
public class MemberController {

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
    public ResponseVo miniAppLogin(@RequestBody RequestUtil requestUtil, ResponseUtil responseUtil) throws Exception {
        JSONObject json = requestUtil.getJson("json");
        String token = memberService.miniAppLogin(json);
        responseUtil.data(token);
        return responseUtil.success();
    }

    @ApiOperation(value = "用户信息", notes = "用户信息接口", httpMethod = "POST")
    @ApiImplicitParams({})
    @RequireAuth
    @PostMapping("synopsis")
    public ResponseVo synopsis(@RequestBody RequestUtil requestUtil, ResponseUtil responseUtil) throws Exception {
        Object member = memberService.synopsis();
        responseUtil.data(member);
        return responseUtil.success();
    }
}
