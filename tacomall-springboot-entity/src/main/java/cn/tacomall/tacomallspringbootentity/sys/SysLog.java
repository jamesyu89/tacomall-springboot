package cn.tacomall.tacomallspringbootentity.sys;

import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.*;

@Data
public class SysLog {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String method;

    private String params;

    private String operation;

    private String ip;

    private Date createTime;
}
