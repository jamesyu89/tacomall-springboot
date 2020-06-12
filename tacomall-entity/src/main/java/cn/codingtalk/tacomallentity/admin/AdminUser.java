/***
 * @Author: 码上talk|RC
 * @Date: 2020-06-12 17:32:54
 * @LastEditTime: 2020-06-12 18:12:58
 * @LastEditors: 码上talk|RC
 * @Description: 
 * @FilePath: \tacomall-springboot\tacomall-entity\src\main\java\cn\codingtalk\tacomallentity\admin\AdminUser.java
 * @Just do what I think it is right
 */
package cn.codingtalk.tacomallentity.admin;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class AdminUser {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String username;

    private String passwd;

    private int status;

    private int is_delete;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;
}
