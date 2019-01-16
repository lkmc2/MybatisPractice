package com.lin.mapper;

import com.lin.model.SysPrivilege;
import com.lin.provider.PrivilegeProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author lkmc2
 * @date 2019/1/15
 * @description 权限数据库接口
 */
public interface PrivilegeMapper {
    // 根据id选择权限（数据库语句写在PrivilegeProvider的selectById方法中）
    @SelectProvider(type = PrivilegeProvider.class, method = "selectById")
    SysPrivilege selectById(Long id);

    // 根据角色id获取权限
    List<SysPrivilege> selectPrivilegeByRoleId(Long roleId);
}
