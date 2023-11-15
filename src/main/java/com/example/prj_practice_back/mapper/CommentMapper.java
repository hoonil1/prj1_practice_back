package com.example.prj_practice_back.mapper;

import com.example.prj_practice_back.domain.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Insert("""
            insert into comment (boardId, comment, memberId)
            values (#{boardId}, #{comment},#{memberId})
            """)
    int insert(Comment comment);

    @Select("""
            select * from comment
            where boardId = #{boardId}
            """)
    List<Comment> selectByBoardId(Integer boardId);

    @Delete("""
        DELETE FROM comment
        WHERE id = #{id}
        """)
    int deleteById(Integer id);

    @Select("""
            select * from comment
            where id = #{id}
            """)
    Comment selectById(Integer id);
}
