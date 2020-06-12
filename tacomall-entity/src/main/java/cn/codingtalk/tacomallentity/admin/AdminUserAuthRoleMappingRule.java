/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-12 15:38:22
 * @LastEditTime: 2020-06-12 15:38:23
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-entity\src\main\java\cn\codingtalk\tacomallentity\admin\AdminAuthRoleMappingRule.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallentity.admin;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class AdminUserAuthRoleMappingRule {
    @TableId(value = "id", type = IdType.AUTO)
    private int id; 

    private int is_delete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}