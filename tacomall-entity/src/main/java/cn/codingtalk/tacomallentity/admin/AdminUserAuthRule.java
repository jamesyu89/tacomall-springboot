/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-12 15:38:07
 * @LastEditTime: 2020-06-12 18:24:23
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-entity\src\main\java\cn\codingtalk\tacomallentity\admin\AdminUserAuthRule.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallentity.admin;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class AdminUserAuthRule {
    @TableId(value = "id", type = IdType.AUTO)
    private int id; 
    
    private String name;

    private int is_delete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}
