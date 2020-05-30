package com.webproject.icollect.service.impl;

import com.webproject.icollect.mapper.CommentMapper;
import com.webproject.icollect.pojo.CommentDO;

import com.webproject.icollect.pojo.UserDO;

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
    public List<CommentDO> getCommentByPid(String pid) {
        return commentMapper.getCommentByPid(pid);
    }

    @Override
    public List<CommentDO> getCommentByUid(int uid) {
        return commentMapper.getCommentByUid(uid);
    }

    @Override
    public void addComment(CommentDO comment) {
        commentMapper.addComment(comment);
    }

    @Override
    public void deleteComment(String cid) {
        commentMapper.deleteComment(cid);
    }

    @Override
    public String getAvatarFromUser(int uid) {
        return commentMapper.getAvatarFromUser(uid);
    }

    @Override
    public UserDO getUserToken(int id) {
        return commentMapper.findUserById(id);
    }

}
