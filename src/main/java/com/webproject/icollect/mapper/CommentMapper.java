package com.webproject.icollect.mapper;

/**
 * Created by Wan Yu on 2020/5/18
 */
import com.webproject.icollect.pojo.CommentDO;
import com.webproject.icollect.pojo.TestDO;
import com.webproject.icollect.pojo.UserDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    @Select("select * from Comment NATURAL JOIN (select username, id as uid from User) as User where pid=#{pid}")
    List<CommentDO> getCommentByPid(String pid);

    @Select("select * from Comment NATURAL JOIN (select username, id as uid from User) as User where uid=#{uid}")
    List<CommentDO> getCommentByUid(int uid);

    @Insert("insert into Comment(cid,ctime,pid,uid,content) values(#{cid},#{ctime},#{pid},#{uid},#{content})")
    void addComment(CommentDO comment);

    @Delete("delete from Comment where cid=#{cid}")
    void deleteComment(String cid);

    @Select("select * from User where id=#{id}")
    UserDO findUserById(int id);
}
