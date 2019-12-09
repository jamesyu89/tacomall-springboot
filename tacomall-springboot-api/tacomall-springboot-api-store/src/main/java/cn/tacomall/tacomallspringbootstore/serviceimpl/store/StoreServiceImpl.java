package cn.tacomall.tacomallspringbootstore.serviceimpl.store;

        import cn.tacomall.tacomallspringbootsecurity.jwt.utils.RequestUserUtil;
        import org.springframework.stereotype.Service;
        import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
        import org.springframework.beans.factory.annotation.Autowired;

        import cn.tacomall.tacomallspringbootentity.store.Store;
        import cn.tacomall.tacomallspringbootmapper.store.StoreMapper;
        import cn.tacomall.tacomallspringbootstore.service.store.StoreService;

@Service
public class StoreServiceImpl extends ServiceImpl<StoreMapper, Store> implements StoreService {

    @Autowired
    StoreMapper storeMapper;

    @Override
    public String login() {
        return "";
    }

    @Override
    public String logout() {
        return "";
    }

}
