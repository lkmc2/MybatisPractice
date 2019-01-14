package com.lin.demo;

import com.lin.BaseMapperTest;
import com.lin.mapper.UserMapper;
import com.lin.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description Mapper接口动态代理实现原理测试
 */
public class MyMapperProxyTest extends BaseMapperTest {

    @Test
    public void testMapper() {
       try(SqlSession sqlSession = getSqlSession()) {
           // 获取UserMapper接口
           MyMapperProxy userMapperProxy = new MyMapperProxy(UserMapper.class, sqlSession);
           UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(
                   Thread.currentThread().getContextClassLoader(),
                   new Class[]{UserMapper.class},
                   userMapperProxy);

           // 调用selectAll方法
           List<SysUser> userList = userMapper.selectAll();
           // 列表非空
           Assert.assertNotNull(userList);
           Assert.assertTrue(userList.size() > 1);
       }
    }

}
