package com.webproject.icollect.controller;

/**
 * Created by Wan Yu on 2020/5/18
 */

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
        List<CommentDO> commentList = commentService.getCommentByTime(pid);
        return new ResultVO<>(200,"success",commentList);
    }

    @PostMapping("/addComment")
    public ResultVO<Object> addComment(@RequestParam("pid") String pid,
                                       @RequestParam("uid") String uid,
                                       @RequestParam("content") String content
                                       ){

        CommentDO commentDO = new CommentDO(pid,uid,content);
        String cid = getUUID();
        commentDO.setCid(cid);
        String ctime = getTime();
        commentDO.setCtime(ctime);
        commentService.addComment(commentDO);
        return new ResultVO<>(200, "success", commentDO);
    }

    @PostMapping("/deleteComment")
    public ResultVO<Object> deleteComment(@RequestParam("cid") String cid){
        commentService.deleteComment(cid);

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
