package com.cyx.mysql.utils.JDBCUtil.template;

import com.cyx.mysql.utils.JDBCUtil.JDBCUtil;
import com.cyx.mysql.utils.JDBCUtil.handler.IResultSetHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// JDBC 操作模板
public class JDBCTemplate {

    private JDBCTemplate() {
    }

    /**
     * DML（增删改）操作的模板
     *
     * @param sql 需要执行的 sql 语句
     * @param params 参数
     * @return 受影响行数
     */
    public static int update(String sql, Object... params) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement(sql);
            setStatementParams(statement, params);
            return statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement);
        }
        return 0;
    }

    /**
     * DQL 查询）操作的模板
     *
     * @param sql       需要执行的，带占位符“?”的 DQL 操作 SQL
     * @param handler   结果集处理器，用来做结果集转换为对应对象的操作
     * @param params    sql 参数中 ? 占位符对应的参数
     * @param <T>       需要返回的对象类型
     * @return          查询出来的对象集合（就算是单个对象，也可以放在集合中）
     */
    public static <T> T query(String sql, IResultSetHandler<T> handler, Object... params) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet set = null;

        try {
            connection = JDBCUtil.getConnection();
            statement = connection.prepareStatement(sql);
            setStatementParams(statement, params);
            set = statement.executeQuery();
            return handler.handle(set);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(connection, statement, set);
        }
        return null;
    }

    /**
     * 向预编译语句对象设置参数
     *
     * @param statement 预编译语句对象
     * @param params 参数数组
     */
    private static void setStatementParams(PreparedStatement statement, Object[] params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            statement.setObject(i + 1, params[i]);
        }
    }
}
