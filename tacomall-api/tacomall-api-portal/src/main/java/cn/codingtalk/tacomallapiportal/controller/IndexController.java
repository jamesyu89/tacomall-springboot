/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-06-12 15:21:54
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-api\tacomall-api-portal\src\main\java\cn\codingtalk\tacomallapiportal\controller\IndexController.java
 * @Just do what I think it is right
 */

package cn.codingtalk.tacomallapiportal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.*;

import cn.codingtalk.tacomallapiportal.annotation.IgnoreAuth;
import cn.codingtalk.tacomallcommon.vo.ResponseVo;

/**
 * @author: running-cat
 * @className: Index
 * @packageName: cn.codingtalk.tacomallsprinbootapiportal.controller
 * @description: 移动端默认入口
 * @data: 2019年11月23日下午12:28:39
 **/

@Api(tags = "默认模板入口")
@RestController
@RequestMapping(value = "/portal/index/")
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @author: running-cat
     * @methodsName: index
     * @description: 默认方法
     * @param: code 测试验证码
     * @return: ResponseDto
     * @throws:
     */

    @ApiOperation(value = "index", notes = "index方法", httpMethod = "POST")
    @ApiImplicitParams({ @ApiImplicitParam(name = "code", value = "验证码", required = true, paramType = "path"), })
    @IgnoreAuth
    @PostMapping("index")
    public ResponseVo<String> index() {
        /**
         * 使用jsonRequest.getStr获取客户端传来的code 无则抛出ClientException
         */
        this.logger.info("index域index模块index方法");
        ResponseVo<String> responseVo = new ResponseVo<>();
        responseVo.setMessage("index域index模块index方法");
        return responseVo;
    }
}
