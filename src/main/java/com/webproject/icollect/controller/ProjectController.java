package com.webproject.icollect.controller;

import com.webproject.icollect.pojo.ProjectDO;
import com.webproject.icollect.pojo.vo.ResultVO;
import com.webproject.icollect.service.ProjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/project")
@Api("项目相关")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/add")
    public ResultVO<Object> addProject(@RequestBody ProjectDO projectDO) {
        projectService.addProject(projectDO);
        return new ResultVO<>(200, "success", null);
    }

    @GetMapping("/delete")
    public ResultVO<Object> deleteProject(@RequestParam("pid") String pid) {
        projectService.deleteProject(pid);
        return new ResultVO<>(200, "success", null);
    }

    @PostMapping("/update")
    public ResultVO<Object> updateProject(@RequestBody ProjectDO projectDO) {
        return new ResultVO<>(200, "success", projectService.updateProject(projectDO));
    }

    @GetMapping("/get")
    public ResultVO<Object> getProject(){
        return new ResultVO<>(200, "success", projectService.getProject());
    }

    @GetMapping("/getUnchecked")
    public ResultVO<Object> getProjectUnchecked(){
        return new ResultVO<>(200, "success", projectService.getProjectUnchecked());
    }

    @GetMapping("/getChecked")
    public ResultVO<Object> getProjectChecked(){
        return new ResultVO<>(200, "success", projectService.getProjectChecked());
    }

    @GetMapping("/getByPid")
    public ResultVO<Object> getProjectInfo(@RequestParam("pid") String pid) {
        return new ResultVO<>(200, "success", projectService.getProjectInfo(pid));
    }

    @GetMapping("/getByAuthor")
    public ResultVO<Object> getProjectByAuthor(@RequestParam("author") String author) {
        return new ResultVO<>(200, "success", projectService.getProjectByAuthor(author));
    }

    @GetMapping("/getByName")
    public ResultVO<Object> getProjectByName(@RequestParam("name") String name) {
        return new ResultVO<>(200, "success", projectService.getProjectByName(name));
    }

    @GetMapping("/check")
    public ResultVO<Object> checkProject(@RequestParam("isChecked") boolean isChecked,
                                         @RequestParam("pid") String pid) {
        projectService.checkProject(isChecked, pid);
        return new ResultVO<>(200, "success", null);
    }

    @GetMapping("/finish")
    public ResultVO<Object> finishProject(@RequestParam("isFinished") boolean isFinished,
                                         @RequestParam("pid") String pid) {
        projectService.finishProject(isFinished, pid);
        return new ResultVO<>(200, "success", null);
    }

    @GetMapping("/end")
    public ResultVO<Object> endProject(@RequestParam("isEnded") boolean isEnded,
                                         @RequestParam("pid") String pid) {
        projectService.endProject(isEnded, pid);
        return new ResultVO<>(200, "success", null);
    }
}
