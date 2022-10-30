package com.example.enlightenmentNote.dto;

import com.example.enlightenmentNote.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class PostsListResDto {

    private UUID postSeq;
    private String title;
    private String author;
    private PostsListCategoriesResDto category;
    private LocalDateTime createdDate;

    public PostsListResDto(Posts entity) {
        this.postSeq = entity.getPostSeq();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.category = new PostsListCategoriesResDto(entity.getCategories());
        this.createdDate = entity.getCreatedDate();
    }
}
