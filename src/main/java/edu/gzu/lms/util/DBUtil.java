package edu.gzu.lms.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// 数据库工具类
public class DBUtil {

    //保证Connection对每个请求都是唯一的.这个时候就可以用到ThreadLocal了,保证每个线程都有自己的连接.
    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();
    private static DruidDataSource druidDataSource = null;

    static {
        Properties prop = new Properties();
        try {
            prop.load(DBUtil.class.getClassLoader().getResourceAsStream("druid.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            druidDataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //获取连接
    public static Connection getConnection() {
        Connection connection = connectionThreadLocal.get();

        try {
            if (null == connection) {
                connection = druidDataSource.getConnection();
                connectionThreadLocal.set(connection);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //关闭连接
    public static void closeConnection() {
        Connection connection = connectionThreadLocal.get();
        if (connection != null ) {
            try {
                connection.close();
                connectionThreadLocal.remove();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }


    public static void close(ResultSet resultSet, PreparedStatement statement) {
        close(resultSet);
        close(statement);
    }
}
