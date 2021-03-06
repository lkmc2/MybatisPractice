package com.lin.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lkmc2
 * @date 2019/1/16
 * @description 创建信息
 */
public class CreateInfo implements Serializable {
    private static final long serialVersionUID = 6320941908222989612L;

    private String createBy; // 创建人
    private Date createTime; // 创建时间

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
