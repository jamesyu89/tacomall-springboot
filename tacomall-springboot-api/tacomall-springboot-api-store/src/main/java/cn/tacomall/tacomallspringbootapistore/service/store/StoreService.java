package cn.tacomall.tacomallspringbootapistore.service.store;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.tacomall.tacomallspringbootentity.store.Store;

public interface StoreService extends IService<Store> {

    String login(String username, String password) throws Exception;

    String logout();
}
