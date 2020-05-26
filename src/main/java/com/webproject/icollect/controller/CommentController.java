package com.webproject.icollect.controller;

/**
 * Created by Wan Yu on 2020/5/18
 */


import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.webproject.icollect.pojo.CommentDO;
import com.webproject.icollect.pojo.UserDO;
import com.webproject.icollect.pojo.vo.LoginVO;
import com.webproject.icollect.pojo.vo.ResultVO;
import com.webproject.icollect.service.CommentService;
import com.webproject.icollect.utils.TokenUtil;
import io.jsonwebtoken.JwtException;
import io.swagger.annotations.Api;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.webproject.icollect.pojo.CommentDO;
import com.webproject.icollect.pojo.vo.ResultVO;
import com.webproject.icollect.service.CommentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@Api("评论")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    HttpServletRequest httpServletRequest;

    @GetMapping("/getComment")
    public ResultVO<Object> getComment(@RequestParam("pid") String pid){
        List<CommentDO> commentList = commentService.getCommentByPid(pid);
        return new ResultVO<>(200,"success",commentList);
    }

    @GetMapping("/getCommitByUid")
    public ResultVO<Object> getCommitByUid(@RequestHeader("token") String token){
        if(token == null)
            return new ResultVO<>(400, "未登录", null);
        int uid;
        try{
            uid = Integer.valueOf(TokenUtil.verifyToken(token).get("id"));
            return new ResultVO<>(200, "success", commentService.getCommentByUid(uid));
        }catch (SignatureVerificationException | JWTDecodeException e){
            return new ResultVO<>(400,"未登录",null);
        }
    }


    //如果不用get方式访问addComment可把这个方法和对应的commentService等内容删除
    public ResponseEntity<Object> getUserToken(String token){
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
        UserDO user = commentService.getUserToken(id);
        return new ResponseEntity<Object>(new ResultVO<UserDO>(200,"success",user),HttpStatus.OK);
    }


    @PostMapping("/addComment")
    public ResultVO<Object> addComment(/*@RequestParam("pid") String pid,
                                       @RequestParam("content") String content,*/
                                       @RequestHeader("token") String token,
                                       @RequestBody CommentDO commentDO
                                       ){
        //先验证用户的token是否存在，即保证用户在登录的情况下添加评论
        if(token != null){
            int uid;
            try {
                uid = Integer.valueOf(TokenUtil.verifyToken(token).get("id"));
                commentDO.setUid(uid);
                String cid = getUUID();
                commentDO.setCid(cid);
                String ctime = getTime();
                commentDO.setCtime(ctime);
                commentService.addComment(commentDO);
                return new ResultVO<>(200, "success", commentDO);

            }catch (SignatureVerificationException | JWTDecodeException e){
                return new ResultVO<Object>(400,"未登录",null);
            }

        }
        else{
            return new ResultVO<Object>(400,"未登录",null);
        }
    }

    @PostMapping("/deleteComment")
    public ResultVO<Object> deleteComment(/*@RequestParam("cid") String cid*/@RequestBody CommentDO commentDO){
        commentService.deleteComment(commentDO.getCid());

        return new ResultVO<>(200,"success",null);

    }

    //获取时间
    private String getTime(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    private String getUUID(){
        String uuid =  UUID.randomUUID().toString();
        return uuid;
    }
}
