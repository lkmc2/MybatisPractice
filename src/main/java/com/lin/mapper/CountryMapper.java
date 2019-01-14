package com.lin.mapper;

import com.lin.model.Country;

import java.util.List;

/**
 * @author lkmc2
 * @date 2019/1/14
 * @description 国家数据库接口
 */
public interface CountryMapper {
    List<Country> selectAll();
}
