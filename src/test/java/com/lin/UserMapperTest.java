package com.lin;

import com.lin.mapper.UserMapper;
import com.lin.model.SysRole;
import com.lin.model.SysRoleExtend;
import com.lin.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
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

    @Test
    public void testInsert() {
        SqlSession sqlSession = getSqlSession();

        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 创建一个用户对象
            SysUser user = new SysUser();
            user.setUserName("tests1");
            user.setUserPassword("123456");
            user.setUserEmail("test1@163.com");
            user.setUserInfo("test info");

            // 正常情况下应该读入一张图片存到byte数组中
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());

            // 插入用户，获取受影响行数
            int effectCount = userMapper.insert(user);
            // 受影响行数必须为1
            Assert.assertEquals(1, effectCount);
            // 用户id未赋值，为空
            Assert.assertNull(user.getId());
        } finally {
            // 为了不影响其他测试，此处选择回滚
            // 默认openSession()是不自动提交的，不回滚也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2() {
        SqlSession sqlSession = getSqlSession();

        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 创建一个用户对象
            SysUser user = new SysUser();
            user.setUserName("tests1");
            user.setUserPassword("123456");
            user.setUserEmail("test1@163.com");
            user.setUserInfo("test info");

            // 正常情况下应该读入一张图片存到byte数组中
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());

            // 插入用户，获取受影响行数
            int effectCount = userMapper.insert2(user);
            // 受影响行数必须为1
            Assert.assertEquals(1, effectCount);
            // 因为用户id从数据库获取id后回写，此值不为空
            Assert.assertNotNull(user.getId());
        } finally {
            // 为了不影响其他测试，此处选择回滚
            // 默认openSession()是不自动提交的，不回滚也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert3() {
        SqlSession sqlSession = getSqlSession();

        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 创建一个用户对象
            SysUser user = new SysUser();
            user.setUserName("tests1");
            user.setUserPassword("123456");
            user.setUserEmail("test1@163.com");
            user.setUserInfo("test info");

            // 正常情况下应该读入一张图片存到byte数组中
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());

            // 插入用户，获取受影响行数
            int effectCount = userMapper.insert3(user);
            // 受影响行数必须为1
            Assert.assertEquals(1, effectCount);
            // 因为用户id从数据库获取id后回写，此值不为空
            Assert.assertNotNull(user.getId());
        } finally {
            // 为了不影响其他测试，此处选择回滚
            // 默认openSession()是不自动提交的，不回滚也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateById() {
        SqlSession sqlSession = getSqlSession();

        try {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 从数据库查询一个用户
            SysUser user = userMapper.selectById(1L);
            // 当前用户名为admin
            Assert.assertEquals("admin", user.getUserName());

            user.setUserName("admin_test");
            user.setUserEmail("test@163.com");

            // 更新数据，获取受影响行数
            int effectCount = userMapper.updateById(user);
            // 受响应行数必须是1
            Assert.assertEquals(1, effectCount);

            // 根据当前id查询修改后的数据
            user = userMapper.selectById(1L);
            // 修改后的名字是admin_test
            Assert.assertEquals("admin_test", user.getUserName());
        } finally {
            // 为了不影响其他测试，此处选择回滚
            // 默认openSession()是不自动提交的，不回滚也不会提交到数据库
            sqlSession.rollback();
            sqlSession.close();
        }
    }

}
