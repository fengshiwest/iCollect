package com.webproject.icollect.service;

import com.webproject.icollect.pojo.ProjectDO;

import java.util.List;

public interface ProjectService {

    // add project
    void addProject(ProjectDO projectDO);

    // delete project
    void deleteProject(String pid);

    // update all information of project
    ProjectDO updateProject(ProjectDO projectDO);

    // get all project
    List<ProjectDO> getProject();

    // get unchecked project
    List<ProjectDO> getProjectUnchecked();

    // get checked project
    List<ProjectDO> getProjectChecked();

    // get by id
    ProjectDO getProjectInfo(String pid);

    // get by author
    List<ProjectDO> getProjectByAuthor(String author);

    // get by project name
    List<ProjectDO> getProjectByName(String name);

    List<ProjectDO> getProjectByCategory(String category);

    // check project
    void checkProject(boolean isChecked, String pid);

    // finish project
    void finishProject(boolean isFinished, String pid);

    // end project
    void endProject(boolean isEnded, String pid);
}
