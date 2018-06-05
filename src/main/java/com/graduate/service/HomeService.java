package com.graduate.service;

import net.sf.json.JSONObject;

/**
 * @author xiyouquedongxing
 * @date 2018/5/25 20:08
 */
public interface HomeService {
    /**
     * 获取数据字典数据
     * */
    JSONObject listDateDictionary(String id, String columnName, String insideValue, String exteriorValue, String pageNo, String pageSize);

    /**
     * 新增数据
     *
     */
    JSONObject add(String columnName, String insideValue, String exteriorValue);

    /**
     * 通过id获取数据
     *
     */
    JSONObject getById(int id);

    /**
     * 通过id获取数据
     *
     */
    JSONObject editById(String id, String columnName, String insideValue, String exteriorValue);

    /**
     * 通过id删除数据
     *
     */
    JSONObject delById(int id);
}
