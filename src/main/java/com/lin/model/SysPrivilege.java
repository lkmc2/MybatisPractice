package com.lin.model;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 权限表
 */
public class SysPrivilege {
    // Mybatis默认是数据库下划线转驼峰命名
    private Long id;
    private String privilegeName;
    private String privilegeUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getPrivilegeUrl() {
        return privilegeUrl;
    }

    public void setPrivilegeUrl(String privilegeUrl) {
        this.privilegeUrl = privilegeUrl;
    }
}
