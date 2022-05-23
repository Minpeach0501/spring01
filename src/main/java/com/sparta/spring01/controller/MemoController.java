package com.sparta.spring01.controller;

import com.sparta.spring01.domain.*;
import com.sparta.spring01.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;


    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<MemoListDto> getMemos() {
        List<Memo> memoList = memoRepository.findAllByOrderByModifiedAtDesc();
        ArrayList<MemoListDto> list = new ArrayList<>();
        for (Memo memo : memoList) {
            MemoListDto dto = new MemoListDto(memo);
            list.add(dto);
        }
       return list; }


    @GetMapping("/api/memos/{id}")
    public Optional<Memo> getContents(@PathVariable Long id) {
        return memoRepository.findById(id);
    }

    @DeleteMapping("/api/memos/{id}")
    public String deleteMemo(@PathVariable Long id, @RequestBody MemoDeleteRequestDto deleteRequestDto ) {
        Optional<Memo> memo = memoRepository.findById(id);
        if(memo.get().getPassword().equals(deleteRequestDto.getPassword()) ){
            memoRepository.deleteById(id);
            return "삭제완료";
        }
        else {
        return "비밀번호가 일치하지않습니다.";}
    }

    @PutMapping("/api/memos/{id}")
    public String updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        Optional<Memo> memo = memoRepository.findById(id);
        if(memo.get().getPassword().equals(requestDto.getPassword()) ){
            memoService.update(id,requestDto);
            return "업데이트 완료";
        }
        else {
            return "비밀번호가 일치하지않습니다.";}

    }
}
