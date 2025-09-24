package com.cyx.jsp.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.cyx.jsp.handler.ResultHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

    private static DruidDataSource dataSource = new DruidDataSource();


    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 初始化数据源
     * @param props
     */
    public static void InitDataSource(Properties props) {
        dataSource.configFromPropety(props);
    }

    /**
     * 关闭数据源
     */
    public static void DestroyDataSource() {
        dataSource.close();
    }

    /**
     * 封装的万能查询
     * @param sql
     * @param handler
     * @param params
     * @return
     * @param <T>
     */
    public static <T> T query(String sql, ResultHandler<T> handler, Object...params) {
        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            if(params != null && params.length > 0) {
                for(int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            ResultSet rs = ps.executeQuery();
            T t = handler.handle(rs);
            rs.close();
            ps.close();
            conn.close();
            return t;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int update(String sql, Object...params) {
        Connection conn = null;
        int affectRows = -1;
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            if (params != null && params.length > 0) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            affectRows = ps.executeUpdate();
            conn.commit();
            ps.close();
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
        return affectRows;
    }
}
