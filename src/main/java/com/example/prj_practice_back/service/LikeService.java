package com.example.prj_practice_back.service;

import com.example.prj_practice_back.domain.Like;
import com.example.prj_practice_back.domain.Member;
import com.example.prj_practice_back.mapper.LikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeMapper mapper;

    public void update(Like like, Member login) {

        like.setMemberId(login.getId());

        // 처음 좋아요 누를 때 : insert
        // 다시 누르면 : delete

        int count = 0;
        if (mapper.delete(like) == 0) {
            count = mapper.insert(like);
        }


    }
}