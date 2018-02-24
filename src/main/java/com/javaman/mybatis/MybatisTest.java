package com.javaman.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author pengzhe
 * @date 2018/2/24 22:15
 * @description
 */
public class MybatisTest {

    @Test
    public void test() throws IOException {

        String resource = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建回话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //操作数据库
       User user= sqlSession.selectOne("test.findUserById", 18);

        System.out.println(user);

        sqlSession.close();

    }


}
