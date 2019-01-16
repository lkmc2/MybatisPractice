package com.lin.mapper;

import com.lin.BaseMapperTest;
import com.lin.model.SysPrivilege;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lkmc2
 * @date 2019/1/15
 * @description 权限数据库测试
 */
public class PrivilegeMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        try (SqlSession sqlSession = getSqlSession()) {
           // 获取PrivilegeMapper接口
            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
            // 查询id为1的权限
            SysPrivilege privilege = privilegeMapper.selectById(1L);
            // 权限不为空
            assertNotNull(privilege);
            // 权限名为用户管理
            assertEquals("用户管理", privilege.getPrivilegeName());
        }
    }

    @Test
    public void testSelectPrivilegeByRoleId() {
        try (SqlSession sqlSession = getSqlSession()) {
            // 获取PrivilegeMapper接口
            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);

            // 根据角色id获取权限
            List<SysPrivilege> privilegeList = privilegeMapper.selectPrivilegeByRoleId(1L);
            for (SysPrivilege privilege : privilegeList) {
                System.out.println("权限名：" + privilege.getPrivilegeName());
            }

            assertTrue(privilegeList.size() > 1);
        }
    }

}