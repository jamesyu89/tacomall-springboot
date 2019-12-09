package cn.tacomall.tacomallspringbootstore.service.store;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.tacomall.tacomallspringbootentity.store.Store;

public interface StoreService extends IService<Store> {

    String login() throws Exception;

    String logout();
}
