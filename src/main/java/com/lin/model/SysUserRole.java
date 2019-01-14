package com.lin.model;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 用户角色关联表
 */
public class SysUserRole {
    // Mybatis默认是数据库下划线转驼峰命名
    private Long userId;
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
