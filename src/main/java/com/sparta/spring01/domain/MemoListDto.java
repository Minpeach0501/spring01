package com.sparta.spring01.domain;


import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class  MemoListDto  {
    private final Long id;
    private final String title;
    private final String username;
    private final LocalDateTime modifiedAt;

    public MemoListDto(Memo memo){
        this.id = memo.getId();
        this.title = memo.getTitle();
        this.username = memo.getUsername();
        this.modifiedAt = memo.getModifiedAt();
    }
}
