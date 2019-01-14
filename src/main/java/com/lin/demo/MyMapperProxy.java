package com.lin.demo;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description Mapper接口动态代理实现原理
 */
public class MyMapperProxy<T> implements InvocationHandler {
    private Class<T> mapperInterface;
    private SqlSession sqlSession;

    public MyMapperProxy(Class<T> mapperInterface, SqlSession sqlSession) {
        this.mapperInterface = mapperInterface;
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 针对不同sql的类型，需要调用sqlSession的不同方法
        // 接口方法中的参数也有很多种情况，这里只考虑没有参数的情况
        // getCanonicalName()是获取带包名的类名
        List<T> list = sqlSession.selectList(mapperInterface.getCanonicalName() + "." + method.getName());
        // 返回值也有很多种情况，这里不做处理直接返回
        return list;
    }
}
