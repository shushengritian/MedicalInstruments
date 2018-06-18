package com.graduate.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.graduate.model.User;
import net.sf.json.JSONObject;

import javax.json.JsonObject;
import java.util.List;

/**
 * @author xiyouquedongxing
 * @date 2018-04-14
 */
public interface IUserService {


    /**
     * 用户登陆
     * @param username 用户名
     * @param password 密码
     * @return boolean 查询结果
     * */
    List<User> login(String username, String password);

    /**
     * 用户登陆
     * @param username 用户名
     * @param password 密码
     * @return boolean 查询结果
     * */
    JSONObject getUserInfo(String username, String password);

    /**
     * 用户登陆
     * @param loginAccount
     * @param oldPassword
     * @param newPassword
     * @return boolean 查询结果
     * */
    JSONObject updatePassword(String loginAccount, String oldPassword, String newPassword, String id);

    /**
     * 用户登陆
     * @param userName
     * @param phone
     * @param email
     * @return boolean 查询结果
     * */
    JSONObject updateUserInfo(String userName, String phone, String email, String id);

}