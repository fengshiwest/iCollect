package com.webproject.icollect.service;



/**
 * Created by Wan Yu on 2020/5/18
 */
import com.webproject.icollect.pojo.CommentDO;

import java.util.List;

public interface CommentService {

    List<CommentDO> getCommentByTime(String pid);

    void addComment(CommentDO comment);

    void deleteComment(String cid);
}
