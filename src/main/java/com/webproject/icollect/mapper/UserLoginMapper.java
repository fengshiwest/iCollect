package com.webproject.icollect.mapper;

import com.webproject.icollect.pojo.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserLoginMapper {
    @Select("select * from User where id=#{id}")
    UserDO findUserById(int id);

    @Select("select * from User where username=#{username}")
    UserDO findUserByUsername(String username);

    @Insert("insert IGNORE into User(username,password,role,avatar) values(#{username},#{password},#{role},#{avatar})")
    void insertUserIgnore(UserDO user);

    @Update("update User set avatar=#{avatar} where username=#{username}")
    void setAvatar(String avatar, String username);
}
