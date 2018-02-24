package com.javaman.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

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
        User user = sqlSession.selectOne("test.findUserById", 18);

        System.out.println(user);

        sqlSession.close();

    }

    @Test
    public void test2() throws IOException {

        String resource = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建回话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> list = sqlSession.selectList("test.findUserByUserName", "peng");

        System.out.println(list);


    }

    @Test
    public void test3() throws IOException {
        String resource = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建回话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setAddress("guangdgong");
        user.setSex("23");
        user.setBirthday(new Date());
        user.setUsername("343423423");
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();

        //获取自增主键

        System.out.println(user.getId());
        sqlSession.close();

    }

    @Test
    public void test4() throws IOException {
        String resource = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建回话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.delete("test.deleteUserById", 24);

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void test5() throws IOException {
        String resource = "SqlMapConfig.xml";

        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建回话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //通过工厂得到sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();

        user.setId(22);
        user.setUsername("weidadezhege");
        user.setBirthday(new Date());
        user.setAddress("foshan");
        user.setSex("2");
        sqlSession.update("test.updateUser", user);

        sqlSession.commit();

        sqlSession.close();
    }

}
