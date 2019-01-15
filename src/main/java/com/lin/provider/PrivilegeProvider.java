package com.lin.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author lkmc2
 * @date 2019/1/15
 * @description 权限数据库语句提供器
 */
public class PrivilegeProvider {
    // 根据id选择权限（方式1，创建SQL对象）
    public String selectById(final Long id) {
        return new SQL() {
            {
                SELECT("id, privilege_name privilegeName, privilege_url privilegeUrl");
                FROM("sys_privilege");
                WHERE("id = #{id}");
            }
        }.toString();
    }

    // 根据id选择权限（方式2，使用字符串）
//    public String selectById(final Long id) {
//        return "select id, " +
//                "privilege_name privilegeName, " +
//                "privilege_url privilegeUrl " +
//                "from sys_privilege where id = #{id}";
//    }
}
