package com.lin.mapper;

import com.lin.model.SysRole;
import com.lin.model.SysRoleExtend;
import com.lin.model.SysUser;

import java.util.List;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 用户数据库接口
 */
public interface UserMapper {
    // 根据id获取用户
    SysUser selectById(Long id);

    // 获取所有用户
    List<SysUser> selectAll();

    // 根据用户id获取角色信息
    List<SysRole> selectRolesByUserId(Long userId);

    // 根据用户id获取角色信息，并带有当前用户名
    List<SysRoleExtend> selectRolesAndUserNameByUserId(Long userId);
}
