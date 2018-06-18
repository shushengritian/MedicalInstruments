package com.graduate.dao;

import com.graduate.model.Supplies;
import com.graduate.model.SuppliesExample;
import java.util.List;
import java.util.Map;

import com.graduate.model.SuppliesStock;
import org.apache.ibatis.annotations.Param;

public interface SuppliesMapper {
    int countByExample(SuppliesExample example);

    int countByMap(@Param("map") Map<String,Object> map);

    int deleteByExample(SuppliesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Supplies record);

    int insertBatch(List<Supplies> list);

    int insertSelective(Supplies record);

    List<Supplies> selectByExample(SuppliesExample example);

    List<Supplies> selectByMap(@Param("map") Map<String,Object> map);

    Supplies selectByPrimaryKey(Long id);

    Supplies selectByHcNo(String hcNo);

    int updateByExampleSelective(@Param("record") Supplies record, @Param("example") SuppliesExample example);

    int updateByExample(@Param("record") Supplies record, @Param("example") SuppliesExample example);

    int updateByPrimaryKeySelective(Supplies record);

    int updateByPrimaryKey(Supplies record);
}