/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-09 23:20:41
 * @LastEditTime: 2020-06-12 18:29:29
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-api\tacomall-api-portal\src\main\java\cn\codingtalk\tacomallapiportal\service\member\MemberService.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallapiportal.service.member;


import com.baomidou.mybatisplus.extension.service.IService;

import cn.codingtalk.tacomallcommon.vo.ResponseVo;
import cn.codingtalk.tacomallentity.member.Member;

public interface MemberService extends IService<Member> {

    ResponseVo<String> wxMaLogin(String iv, String code, String appid, String rawData, String signature, String encryptedData);

    ResponseVo<Member> info();
}
