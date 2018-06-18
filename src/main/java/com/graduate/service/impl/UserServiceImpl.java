package com.graduate.service.impl;

import com.graduate.dao.UserMapper;
import com.graduate.model.User;
import com.graduate.model.UserExample;
import com.graduate.model.UserExample.Criteria;
import com.graduate.service.IUserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * User Class
 *
 * @author xiyouquedongxing
 * @date 2018-04-14
 * */
@Service("userService")
public class UserServiceImpl extends BaseImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public List<User> login(String username, String password) {
        Map<String,String> map = new HashMap<String,String>(2);
        if (StringUtils.isNotBlank(username)) {
            map.put("username",username);
        }
        if (StringUtils.isNotBlank(password)) {
            map.put("password",password);
        }
        List<User> list = userMapper.getUser(map);
        System.out.println("查询结果："+list);
        return list;
    }

    @Override
    public JSONObject getUserInfo(String username, String password) {
        Map<String,String> map = new HashMap<String,String>(2);
        if (StringUtils.isNotBlank(username)) {
            map.put("username",username);
        }
        if (StringUtils.isNotBlank(password)) {
            map.put("password",password);
        }
        List<User> list = userMapper.getUser(map);
        if (list.size() < 1) {
            JSONObject obj = new JSONObject();
            obj.put("code","0");
            obj.put("msg","未查询到用户信息");
            return obj;
        }
        String str = getListGson().toJson(list);
        JSONArray data = JSONArray.fromObject(str);
        JSONObject obj = data.getJSONObject(0);
        return getByIdResult(obj);
    }

    @Override
    public JSONObject updatePassword(String loginAccount, String oldPassword, String newPassword, String id) {
        Map<String,Object> map = new HashMap<>(6);
        if (StringUtils.isNotBlank(id)) {
            map.put("id",Long.parseLong(id));
        }
        if (StringUtils.isNotBlank(loginAccount)) {
            map.put("loginAccount",loginAccount);
        }
        if (StringUtils.isNotBlank(oldPassword)) {
            map.put("oldPassword",oldPassword);
        }
        if (StringUtils.isNotBlank(newPassword)) {
            map.put("newPassword",newPassword);
        }
        map.put("modifiedTime",format.format(new Date()));
        int i = userMapper.updateByMap(map);
        return aiAndSi(i, 1);
    }

    @Override
    public JSONObject updateUserInfo(String userName, String phone, String email, String id) {
        Map<String,Object> map = new HashMap<>(6);
        if (StringUtils.isNotBlank(id)) {
            map.put("id",Long.parseLong(id));
        }
        if (StringUtils.isNotBlank(userName)) {
            map.put("userName",userName);
        }
        if (StringUtils.isNotBlank(phone)) {
            map.put("phone",phone);
        }
        if (StringUtils.isNotBlank(email)) {
            map.put("email",email);
        }
        map.put("modifiedTime",format.format(new Date()));
        int i = userMapper.updateInfoByMap(map);
        return aiAndSi(i, 1);
    }

}