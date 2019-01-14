package com.lin;

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

}
