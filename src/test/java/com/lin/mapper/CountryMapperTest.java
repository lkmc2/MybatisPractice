package com.lin.mapper;

import com.lin.BaseMapperTest;
import com.lin.example.CountryExample;
import com.lin.model.Country;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 国家Mapper测试
 */
public class CountryMapperTest extends BaseMapperTest {

    @Test
    public void testSelectAll() {
        try (SqlSession sqlSession = getSqlSession()) {
            // 执行mapper中的sql语句，获取国家列表
            List<Country> countryList = sqlSession.selectList("com.lin.mapper.CountryMapper.selectAll");
            printCountryList(countryList);
        }
    }

    private void printCountryList(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.printf("%-4d%4s%4s\n",
                    country.getId(), country.getCountryname(), country.getCountrycode());
        }
    }

    @Test
    public void testExample() {
        try(SqlSession sqlSession = getSqlSession()) {
            // 获取CountryMapper接口
            CountryMapper countryMapper = sqlSession.getMapper(CountryMapper.class);

            // 创建Example对象
            CountryExample example = new CountryExample();
            // 设置排序规则
            example.setOrderByClause("id desc, countryname asc");
            // 设置distinct去重
            example.setDistinct(true);
            // 创建条件
            CountryExample.Criteria criteria = example.createCriteria();
            // id >= 1
            criteria.andIdGreaterThanOrEqualTo(1);
            // id < 4
            criteria.andIdLessThan(4);
            // country_code like '%U%'，最容易出错的地方，注意like必须自己写上通配符的位置
            criteria.andCountrycodeLike("%U%");
            // or 的情况
            CountryExample.Criteria or = example.or();
            // country_name = 中国
            or.andCountrynameEqualTo("中国");
            // 执行查询
            List<Country> countryList = countryMapper.selectByExample(example);
            printCountryList(countryList);
        }
    }

}
