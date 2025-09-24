package com.cyx.jsp.handler;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 对查询的结果集进行处理的接口
 * @param <T>
 */
public interface ResultHandler <T> {

    T handle(ResultSet rs) throws SQLException;
}
