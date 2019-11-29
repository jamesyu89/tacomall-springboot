package cn.tacomall.tacomallspringbootentity.user;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class UserWeixin {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int userId;

    private String openId;
}
