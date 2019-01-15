package com.lin.mapper;

import com.lin.model.SysRole;
import org.apache.ibatis.annotations.Select;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 角色数据库接口
 */
public interface RoleMapper {
    // 根据id选择用户角色，@Select使用文本拼接和字符串数组都可以
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
}
