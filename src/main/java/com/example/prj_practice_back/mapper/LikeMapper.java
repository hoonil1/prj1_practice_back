package com.example.prj_practice_back.mapper;

import com.example.prj_practice_back.domain.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface LikeMapper {
    @Delete("""
        DELETE FROM boardLike
        WHERE boardId = #{boardId}
          AND memberId = #{memberId}
        """)
    int delete(Like like);

    @Insert("""
        INSERT INTO boardLike (boardId, memberId)
        VALUES (#{boardId}, #{memberId})
        """)
    int insert(Like like);

    @Select("""
            select count(id) from boardlike
            where boardId = #{boardId}
            """)
    int countByBoardId(Integer boardId);
}