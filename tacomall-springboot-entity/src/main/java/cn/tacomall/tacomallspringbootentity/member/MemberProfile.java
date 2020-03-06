package cn.tacomall.tacomallspringbootentity.member;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class MemberProfile {


    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private int memberId;

    private String nickname;

    private String avatar;
}
