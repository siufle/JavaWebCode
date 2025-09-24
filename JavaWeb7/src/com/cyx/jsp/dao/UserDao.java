package com.cyx.jsp.dao;

import com.cyx.jsp.pojo.User;

public interface UserDao {

    User getUserByUsername(String username);

    Integer getUrlCount(String username, String url);
}
