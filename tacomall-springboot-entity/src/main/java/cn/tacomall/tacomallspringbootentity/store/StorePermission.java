package cn.tacomall.tacomallspringbootentity.store;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class StorePermission {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String name;
}
