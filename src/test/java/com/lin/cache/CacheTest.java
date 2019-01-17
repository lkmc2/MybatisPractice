package com.lin.cache;

import com.lin.BaseMapperTest;
import com.lin.mapper.RoleMapper;
import com.lin.mapper.UserMapper;
import com.lin.model.SysRole;
import com.lin.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author lkmc2
 * @date 2019/1/17
 * @description 缓存测试
 */
public class CacheTest extends BaseMapperTest {

    // 测试一级缓存
    @Test
    public void testL1Cache() {
        SysUser user1;

        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 查询id为1的用户
            user1 = userMapper.selectById(1L);
            // 对当前获取的对象重新赋值
            user1.setUserName("New Name");

            // 再次查询获取id相同的用户（这里会直接用缓存的数据，不连接数据库查询，这是Mybatis的一级缓存）
            SysUser user2 = userMapper.selectById(1L);
            // 虽然没有更新数据库，但是这个用户名和user1重新赋值的名字相同
            assertEquals("New Name", user2.getUserName());
            // 无论如何，user2和user1完全就是同一个实例
            assertEquals(user1, user2);
        }

        System.out.println("开启一个新Session");

        // 开启一个新Session
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            //  查询id为1的用户
            SysUser user2 = userMapper.selectById(1L);
            // 第二个Session获取的用户名仍然是admin
            assertEquals("admin", user2.getUserName());
            // 这里的user2和前一个session查询的结果是两个不同的实例
            assertNotEquals(user1, user2);

            // 执行删除（执行任何INSERT、UPDATE、DELETE操作都会情况一级缓存，必须再次连接数据库查询）
            userMapper.deleteById(2L);

            // 获取use3
            SysUser user3 = userMapper.selectById(1L);
            // 这里的user2和user3是两个不同的实例
            assertNotEquals(user2, user3);
        }
    }

    // 测试二级缓存
    @Test
    public void testL2Cache() {
        SysRole role1;

        try(SqlSession sqlSession = getSqlSession()) {
            // 获取RoleMapper接口
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            // 查询id为1的角色
            role1 = roleMapper.selectById(1L);
            // 对当前获取的对象重新赋值
            role1.setRoleName("New Name");

            // 再次查询获取id相同的角色（这里会直接用缓存的数据，不连接数据库查询，这是Mybatis的一级缓存）
            SysRole role2 = roleMapper.selectById(1L);
            // 虽然没有更新数据库，但是这个角色名和role1重新赋值的名字相同
            assertEquals("New Name", role2.getRoleName());
            // 无论如何，role2和role1完全就是同一个实例
            assertEquals(role1, role2);
        }

        System.out.println("开启一个新Session");

        // 开启一个新Session
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取RoleMapper接口
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            //  查询id为1的角色（这里使用二级缓存，不连接数据库，将被序列化的缓存进行反序列化，返回不同的实例对象）
            SysRole role2 = roleMapper.selectById(1L);
            // 第二个Session获取的角色名是New Name
            assertEquals("New Name", role2.getRoleName());
            // 这里的role2和前一个session查询的结果是两个不同的实例
            assertNotEquals(role1, role2);

            // 获取use3（这里使用二级缓存，不连接数据库，将被序列化的缓存进行反序列化，返回不同的实例对象）
            SysRole user3 = roleMapper.selectById(1L);
            // 这里的user2和user3是两个不同的实例
            assertNotEquals(role2, user3);
        }
    }

    // 测试脏数据
    @Test
    public void testDirtyData() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

            // 根据用户id选出用户和角色信息
            SysUser user = userMapper.selectUserAndRoleById(1001L);
            assertEquals("普通用户", user.getRole().getRoleName());
            System.out.println("角色名：" + user.getRole().getRoleName());
        }

        System.out.println("开启一个新Session");

        // 开启一个新Session
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取RoleMapper接口
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            // 获取id为2的角色
            SysRole role = roleMapper.selectById(2L);
            role.setRoleName("脏数据");
            roleMapper.updateById(role);

            // 提交修改
            sqlSession.commit();
        }

        System.out.println("开启另一个新Session");

        try(SqlSession sqlSession = getSqlSession()) {
            // 获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 获取RoleMapper接口
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            // 根据用户id选出用户和角色信息
            SysUser user = userMapper.selectUserAndRoleById(1001L);
            // 获取id为2的角色
            SysRole role = roleMapper.selectById(2L);

            assertEquals("普通用户", user.getRole().getRoleName());
            assertEquals("脏数据", role.getRoleName());
            System.out.println("角色名：" + user.getRole().getRoleName());

            // 还原数据
            role.setRoleName("普通用户");
            roleMapper.updateById(role);

            // 提交修改
            sqlSession.commit();
        }
    }

}
