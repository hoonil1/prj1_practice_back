package com.example.prj_practice_back.domain;

import lombok.Data;

@Data
public class Member {
    private Integer uniqueId;
    private String id;
    private String password;
    private String email;
    private String inserted;
}