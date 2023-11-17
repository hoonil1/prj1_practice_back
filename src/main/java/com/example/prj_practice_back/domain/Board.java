package com.example.prj_practice_back.domain;

import com.example.prj_practice_back.Utility.AgoUtil;
import lombok.Data;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

@Data
public class Board {
    private Integer id;
    private String title;
    private String content;
    private String writer;
    private String nickName;
    private LocalDateTime inserted;
    private Integer countComment;
    private Integer countLike;

    public String getAgo() {
        return AgoUtil.getAgo(inserted, LocalDateTime.now());
    }
}