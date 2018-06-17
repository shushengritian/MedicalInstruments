package com.graduate.service.impl;

import com.graduate.dao.DepartmentMapper;
import com.graduate.model.Department;
import com.graduate.model.DepartmentExample;
import com.graduate.model.DepartmentExample.Criteria;
import com.graduate.service.DepartmentService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiyouquedongxing
 * @date 2018/6/5 16:59
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public JSONObject listDepartment(String id, String number, String name, String landline,
                                     String status, String pageNo, String pageSize) {
        JSONObject obj = new JSONObject();
        Map<String,Object> map = new HashMap<>(8);
        //查询所有数据
        if (StringUtils.isNotBlank(id)) {
            map.put("id",Integer.parseInt(id));
        }
        if (StringUtils.isNotBlank(number)) {
            map.put("number",number);
        }
        if (StringUtils.isNotBlank(name)) {
            map.put("name",name);
        }
        if (StringUtils.isNotBlank(landline)) {
            map.put("landline",landline);
        }
        if (StringUtils.isNotBlank(status)) {
            map.put("status",status);
        }
        if (StringUtils.isNotBlank(pageNo) && StringUtils.isNotBlank(pageSize)) {
            int startIndex = (Integer.parseInt(pageNo) - 1) * Integer.parseInt(pageSize);
            map.put("startIndex",startIndex);
            map.put("pageSize",Integer.parseInt(pageSize));
        }
        List<Department> list = departmentMapper.selectByMap(map);
        JSONArray data = JSONArray.fromObject(list);
        //查询数据条数
        int count = departmentMapper.countByMap(map);
        if (count > 0) {
            obj.put("code","1");
            obj.put("msg","查询成功！");
            obj.put("count",count);
            obj.put("data",data);
        } else {
            obj.put("code","0");
            obj.put("msg","搜索到0条记录！");
        }
        return obj;
    }

    @Override
    public JSONObject add(String number, String name, String landline, String status) {
        JSONObject obj = new JSONObject();
        Department department = new Department();
        if (StringUtils.isNotBlank(number)) {
            department.setNumber(number);
        }
        if (StringUtils.isNotBlank(name)) {
            department.setName(name);
        }
        if (StringUtils.isNotBlank(landline)) {
            department.setLandline(landline);
        }
        if (StringUtils.isNotBlank(status)) {
            department.setStatus(Byte.parseByte(status));
        }
        department.setCreateTime(new Date());
        department.setModifiedTime(new Date());
        int res = departmentMapper.insert(department);
        if (res > 0) {
            obj.put("code","1");
            obj.put("msg","添加成功！");
        } else {
            obj.put("code","0");
            obj.put("msg","添加失败！");
        }
        return obj;
    }

    @Override
    public JSONObject getDepartmentById(String id) {
        JSONObject obj = new JSONObject();
        Map<String,Object> map = new HashMap<>(1);
        if (StringUtils.isNotBlank(id)) {
            map.put("id",Integer.parseInt(id));
        }
        List<Department> list = departmentMapper.selectByMap(map);
        JSONObject data = JSONArray.fromObject(list).getJSONObject(0);
        if (data.size() > 0) {
            obj.put("code","1");
            obj.put("msg","查询成功！");
            obj.put("data",data);
        } else {
            obj.put("code","0");
            obj.put("msg","搜索到0条记录！");
        }
        return obj;
    }

    @Override
    public JSONObject editById(String id, String number, String name, String landline, String status) {
        JSONObject obj = new JSONObject();
        DepartmentExample example = new DepartmentExample();
        Department department = new Department();
        Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(id)) {
            criteria.andIdEqualTo(Long.parseLong(id));
            department.setId(Long.parseLong(id));
        }
        if (StringUtils.isNotBlank(number)) {
            department.setNumber(number);
        }
        if (StringUtils.isNotBlank(name)) {
            department.setName(name);
        }
        if (StringUtils.isNotBlank(landline)) {
            department.setLandline(landline);
        }
        if (StringUtils.isNotBlank(status)) {
            department.setStatus(Byte.parseByte(status));
        }
        department.setModifiedTime(new Date());
        int res = departmentMapper.updateByExample(department, example);
        if (res > 0) {
            obj.put("code","1");
            obj.put("msg","编辑成功！");
        } else {
            obj.put("code","0");
            obj.put("msg","编辑失败！");
        }
        return obj;
    }

    @Override
    public JSONObject delById(String id) {
        JSONObject obj = new JSONObject();
        int res = departmentMapper.deleteByPrimaryKey(Long.parseLong(id));
        if (res > 0) {
            obj.put("code","1");
            obj.put("msg","删除成功！");
        } else {
            obj.put("code","0");
            obj.put("msg","删除失败！");
        }
        return obj;
    }

}
