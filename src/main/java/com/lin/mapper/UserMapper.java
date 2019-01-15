package com.lin.mapper;

import com.lin.model.SysRole;
import com.lin.model.SysRoleExtend;
import com.lin.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 用户数据库接口
 */
public interface UserMapper {
    // 根据id获取用户
    SysUser selectById(Long id);

    // 获取所有用户
    List<SysUser> selectAll();

    // 根据用户id获取角色信息
    List<SysRole> selectRolesByUserId(Long userId);

    // 根据用户id获取角色信息，并带有当前用户名
    List<SysRoleExtend> selectRolesAndUserNameByUserId(Long userId);

    // 根据用户id获取角色信息，并带有当前用户名（方式2）
    List<SysRole> selectRolesAndUserNameByUserId2(Long userId);

    // 新增用户
    int insert(SysUser sysUser);

    // 新增用户（带主键值）
    int insert2(SysUser sysUser);

    // 新增用户（带主键值，方式2）
    int insert3(SysUser sysUser);

    // 根据主键更新
    int updateById(SysUser sysUser);

    // 根据主键删除
    int deleteById(Long id);

    // 根据主键删除（方法名相同时，会同时匹配xml中的同一个delete标签）
    int deleteById(SysUser sysUser);

    // 根据用户id和角色的enabled状态获取用户的角色
    // 当参数超过1个时，需要加上@Param注解，或者在xml写#{0}或#{param1}表示第一个参数，剩下的以此类推
    List<SysRole> selectRolesByUserIdAndRoleEnabled(
            @Param("userId") Long userId,
            @Param("enabled") Integer enabled);

    // 根据用户id和角色的enabled状态获取用户的角色（方式2，使用实体类中的属性）
    List<SysRole> selectRolesByUserAndRole(
            @Param("user") SysUser user,
            @Param("role") SysRole role);

    // 根据条件进行查询用户：
    // 1.当只输入用户名时，需要根据用户名进行模糊查询
    // 2.当只输入邮箱时，根据邮箱进行完全匹配
    // 3.当同时输入用户名和邮箱时，用这两个条件去查询匹配的用户
    List<SysUser> selectByUser(SysUser sysUser);

    // 根据id选择性更新属性
    int updateByIdSelective(SysUser sysUser);

    // 根据用户id或用户名查询
    SysUser selectByIdOrUserName(SysUser sysUser);

    // 根据用户id集合查询
    List<SysUser> selectByIdList(List<Long> idList);

    // 批量插入用户信息
    int insertList(List<SysUser> userList);

    // 通过Map更新列
    int updateByMap(Map<String, Object> map);

    // 根据用户id获取用户信息和用户的角色信息
    SysUser selectUserAndRoleById(Long id);

    // 根据用户id获取用户信息和用户的角色信息（方式2，使用resultMap作为返回值）
    SysUser selectUserAndRoleById2(Long id);

    // 根据用户id获取用户信息和用户的角色信息（方式3，使用resultMap作为返回值，association标签的嵌套查询）
    SysUser selectUserAndRoleByIdSelect(Long id);
}
