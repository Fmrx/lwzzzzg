package com.lwzzzzg.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lwzzzzg.entity.UmsMember;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author fmrx
 * @since 2020-11-05
 */
public interface UmsMemberService extends IService<UmsMember> {


    List<UmsMember> selectList();

}
