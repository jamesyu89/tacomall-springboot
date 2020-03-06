package cn.tacomall.tacomallspringbootentity.member;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class Member {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String username;

    private String password;

    private int status;

    @TableField(exist = false)
    private MemberProfile userProfile;

    @TableField(exist = false)
    private MemberWeixin userWeixin;
}
