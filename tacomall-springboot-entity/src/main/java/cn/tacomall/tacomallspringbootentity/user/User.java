package cn.tacomall.tacomallspringbootentity.user;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String username;

    private String password;
}
