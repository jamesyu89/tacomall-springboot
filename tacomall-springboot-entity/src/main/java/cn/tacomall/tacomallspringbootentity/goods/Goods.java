package cn.tacomall.tacomallspringbootentity.goods;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class Goods {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

}
