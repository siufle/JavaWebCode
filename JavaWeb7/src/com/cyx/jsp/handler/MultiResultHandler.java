package com.cyx.jsp.handler;

import org.apache.commons.beanutils.BeanUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiResultHandler<T> implements ResultHandler<List<T>> {

    private Class<T> clazz;

    public MultiResultHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public List<T> handle(ResultSet rs) throws SQLException {
        List<T> dataList = new ArrayList<>();
        while (rs.next()) {
            try {
                T t = clazz.newInstance();
                Map<String, Object> values = new HashMap<>();
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String label = rsmd.getColumnLabel(i);
                    Object value = rs.getObject(i);
                    values.put(label, value);
                }
                //使用工具类对对象的属性进行注入
                BeanUtils.populate(t, values);
                dataList.add(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dataList;
    }
}
