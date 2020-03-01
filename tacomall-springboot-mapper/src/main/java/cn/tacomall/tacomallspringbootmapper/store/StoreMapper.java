package cn.tacomall.tacomallspringbootmapper.store;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.tacomall.tacomallspringbootentity.store.Store;
import cn.tacomall.tacomallspringbootentity.store.StoreRole;
import cn.tacomall.tacomallspringbootentity.store.StorePermission;

import java.util.List;

@Repository
public interface StoreMapper extends BaseMapper<Store> {
    StoreRole getRole(int id);

    List<StorePermission> getPermission(int id);
}
