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

    // 根据用户id获取角色信息，并带有当前用户名（方式2）
    List<SysRole> selectRolesAndUserNameByUserId2(Long userId);

    // 新增用户
    int insert(SysUser sysUser);

    // 新增用户（带主键值）
    int insert2(SysUser sysUser);

    // 新增用户（带主键值，方式2）
    int insert3(SysUser sysUser);

    // 根据主键更新
    int updateById(SysUser sysUser);

    // 根据主键删除
    int deleteById(Long id);

    // 根据主键删除（方法名相同时，会同时匹配xml中的同一个delete标签）
    int deleteById(SysUser sysUser);
}
