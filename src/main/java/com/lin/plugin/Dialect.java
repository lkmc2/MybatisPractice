package com.lin.plugin;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Properties;

/**
 * @author lkmc2
 * @date 2019/1/17
 * @description 数据库方言，针对不同数据库分别实现
 */
public interface Dialect {
    /**
     * 跳过count和分页查询
     *
     * @param msId            执行的Mybatis方法全名
     * @param parameterObject 方法参数
     * @param rowBounds       分页参数
     * @return true跳过，返回默认查询结果，false则执行分页查询
     */
    boolean skip(String msId, Object parameterObject, RowBounds rowBounds);

    /**
     * 执行分页前，返回true会进行count查询，返回false会继续下面的beforePage判断
     *
     * @param msId            执行的Mybatis方法全名
     * @param parameterObject 方法参数
     * @param rowBounds       分页参数
     * @return true跳过，返回默认查询结果，false则执行分页查询
     */
    boolean beforeCount(String msId, Object parameterObject, RowBounds rowBounds);

    /**
     * 生成count查询sql
     *
     * @param boundSql        绑定SQL对象
     * @param parameterObject 方法参数
     * @param rowBounds       分页参数
     * @param countKey        count缓存key
     * @return count查询sql
     */
    String getCountSql(BoundSql boundSql, Object parameterObject, RowBounds rowBounds, CacheKey countKey);

    /**
     * 执行完count查询后
     *
     * @param count           查询结果总数
     * @param parameterObject 方法参数
     * @param rowBounds       分页参数
     */
    void afterCount(long count, Object parameterObject, RowBounds rowBounds);

    /**
     * 执行分页前，返回true会进行分页查询，返回false会返回默认查询结果
     *
     * @param msId            查询结果总数
     * @param parameterObject 方法参数
     * @param rowBounds       分页参数
     */
    boolean beforePage(String msId, Object parameterObject, RowBounds rowBounds);

    /**
     * 生成分页查询sql
     *
     * @param boundSql        绑定SQL对象
     * @param parameterObject 方法参数
     * @param rowBounds       分页参数
     * @param pageKey        count缓存key
     * @return count查询sql
     */
    String getPageSql(BoundSql boundSql, Object parameterObject, RowBounds rowBounds, CacheKey pageKey);

    /**
     * 分页查询后，处理分页结果，拦截器中直接return该方法的返回值
     *
     * @param pageList        分页查询结果
     * @param parameterObject 方法参数
     * @param rowBounds       分页参数
     * @return 分页结果的返回值
     */
    Object afterPage(List pageList, Object parameterObject, RowBounds rowBounds);

    /**
     * 设置参数
     *
     * @param properties 插件参数
     */
    void setProperties(Properties properties);
}
