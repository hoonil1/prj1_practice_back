package com.example.prj_practice_back.domain;

import lombok.Data;

@Data
public class Like {
    private Integer id;
    private Integer boardId;
    private String memberId;
}