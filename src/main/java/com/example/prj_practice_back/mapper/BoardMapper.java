package com.example.prj_practice_back.mapper;

import com.example.prj_practice_back.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Insert("""
            INSERT INTO board (title, content, writer)
            VALUES (#{title}, #{content}, #{writer})
            """)
    int insert(Board board);

    @Select("""
                    
                SELECT b.id,
                           b.title,\s
                           b.content,\s
                           b.writer,\s
                           m.nickName,
                           b.inserted,
                        count(distinct c.id) countComment,
                        count(distinct l.id) countLike
                    FROM board b JOIN member m ON b.writer = m.id
                    left join comment c on b.id = c.boardId
                    left join boardLike l on b.id = l.boardId
                    GROUP BY b.id
                    ORDER BY b.id DESC
                    limit #{from} ,10;
            """)
    List<Board> selectAll(Integer from);

    @Select("""
            SELECT b.id,
                   b.title, 
                   b.content, 
                   b.writer, 
                   m.nickName,
                   b.inserted
                
            FROM board b JOIN member m ON b.writer = m.id
            WHERE b.id = #{id}
            """)
    Board selectById(Integer id);

    @Delete("""
            DELETE FROM board
            WHERE id = #{id}
            """)
    int deleteById(Integer id);

    @Update("""
            UPDATE board
            SET title = #{title},
                content = #{content},
                writer = #{writer}
            WHERE id = #{id}
            """)
    int update(Board board);


    @Delete("""
            DELETE FROM board
            WHERE writer = #{writer}
            """)
    int deleteByWriter(String writer);

    @Select("""
            SELECT id
            FROM board
            WHERE writer = #{id}
            """)
    List<Integer> selectIdListByMemberId(String writer);

    @Select("""
select count(*) from board;
""")
    int countAll();
}