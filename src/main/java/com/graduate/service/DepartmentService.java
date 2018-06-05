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
}
