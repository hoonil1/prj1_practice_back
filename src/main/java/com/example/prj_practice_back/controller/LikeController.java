package com.example.prj_practice_back.controller;

import com.example.prj_practice_back.domain.Like;
import com.example.prj_practice_back.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/like")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService service;


    @PostMapping
    public void like(@RequestBody Like like) {
        service.update(like);
    }
}
