package com.lin.mapper;

import com.lin.BaseMapperTest;
import com.lin.model.SysRole;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
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
            assertEquals("管理员", role.getRoleName());
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
            assertEquals("管理员", role.getRoleName());
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

    @Test
    public void tesInsert() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取RoleMapper
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            // 创建一个新角色
            SysRole role = new SysRole();

            role.setRoleName("数据库拥有者");
            role.setEnabled(1);
            role.setCreateBy(1);
            role.setCreateTime(new Date());

            // 选择所有角色
            int effectCount = roleMapper.insert(role);
            // 受影响行数必须为1
            assertEquals(1, effectCount);
            // 角色id为空
            assertNull(role.getId());
        } finally {
            // 为了不影响其他测试，此处选择回滚
            // 默认openSession()是不自动提交的，不回滚也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void tesInsert2() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取RoleMapper
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            // 创建一个新角色
            SysRole role = new SysRole();

            role.setRoleName("数据库拥有者");
            role.setEnabled(1);
            role.setCreateBy(1);
            role.setCreateTime(new Date());

            // 选择所有角色
            int effectCount = roleMapper.insert2(role);
            // 受影响行数必须为1
            assertEquals(1, effectCount);
            // 角色id会回写到role上，id非空
            assertNotNull(role.getId());
        } finally {
            // 为了不影响其他测试，此处选择回滚
            // 默认openSession()是不自动提交的，不回滚也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void tesInsert3() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取RoleMapper
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            // 创建一个新角色
            SysRole role = new SysRole();

            role.setRoleName("数据库拥有者");
            role.setEnabled(1);
            role.setCreateBy(1);
            role.setCreateTime(new Date());

            // 选择所有角色
            int effectCount = roleMapper.insert3(role);
            // 受影响行数必须为1
            assertEquals(1, effectCount);
            // 角色id会回写到role上，id非空
            assertNotNull(role.getId());
        } finally {
            // 为了不影响其他测试，此处选择回滚
            // 默认openSession()是不自动提交的，不回滚也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void tesUpdate() {
        SqlSession sqlSession = getSqlSession();
        try {
            // 获取RoleMapper
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            // 修改id为1的角色信息
            SysRole role = new SysRole();
            role.setId(1L);
            role.setRoleName("数据库拥有者");
            role.setEnabled(1);
            role.setCreateBy(1);
            role.setCreateTime(new Date());

            // 选择所有角色
            int effectCount = roleMapper.updateById(role);
            // 受影响行数必须为1
            assertEquals(1, effectCount);
            // 角色id会回写到role上，id非空
            assertNotNull(role.getId());
        } finally {
            // 为了不影响其他测试，此处选择回滚
            // 默认openSession()是不自动提交的，不回滚也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

}