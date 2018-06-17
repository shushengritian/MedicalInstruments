package com.graduate.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author xiyouquedongxing
 * @date 2018/6/7 21:37
 */
public class BaseImpl {

    private Gson gson;


    public JSONObject selectResult(int count, JSONArray data){
        JSONObject obj = new JSONObject();
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
    public JSONObject addResult(int res){
        JSONObject obj = new JSONObject();
        if (res > 0) {
            obj.put("code","1");
            obj.put("msg","添加成功！");
        } else {
            obj.put("code","0");
            obj.put("msg","添加失败！");
        }
        return obj;
    }
    public JSONObject getByIdResult(JSONObject data){
        JSONObject obj = new JSONObject();
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
    public JSONObject editByIdResult(int res){
        JSONObject obj = new JSONObject();
        if (res > 0) {
            obj.put("code","1");
            obj.put("msg","编辑成功！");
        } else {
            obj.put("code","0");
            obj.put("msg","编辑失败！");
        }
        return obj;
    }
    public JSONObject aiAndSi(int ai, int si){
        JSONObject obj = new JSONObject();
        if (ai > 0 && si > 0) {
            obj.put("code","1");
            obj.put("msg","操作成功！");
        } else {
            obj.put("code","0");
            obj.put("msg","操作失败！");
        }
        return obj;
    }
    public JSONObject delByIdResult(int res){
        JSONObject obj = new JSONObject();
        if (res > 0) {
            obj.put("code","1");
            obj.put("msg","删除成功！");
        } else {
            obj.put("code","0");
            obj.put("msg","删除失败！");
        }
        return obj;
    }
    public JSONObject booleanResult(boolean b){
        JSONObject obj = new JSONObject();
        if (b) {
            obj.put("code","1");
            obj.put("msg","上传成功！");
        } else {
            obj.put("code","0");
            obj.put("msg","上传失败！");
        }
        return obj;
    }

    public Gson getListGson() {
        if (gson == null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gson = gsonBuilder.setDateFormat("yyyy-MM-dd").create();
        }
        return gson;
    }
}
