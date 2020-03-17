package cn.codingtalk.tacomallmapper.admin;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.codingtalk.tacomallentity.admin.Admin;
import cn.codingtalk.tacomallentity.admin.AdminRole;
import cn.codingtalk.tacomallentity.admin.AdminPermission;

import java.util.List;

@Repository
public interface AdminMapper extends BaseMapper<Admin> {
    AdminRole getRole(int id);

    List<AdminPermission> getPermission(int id);
}
