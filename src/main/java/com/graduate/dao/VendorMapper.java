package com.graduate.dao;

import com.graduate.model.Vendor;
import com.graduate.model.VendorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VendorMapper {
    int countByExample(VendorExample example);

    int deleteByExample(VendorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Vendor record);

    int insertSelective(Vendor record);

    List<Vendor> selectByExample(VendorExample example);

    Vendor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Vendor record, @Param("example") VendorExample example);

    int updateByExample(@Param("record") Vendor record, @Param("example") VendorExample example);

    int updateByPrimaryKeySelective(Vendor record);

    int updateByPrimaryKey(Vendor record);
}