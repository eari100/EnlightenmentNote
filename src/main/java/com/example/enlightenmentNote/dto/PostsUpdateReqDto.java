package com.example.enlightenmentNote.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostsUpdateReqDto {
    private String title;
    private String content;
    private UUID categorySeq;
}
