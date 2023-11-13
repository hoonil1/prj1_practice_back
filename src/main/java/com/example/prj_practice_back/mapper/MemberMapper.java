package com.example.prj_practice_back.mapper;

import com.example.prj_practice_back.domain.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("""
        INSERT INTO member (id, password, email)
        VALUES (#{id}, #{password}, #{email})
        """)
    int insert(Member member);

    @Select("""
        SELECT id FROM member
        WHERE id = #{id}
        """)
    String selectId(String id);

    @Select("""
        SELECT email FROM member
        WHERE email = #{email}
        """)
    String selectEmail(String email);

    @Select("""
        SELECT id, password, email, inserted
        FROM member
        ORDER BY inserted DESC
        """)
    List<Member> selectAll();

    @Select("""
        SELECT *
        FROM member
        WHERE id = #{id}
        """)
    Member selectById(String id);

    @Delete("""
        DELETE FROM member
        WHERE id = #{id}
        """)
    int deleteById(String id);

    @Update("""
            update member
            set password=#{password},
            email=#{email}
            where id = #{id};
            """)
    int update(Member member);

    // dynamic sql
//    @Update("""
//            <script>
//            update member
//            set
//            <if test="password != ''">
//             password=#{pasword},
//            </if>
//            email=#{email}
//            where id = #{id};
//            </script>
//
//            """)
//    int update(Member member);
}