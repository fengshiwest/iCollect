package com.webproject.icollect.service.impl;

import com.webproject.icollect.mapper.UserLoginMapper;
import com.webproject.icollect.pojo.UserDO;
import com.webproject.icollect.service.LoginService;
import com.webproject.icollect.utils.exception.UserRepeatException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserLoginMapper userLoginMapper;

    @Override
    public UserDO getUserInfo(int id) {
        return userLoginMapper.findUserById(id);
    }

    @Override
    public UserDO getUserInfo(String username) {
        return userLoginMapper.findUserByUsername(username);
    }

    @Override
    public UserDO userLogin(String username, String password) {
        UserDO userDO = userLoginMapper.findUserByUsername(username);
        if(userDO!=null){
            if(password.equals(userDO.getPassword())){
                return userDO;
            }
        }
        return null;
    }

    @Override
    public UserDO userRegister(UserDO user) {
        UserDO userDO = userLoginMapper.findUserByUsername(user.getUsername());
        if(userDO!=null){
            throw new UserRepeatException(200,"用户名已存在");
        }
        userLoginMapper.insertUserIgnore(user);
        userDO = userLoginMapper.findUserByUsername(user.getUsername());
        return userDO;
    }
}
