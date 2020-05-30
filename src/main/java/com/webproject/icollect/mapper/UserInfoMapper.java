package com.webproject.icollect.mapper;

import com.webproject.icollect.pojo.DonateDO;
import com.webproject.icollect.pojo.ProjectDO;
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
    @Select("select info.*, user.* from (select * from UserInfo where uid = #{uid}) info, (select avatar,username from User where id = #{uid}) user")
    UserInfoDo getUserInfoByid(String uid);
    //获取user表中的avatar字段
    @Select("select avatar from User where id =#{uid}")
    String getAvatarFromUser(String uid);
    //获取user表中的username字段
    @Select("select username from User where id = #{uid}")
    String getUsernameFromUser(String uid);
    //获取该用户发起的项目信息
    @Select("select * from Project where authorID = #{uid}")
    List<ProjectDO> getCreatedProject(String uid);
    //获取所有uid
    @Select("select uid from UserInfo")
    List<String> getUserInfoUID();
    //添加新的用户信息
    @Insert("insert into UserInfo(uid,username,area,tel,description) values(#{uid},#{username},#{area},#{tel},#{description})")
    void addUserInfo(UserInfoDo userInfoDo);
    //编辑更新已有uid的用户信息
    @Update("update UserInfo info inner join User user on info.uid = user.id set info.area=#{area}, info.tel=#{tel}, info.description=#{description},user.avatar=#{avatar} where info.uid=#{uid}")
    void updateUserInfo(UserInfoDo userInfoDo);
    //获取该用户参与的项目信息
    @Select("select * from Donate where donor = #{uid}")
    List<DonateDO> getDonationInfo(String uid);
    //更新user表的avatar字段
    @Select("update User set avatar=#{avatar} where id = #{uid}")
    void updateAvatar(UserInfoDo userInfoDo);


}
