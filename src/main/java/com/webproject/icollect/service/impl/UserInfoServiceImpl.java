package com.webproject.icollect.service.impl;

import com.webproject.icollect.mapper.UserInfoMapper;
import com.webproject.icollect.pojo.UserInfoDo;
import com.webproject.icollect.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfoDo getUserInfoByid(String uid){return userInfoMapper.getUserInfoByid(uid);}
    @Override
    public void addUserInfo(UserInfoDo userInfoDo){userInfoMapper.addUserInfo(userInfoDo);}
    @Override
    public void updateUserInfo(UserInfoDo userInfoDo){userInfoMapper.updateUserInfo(userInfoDo);}
    @Override
    public List<String> getUserInfoUID(){return userInfoMapper.getUserInfoUID();}
}
