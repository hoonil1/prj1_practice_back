package com.example.prj_practice_back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/board")
@RestController
@RequiredArgsConstructor
public class BoardController {

    @PostMapping("add")
    public void add() {
        System.out.println("BoardController.add");
        System.out.println("BoardController.add");
    }
}
