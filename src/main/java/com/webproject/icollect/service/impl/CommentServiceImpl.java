package com.webproject.icollect.service.impl;

import com.webproject.icollect.mapper.CommentMapper;
import com.webproject.icollect.pojo.CommentDO;
import com.webproject.icollect.service.CommentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Wan Yu on 2020/5/18
 */

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentDO> getCommentByTime(String pid) {
        return commentMapper.getCommendByTime(pid);
    }

    @Override
    public void addComment(CommentDO comment) {
        commentMapper.addComment(comment);
    }

    @Override
    public void deleteComment(String cid) {
        commentMapper.deleteComment(cid);
    }
}
