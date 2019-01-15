package com.lin.mapper;

import com.lin.example.CountryExample;
import com.lin.model.Country;

import java.util.List;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 国家数据库接口
 */
public interface CountryMapper {
    // 获取所有的国家
    List<Country> selectAll();

    // 根据Example条件进行查询
    List<Country> selectByExample(CountryExample example);
}
