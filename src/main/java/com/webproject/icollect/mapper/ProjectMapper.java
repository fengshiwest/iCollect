package com.webproject.icollect.mapper;

import com.webproject.icollect.pojo.ProjectDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Wan Yu on 2020/5/19
 */

@Mapper
@Repository
public interface ProjectMapper {

    @Insert("insert into Project(pid,author,name,introduction,image,startTime,endTime,targetMoney,currentMoney,isFinished,isChecked,isEnded,qrCode) " +
            "values(#{pid},#{author},#{name},#{introduction},#{image},#{startTime},#{endTime},#{targetMoney},#{currentMoney},#{isFinished},#{isChecked},#{isEnded},#{qrCode})")
    void addProject(ProjectDO projectDO);

    @Delete("delete from Project where pid=#{pid}")
    void deleteProject(String pid);

    @Update("update Project set name=#{name}, introduction=#{introduction},image=#{image}, startTime=#{startTime}, endTime=#{endTime}," +
            " targetMoney=#{targetMoney}, isEnded=#{isEnded}, qrCode=#{qrCode} where pid=#{pid}")
    void updateProject(ProjectDO projectDO);

    @Update("update Project set isChecked=#{isChecked} where pid=#{pid}")
    void checkProject(boolean isChecked, String pid);

    @Update("update Project set isFinished=#{isFinished} where pid=#{pid}")
    void finishProject(boolean isFinished, String pid);

    @Update("update Project set isEnded=#{isEnded} where pid=#{pid}")
    void endProject(boolean isEnded, String pid);

    @Update("update Project set currentMoney=#{currentMoney} where pid=#{pid}")
    void updateMoney(double currentMoney, String pid);

    @Select("select * from Project")
    List<ProjectDO> getProject();

    @Select("select * from Project where isChecked=false")
    List<ProjectDO> getProjectUnchecked();

    @Select("select * from Project where isChecked=true")
    List<ProjectDO> getProjectChecked();

    @Select("select * from Project where pid=#{pid}")
    ProjectDO getProjectInfo(String pid);

    @Select("select * from Project where author=#{author}")
    List<ProjectDO> getProjectByAuthor(String author);

    @Select("select * from Project where name like #{name}")
    List<ProjectDO> getProjectByName(String name);

}
