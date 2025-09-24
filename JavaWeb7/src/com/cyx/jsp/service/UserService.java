package com.cyx.jsp.service;

public interface UserService {

    int login(String username, String password);

    boolean hasPermission(String username, String url);
}
