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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.annotations.*;

import cn.tacomall.tacomallspringbootutils.RequestUtil;
import cn.tacomall.tacomallspringbootutils.ResponseUtil;
import cn.tacomall.tacomallspringbootsecurity.jwt.annotation.IgnoreAuth;
import cn.tacomall.tacomallspringbootcommon.dto.ResponseDto;

/**
 * @author: running-cat
 * @className: Index
 * @packageName: cn.tacomall.tacomallsprinbootapiportal.controller
 * @description: 移动端默认入口
 * @data: 2019年11月23日下午12:28:39
 **/

@Api(tags = "默认模板入口")
@RestController
@RequestMapping(value = "/portal/index/")
public class Index {

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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "验证码", required = true, paramType = "path"),
    })
    @IgnoreAuth
    @PostMapping("index")
    public ResponseDto index(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        /**
         * 使用jsonRequest.getStr获取客户端传来的code
         * 无则抛出ClientException
         */
        String code = jsonRequest.getStr("code");
        this.logger.info("index域index模块index方法");
        return responseUtil.success(code); // 返回ResponseDto对象
    }
}
