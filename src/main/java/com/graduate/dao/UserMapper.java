package com.graduate.dao;

import com.graduate.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author xiyouquedongxing
 * @date 2018-04-14
 */
public interface UserMapper {

    User selectUser(long id);

    List<User> getUser(Map<String,String> map);

}