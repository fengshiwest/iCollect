package com.webproject.icollect.service.impl;

import com.webproject.icollect.mapper.ProjectMapper;
import com.webproject.icollect.mapper.UserLoginMapper;
import com.webproject.icollect.pojo.ProjectDO;
import com.webproject.icollect.pojo.UserDO;
import com.webproject.icollect.service.ImageService;
import com.webproject.icollect.utils.exception.ImageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ProjectMapper projectMapper;

    @Autowired
    private UserLoginMapper userLoginMapper;

    private String PATH;

    public ImageServiceImpl(){
//        try {
//            PATH = ResourceUtils.getURL("classpath:").getPath() + "image/";
            PATH = "/www/wwwroot/image/";
            System.out.println(PATH);
//        }catch (IOException e){
//            e.printStackTrace();
//        }
    }

    @Override
    public void download(String type, String id, String imgName, HttpServletResponse response) {
        File dir = new File(PATH + type + "/" + id + "/", imgName);
        if(!dir.exists())
            throw new ImageException(400, "图片不存在");
        String path = PATH + type + "/" + id + "/" + imgName;
        InputStream bis = null;
        BufferedOutputStream out = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File(path)));
            out = new BufferedOutputStream(response.getOutputStream());
            int len = 0;
            while ((len = bis.read()) != -1) {
                out.write(len);
                out.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finally{
            try {
                bis.close();
                out.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void uploadProject(MultipartFile file, HttpServletRequest request) {

        String pid = request.getParameter("pid");
        // @type: image || qrCode
        String type = request.getParameter("type");
        if(!"image".equals(type) && !"qrCode".equals(type))
            throw new ImageException(400, "image请求体参数错误");
        String imgName = type+"-"+file.getOriginalFilename();
        File dir = new File(PATH+"project/"+pid+"/", imgName);
        write(dir, file);
        ProjectDO projectDO = projectMapper.getProjectInfo(pid);
        if("image".equals(type)) {
            String image = projectDO.getImage();
            if(image != null && image.length() > 0)
                delete("project", pid, image);
            projectMapper.setImage(imgName, pid);
        }
        else {
            String qrCode = projectDO.getImage();
            if(qrCode != null && qrCode.length() > 0)
                delete("project", pid, qrCode);
            projectMapper.setQrCode(imgName, pid);
        }
    }

    @Override
    public void uploadUser(MultipartFile file, HttpServletRequest request) {
        String username = request.getParameter("username");
        String imgName = file.getOriginalFilename();
        File dir = new File(PATH+"user/"+username+"/", imgName);
        write(dir, file);
        UserDO userDO = userLoginMapper.findUserByUsername(username);
        String avatar = userDO.getAvatar();
        if(avatar != null && avatar.length() > 0)
            delete("user", username, userDO.getAvatar());
        userLoginMapper.setAvatar(imgName, username);
    }

    @Override
    public void delete(String type, String id, String imgName) {
        File dir = new File(PATH + type + "/" + id + "/", imgName);
        if(!dir.exists())
            return;
//            throw new ImageException(400, "图片不存在");
        if("project".equals(type)) {
            if ("image".equals(imgName.substring(0, 5)))
                projectMapper.setImage(null, id);
            else
                projectMapper.setQrCode(null, id);
        }else{
            userLoginMapper.setAvatar("default.png", id);
        }
        dir.delete();
    }

    private void write(File dir, MultipartFile file){
        try {
            // 目录不存在
            if (!dir.getParentFile().exists())
                dir.getParentFile().mkdirs();
            // 图片存在
            if (dir.exists())
                dir.delete();
            dir.createNewFile();
            file.transferTo(dir);
        }catch (IOException e){
            e.printStackTrace();
            throw new ImageException(500, "图片上传失败");
        }
    }
}
