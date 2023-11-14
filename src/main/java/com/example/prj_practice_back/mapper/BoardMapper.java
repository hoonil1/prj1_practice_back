package com.example.prj_practice_back.mapper;

import com.example.prj_practice_back.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Insert("""
            insert into board (title,content,writer)
            values (#{title}, #{content},#{writer});
            """)
    int insert(Board board);

    @Select("""
            SELECT b.id, b.title,b.writer, m.nickName, b.inserted
            FROM board b join member m on b.writer = m.id
            ORDER BY b.id DESC
            """)
    List<Board> selectAll();

    @Select("""
            SELECT b.id, b.title, b.content, m.id writer,m.nickName, b.inserted
            FROM board b join member m on b.writer = m.id
            WHERE b.id = #{id}
            """)
    Board selectById(Integer id);

    @Delete("""
            DELETE FROM board
            WHERE id = #{id};
            """)
    int deleteById(Integer id);


    @Update("""
            update board set title=#{title}, content=#{content},writer=#{writer}
            where id=#{id}
            """)
    int editBoard(Board board);

    @Delete("""
            delete from board
            where writer=#{writer}
            """)
    int deleteByWriter(String writer);
}
