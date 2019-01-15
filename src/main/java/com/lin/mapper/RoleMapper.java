package com.lin.mapper;

import com.lin.model.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

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

    // 根据id选择角色（方式2，指定resultMap，指定id需要mybatis 3.3.1版本之后才可以）
    @Results(id = "roleResultMap", value = {
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

    // 选出所有的角色，此处@ResultMap中的值，是复用@Results注解声明的roleResultMap
    @ResultMap("roleResultMap")
    @Select("select * from sys_role")
    List<SysRole> selectAll();

    // 将角色插入数据库，不返回主键
    @Insert({"insert into sys_role(id, role_name, enabled, create_by, create_time) ",
            "values(#{id}, #{roleName}, #{enabled}, #{createBy},",
            "#{createTime, jdbcType=TIMESTAMP})"})
    int insert(SysRole sysRole);

    // 将角色插入数据库（方式2，返回自增主键，使用useGeneratedKeys获取key值，并设置到id属性上）
    @Insert({"insert into sys_role(role_name, enabled, create_by, create_time) ",
             "values(#{roleName}, #{enabled}, #{createBy},",
                    "#{createTime, jdbcType=TIMESTAMP})"})
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(SysRole sysRole);

    // 将角色插入数据库（方式3，返回非自增主键，使用SELECT LAST_INSERT_ID()获取key值，并设置到id属性上）
    @Insert({"insert into sys_role(role_name, enabled, create_by, create_time) ",
            "values(#{roleName}, #{enabled}, #{createBy},",
            "#{createTime, jdbcType=TIMESTAMP})"})
    @SelectKey(statement = "SELECT LAST_INSERT_ID()",
               keyProperty = "id",
               resultType = Long.class,
               before = false) // before为false等效于xml中order为AFTER
    int insert3(SysRole sysRole);
}
