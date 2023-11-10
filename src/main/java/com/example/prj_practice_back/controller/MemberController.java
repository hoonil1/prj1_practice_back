package com.example.prj_practice_back.controller;

import com.example.prj_practice_back.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
public class MemberController {

    @PostMapping("signup")
    public void signup(@RequestBody Member member) {
        System.out.println("member = " + member);
    }
}
