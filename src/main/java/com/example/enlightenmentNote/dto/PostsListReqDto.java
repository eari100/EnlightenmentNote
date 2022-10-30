package com.example.enlightenmentNote.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PostsListReqDto {
    private String title;
    private String content;
    private String author;
    private String categorySeq;
}
