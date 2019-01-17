package com.lin.plugin;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.*;

import java.sql.Statement;
import java.util.*;

/**
 * @author lkmc2
 * @date 2019/1/17
 * @description Mybatis Map类型下划线key转小写驼峰形式插件
 */
@Intercepts(@Signature(
        type = ResultSetHandler.class,
        method = "handleResultSets",
        args = {Statement.class}
))
@SuppressWarnings({"unchecked"})
public class CameHumpInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 先执行得到结果，再对结果进行处理
        List<Object> list = (List<Object>) invocation.proceed();

        for (Object object : list) {
            // 如果结果是Map类型，就对Map的key进行转换
            if (object instanceof Map) {
                processMap((Map) object);
            } else {
                break;
            }
        }
        return list;
    }

    // 处理Map类型
    private void processMap(Map<String, Object> map) {
        Set<String> keySet = new HashSet<>(map.keySet());
        for (String key : keySet) {
            // 将以大写开头的字符串转换成小写，如果包含下划线也会处理为驼峰
            // 此处只通过这两个简单的标识来判断是否进行转换
            if (key.charAt(0) >= 'A'
                    && key.charAt(0) <= 'Z'
                    || key.contains("_")) {
                Object value = map.get(key);
                map.remove(key);
                map.put(underlineToCamelhump(key), value);
            }
        }
    }

    // 将下划线风格转换为驼峰风格
    private String underlineToCamelhump(String inputString) {
        StringBuilder sb = new StringBuilder();

        // 下一个字符是否是大写
        boolean nextUpperCase = false;

        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);

            // 如果字符等于下划线，且不是第一个字符，那么下一个字符是大写
            if (c == '_') {
                if (sb.length() > 0) {
                    nextUpperCase = true;
                }

            } else {
                // 如果标记此字符是大写，那么转换成大写
                if (nextUpperCase) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    // 如果不是大写那么转换成小写
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        return sb.toString();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
