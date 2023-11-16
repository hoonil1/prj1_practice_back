package com.example.prj_practice_back.mapper;

import com.example.prj_practice_back.domain.Like;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {

    @Delete("""
            delete from boardLike
            where boardId = #{boardId} and memberId = #{memberId} 
            """)
    int delete(Like like);

    @Insert("""
            insert into boardlike (memberId, boardId) values (#{boardId}, #{memberId});
            """)
    int insert(Like like);
}
