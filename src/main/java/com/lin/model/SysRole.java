package com.lin.model;

import java.util.List;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 角色表
 */
public class SysRole {
    // Mybatis默认是数据库下划线转驼峰命名
    private Long id;
    private String roleName;
    private Integer enabled;

    private CreateInfo createInfo; // 创建信息

    private SysUser user; // 用户信息

    private List<SysPrivilege> privilegeList; // 角色包含的权限列表

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public CreateInfo getCreateInfo() {
        return createInfo;
    }

    public void setCreateInfo(CreateInfo createInfo) {
        this.createInfo = createInfo;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public List<SysPrivilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<SysPrivilege> privilegeList) {
        this.privilegeList = privilegeList;
    }
}
