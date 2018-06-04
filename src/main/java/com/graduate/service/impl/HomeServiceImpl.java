package com.graduate.service.impl;

import com.graduate.dao.HomeMapper;
import com.graduate.model.DataDictionary;
import com.graduate.service.HomeService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiyouquedongxing
 * @date 2018/5/25 20:09
 */
@Service("homeServiceImpl")
public class HomeServiceImpl implements HomeService {

    @Resource
    private HomeMapper homeMapper;
    /**
     * 查询数据字典数据
     * */
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public JSONObject listDateDictionary(String id, String columnName, String insideValue, String exteriorValue, String pageNo, String pageSize) {
        JSONObject obj = new JSONObject();
        Map<String,Object> map = new HashMap<>();
        //查询所有数据
        if (StringUtils.isNotBlank(id)) {
            map.put("id",Integer.parseInt(id));
        }
        if (StringUtils.isNotBlank(columnName)) {
            map.put("columnName",columnName);
        }
        if (StringUtils.isNotBlank(insideValue)) {
            map.put("insideValue",insideValue);
        }
        if (StringUtils.isNotBlank(exteriorValue)) {
            map.put("exteriorValue",exteriorValue);
        }
        if (StringUtils.isNotBlank(pageNo) && StringUtils.isNotBlank(pageSize)) {
            int startIndex = (Integer.parseInt(pageNo) - 1) * Integer.parseInt(pageSize);
            map.put("startIndex",startIndex);
            map.put("pageSize",Integer.parseInt(pageSize));
        }

        List<DataDictionary> list = homeMapper.listDataDictionary(map);
        JSONArray data = JSONArray.fromObject(list);
        //查询数据条数
        int count = homeMapper.count(map);
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
    public JSONObject add(String columnName, String insideValue, String exteriorValue) {
        JSONObject obj = new JSONObject();
        Map<String,Object> map = new HashMap<>();
        if (StringUtils.isNotBlank(columnName)) {
            map.put("columnName",columnName);
        }
        if (StringUtils.isNotBlank(insideValue)) {
            map.put("insideValue",insideValue);
        }
        if (StringUtils.isNotBlank(exteriorValue)) {
            map.put("exteriorValue",exteriorValue);
        }
        String currentTime = format.format(new Date());
        map.put("currentTime",currentTime);
        int res = homeMapper.add(map);
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
    public JSONObject getById(int id) {
        JSONObject obj = new JSONObject();
        //查询所有数据
        List<DataDictionary> list = homeMapper.getDataById(id);
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
    public JSONObject editById(String id, String columnName, String insideValue, String exteriorValue) {
        JSONObject obj = new JSONObject();
        Map<String,Object> map = new HashMap<>();
        if (StringUtils.isNotBlank(id)) {
            map.put("id",Integer.parseInt(id));
        }
        if (StringUtils.isNotBlank(columnName)) {
            map.put("columnName",columnName);
        }
        if (StringUtils.isNotBlank(insideValue)) {
            map.put("insideValue",insideValue);
        }
        if (StringUtils.isNotBlank(exteriorValue)) {
            map.put("exteriorValue",exteriorValue);
        }
        String currentTime = format.format(new Date());
        map.put("currentTime",currentTime);
        int res = homeMapper.editDataById(map);
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
    public JSONObject delById(int id) {
        JSONObject obj = new JSONObject();
        int res = homeMapper.delById(id);
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
