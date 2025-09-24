package com.cyx.jsp.dao.impl;

import com.cyx.jsp.dao.UserDao;
import com.cyx.jsp.handler.SingleResultHandler;
import com.cyx.jsp.jdbc.JdbcUtil;
import com.cyx.jsp.pojo.User;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUserByUsername(String username) {
        String sql = "select username,password,name from user where username=?";
        return JdbcUtil.query(sql,new SingleResultHandler<>(User.class),username);
    }

    @Override
    public Integer getUrlCount(String username,String url) {
        String sql = "SELECT COUNT(*) FROM user_role a INNER JOIN role b ON a.role_id=b.id " +
                "INNER JOIN role_permission c ON b.id=c.role_id INNER JOIN permission d ON d.id=c.permission_id " +
                "WHERE a.username=? AND d.url=?";
        return JdbcUtil.query(sql,new SingleResultHandler<>(Integer.class),username,url);
    }
}
