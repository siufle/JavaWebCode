package com.cyx.jsp.service.impl;

import com.cyx.jsp.dao.UserDao;
import com.cyx.jsp.dao.impl.UserDaoImpl;
import com.cyx.jsp.pojo.User;
import com.cyx.jsp.service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public int login(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if(user==null){
            return -1;
        }
        return user.getPassword().equals(password)?1:0;
    }

    @Override
    public boolean hasPermission(String username, String url) {
        return userDao.getUrlCount(username, url) > 0;
    }
}
