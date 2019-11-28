package cn.tacomall.tacomallspringbootentity.user;

import lombok.Data;

@Data
public class UserProfile {
    private int id;
    private int userId;
    private String avatar;
    private String nickname;
}
