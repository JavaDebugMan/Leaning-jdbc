package com.javaman.test;

import com.javaman.dao.UserDao;
import com.javaman.dao.UserDaoImpl;
import com.javaman.mapper.UserMapper;
import com.javaman.mybatis.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author pengzhe
 * @date 2018/2/25 11:20
 * @description
 */
public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws IOException {
        String resource = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void test() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.findUserById(22);
        System.out.println(userById);
    }

    @Test
    public void test2() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> peng = mapper.findUserByUserName("peng");
        System.out.println(peng);
    }

}
