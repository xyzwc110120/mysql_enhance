package com.cyx.mysql.utils.JDBCUtil.handler;

import java.sql.ResultSet;

public interface IResultSetHandler<T> {

    T handle(ResultSet set) throws Exception;
}
