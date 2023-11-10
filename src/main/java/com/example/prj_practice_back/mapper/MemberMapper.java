package com.example.prj_practice_back.mapper;

import com.example.prj_practice_back.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {


    @Insert("""
insert into member (id,password,email)
values(#{id},#{password},#{email});
""")
    int insert(Member member);
}
