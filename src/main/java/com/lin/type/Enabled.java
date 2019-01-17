package com.lin.type;

/**
 * @author lkmc2
 * @date 2019/1/17
 * @description 是否启用
 */
public enum Enabled {
    ENABLED(1), // 启用
    DISABLED(0); // 禁用

    private final int value;

    Enabled(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
