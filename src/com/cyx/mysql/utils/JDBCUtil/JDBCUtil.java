package com.cyx.mysql.utils.JDBCUtil;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {

    private static DataSource source = null;

    static {
        try {
            Properties properties = new Properties();
            // 通过类加载器（ClassLoader）获取 dbcp.properties 文件并转化为流
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));

            // 通过 properties 配置文件中的键值来创建 BasicDataSource 对象。
            source = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return source.getConnection();
    }

    /**
     * 资源关闭方法（针对于 DML 操作）
     */
    public static void close(Connection connection, Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (Exception ignored) {
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ignored) {
            }
        }

    }

    /**
     * 资源关闭方法（针对于 DQL 操作）
     */
    public static void close(Connection connection, Statement statement, ResultSet set) {
        try {
            if (set != null) {
                set.close();
            }
        } catch (Exception ignored) {
        } finally {
            close(connection, statement);
        }
    }

}
