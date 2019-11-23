/**
 * projectName: tacomall-sprinboot
 * fileName: Index.java
 * packageName: cn.tacomall.tacomallsprinbootapiportal.controller
 * date: 2019年11月23日下午12:28:39
 *
 * 修改履历:
 *     日期                          修正者           主要内容
 *     2019年11月23日下午12:28:39    running-cat      初版完成
 *
 * copyright(c) 2019-2020 芒果教育科技有限公司
 */

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

/**
 * @author: running-cat
 * @className: Index
 * @packageName: cn.tacomall.tacomallsprinbootapiportal.controller
 * @description: 移动端默认入口
 * @data: 2019年11月23日下午12:28:39
 **/

@Api(tags = "portal domain and index module")
@RestController
@RequestMapping(value = "/portal/index/")
public class Index {

    /**
     * @author:  running-cat
     * @methodsName: index
     * @description: 默认方法
     * @param:  code 测试验证码
     * @return: ResponseDto
     * @throws:
     */

    @ApiOperation(value = "index", notes = "index method", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "code", value = "verify code", required = true, paramType = "path"),
    })
    @IgnoreAuth
    @PostMapping("index")
    public ResponseDto index(@RequestBody RequestUtil jsonRequest, ResponseUtil responseUtil) throws Exception {
        /**
         * 使用jsonRequest.getStr获取客户端传来的code
         * 无则抛出ClientException
         */
        String code = jsonRequest.getStr("code");
        return responseUtil.success(code); // 返回ResponseDto对象
    }
}
