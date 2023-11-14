package com.example.prj_practice_back.service;

import com.example.prj_practice_back.domain.Member;
import com.example.prj_practice_back.mapper.BoardMapper;
import com.example.prj_practice_back.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper mapper;
    private final BoardMapper boardMapper;

    public boolean add(Member member) {
        return mapper.insert(member) == 1;
    }

    public String getId(String id) {
        return mapper.selectId(id);
    }

    public String getEmail(String email) {
        return mapper.selectEmail(email);

    }

    public String getNickName(String nickName) {
        return mapper.selectNickName(nickName);
    }

    public boolean validate(Member member) {
        if (member == null) {
            return false;
        }

        if (member.getEmail().isBlank()) {
            return false;
        }

        if (member.getPassword().isBlank()) {
            return false;
        }
        if (member.getNickName().isBlank()) {
            return false;
        }

        if (member.getId().isBlank()) {
            return false;
        }
        return true;
    }

    public List<Member> list() {
        return mapper.selectAll();
    }

    public Member getMember(String id) {
        return mapper.selectById(id);
    }


    public boolean deleteMember(String id) {
        // 1. 이 멤버가 작성한 게시물을 삭제하고
        boardMapper.deleteByWriter(id);
        // 2. 이 멤버 탈퇴
        return mapper.deleteById(id) == 1;
    }

    public boolean update(Member member) {
//        Member oldMember = mapper.selectId(member.getId());
//
//        if (member.getPassword().equals("")) {
//            member.setPassword(oldMember.getPassword());
//        }
        return mapper.update(member) == 1;
    }


    public boolean login(Member member, WebRequest request) {
        Member dbMember = mapper.selectById(member.getId());

        if (dbMember != null) {
            if (dbMember.getPassword().equals(member.getPassword())) {
                dbMember.setPassword("");
                request.setAttribute("login", dbMember, RequestAttributes.SCOPE_SESSION);
                return true;
            }
        }
        return false;
    }

    public boolean deleteAccess(Member login, String id) {
        return login.getId().equals(id);
    }

    public boolean hasAccess(String id, Member login) {
        return login.getId().equals(id);
    }
}