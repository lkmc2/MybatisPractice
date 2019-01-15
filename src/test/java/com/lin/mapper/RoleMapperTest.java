package com.lin.mapper;

import com.lin.BaseMapperTest;
import com.lin.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lkmc2
 * @date 2019/1/15
 * @description 角色数据库测试
 */
public class RoleMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取RoleMapper
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            // 选择id为1的角色
            SysRole role = roleMapper.selectById(1L);
            // 角色必须非空
            assertNotNull(role);
            assertNotNull(role.getId());
        }
    }

    @Test
    public void testSelectById2() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取RoleMapper
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            // 选择id为1的角色
            SysRole role = roleMapper.selectById2(1L);
            // 角色必须非空
            assertNotNull(role);
            assertNotNull(role.getId());
        }
    }

    @Test
    public void testSelectAll() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取RoleMapper
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            // 选择所有角色
            List<SysRole> roleList = roleMapper.selectAll();
            // 角色必须非空
            assertNotNull(roleList);
            // 角色列表必须大于0
            assertTrue(roleList.size() > 0);
        }
    }

}