package com.example.prj_practice_back.mapper;

import com.example.prj_practice_back.domain.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert("""
            insert into board (title,content,writer)
            values (#{title}, #{content}, #{writer});
            """)
    int insert(Board board);

    @Select("""
            SELECT id, title, writer, inserted
            FROM board
            ORDER BY id DESC
            """)
    List<Board> selectAll();

    @Select("""
            SELECT id, title, content, writer, inserted
            FROM board
            WHERE id = #{id}
            """)
    Board selectById(Integer id);
}
