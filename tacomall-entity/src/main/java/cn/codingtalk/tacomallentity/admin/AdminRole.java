package cn.codingtalk.tacomallentity.admin;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class AdminRole {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String name;
}
