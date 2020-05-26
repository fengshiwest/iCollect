package com.webproject.icollect.controller;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.webproject.icollect.pojo.UserInfoDo;
import com.webproject.icollect.pojo.vo.ResultVO;
import com.webproject.icollect.service.UserInfoService;
import com.webproject.icollect.utils.TokenUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

        if(token!=null){
            String uid;
            try {
                //获取token中的id作为区分用户的uid主键
                uid = TokenUtil.verifyToken(token).get("id");
                userInfoDo.setUid(uid);
                //判断更新数据行
                if(isExisted(uid)){
                    userInfoService.updateUserInfo(userInfoDo);
                }
                //添加一行新的数据行
                else{
                    userInfoService.addUserInfo(userInfoDo);
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
                return new ResultVO<>(200,"success",userInfoDo);
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
