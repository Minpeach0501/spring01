package com.sparta.spring01.domain;

import lombok.Getter;

@Getter
public class MemoRequestDto {
    private String title;
    private String username;
    private String password;
    private String contents;
}
