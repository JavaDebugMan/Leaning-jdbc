package com.javaman.dao;

import com.javaman.mybatis.User;

/**
 * @author pengzhe
 * @date 2018/2/25 09:34
 * @description
 */
public interface UserDao {

    User findUserById(int id) throws Exception;

    void insertUser(User user) throws Exception;

    void deleteUser(int id) throws Exception;

}
