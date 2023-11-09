package com.example.prj_practice_back.mapper;

import com.example.prj_practice_back.domain.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    @Insert("""
            insert into board (title,content,writer)
            values (#{title}, #{content}, #{writer});
            """)
    int insert(Board board);
}
