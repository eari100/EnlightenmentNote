package com.example.enlightenmentNote.dto;

import com.example.enlightenmentNote.domain.categories.Categories;
import com.example.enlightenmentNote.domain.categories.CategoriesRepo;
import com.example.enlightenmentNote.domain.posts.Posts;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostsSaveReqDto {

    private String title;
    private String content;
    private String author;
    private UUID categorySeq;

    public Posts toEntity(Categories categories) {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .categories(categories)
                .build();
    }

}
