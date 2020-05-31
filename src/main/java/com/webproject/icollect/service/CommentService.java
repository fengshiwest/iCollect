package com.webproject.icollect.service;



/**
 * Created by Wan Yu on 2020/5/18
 */
import com.webproject.icollect.pojo.CommentDO;

import com.webproject.icollect.pojo.UserDO;


import java.util.List;

public interface CommentService {

    List<CommentDO> getCommentByPid(String pid);


    List<CommentDO> getCommentByUid(int uid);


    UserDO getUserToken(int id);

    void addComment(CommentDO comment);

    void deleteComment(String cid);

    String getAvatarFromUser(int uid);
}
