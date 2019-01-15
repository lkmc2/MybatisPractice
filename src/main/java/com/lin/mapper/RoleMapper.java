package com.lin.mapper;

import com.lin.model.SysRole;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 角色数据库接口
 */
public interface RoleMapper {
    // 根据id选择角色，@Select使用文本拼接和字符串数组都可以
    // 启用了mybatis-config.xml中的mapUnderscoreToCamelCase的话，可以不给字段取别名
    // 直接使用select * from sys_role where id = #{id}
//    @Select({"select id, role_name roleName, enabled, " +
//            "create_by createBy, " +
//            "create_time createTime" +
//            "from sys_role" +
//            "where id = #{id}"})
    @Select({"select id, role_name roleName, enabled, ",
                "create_by createBy, ",
                "create_time createTime ",
            "from sys_role",
            "where id = #{id}"})
    SysRole selectById(Long id);

    // 根据id选择角色（方式2，指定resultMap）
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time")
    })
    @Select({"select id, role_name, enabled, create_by, create_time ",
            "from sys_role",
            "where id = #{id}"})
    SysRole selectById2(Long id);
}
