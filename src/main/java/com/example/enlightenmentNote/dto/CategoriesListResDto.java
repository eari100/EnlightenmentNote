package com.example.enlightenmentNote.dto;

import com.example.enlightenmentNote.domain.categories.Categories;
import lombok.Getter;

import java.util.UUID;

@Getter
public class CategoriesListResDto {
    private UUID seq;
    private String name;

    public CategoriesListResDto(Categories entity) {
        this.seq = entity.getCategorySeq();
        this.name = entity.getName();
    }
}
