/**
 * projectName: tacomall-sprinboot
 * fileName: Index.java
 * packageName: cn.tacomall.tacomallsprinbootapiportal.controller
 * date: 2019年11月23日下午12:28:39
 * <p>
 * 修改履历:
 * 日期                          修正者           主要内容
 * 2019年11月23日下午12:28:39    running-cat      初版完成
 * <p>
 * copyright(c) 2019-2020 芒果教育科技有限公司
 */

package cn.tacomall.tacomallspringbootapiportal.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.*;

import cn.tacomall.tacomallspringbootcommon.dto.ResponseDto;
import cn.tacomall.tacomallspringbootutils.RequestUtil;
import cn.tacomall.tacomallspringbootutils.ResponseUtil;
import cn.tacomall.tacomallspringbootutils.ConstantUtil;
import cn.tacomall.tacomallspringbootapiportal.annotation.IgnoreAuth;
import cn.tacomall.tacomallspringbootapiportal.annotation.RequireAuth;
import cn.tacomall.tacomallspringbootapiportal.service.user.*;

/**
 * @author: running-cat
 * @className: User
 * @packageName: cn.tacomall.tacomallsprinbootapiportal.controller
 * @description: 移动端用户模块
 * @data: 2019年11月23日下午12:28:39
 **/

@Api(tags = "用户模块")
@RestController
@RequestMapping(value = "/portal/user/")
public class User {
    @Autowired
    private UserService userService;

    /**
     * @author: running-cat
     * @methodsName: register
     * @description: 用户注册
     * @param: name 用户名称
     * @return: ResponseDto
     * @throws:
     */

    @ApiOperation(value = "注册", notes = "用户注册接口", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "path"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "path")
    })
    @IgnoreAuth
    @PostMapping("register")
    public ResponseDto register(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        String username = jsonRequest.getStr("username");
        String password = jsonRequest.getStr("password");
        Map<String, Object> map = userService.register(username, password);
        responseUtil.data(map);
        if (map == ConstantUtil.EMPTY_MAP) {
            return responseUtil.error();
        }
        return responseUtil.success();
    }

    /**
     * @author: running-cat
     * @methodsName: login
     * @description: 用户登录
     * @param: username 用户名 password 密码
     * @return: ResponseDto
     * @throws:
     */

    @ApiOperation(value = "登录", notes = "登录接口接口", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "path"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "path")
    })
    @IgnoreAuth
    @PostMapping("login")
    public ResponseDto login(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        String username = jsonRequest.getStr("username");
        String password = jsonRequest.getStr("password");
        Map<String, Object> map = userService.login(username, password);
        responseUtil.data(map);
        return responseUtil.success();
    }

    /**
     * @author: running-cat
     * @methodsName: messageCodeLogin
     * @description: 手机验证码登录
     * @param: mobile 手机号 code 验证码
     * @return: ResponseDto
     * @throws:
     */

    @ApiOperation(value = "验证码登录", notes = "验证码登录接口", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号", required = true, paramType = "path"),
            @ApiImplicitParam(name = "code", value = "验证码", required = true, paramType = "path")
    })
    @IgnoreAuth
    @PostMapping("messageCodeLogin")
    public ResponseDto messageCodeLogin(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        /**
         * @TODO
         */
        return responseUtil.success();
    }

    /**
     * @author: running-cat
     * @methodsName: miniAppLogin
     * @description: 小程序用户登录
     * @param: iv code encryptedData
     * @return: ResponseDto
     * @throws:
     */

    @ApiOperation(value = "小程序用户注册接口", notes = "小程序用户注册接口", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "iv", value = "iv", required = true, paramType = "path"),
            @ApiImplicitParam(name = "code", value = "code", required = true, paramType = "path"),
            @ApiImplicitParam(name = "encryptedData", value = "encryptedData", required = true, paramType = "path")
    })
    @IgnoreAuth
    @PostMapping("miniAppLogin")
    public ResponseDto miniAppLogin(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        String iv = jsonRequest.getStr("iv");
        String code = jsonRequest.getStr("code");
        String encryptedData = jsonRequest.getStr("encryptedData");
        Map<String, Object> map = userService.miniAppLogin(iv, code, encryptedData);
        responseUtil.data(map);
        return responseUtil.success();
    }

    /**
     * @author: running-cat
     * @methodsName: synopsis
     * @description: 用户信息
     * @param:
     * @return: ResponseDto
     * @throws:
     */

    @ApiOperation(value = "用户信息", notes = "用户信息接口", httpMethod = "POST")
    @ApiImplicitParams({})
    @RequireAuth
    @PostMapping("synopsis")
    public ResponseDto synopsis(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        Map<String, Object> map = userService.synopsis();
        responseUtil.data(map);
        return responseUtil.success();
    }
}
