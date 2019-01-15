package com.lin.example;

import com.mmall.pojo.SysUser;

import java.util.Date;

public class SysUserWithBLOBs extends SysUser {
    private String userInfo;

    private byte[] headImg;

    public SysUserWithBLOBs(Long id, String userName, String userPassword, String userEmail, Date createTime, String userInfo, byte[] headImg) {
        super(id, userName, userPassword, userEmail, createTime);
        this.userInfo = userInfo;
        this.headImg = headImg;
    }

    public SysUserWithBLOBs() {
        super();
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo == null ? null : userInfo.trim();
    }

    public byte[] getHeadImg() {
        return headImg;
    }

    public void setHeadImg(byte[] headImg) {
        this.headImg = headImg;
    }
}