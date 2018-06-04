package com.graduate.dao;

import com.graduate.model.DepartmentStock;
import com.graduate.model.DepartmentStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentStockMapper {
    int countByExample(DepartmentStockExample example);

    int deleteByExample(DepartmentStockExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DepartmentStock record);

    int insertSelective(DepartmentStock record);

    List<DepartmentStock> selectByExample(DepartmentStockExample example);

    DepartmentStock selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DepartmentStock record, @Param("example") DepartmentStockExample example);

    int updateByExample(@Param("record") DepartmentStock record, @Param("example") DepartmentStockExample example);

    int updateByPrimaryKeySelective(DepartmentStock record);

    int updateByPrimaryKey(DepartmentStock record);
}