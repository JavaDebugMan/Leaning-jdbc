package com.javaman.mapper;

import com.javaman.mybatis.User;

/**
 * @author pengzhe
 * @date 2018/2/25 09:34
 * @description
 */
public interface UserMapper {

 /*   User findUserById(int id) throws Exception;

    void insertUser(User user) throws Exception;

    void deleteUser(int id) throws Exception;*/

    /**
     * id
     * @param id
     * @return
     */
    User findUserById(int id);




}
