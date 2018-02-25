package com.javaman.mapper;

import com.javaman.mybatis.User;

import java.util.List;

/**
 * @author pengzhe
 * @date 2018/2/25 09:34
 * @description
 */
public interface UserMapper {

    /**
     * id
     *
     * @param id
     * @return
     */
    User findUserById(int id);

    /**
     * find
     *
     * @param name
     * @return
     */
    List<User> findUserByUserName(String name);

    /**
     * insert
     *
     * @param user
     */
    void insertUser(User user);

    /**
     * delete
     *
     * @param id
     */
    void deleteUserById(int id);


}
