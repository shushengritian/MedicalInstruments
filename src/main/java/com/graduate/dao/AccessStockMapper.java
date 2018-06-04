package com.graduate.dao;

import com.graduate.model.AccessStock;
import com.graduate.model.AccessStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccessStockMapper {
    int countByExample(AccessStockExample example);

    int deleteByExample(AccessStockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AccessStock record);

    int insertSelective(AccessStock record);

    List<AccessStock> selectByExample(AccessStockExample example);

    AccessStock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AccessStock record, @Param("example") AccessStockExample example);

    int updateByExample(@Param("record") AccessStock record, @Param("example") AccessStockExample example);

    int updateByPrimaryKeySelective(AccessStock record);

    int updateByPrimaryKey(AccessStock record);
}