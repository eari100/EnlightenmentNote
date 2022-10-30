package com.example.enlightenmentNote.dto;

import com.example.enlightenmentNote.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsDetailResDto {

    private String title;
    private String author;
    private PostsDetailCategoriesResDto category;
    private String content;
    private LocalDateTime createdDate;

    public PostsDetailResDto(Posts entity) {
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.category = new PostsDetailCategoriesResDto(entity.getCategories());
        this.content = entity.getContent();
        this.createdDate = entity.getCreatedDate();
    }
}
