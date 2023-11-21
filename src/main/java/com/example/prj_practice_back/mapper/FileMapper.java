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
insert into boardFile (boardId,name)
values (#{boardId},#{name})
""")
    int insert(Integer boardId, String name);

    @Select("""
select id,name from boardfile
where boardId=${boardId}
order by 1 desc
""")
    List<BoardFile> selectNamesByBoardId(Integer boardId);

    @Delete("""
delete from boardfile
where boardId = #{boardId}
""")
    int deleteByBoardId(Integer boardId);
}
