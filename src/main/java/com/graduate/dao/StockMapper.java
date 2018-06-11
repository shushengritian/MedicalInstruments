package com.graduate.dao;

import com.graduate.model.Stock;
import com.graduate.model.StockExample;
import java.util.List;
import java.util.Map;

import com.graduate.model.SuppliesStock;
import org.apache.ibatis.annotations.Param;

public interface StockMapper {
    int countByExample(StockExample example);

    int countByMap(@Param("map") Map<String,Object> map);

    int deleteByExample(StockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Stock record);

    int insertSelective(Stock record);

    List<Stock> selectByExample(StockExample example);

    List<SuppliesStock> selectByMap(@Param("map") Map<String,Object> map);

    Stock selectByPrimaryKey(Long id);

    Stock selectByHcNo(@Param("hcNo") String hcNo);

    int updateByExampleSelective(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByExample(@Param("record") Stock record, @Param("example") StockExample example);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
}