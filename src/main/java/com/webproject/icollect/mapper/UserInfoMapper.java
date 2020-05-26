package com.webproject.icollect.mapper;

import com.webproject.icollect.pojo.UserInfoDo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by Zhang Ding
 */

@Mapper
@Repository
public interface UserInfoMapper {
    //获取特定uid的用户信息
    @Select("select * from UserInfo where uid=#{uid}")
    UserInfoDo getUserInfoByid(String uid);
    //获取所有uid
    @Select("select uid from UserInfo")
    List<String> getUserInfoUID();
    //添加新的用户信息
    @Insert("insert into UserInfo(uid,username,area,tel,description) values(#{uid},#{username},#{area},#{tel},#{description})")
    void addUserInfo(UserInfoDo userInfoDo);
    //编辑更新已有uid的用户信息
    @Update("update UserInfo set username=#{username}, area=#{area}, tel=#{tel}, description=#{description} where uid=#{uid}")
    void updateUserInfo(UserInfoDo userInfoDo);

}
