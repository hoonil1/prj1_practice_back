package com.example.prj_practice_back.mapper;

import com.example.prj_practice_back.domain.BoardFile;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FileMapper {

    @Insert("""
        INSERT INTO boardFile (boardId, name)
        VALUES (#{boardId}, #{name})
        """)
    int insert(Integer boardId, String name);

    @Select("""
        SELECT id, name
        FROM boardFile
        WHERE boardId = #{boardId}
        """)
    List<BoardFile> selectNamesByBoardId(Integer boardId);

    @Delete("""
        DELETE FROM boardFile
        WHERE boardId = #{boardId}
        """)
    int deleteByBoardId(Integer boardId);

    @Select("""
        SELECT * 
        FROM boardFile 
        WHERE id = #{id}
        """)
    BoardFile selectById(Integer id);

    @Delete("""
        DELETE FROM boardFile
        WHERE id = #{id}
        """)
    int deleteById(Integer id);
}