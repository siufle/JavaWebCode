package com.cyx.jsp.handler;

import org.apache.commons.beanutils.BeanUtils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class SingleResultHandler<T> implements ResultHandler<T>{

    private Class<T> clazz;

    public SingleResultHandler(Class<T> clazz) {
        this.clazz = clazz;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T handle(ResultSet rs) throws SQLException {
        int count = 0;
        T t = null;
        while (rs.next()) {
            count++;
            if(count > 1){
                throw new RuntimeException("查询结果存在多条数据：" + count);
            }
            try {
                if(clazz.isPrimitive() || Integer.class == clazz || Long.class == clazz){
                    return rs.getObject(1,clazz);
                }
                t = clazz.newInstance();
                HashMap<String, Object> values = new HashMap<>();
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String label = rsmd.getColumnLabel(i);
                    Object value = rs.getString(i);
                    values.put(label, value);
                }
                //使用工具类对对象的属性进行注入
                BeanUtils.populate(t, values);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }
}
