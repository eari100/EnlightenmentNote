package com.example.enlightenmentNote.controller;

import com.example.enlightenmentNote.dto.CategoriesListResDto;
import com.example.enlightenmentNote.service.CategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CategoriesApiController {

    private final CategoriesService categoriesService;

    @GetMapping("/api/v1/categories/list")
    public List<CategoriesListResDto> findAll() {
        return categoriesService.findAll();
    }
}
