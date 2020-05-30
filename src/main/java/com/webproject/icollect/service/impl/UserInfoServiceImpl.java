package com.webproject.icollect.service.impl;
/**
 * create by Zhang Ding
 * */
import com.webproject.icollect.mapper.UserInfoMapper;
import com.webproject.icollect.pojo.DonateDO;
import com.webproject.icollect.pojo.ProjectDO;
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
    @Override
    public List<ProjectDO> getCreatedProject(String uid) {
        return userInfoMapper.getCreatedProject(uid);
    }

    @Override
    public void updateAvatar(UserInfoDo userInfoDo) {
        userInfoMapper.updateAvatar(userInfoDo);
    }

    @Override
    public String getAvatarFromUser(String uid) {
        return userInfoMapper.getAvatarFromUser(uid);
    }

    @Override
    public String getUsernameFromUser(String uid) {
        return userInfoMapper.getUsernameFromUser(uid);
    }

    @Override
    public List<DonateDO> getDonationInfo(String uid) {
        return userInfoMapper.getDonationInfo(uid);
    }
}
