package com.webproject.icollect.service;

import com.webproject.icollect.pojo.DonateDO;
import com.webproject.icollect.pojo.ProjectDO;
import com.webproject.icollect.pojo.UserInfoDo;

import java.util.List;
/**
 * created by Zhang Ding
 */

public interface UserInfoService {
    //获取特定uid的用户信息
    UserInfoDo getUserInfoByid(String uid);
    //添加新的用户信息
    void addUserInfo(UserInfoDo userInfoDo);
    //编辑更新已有uid的用户信息
    void updateUserInfo(UserInfoDo userInfoDo);
    //获取所有uid
    List<String> getUserInfoUID();
    //获取该用户创建的所有项目信息
    List<ProjectDO> getCreatedProject(String uid);
    //获取用户参与的所有项目信息
    List<DonateDO> getDonationInfo(String uid);
}
