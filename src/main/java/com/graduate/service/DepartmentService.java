package com.graduate.service;

import net.sf.json.JSONObject;

/**
 * @author xiyouquedongxing
 * @date 2018/6/5 16:59
 */
public interface DepartmentService {
    /**
     * 获取数据字典数据
     * */
    JSONObject listDepartment(String id, String number, String name, String landline,
                              String status, String pageNo, String pageSize);

    /**
     * 新增数据
     *
     */
    JSONObject add(String number, String name, String landline, String status);

    /**
     * 通过ID查询数据
     * */
    JSONObject getDepartmentById(String id);

    /**
     * 通过id获取数据
     *
     */
    JSONObject editById(String id, String number, String name, String landline, String status);

    /**
     * 通过id删除数据
     *
     */
    JSONObject delById(String id);
}
