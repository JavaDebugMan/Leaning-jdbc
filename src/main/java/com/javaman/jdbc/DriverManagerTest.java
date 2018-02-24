package com.javaman.jdbc;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author pengzhe
 * @date 2018/2/24 17:55
 * @description
 */
public class DriverManagerTest {

    @Test
    public void test() throws IOException, SQLException, ClassNotFoundException {
        String driverClass = null;
        String jdbcUrl = null;
        String user = null;
        String password = null;

        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        driverClass = properties.getProperty("driver");
        jdbcUrl = properties.getProperty("jdbcUrl");
        user = properties.getProperty("user");
        password = properties.getProperty("password");
        /*加载数据库驱动*/
        Class.forName(driverClass);
        //DriverManager.getConnection获取数据库连接
        Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
        Connection connection2 = DriverManager.getConnection(jdbcUrl, user, password);
        boolean autoCommit = connection.getAutoCommit();
        int transactionIsolation = connection.getTransactionIsolation();
        System.out.println(autoCommit);
        System.out.println(transactionIsolation);
        System.out.println("connection1====="+connection);
        System.out.println("connection2====="+connection2);

    }


}
