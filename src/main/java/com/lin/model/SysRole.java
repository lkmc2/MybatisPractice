package com.lin.model;

import com.lin.type.Enabled;

import java.io.Serializable;
import java.util.List;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 角色表
 * 二级缓存使用可读写缓存配置，需要进行Serializable序列化缓存
 */
public class SysRole implements Serializable {
    private static final long serialVersionUID = 6320941908222932112L;

    // Mybatis默认是数据库下划线转驼峰命名
    private Long id;
    private String roleName;

    private Enabled enabled; // 是否启用的枚举

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

    public Enabled getEnabled() {
        return enabled;
    }

    public void setEnabled(Enabled enabled) {
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
