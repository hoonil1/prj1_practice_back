package com.example.prj_practice_back.controller;

import com.example.prj_practice_back.domain.Board;
import com.example.prj_practice_back.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/board")
@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;

    @PostMapping("add")
    public void add(@RequestBody Board board) {
        service.save(board);
    }
}
