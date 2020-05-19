package com.webproject.icollect.mapper;

import com.webproject.icollect.pojo.ProjectDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Wan Yu on 2020/5/19
 */

@Mapper
@Repository
public interface ProjectMapper {

    @Select("select * from Project where pid=#{pid}")
    ProjectDO getProjectInfo(String pid);

    @Select("select * from Project where author=#{author}")
    List<ProjectDO> getProjectByAuthor(String author);

    @Select("select * from Project where name=#{name}")
    List<ProjectDO> getProjectByName(String name);

    @Insert("insert into Project(pid,author,name,introduction,image,startTime,endTime,targetMoney,currentMoney,isFinished,isChecked,isEnded,qrCode) " +
            "values(#{pid},#{author},#{name},#{introduction},#{image},#{startTime},#{endTime},#{targetMoney},#{currentMoney},#{isFinished},#{isChecked},#{isEnded},#{qrCode})")
    void addProject(ProjectDO projectDO);

    @Update("update Project set isChecked=#{isChecked}")
    ProjectDO checkProject(boolean isChecked);

    @Update("update Project set isFinished=#{isFinished}")
    ProjectDO finishProject(boolean isFinished);

    @Update("update Project set isEnded=#{isEnded}")
    ProjectDO endProject(boolean isEnded);

    @Update("update Project set currentMoney=#{currentMoney}")
    ProjectDO updateMoney(double currentMoney);
}
