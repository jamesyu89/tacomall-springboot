package cn.codingtalk.tacomallentity.admin;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class AdminRoleMappingPermission {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;
}