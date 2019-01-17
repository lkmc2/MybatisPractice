package com.lin.mapper;

import com.lin.model.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 角色数据库接口
 * 当该类只使用注解写SQL时，开启二级缓存只需要给类配置@CacheNamespace注解
 * 如果该类同时使用了注解和xml写SQL，那么需要配置@CacheNamespaceRef注解，同时也要配置xml文件的二级缓存
 */
@CacheNamespaceRef(RoleMapper.class)
public interface RoleMapper {
    // 根据id选择角色，@Selet使用文本拼接和字符串数组都可以
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

    // 根据id更新角色
    @Update({"update sys_role",
            "set role_name = #{roleName},",
                "enabled = #{enabled},",
                "create_by = #{createInfo.createBy},",
                "create_time = #{createInfo.createTime, jdbcType=TIMESTAMP}",
            "where id = #{id}" })
    int updateById(SysRole sysRole);

    // 根据id删除角色
    @Delete("delete from sys_role where id = #{id}")
    int deleteById(Long id);

    // 根据id选出角色
    SysRole selectRoleById(Long id);

    // 选出所有的角色和角色对应的权限
    List<SysRole> selectAllRoleAndPrivileges();

    // 根据用户id选出角色列表
    List<SysRole> selectRoleByUserId(Long userId);

    // 根据用户的id获取用户的角色信息（当enabled为1时，角色信息会包含权限信息，enabled为0时，角色不包含权限信息）
    List<SysRole> selectRoleByUserIdChoose(Long userId);
}
