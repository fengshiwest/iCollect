package com.webproject.icollect.controller;
/**
 * create by Zhang Ding
 * */
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.webproject.icollect.pojo.DonateDO;
import com.webproject.icollect.pojo.ProjectDO;
import com.webproject.icollect.pojo.UserInfoDo;
import com.webproject.icollect.pojo.vo.ResultVO;
import com.webproject.icollect.service.UserInfoService;
import com.webproject.icollect.utils.TokenUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Api("用户信息")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    HttpServletRequest httpServletRequest;
    //编辑用户信息
    @PostMapping("/setUserInfo")
    public ResultVO<Object> modifyUserInfo(@RequestHeader String token, @RequestBody UserInfoDo userInfoDo){
        //根据token是否为空判断用户是否已登录
        if(token!=null){
            String uid;
            try {
                //获取token中的id作为区分用户的uid主键
                uid = TokenUtil.verifyToken(token).get("id");
                userInfoDo.setUid(uid);
                //从user表中获取对应id的用户名字段
                String username = userInfoService.getUsernameFromUser(uid);
                userInfoDo.setUsername(username);
                //如果已经存在该uid的数据行，则更新其中的数据
                if(isExisted(uid)){
                    userInfoService.updateUserInfo(userInfoDo);
                }
                //如果没有，则添加一行对应uid的数据行
                else{
                    userInfoService.addUserInfo(userInfoDo);
                    //更新user表中的用户头像
                    userInfoService.updateAvatar(userInfoDo);
                }
                return new ResultVO<Object>(200,"success",userInfoDo);
            }catch (SignatureVerificationException | JWTDecodeException e){
                return new ResultVO<Object>(400,"未登录",null);
            }
        }
        else{
            return new ResultVO<Object>(400,"未登录",null);
        }
    }
    //根据用户的id获取当前用户信息
    @GetMapping("/getUserInfoByid")
    public ResultVO<Object> getUserInfo(@RequestHeader String token){
        if(token !=null){
            String uid;
            try{
                uid = TokenUtil.verifyToken(token).get("id");
                UserInfoDo userInfoDo = userInfoService.getUserInfoByid(uid);
                if(userInfoDo !=null){
                    //添加用户发起的项目信息对象
                    List<ProjectDO> createdProject = userInfoService.getCreatedProject(uid);
                    userInfoDo.setCreatedProject(createdProject);
                    //添加用户参与的捐款信息对象
                    List<DonateDO> donationInfo = userInfoService.getDonationInfo(uid);
                    userInfoDo.setDonationInfo(donationInfo);
                    return new ResultVO<>(200,"success",userInfoDo);
                }
                //如果userInfo表中没有该uid的数据行，则添加
                else{
                    UserInfoDo setUid = new UserInfoDo(uid);
                    //从user表中获取用户名和头像图片
                    String username = userInfoService.getUsernameFromUser(uid);
                    setUid.setUsername(username);
                    String avatar  = userInfoService.getAvatarFromUser(uid);
                    setUid.setAvatar(avatar);
                    //添加用户发起的项目信息对象
                    List<ProjectDO> createdProject = userInfoService.getCreatedProject(uid);
                    setUid.setCreatedProject(createdProject);
                    //添加用户参与的捐款信息对象
                    List<DonateDO> donationInfo = userInfoService.getDonationInfo(uid);
                    setUid.setDonationInfo(donationInfo);
                    userInfoService.addUserInfo(setUid);
                    return new ResultVO<>(200,"success",setUid);
                }
            }catch(SignatureVerificationException | JWTDecodeException e){
                return new ResultVO<Object>(400,"未登录",null);
            }
        }
        else{
            return new ResultVO<Object>(400,"未登录",null);
        }

    }
    //获取数据表中的uid字段，判断当前用户的uid是否存在其中
    public boolean isExisted(String uid){
       return userInfoService.getUserInfoUID().contains(uid);
    }


}
