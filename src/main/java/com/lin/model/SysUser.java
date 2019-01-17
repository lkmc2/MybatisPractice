package com.lin.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 用户表
 * 二级缓存使用可读写缓存配置，需要进行Serializable序列化缓存
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = 6320941908222938912L;

    // Mybatis默认是数据库下划线转驼峰命名
    private Long id;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userInfo;
    private byte[] headImg; // byte[]可以对应blob等二进制类型
    private Date createTime;

    private SysRole role; // 用户角色

    private List<SysRole> roleList; // 用户的角色集合

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public byte[] getHeadImg() {
        return headImg;
    }

    public void setHeadImg(byte[] headImg) {
        this.headImg = headImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SysRole getRole() {
        return role;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }

    public List<SysRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<SysRole> roleList) {
        this.roleList = roleList;
    }
}
