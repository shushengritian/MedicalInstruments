package com.graduate.dao;

import com.graduate.model.DataDictionary;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author xiyouquedongxing
 * @date 2018/5/26 23:34
 */
public interface HomeMapper {

    List<DataDictionary> listDataDictionary(@Param("map") Map<String,Object> map);

    /**
     * 查询总条数
     * @return int
     * */
    int count(@Param("map") Map<String,Object> map);

    /**
     * 新增数据
     *
     */
    int add(@Param("map") Map<String,Object> map);

    /**
     * 根据id查询
     *
     * */
    List<DataDictionary> getDataById(@Param("id") int id);

    /**
     *  根据id修改数据
     * */
    int editDataById(@Param("map") Map<String,Object> map);

    /**
     * 通过id删除数据
     * @return int
     * */
    int delById(@Param("id") int id);
}
