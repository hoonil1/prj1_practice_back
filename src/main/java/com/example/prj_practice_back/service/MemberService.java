package com.example.prj_practice_back.service;

import com.example.prj_practice_back.domain.Member;
import com.example.prj_practice_back.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper mapper;

    public void add(Member member) {
        mapper.insert(member);
    }
}
