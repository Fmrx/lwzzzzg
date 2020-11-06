package com.lwzzzzg.service.impl;

import com.lwzzzzg.entity.UmsMember;
import com.lwzzzzg.mapper.UmsMemberMapper;
import com.lwzzzzg.service.UmsMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author fmrx
 * @since 2020-11-05
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {

    @Override
    public List<UmsMember> selectList() {
        return this.baseMapper.selectList(null);
    }
}
