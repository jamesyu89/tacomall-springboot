package cn.tacomall.tacomallspringbootproviderstorage.service;

import java.util.Map;

public interface SecurityService {
    Map<String, Object> authorize(String dir);
}
