package com.graduate.dao;


import com.graduate.model.Vendor;
import com.graduate.model.VendorExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface VendorMapper {
    int countByExample(VendorExample example);

    int countByMap(@Param("map") Map<String,Object> map);

    int deleteByExample(VendorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Vendor record);

    int insertBatch(List<Vendor> list);

    int insertSelective(Vendor record);

    List<Vendor> selectByExample(VendorExample example);

    List<Vendor> selectByMap(@Param("map") Map<String,Object> map);

    Vendor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Vendor record, @Param("example") VendorExample example);

    int updateByExample(@Param("record") Vendor record, @Param("example") VendorExample example);

    int updateByPrimaryKeySelective(Vendor record);

    int updateByPrimaryKey(Vendor record);
}