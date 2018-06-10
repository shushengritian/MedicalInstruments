package com.graduate.dao;

import com.graduate.model.Supplies;
import com.graduate.model.SuppliesExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SuppliesMapper {
    int countByExample(SuppliesExample example);

    int countByMap(@Param("map") Map<String,Object> map);

    int deleteByExample(SuppliesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Supplies record);

    int insertSelective(Supplies record);

    List<Supplies> selectByExample(SuppliesExample example);

    List<Supplies> selectByMap(@Param("map") Map<String,Object> map);

    Supplies selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Supplies record, @Param("example") SuppliesExample example);

    int updateByExample(@Param("record") Supplies record, @Param("example") SuppliesExample example);

    int updateByPrimaryKeySelective(Supplies record);

    int updateByPrimaryKey(Supplies record);
}