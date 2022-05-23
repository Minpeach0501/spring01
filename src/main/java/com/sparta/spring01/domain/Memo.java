package com.sparta.spring01.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Memo extends  Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable =false)
    private String title;

    @Column(nullable =false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable =false)
    private String contents;

    public Memo(String title, String username, String password, String contents){
        this.title = title;
        this.username = username;
        this.password = password;
        this.contents = contents;
    }



    public void delete(MemoDeleteRequestDto deleteRequestDto){
        this.password = deleteRequestDto.getPassword();
    }

    public void update(MemoRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }

    public Memo(MemoRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }
}
