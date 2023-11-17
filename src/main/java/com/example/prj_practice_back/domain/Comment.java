package com.example.prj_practice_back.domain;

import com.example.prj_practice_back.Utility.AgoUtil;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    private Integer id;
    private Integer boardId;
    private String memberId;
    private String memberNickName;
    private String comment;
    private LocalDateTime inserted;

    public String getAgo() {
        return AgoUtil.getAgo(inserted, LocalDateTime.now());
    }
}