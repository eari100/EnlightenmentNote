package com.example.enlightenmentNote.controller;

import com.example.enlightenmentNote.dto.*;
import com.example.enlightenmentNote.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @GetMapping("/api/v1/posts/list")
    public Page<PostsListResDto> findPostsList(@ModelAttribute PostsListReqDto reqDto,
                                               @RequestParam(name = "pageNum", defaultValue = "0") int num,
                                               @RequestParam(name = "pageSize", defaultValue = "10") int size) {

        return postsService.findPostsList(reqDto, PageRequest.of(num, size));
    }

    @GetMapping("/api/v1/posts/{postSeq}")
    public PostsDetailResDto findById(@PathVariable UUID postSeq) {
        return postsService.findById(postSeq);
    }

    @PostMapping("/api/v1/posts")
    public UUID save(@RequestBody PostsSaveReqDto reqDto) {
        return postsService.save(reqDto);
    }

    @PatchMapping("/api/v1/posts/{postSeq}")
    public UUID update(@PathVariable UUID postSeq, @RequestBody PostsUpdateReqDto reqDto) {
        return postsService.update(postSeq, reqDto);
    }

    @DeleteMapping("/api/v1/posts/{postSeq}")
    public UUID delete(@PathVariable UUID postSeq) {
        postsService.delete(postSeq);
        return postSeq;
    }

}
