package com.webproject.icollect.service;

import com.webproject.icollect.pojo.UserDO;

public interface LoginService {

    UserDO getUserInfo(int id);
    UserDO getUserInfo(String username);
    UserDO userLogin(String username,String password);

    UserDO userRegister(UserDO user);
}
