package cn.tacomall.tacomallspringbootmapper.admin;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.tacomall.tacomallspringbootentity.admin.Admin;
import cn.tacomall.tacomallspringbootentity.admin.AdminRole;
import cn.tacomall.tacomallspringbootentity.admin.AdminPermission;

import java.util.List;

@Repository
public interface AdminMapper extends BaseMapper<Admin> {
    AdminRole getRole(int id);

    List<AdminPermission> getPermission(int id);
}
