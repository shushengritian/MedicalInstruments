package com.graduate.dao;

import com.graduate.model.Contract;
import com.graduate.model.ContractExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;

public interface ContractMapper {
    int countByExample(ContractExample example);

    int countByMap(@Param("map") Map<String,Object> map);

    int deleteByExample(ContractExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Contract record);

    int insertSelective(Contract record);

    List<Contract> selectByMap(@Param("map") Map<String,Object> map);

    List<Contract> selectByExample(ContractExample example);

    Contract selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Contract record, @Param("example") ContractExample example);

    int updateByExampleWithBLOBs(@Param("record") Contract record, @Param("example") ContractExample example);

    int updateByExample(@Param("record") Contract record, @Param("example") ContractExample example);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKeyWithBLOBs(Contract record);

    int updateByPrimaryKey(Contract record);
}