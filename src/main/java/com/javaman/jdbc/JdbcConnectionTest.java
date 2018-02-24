package com.javaman.jdbc;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author pengzhe
 * @date 2018/2/24 17:29
 * @description
 */
public class JdbcConnectionTest {

    @Test
    public void test1() throws SQLException {
        Driver driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://119.23.236.253:3306/test";
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "root1122.");
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }

    public Connection getConnection() throws ClassNotFoundException, IllegalAccessException, InstantiationException,
            SQLException, IOException {

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

        Driver driver = (Driver) Class.forName(driverClass).newInstance();
        Properties info = new Properties();
        info.put("user", user);
        info.put("password", password);
        Connection connect = driver.connect(jdbcUrl, info);
        return connect;
    }

    @Test
    public void test2() throws ClassNotFoundException, SQLException, InstantiationException, IOException, IllegalAccessException {
        Connection connection = getConnection();
        System.out.println(connection);
    }


}
