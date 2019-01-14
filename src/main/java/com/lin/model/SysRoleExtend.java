package com.lin.model;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 角色拓展类（多添加了用户名）
 */
public class SysRoleExtend extends SysRole {
    private String userName; // 用户名

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
