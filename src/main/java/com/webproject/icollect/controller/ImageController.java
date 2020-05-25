package com.webproject.icollect.controller;


import com.webproject.icollect.pojo.vo.ResultVO;
import com.webproject.icollect.service.ImageService;
import com.webproject.icollect.utils.exception.ImageException;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/image")
@Api("获取/上传图片")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/upload/{type}")
    public ResultVO<Object> upload(@RequestParam("img") MultipartFile file,
                                   @PathVariable("type") String type,
                                   HttpServletRequest request) {
        if("project".equals(type))
            imageService.uploadProject(file, request);
        else if("user".equals(type))
            imageService.uploadUser(file, request);
        else
            throw new ImageException(400, "image请求参数错误");
        return new ResultVO<>(200, "success", null);
    }

    @GetMapping("/get/{type}/{id}/{imgName}")
    public ResultVO<Object> download(@PathVariable("type") String type,
                         @PathVariable("id") String id,
                         @PathVariable("imgName") String imgName, HttpServletResponse response) {
        imageService.download(type, id, imgName, response);
        return new ResultVO<>(200, "success", null);
    }

    @GetMapping("/delete/{type}/{id}/{imgName}")
    public ResultVO<Object> delete(@PathVariable("type") String type,
                       @PathVariable("id") String id,
                       @PathVariable("imgName") String imgName) {
        imageService.delete(type, id, imgName);
        return new ResultVO<>(200, "success", null);
    }

}
