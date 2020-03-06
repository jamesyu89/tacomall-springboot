package cn.tacomall.tacomallspringbootentity.admin;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class Admin {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int storeRoleId;

    private String username;

    private String password;

    private int status;
}
