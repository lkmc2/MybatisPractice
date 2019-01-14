package com.lin;

import com.lin.mapper.UserMapper;
import com.lin.model.SysRole;
import com.lin.model.SysRoleExtend;
import com.lin.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 用户数据库测试
 */
public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 查询id为1的用户
            SysUser user = userMapper.selectById(1L);
            // 用户必须非空
            Assert.assertNotNull(user);
            // 用户名必须等于admin
            Assert.assertEquals("admin", user.getUserName());
        }
    }

    @Test
    public void testSelectAll() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 查询所有用户
            List<SysUser> userList = userMapper.selectAll();
            // 用户列表必须非空
            Assert.assertNotNull(userList);
            // 用户数量大于0
            Assert.assertTrue(userList.size() > 0);
        }
    }

    @Test
    public void testSelectRolesByUserId() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 根据用户id获取角色信息
            List<SysRole> userList = userMapper.selectRolesByUserId(1L);
            // 用户列表必须非空
            Assert.assertNotNull(userList);
            // 用户数量大于0
            Assert.assertTrue(userList.size() > 0);
        }
    }

    @Test
    public void testSelectRolesAndUserNameByUserId() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 根据用户id获取角色信息，并带有当前用户名
            List<SysRoleExtend> userList = userMapper.selectRolesAndUserNameByUserId(1L);
            // 用户列表必须非空
            Assert.assertNotNull(userList);
            // 用户数量大于0
            Assert.assertTrue(userList.size() > 0);
        }
    }

    @Test
    public void testSelectRolesAndUserNameByUserId2() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 根据用户id获取角色信息，并带有当前用户名
            List<SysRole> userList = userMapper.selectRolesAndUserNameByUserId2(1L);
            // 用户列表必须非空
            Assert.assertNotNull(userList);
            // 用户数量大于0
            Assert.assertTrue(userList.size() > 0);
        }
    }

}
