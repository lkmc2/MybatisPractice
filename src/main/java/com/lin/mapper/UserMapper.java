package com.lin.mapper;

import com.lin.model.SysUser;

import java.util.List;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 用户数据库接口
 */
public interface UserMapper {
    SysUser selectById(Long id);

    List<SysUser> selectAll();
}
