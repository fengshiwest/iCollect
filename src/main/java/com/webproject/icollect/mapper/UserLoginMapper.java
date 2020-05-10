package com.webproject.icollect.mapper;

import com.webproject.icollect.pojo.UserDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserLoginMapper {
    @Select("select * from user where id=#{id}")
    UserDO findUserById(int id);

    @Select("select * from user where username=#{username}")
    UserDO findUserByUsername(String username);

    @Insert("insert IGNORE into user(username,password,role,avatar) values(#{username},#{password},#{role},#{avatar})")
    void insertUserIgnore(UserDO user);

}
