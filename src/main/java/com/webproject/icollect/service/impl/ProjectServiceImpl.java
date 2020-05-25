package com.webproject.icollect.service.impl;

import com.webproject.icollect.mapper.ProjectMapper;
import com.webproject.icollect.pojo.ProjectDO;
import com.webproject.icollect.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public void addProject(ProjectDO projectDO) {
        projectDO.setPid(getUUID());
        projectMapper.addProject(projectDO);
    }

    @Override
    public void deleteProject(String pid) {
        projectMapper.deleteProject(pid);
    }

    @Override
    public ProjectDO updateProject(ProjectDO projectDO) {
        ProjectDO project = projectMapper.getProjectInfo(projectDO.getPid());
        if(project.getCurrentMoney() >= projectDO.getTargetMoney())
            projectDO.setIsFinished(true);
        projectMapper.updateProject(projectDO);
        return projectMapper.getProjectInfo(projectDO.getPid());
    }

    @Override
    public List<ProjectDO> getProject() {
        return projectMapper.getProject();
    }

    @Override
    public List<ProjectDO> getProjectUnchecked() {
        return projectMapper.getProjectUnchecked();
    }

    @Override
    public List<ProjectDO> getProjectChecked() {
        return projectMapper.getProjectChecked();
    }

    @Override
    public ProjectDO getProjectInfo(String pid) {
        return projectMapper.getProjectInfo(pid);
    }

    @Override
    public List<ProjectDO> getProjectByAuthor(String author) {
        return projectMapper.getProjectByAuthor(author);
    }

    @Override
    public List<ProjectDO> getProjectByName(String name) {
        return projectMapper.getProjectByName("%"+name+"%");
    }

    @Override
    public void checkProject(boolean isChecked, String pid) {
        projectMapper.checkProject(isChecked, pid);
    }

    @Override
    public void finishProject(boolean isFinished, String pid) {
        projectMapper.finishProject(isFinished, pid);
    }

    @Override
    public void endProject(boolean isEnded, String pid) {
        projectMapper.endProject(isEnded, pid);
    }

    private String getUUID(){
        String uuid =  UUID.randomUUID().toString();
        return uuid;
    }
}
