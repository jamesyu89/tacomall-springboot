package cn.tacomall.tacomallspringbootentity.user;

import lombok.Data;

@Data
public class UserWeixin {
    private int id;
    private int userId;
    private String open_id;
}
