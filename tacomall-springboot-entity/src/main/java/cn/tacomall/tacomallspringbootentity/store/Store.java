package cn.tacomall.tacomallspringbootentity.store;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class Store {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int storeRoleId;

    private String username;

    private String password;

    private int status;
}
