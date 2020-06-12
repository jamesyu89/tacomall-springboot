/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-12 17:37:54
 * @LastEditTime: 2020-06-12 18:15:33
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-mapper\src\main\java\cn\codingtalk\tacomallmapper\admin\AdminUserMapper.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallmapper.admin;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.codingtalk.tacomallentity.admin.AdminUser;
import cn.codingtalk.tacomallentity.admin.AdminUserAuthRole;
import cn.codingtalk.tacomallentity.admin.AdminUserAuthRule;

@Repository
public interface AdminUserMapper  extends BaseMapper<AdminUser>{

    AdminUserAuthRole getAuthRole(int Id);

    List<AdminUserAuthRule> getAuthRule(int Id);
    
}
