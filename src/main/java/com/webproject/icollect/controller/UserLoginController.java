package com.webproject.icollect.controller;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.webproject.icollect.pojo.UserDO;
import com.webproject.icollect.pojo.vo.LoginVO;
import com.webproject.icollect.pojo.vo.ResultVO;
import com.webproject.icollect.service.LoginService;
import com.webproject.icollect.utils.TokenUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@Api("用户登陆注册")
public class UserLoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    HttpServletRequest request;

    @GetMapping("/login")
    public ResponseEntity<Object> getUserInfo(@RequestHeader("token") String token){
//        String token = request.getHeader("token");
        if(token == null){
            return new ResponseEntity<>(new ResultVO<Object>(400,"未登录",null),HttpStatus.UNAUTHORIZED);
        }
        int id;
        try {
            id = Integer.valueOf(TokenUtil.verifyToken(token).get("id"));
        }catch (SignatureVerificationException | JWTDecodeException e){
            return new ResponseEntity<>(new ResultVO<Object>(400,"未登录",null),HttpStatus.UNAUTHORIZED);
        }
        UserDO user = loginService.getUserInfo(id);
        return new ResponseEntity<Object>(new ResultVO<UserDO>(200,"success",user),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResultVO<Object> login(@RequestParam("username") String username,
                                  @RequestParam("password") String password){
        UserDO user = loginService.userLogin(username,password);
        if(user == null){
            return new ResultVO<>(401,"用户名/密码错误",null);
        }
        String token = TokenUtil.getToken(user);
        return new ResultVO<>(200,"success",new LoginVO<UserDO>(token,user));
    }

    @PostMapping("/register")
    public ResultVO<Object> register(@RequestParam("username") String username,
                                     @RequestParam("password") String password){
        UserDO userDO = new UserDO(username,password);
        UserDO user = loginService.userRegister(userDO);
        String token = TokenUtil.getToken(user);
        return new ResultVO<>(200,"success",new LoginVO<UserDO>(token,user));
    }

}
