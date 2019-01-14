package com.lin.model;

import java.util.Date;

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
    private Integer createBy;
    private Date createTime;

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

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
