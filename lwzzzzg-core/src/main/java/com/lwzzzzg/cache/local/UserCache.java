package com.lwzzzzg.cache.local;

import com.lwzzzzg.entity.UmsMember;
import com.lwzzzzg.mapper.UmsMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class UserCache {

    @Autowired
    private UmsMemberMapper umsMemberMapper;

    /**
     * 创建本地缓存
     * @param uid
     * @return
     */
    @Cacheable(value = "userInfo", key = "#uid")
    public UmsMember getUmsMember(Long uid) {
        return umsMemberMapper.selectById(uid);
    }

    /**
     * 删除本地缓存
     * @param uid
     */
    @CacheEvict(value = "userInfo", key = "#uid")
    public void deleteUmsMember(Long uid) {
        System.out.println(uid);
    }

}
