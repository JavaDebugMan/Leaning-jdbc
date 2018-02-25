package com.javaman.dao;

import com.javaman.mybatis.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author pengzhe
 * @date 2018/2/25 09:44
 * @description
 */
public class UserDaoImplTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws IOException {
        String resource = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void test() throws Exception {
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User userById = userDao.findUserById(22);
        System.out.println(userById);
    }
}
