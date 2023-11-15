package com.example.prj_practice_back.mapper;

import com.example.prj_practice_back.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CommentMapper {

    @Insert("""
            insert into comment (boardId, comment, memberId)
            values (#{boardId}, #{comment},#{memberId})
            """)
    int insert(Comment comment);
}
