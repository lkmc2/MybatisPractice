package com.lin.plugin;

import org.apache.ibatis.session.RowBounds;

/**
 * @author lkmc2
 * @date 2019/1/18
 * @description 可以记录total的分页参数
 */
public class PageRowBounds extends RowBounds {
    private long total;

    public PageRowBounds() {
        super();
    }

    public PageRowBounds(int offset, int limit) {
        super(offset, limit);
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
