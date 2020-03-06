package cn.tacomall.tacomallspringbootentity.member;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class MemberWeixin {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int memberId;

    private String openId;

    private String nickname;

    private String gender;

    private String avatarUrl;
}
