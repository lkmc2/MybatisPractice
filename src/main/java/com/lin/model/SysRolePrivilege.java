package com.lin.model;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 角色权限关联表
 */
public class SysRolePrivilege {
    // Mybatis默认是数据库下划线转驼峰命名
    private Long roleId;
    private Long privilegeId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }
}
