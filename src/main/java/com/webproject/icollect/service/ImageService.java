package com.webproject.icollect.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ImageService {

    public void uploadProject(MultipartFile file, HttpServletRequest request);

    public void uploadUser(MultipartFile file, HttpServletRequest request);

    public void download(String type, String id, String imgName, HttpServletResponse response);

    public void delete(String type, String id, String imgName);
}
