package com.lin.mapper;

import com.lin.example.CountryExample;
import com.lin.model.Country;
import org.apache.ibatis.annotations.Param;

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

    // 根据Example选择性更新国家信息
    int updateByExampleSelective(@Param("record") Country record, @Param("example")CountryExample example);

    // 根据Example进行删除
    int deleteByExample(CountryExample example);

    // 根据Example进行统计
    int countByExample(CountryExample example);
}
