package com.lin.cache;

import com.lin.BaseMapperTest;
import com.lin.mapper.UserMapper;
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
            // 这里的user和user3时两个不同的实例
            assertNotEquals(user2, user3);
        }
    }

}
