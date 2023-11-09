package com.example.prj_practice_back.service;

import com.example.prj_practice_back.domain.Board;
import com.example.prj_practice_back.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;
    public void save(Board board) {
        mapper.insert(board);
    }
}
