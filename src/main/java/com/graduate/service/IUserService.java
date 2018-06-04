package com.graduate.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.graduate.model.User;

import javax.json.JsonObject;

/**
 * @author xiyouquedongxing
 * @date 2018-04-14
 */
public interface IUserService {

    /**
     * 查询用户信息
     * @param userId 用户id
     * @return User 用户实体类
     */
    User selectUser(long userId);

    /**
     * 用户登陆
     * @param username 用户名
     * @param password 密码
     * @return boolean 查询结果
     * */
    boolean login(String username, String password);
}